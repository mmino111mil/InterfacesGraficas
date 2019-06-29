/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mmino
 */
public class Pais {
    
    private String code;
    private String nombre;
    private List<Provincia> provincias;

    public Pais(String code, String nombre) {
        this.code = code;
        this.nombre = nombre;
        this.provincias = new ArrayList<Provincia>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public void addProvincia(Provincia provincia){
        this.provincias.add(provincia);
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public int totalDeHabitantes(){
        int total = 0;
        for(Provincia p : this.provincias){
            total += p.totalDeHabitantes();
        }
        //localidades.stream().mapToInt(f -> f.getHabitantes()).sum();
        return total;
    }
}
