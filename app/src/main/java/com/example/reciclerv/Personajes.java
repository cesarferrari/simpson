package com.example.reciclerv;

import java.io.Serializable;

public class Personajes implements Serializable {
    private String name;
    private String description;
    private int photo;
    private String nal;
    private String pais;
    private String address;
    private String size;
    private String estilo;
    private String golpe;
    private String raqueta;
    private String cordaje;

    public Personajes(){

    }
    public Personajes(String nombre, String descripcion, int foto, String nacionalidad, String pais,
                      String direccion, String talla, String estilo, String golpe, String raqueta,
                      String cordaje) {
        this.name = nombre;
        this.description = descripcion;
        this.photo = foto;
        this.nal = nacionalidad;
        this.pais = pais;
        this.address = direccion;
        this.size = talla;
        this.estilo = estilo;
        this.golpe = golpe;
        this.raqueta = raqueta;
        this.cordaje = cordaje;
    }

    public String getNal() {
        return nal;
    }

    public void setNal(String nal) {
        this.nal = nal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getGolpe() {
        return golpe;
    }

    public void setGolpe(String golpe) {
        this.golpe = golpe;
    }

    public String getRaqueta() {
        return raqueta;
    }

    public void setRaqueta(String raqueta) {
        this.raqueta = raqueta;
    }

    public String getCordaje() {
        return cordaje;
    }

    public void setCordaje(String cordaje) {
        this.cordaje = cordaje;
    }

    public Personajes(String nombre, String descripcion, int foto) {
        this.name = nombre;
        this.description = descripcion;
        this.photo = foto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
