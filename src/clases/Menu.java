/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;

/**
 *
 * @author Jeremy martinez
 */
public class Menu {
    private int ln_Idmenu;
    private int ln_Idrecetas;
    private String lsNombreReceta;
    private String lsTipoMenu;
    private float lf_calorias;
    private float lf_hidratos;
    private float lf_proteinas;
    private float lf_grasas;
    private float lf_fibras; 

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
    private LocalDate lfFechaIni;
    private LocalDate lfFechaFin;

    public String getLsTipoMenu() {
        return lsTipoMenu;
    }

    public String getLsNombreReceta() {
        return lsNombreReceta;
    }

    public void setLsNombreReceta(String lsNombreReceta) {
        this.lsNombreReceta = lsNombreReceta;
    }

    public void setLsTipoMenu(String lsTipoMenu) {
        this.lsTipoMenu = lsTipoMenu;
    }

    public LocalDate getLfFechaIni() {
        return lfFechaIni;
    }

    public void setLfFechaIni(LocalDate lfFechaIni) {
        this.lfFechaIni = lfFechaIni;
    }

    public LocalDate getLfFechaFin() {
        return lfFechaFin;
    }

    public void setLfFechaFin(LocalDate lfFechaFin) {
        this.lfFechaFin = lfFechaFin;
    }
    

    public int getLn_Idmenu() {
        return ln_Idmenu;
    }

    public void setLn_Idmenu(int ln_Idmenu) {
        this.ln_Idmenu = ln_Idmenu;
    }

    public int getLn_Idrecetas() {
        return ln_Idrecetas;
    }

    public void setLn_Idrecetas(int ln_Idrecetas) {
        this.ln_Idrecetas = ln_Idrecetas;
    }
    
}
