/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas.dao;

import interfacesgraficas.model.Pais;
import interfacesgraficas.model.Provincia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mmino
 */
public class PaisMemDAO extends PaisDAO{
    
    /**
    * Este es mi collecion de paieses,
    * donde se guardaran en memoria
    */
    private List<Pais> paises;

    /**
     * En el constructor voy a inicializaar paises
     */
    public PaisMemDAO() {
        this.paises = new ArrayList<Pais>();
        cargaInicial();
    }
    
    private void cargaInicial(){
        
        Pais argentina = new Pais("ar","Argentina");
        Provincia buenosAires = new Provincia("BA","Buenos Aires");
        Provincia santaFe = new Provincia("SF","Santa Fe");
        argentina.addProvincia(buenosAires);
        argentina.addProvincia(santaFe);
        paises.add(argentina);
        
        Pais uruguay = new Pais("ur","Uruguay");
        paises.add(uruguay);
        Provincia montevideo = new Provincia("MT","Montevideo");
        uruguay.addProvincia(montevideo);
        Provincia carmelo = new Provincia("CA","Carmelo");
        uruguay.addProvincia(carmelo);
        
        Pais chile = new Pais("ch", "Chile");
        paises.add(chile);
        chile.addProvincia(new Provincia("ST","Santiago de Chile"));
        
        Pais paraguay = new Pais("pa","Paraguay");
        paises.add(paraguay);
    }
    
    /**
     * Agrego el nuevo pais a la collecion de paises
     * @param pais 
     */
    public void create(Pais pais){ 
        this.paises.add(pais);
    }
    
    /**
     * Para modificar un pais lo voy a tener que buscar en la coleccion de paises
     * y modificarlo
     * @param pais 
     */
    public void update (Pais pais){
        Iterator<Pais> it = this.paises.iterator();
        while(it.hasNext()){
            Pais p = it.next();
            if(p.equals(pais)){
                p.setCode(pais.getCode());
                p.setNombre(pais.getNombre());
            }
        }
        
    }
    
    public void delete (Pais pais){
        this.paises.remove(pais);
    }
    
    public List<Pais> all(){
        return this.paises;
    }
    
}
