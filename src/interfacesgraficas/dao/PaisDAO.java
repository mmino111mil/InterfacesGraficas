/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas.dao;

import interfacesgraficas.model.Pais;
import java.util.List;

/**
 *
 * @author mmino
 */
public class PaisDAO {
    
    public void create(Pais pais){ }
    
    public void update (Pais pais){ }
    
    public void delete (Pais pais){ }
    
    public List<Pais> all(){return null;}
    
    public void printAll(){
        for(Pais g : all() ){
            System.out.println(g.getCode() + "-" + g.getNombre());
        }
    }
    
    public void close(){}
        
}
