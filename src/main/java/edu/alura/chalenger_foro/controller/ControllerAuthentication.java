package edu.alura.chalenger_foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.alura.chalenger_foro.service.ServiceAutentication;

@Controller
@RequestMapping(value = "/login")
public class ControllerAuthentication {
    @Autowired
    private ServiceAutentication service;
}
