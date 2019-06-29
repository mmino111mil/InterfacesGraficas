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
public class Provincia {
    
    private String code;
    private String name;
    private List<Localidad> localidades;

    public Provincia(String code, String name) {
        this.code = code;
        this.name = name;
        this. localidades = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return name ;
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
        final Provincia other = (Provincia) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    public int totalDeHabitantes(){
        int total = 0;
        for(Localidad l : this.localidades){
            total += l.getHabitantes();
        }
        //localidades.stream().mapToInt(f -> f.getHabitantes()).sum();
        return total;
    }
    
}
