### Sample API

If you have no docker locak repository.
```
docker run -d -p 5001:5000 --name registry registry:2
```

Check Docker Local Repository
```
curl http://localhost:5001/v2/_catalog
```

Build Maven Project
```
mvn clean install
```

Build Docker Image
```
docker build -t jdc/simple-service .
```

Tags Docker Image
```
docker tag jdc/single-service localhost:5001/jdc/single-service
```

Push Docker Image to Local Repository
```
docker push localhost:5001/jdc/single-service
```

Create Deployment
```
kubectl apply -f kubernetes/deployment.yml
```

Create Service
```
kubectl apply -f kubernetes/service.yml
```