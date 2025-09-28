package com.example.javamarrykotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class controller {

     @GetMapping("/hello")
    fun sayfriday():String{
       return "smiles"
    }

}