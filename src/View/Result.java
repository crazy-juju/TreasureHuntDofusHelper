/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Hint;
import Model.Zone;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author julien
 */
public class Result extends AbstractTableModel {
    ArrayList<Hint> hints ;
    private final String[] entetes = {"Position","Nom de l'indice","Categorie de l'indice"};
    public Result(ArrayList<Hint> z){
        super();
        hints=z;
        
    }
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return hints.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         switch(columnIndex){
            case 0:
                return hints.get(rowIndex).posx+" / "+hints.get(rowIndex).posy;
            case 1:
                return hints.get(rowIndex).label;
            case 2:
                return hints.get(rowIndex).category;
            default:
                return null;
    }
    }
    
}
