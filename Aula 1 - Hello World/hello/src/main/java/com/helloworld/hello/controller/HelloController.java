package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/helloworld")
    @GetMapping
    public String hello(){
        return "<b>Mentalidades</b>: Orientação ao Futuro, Mentalidade de Crescimento, Persistência<br>" +
                "<b>Habilidades</b>: Atenção aos detalhes e proatividade";
    }

    @RequestMapping("/helloworld2")
    @GetMapping
    public String hello2(){
        return "Meus objetivos de aprendizagem são: aperfeiçoar meus conhecimentos em <b>Spring</b> e <b>Maven/Graple</b>.";
    }

}