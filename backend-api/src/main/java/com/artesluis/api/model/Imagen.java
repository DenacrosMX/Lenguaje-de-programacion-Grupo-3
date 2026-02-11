package com.artesluis.api.model;

public class Imagen {
  private Long id;
  private String titulo;
  private String url;
  private String categoria;

  public Imagen() {}

  public Imagen(Long id, String titulo, String url, String categoria) {
    this.id = id;
    this.titulo = titulo;
    this.url = url;
    this.categoria = categoria;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
