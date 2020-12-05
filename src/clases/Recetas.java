/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Jeremy martinez
 */
public class Recetas {
    
    private int ln_Idrecetas;
    private String nombre_receta;
    private int ln_tipoReceta;
    private String  ls_tipo_receta;
    private int ln_idIngrediente;
    private Ingredientes ingrediente;
    private float lf_cant_gramos;
    private String ls_preparacion;
    private float lf_calorias;
    private float lf_hidratos;
    private float lf_proteinas;
    private float lf_grasas;
    private float lf_fibras; 

    public int getLn_tipoReceta() {
        return ln_tipoReceta;
    }

    public void setLn_tipoReceta(int ln_tipoReceta) {
        this.ln_tipoReceta = ln_tipoReceta;
    }

    public float getLf_calorias() {
        return lf_calorias;
    }

    public void setLf_calorias(float lf_calorias) {
        this.lf_calorias = lf_calorias;
    }

    public float getLf_hidratos() {
        return lf_hidratos;
    }

    public void setLf_hidratos(float lf_hidratos) {
        this.lf_hidratos = lf_hidratos;
    }

    public float getLf_proteinas() {
        return lf_proteinas;
    }

    public void setLf_proteinas(float lf_proteinas) {
        this.lf_proteinas = lf_proteinas;
    }

    public float getLf_grasas() {
        return lf_grasas;
    }

    public void setLf_grasas(float lf_grasas) {
        this.lf_grasas = lf_grasas;
    }

    public float getLf_fibras() {
        return lf_fibras;
    }

    public void setLf_fibras(float lf_fibras) {
        this.lf_fibras = lf_fibras;
    }

    
    
    public String getNombre_receta() {
        return nombre_receta;
    }

    public void setNombre_receta(String nombre_receta) {
        this.nombre_receta = nombre_receta;
    }

    
    
    public Ingredientes getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingredientes ingrediente) {
        this.ingrediente = ingrediente;
    }
    

    public int getLn_Idrecetas() {
        return ln_Idrecetas;
    }

    public void setLn_Idrecetas(int ln_Idrecetas) {
        this.ln_Idrecetas = ln_Idrecetas;
    }

    public int getLn_idIngrediente() {
        return ln_idIngrediente;
    }

    public void setLn_idIngrediente(int ln_idIngrediente) {
        this.ln_idIngrediente = ln_idIngrediente;
    }

    public float getLf_cant_gramos() {
        return lf_cant_gramos;
    }

    public void setLf_cant_gramos(float lf_cant_gramos) {
        this.lf_cant_gramos = lf_cant_gramos;
    }

    public String getLs_preparacion() {
        return ls_preparacion;
    }

    public void setLs_preparacion(String ls_preparacion) {
        this.ls_preparacion = ls_preparacion;
    }
    
    public String getLs_tipo_receta() {
        return ls_tipo_receta;
    }

    public void setLs_tipo_receta(String ls_tipo_receta) {
        this.ls_tipo_receta = ls_tipo_receta;
    }
}
