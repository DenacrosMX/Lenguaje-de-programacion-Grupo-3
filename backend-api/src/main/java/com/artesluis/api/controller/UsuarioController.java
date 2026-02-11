package com.artesluis.api.controller;

import com.artesluis.api.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

  @GetMapping
  public List<Usuario> listarUsuarios() {
    return List.of(
      new Usuario(1L, "Luis Arte", "luis@artesluis.com", "ADMIN"),
      new Usuario(2L, "Ana Torres", "ana@artesluis.com", "EDITOR"),
      new Usuario(3L, "Carlos Vega", "carlos@artesluis.com", "CLIENTE")
    );
  }
}
