# Beaution Manager Server

API for beauty salon management built with Spring Boot and Kotlin.

## Current Status

✅ Customer API with pagination implemented
✅ PostgreSQL database integration
✅ Docker containerization

## Quick Start

### Run the application

```bash
./gradlew clean build
docker-compose up --build
```

API will be available at: `http://localhost:8080`

## Testing Pagination

### Get customers with pagination

```bash
# First page, 10 items
curl "http://localhost:8080/api/customers?page=0&size=10"

# Second page, 5 items
curl "http://localhost:8080/api/customers?page=1&size=5"

# With sorting by last name (ascending)
curl "http://localhost:8080/api/customers?page=0&size=10&sort=lastName,asc"

# With sorting by first name (descending)
curl "http://localhost:8080/api/customers?page=0&size=10&sort=firstName,desc"

# Multiple sort criteria
curl "http://localhost:8080/api/customers?page=0&size=10&sort=lastName,asc&sort=firstName,asc"
```

### Response format

```json
{
  "content": [...],
  "pageable": {...},
  "totalPages": 27,
  "totalElements": 270,
  "last": false,
  "first": true,
  "size": 10,
  "number": 0,
  "numberOfElements": 10,
  "empty": false
}
```

## Tech Stack

- **Language**: Kotlin
- **Framework**: Spring Boot 4.0.0
- **Database**: PostgreSQL 16
- **Build**: Gradle
- **Container**: Docker
