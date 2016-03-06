/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Zone;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author julien
 */
public class SearchPanel extends JPanel implements ActionListener{
    ArrayList<Zone> zones;
    ArrayList<JTable> tab_result = new ArrayList<>();
    JPanel panel ;
    JTextField label_zone = new JTextField(20),label_hint = new JTextField(20),category_hint = new JTextField(20);
    JButton valid= new JButton(" Valider les critéres de recherche ");
    GridBagConstraints constr = new GridBagConstraints();
    JScrollPane pane;
    
    public SearchPanel(ArrayList<Zone> z){
        zones= z;
        valid.addActionListener(this);
        constr.fill=GridBagConstraints.BOTH;
        this.setLayout(new GridBagLayout());
        panel= new JPanel();
        panel.setLayout(new GridBagLayout());
        pane = new JScrollPane(panel);
        init(zones);
        this.setVisible(true);
    }
    
    public void init(ArrayList<Zone> z){
        pane.removeAll();
        panel.removeAll();
        tab_result.clear();
        this.removeAll();
        
        
        
        
        constr.gridx=0;
        constr.gridy=0;
        this.add(new JLabel(" Nom de la Zone : "),constr);
        constr.gridx=1;
        this.add(label_zone,constr);
        constr.gridx=0;
        constr.gridy+=1;
        this.add(new JLabel(" Nom de l'indice : "),constr);
        constr.gridx=1;
        this.add(label_hint,constr);
        constr.gridx=0;
        constr.gridy+=1;
        this.add(new JLabel(" Categorie de l'indice : "),constr);
        constr.gridx=1;
        this.add(category_hint,constr);
        constr.gridx=0;
        constr.gridy+=1;
        this.add(valid,constr);

        
        
        
        GridBagConstraints cont= new GridBagConstraints();
        cont.fill=GridBagConstraints.BOTH;

        cont.gridx=0;
        cont.gridy=0;
        for(int i=0;i<z.size();i++){
            panel.add(new JLabel(z.get(i).label),cont);
            cont.gridy+=1;
            cont.gridwidth=5;
            tab_result.add(new JTable(new Result(z.get(i).hints)));
            
            panel.add(tab_result.get(i),cont);
            cont.gridy+=1;
            cont.gridwidth=1;
        }
        
        constr.gridy+=1;
        constr.gridwidth=3;
        

        pane = new JScrollPane(panel);
        this.add(pane);
        constr.gridwidth=1;
    }

    
    public ArrayList<Zone> search(String zlabel,String hlabel,String hcategory){
        ArrayList<Zone> tmp = new ArrayList<>() ;
        if(zlabel.length()==0 && hlabel.length()==0 && hcategory.length()==0){
            return zones;
        }else{
            Boolean label_void= false;
            if(zlabel.length()==0){
                label_void=true;
            }
           for(int i=0;i<zones.size();i++){
               if(zlabel.length()!=0 && zlabel.equals(zones.get(i).label)){
                   tmp.add(new Zone(zones.get(i).label));
                   
                   tmp.get(tmp.size()-1).hints = new ArrayList<>();
                   tmp.get(tmp.size()-1).hints =zones.get(i).FilterHints(hlabel, hcategory);
                   if(tmp.get(tmp.size()-1).hints.size()==0){
                       tmp.remove(tmp.size()-1);
                   }
               }
               if(label_void){
                   tmp.add(new Zone(zones.get(i).label));
                   
                   tmp.get(tmp.size()-1).hints = new ArrayList<>();
                   tmp.get(tmp.size()-1).hints =zones.get(i).FilterHints(hlabel, hcategory);
                   if(tmp.get(tmp.size()-1).hints.size()==0){
                       tmp.remove(tmp.size()-1);
                   }
               }
               
           }  
          return tmp;  
        }  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()== this.valid){
           this.init(this.search(this.label_zone.getText(),this.label_hint.getText(),this.category_hint.getText()));
           this.updateUI();
        }
    }
    
}
