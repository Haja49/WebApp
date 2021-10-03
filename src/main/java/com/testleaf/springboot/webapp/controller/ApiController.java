/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testleaf.springboot.webapp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
@Scope("request")
public class ApiController {
    
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public String sayHi(@PathVariable String name){
        return "Hello "+name;
    }
    
}
