/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Jeremy martinez
 */
public class Cliente {
    private String ls_cedula;
    private String ls_nombres;
    private String ls_apellidos;
    private String ls_telefonos;
    private String ls_mail;
    private String ls_direccion;
    private float lf_peso;                  //datos para vip
    private float lf_estatura;              //datos para vip
    private float lf_horas_ejercicio_semanal;//datos para vip
    private String profesion;               //datos para vip
    private float lf_IMC;                   //datos para vip
    private String ls_tipo_cliente; //v= vip f = fresh
    private LocalDate   fecha_suscripcion;
    private LocalDate   fecha_fin_suscripcion;
    private float  lf_precio;
    
    public LocalDate getFecha_suscripcion() {
        return fecha_suscripcion;
    }

    public void setFecha_suscripcion(LocalDate fecha_suscripcion) {
        this.fecha_suscripcion = fecha_suscripcion;
    }

    public LocalDate getFecha_fin_suscripcion() {
        return fecha_fin_suscripcion;
    }

    public void setFecha_fin_suscripcion(LocalDate fecha_fin_suscripcion) {
        this.fecha_fin_suscripcion = fecha_fin_suscripcion;
    }
    

    public float getLf_peso() {
        return lf_peso;
    }

    public void setLf_peso(float lf_peso) {
        this.lf_peso = lf_peso;
    }

    public float getLf_estatura() {
        return lf_estatura;
    }

    public void setLf_estatura(float lf_estatura) {
        this.lf_estatura = lf_estatura;
    }

    public float getLf_horas_ejercicio_semanal() {
        return lf_horas_ejercicio_semanal;
    }

    public void setLf_horas_ejercicio_semanal(float lf_horas_ejercicio_semanal) {
        this.lf_horas_ejercicio_semanal = lf_horas_ejercicio_semanal;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public float getLf_IMC() {
        return lf_IMC;
    }

    public void setLf_IMC(float lf_IMC) {
        this.lf_IMC = lf_IMC;
    }
    

    public float getLf_precio() {
        return lf_precio;
    }

    public void setLf_precio(float lf_precio) {
        this.lf_precio = lf_precio;
    }

    public String getLs_cedula() {
        return ls_cedula;
    }

    public void setLs_cedula(String ls_cedula) {
        this.ls_cedula = ls_cedula;
    }

    public String getLs_nombres() {
        return ls_nombres;
    }

    public void setLs_nombres(String ls_nombres) {
        this.ls_nombres = ls_nombres;
    }

    public String getLs_apellidos() {
        return ls_apellidos;
    }

    public void setLs_apellidos(String ls_apellidos) {
        this.ls_apellidos = ls_apellidos;
    }

    public String getLs_telefonos() {
        return ls_telefonos;
    }

    public void setLs_telefonos(String ls_telefonos) {
        this.ls_telefonos = ls_telefonos;
    }

    public String getLs_mail() {
        return ls_mail;
    }

    public void setLs_mail(String ls_mail) {
        this.ls_mail = ls_mail;
    }

    public String getLs_direccion() {
        return ls_direccion;
    }

    public void setLs_direccion(String ls_direccion) {
        this.ls_direccion = ls_direccion;
    }

    public String getLs_tipo_cliente() {
        return ls_tipo_cliente;
    }

    public void setLs_tipo_cliente(String ls_tipo_cliente) {
        this.ls_tipo_cliente = ls_tipo_cliente;
    }

 
    
}
