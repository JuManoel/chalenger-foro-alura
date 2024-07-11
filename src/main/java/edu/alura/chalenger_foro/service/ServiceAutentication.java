package edu.alura.chalenger_foro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alura.chalenger_foro.repository.PerfilRepository;
import edu.alura.chalenger_foro.repository.UsuarioRepository;

@Service
public class ServiceAutentication {
    @Autowired
    private UsuarioRepository uRepository;
    @Autowired
    private PerfilRepository pREpository;
}
