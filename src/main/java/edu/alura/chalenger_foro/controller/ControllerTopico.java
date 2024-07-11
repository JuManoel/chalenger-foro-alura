package edu.alura.chalenger_foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.alura.chalenger_foro.service.ServiceTopico;

@Controller
public class ControllerTopico {
    @Autowired
    private ServiceTopico service;
}
