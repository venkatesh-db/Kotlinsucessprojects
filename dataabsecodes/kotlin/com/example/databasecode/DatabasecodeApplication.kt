package com.example.databasecode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DatabasecodeApplication

fun main(args: Array<String>) {
    runApplication<DatabasecodeApplication>(*args)
}


/*

curl -X POST http://localhost:9090/api/users \
-H "Content-Type: application/json" \
-d '{"name":"Alice","email":"alice@example.com","isActive":true}'

curl http://localhost:9090/api/users/1


 */