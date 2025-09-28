package com.example.springday2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Springday2Application

fun main(args: Array<String>) {
    runApplication<Springday2Application>(*args)
}

/*

curl http://localhost:9090/api/users

curl http://localhost:9090/api/users/1

curl -X POST http://localhost:9090/api/users \
  -H "Content-Type: application/json" \
  -d '{"id":3,"name":"Charlie","email":"charlie@example.com","is_active":true}'


 */