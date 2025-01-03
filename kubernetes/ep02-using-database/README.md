# Learning Kubernetes

## Episode 2

After learning how to create kubernetes pod and service, we have to learn Spring Boots Application and Database on kubernete cluster environment.

We will use PostgreSql for Database and Spring Boots application for Rest API.

### Preparing for Database

#### Secrets and ConfigMap
While we are using database container, we need to define database name, database username, and database password. Those informations may varies uppon environments and should not be expose on public or private repository.

Kubernetes support Secrets and ConfigMap and we should use sensitive data on secret and changable data on config map.

By using secret value cannot easily known to others and by using config map, we can change values according to environments.

```
apiVersion: v1
kind: Secret
metadata:
  name: postgres-secret
type: Opaque
data:
  POSTGRES_PASSWORD: bXlwYXNzd29yZA==

---
apiVersion: v1
kind: ConfigMap
metadata:
  name: postgres-config
data:
  POSTGRES_DB: testdb
  POSTGRES_USER: testdb
```

These configuration also place at kubernetes/database-metadata.yml. After that we have to create these secret and configMap.
```
kubectl apply -f kubernetes/database-metadata.yml
```

You can also check secret and config map via these commands.
```
kubectl get secrets
kubectl get configMaps
```

#### Persistent Volume Calim

```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: postgres-pvc
  namespace: default
  labels:
    app: postgres-pvc
spec:
  accessModes:
  - ReadWriteOnce
  resources:
    requests:
      storage: 1Gi
```

Create Persistent Volume Claim

```
kubectl apply -f kubernetes/database-pvc.yml
```

### Deployment

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name:  postgres
  labels:
    app:  postgres
spec:
  selector:
    matchLabels:
      app: postgres
  replicas: 1
  template:
    metadata:
      labels:
        app:  postgres
    spec:
      containers:
      - name:  postgres
        image:  postgres:alpine
        env:
        - name: POSTGRES_DB
          valueFrom:
            configMapKeyRef:
              name: postgres-config
              key: POSTGRES_DB
        - name: POSTGRES_USER
          valueFrom:
            configMapKeyRef:
              name: postgres-config
              key: POSTGRES_USER
        - name: POSTGRES_PASSWORD
          valueFrom:
            secretKeyRef:
              name: postgres-secret
              key: POSTGRES_PASSWORD
        resources:
          requests:
            cpu: 100m
            memory: 100Mi
          limits:
            cpu: 100m
            memory: 100Mi
        volumeMounts:
        - name: postgres-storage
          mountPath: /var/lib/postgresql/data
      volumes:
      - name: postgres-storage
        persistentVolumeClaim:
          claimName: postgres-pvc
```

Create Pod for PostgreSQL Database
```
kubectl apply -f kubernetes/database-deployment.yml
```

#### Kubernete Service

```
apiVersion: v1
kind: Service
metadata:
  name: postgres
spec:
  selector:
    app: postgres
  type: LoadBalancer
  ports:
  - protocol: TCP
    port: 5432
    targetPort: 5432
```

Create Kubernete Service for Postgresql
```
kubectl apply -f kubernetes/database-service.yml
```

### Spring Boots Application

#### Maven Install

```
mvn clean install
```

#### Build Docker Image

```
docker build -t jdc/regions-api .
```

#### Tag and Push to Local Docker Repository

```
docker tag jdc/regions-api localhost:5001/jdc/regions-api
docker push localhost:5001/jdc/regions-api
```

#### Deployment for Spring Boots Application

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name:  region-api
  labels:
    app:  region-api
spec:
  selector:
    matchLabels:
      app: region-api
  replicas: 1
  template:
    metadata:
      labels:
        app:  region-api
    spec:
      containers:
      - name:  region-api
        image:  localhost:5001/jdc/regions-api
        resources:
          requests:
            cpu: 250m
            memory: 128Mi
          limits:
            cpu: 500m
            memory: 256Mi
        env:
        - name: HOST_NAME
          value: postgres
        - name: POSTGRES_DB
          valueFrom:
            configMapKeyRef:
              name: postgres-config
              key: POSTGRES_DB
        - name: POSTGRES_USER
          valueFrom:
            configMapKeyRef:
              name: postgres-config
              key: POSTGRES_USER
        - name: POSTGRES_PASSWORD
          valueFrom:
            secretKeyRef:
              name: postgres-secret
              key: POSTGRES_PASSWORD
        ports:
        - containerPort:  8080
```

Create pod for Spring Boots Application
```
kubectl apply -f kubernetes/api-deployment.yml
```

#### Create Service for Spring Boots Application

```
apiVersion: v1
kind: Service
metadata:
  name: region-api
spec:
  selector:
    app: region-api
  type: LoadBalancer
  ports:
  - protocol: TCP
    port: 8080
    targetPort: 8080
```

Create Service for Spring Boots Application
```
kubectl apply -f kubernetes/api-service.yml
```