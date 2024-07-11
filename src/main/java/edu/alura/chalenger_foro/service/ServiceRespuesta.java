package edu.alura.chalenger_foro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alura.chalenger_foro.repository.RespuestaRepository;

@Service
public class ServiceRespuesta {
    @Autowired
    private RespuestaRepository repository;
}
