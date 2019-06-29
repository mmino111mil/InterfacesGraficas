/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas.view;

import interfacesgraficas.model.Pais;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mmino
 */
public class PaisesTableModel extends AbstractTableModel{

    private static final String[] COLUMNAS = {"CODIGO","NOMBRE",""};
    private List<Pais> paises;
            
    public PaisesTableModel(List<Pais> paises) {
        this.paises = paises ;
    }

    @Override
    public int getRowCount() {
        return this.paises.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Object retorno = null;
        Pais pais = paises.get(rowIndex);
        
        switch(columnIndex){
            case 0 : retorno = pais.getCode();break;
            case 1 : retorno = pais.getNombre();break;
            case 2 : retorno = "";
        }
        
        return retorno;     
    }
    

 public Class getColumnClass(int column) {
    if (column == 2)
      return ((new JButton()).getClass());

    return getValueAt(0, column).getClass();
  }
    
    @Override
    public String getColumnName(int index){
       return COLUMNAS[index]; 
    }
    
}
