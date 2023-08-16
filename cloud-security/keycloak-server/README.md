# Keycloak Server

## Server Installation

Docker Compose File
```
version: '3'

volumes:
  postgres_data:
    driver: local

services:
  db:
    image: postgres:latest
    volumes: 
      - postgres_data:/var/lib/postgresql/data
    environment:
      POSTGRES_DB: keycloak_db
      POSTGRES_USER: keycloak
      POSTGRES_PASSWORD: keycloak
    ports:
      - 5432:5432
  kc:
    image: quay.io/keycloak/keycloak:latest
    environment:
      DB_VENDOR: postgres
      DB_ADDR: db
      DB_SCHEMA: public
      DB_DATABASE: keycloak_db
      DB_USER: keycloak
      DB_PASSWORD: keycloak
      KEYCLOAK_ADMIN: admin
      KEYCLOAK_ADMIN_PASSWORD: admin 
      KC_HOSTNAME: localhost
    ports:
      - 8080:8080
    depends_on:
      - db
    command: 
      - start-dev
```

Starting up 
```
docker-compose up -d
```

## Configuration in Keycloak Server

1. Realm Settings
2. Create Client for Resource Server
3. Role Settings
4. Create User for Resource Server

## Using REST Endpoint

1. Generate Token
2. Referesh Token
3. Sign Up New User