/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas.model;

import java.util.Objects;

/**
 *
 * @author mmino
 */
public class Localidad {
    private String code;
    private String nombre;
    private Integer habitantes;

    public Localidad(String code, String nombre) {
        this.code = code;
        this.nombre = nombre;
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

    public Integer getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Integer habitantes) {
        this.habitantes = habitantes;
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
        final Localidad other = (Localidad) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public int totalDeHabitantes(){
        return habitantes;
    }
}
