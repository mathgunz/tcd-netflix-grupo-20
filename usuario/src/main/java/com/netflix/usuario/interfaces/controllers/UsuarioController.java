package com.netflix.usuario.interfaces.controllers;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    @GetMapping
    public String get() {
        return "funciona!";
    }
}