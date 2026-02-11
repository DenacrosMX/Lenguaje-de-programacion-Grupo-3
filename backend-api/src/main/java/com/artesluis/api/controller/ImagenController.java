package com.artesluis.api.controller;

import com.artesluis.api.model.Imagen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

  @GetMapping
  public List<Imagen> listarImagenes() {
    return List.of(
      new Imagen(1L, "Boceto Logo", "https://example.com/img/logo-1.jpg", "branding"),
      new Imagen(2L, "Portada Catalogo", "https://example.com/img/portada-1.jpg", "editorial"),
      new Imagen(3L, "Mockup App", "https://example.com/img/mockup-1.jpg", "digital")
    );
  }
}
