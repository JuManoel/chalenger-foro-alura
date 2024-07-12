package edu.alura.chalenger_foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.alura.chalenger_foro.service.ServiceRespuesta;

@Controller
@RequestMapping(value = "/Respuesta")
public class ControllerRespuesta {
    @Autowired
    private ServiceRespuesta service;
}
