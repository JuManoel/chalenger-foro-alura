package edu.alura.chalenger_foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.alura.chalenger_foro.service.ServiceRespuesta;

@Controller
public class ControllerRespuesta {
    @Autowired
    private ServiceRespuesta service;
}
