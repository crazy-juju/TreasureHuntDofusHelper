/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddController;
import Model.Zone;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author julien
 */
public class NewHintPanel extends JPanel implements ActionListener{
    ArrayList<Zone> zones;
    JComboBox list_zones = new JComboBox();
    JTextField label,category,posx,posy;
    JLabel log = new JLabel();
    JButton valid= new JButton(" Valider ");
    GridBagConstraints cont = new GridBagConstraints();
    
    public NewHintPanel(ArrayList<Zone> z){
        zones=z;
        log.setBackground(Color.red);
        for(int i=0;i<zones.size();i++){
            list_zones.addItem(zones.get(i).label);
        }
        valid.addActionListener(this);
        label= new JTextField(30);
        category= new JTextField(20);
        posx=new JTextField(5);
        posy=new JTextField(5);
        this.setLayout(new GridBagLayout());
        cont.fill= GridBagConstraints.BOTH;
        init();
        this.setVisible(true);
    }
    
    public void init(){
        
        this.removeAll();
        cont.gridx=0;
        cont.gridy=0;
        this.add(new JLabel(" Choissisez la zone de l'indice dans la liste : "),cont);
        cont.gridx=1;
        this.add(list_zones,cont);
        cont.gridx=0;
        cont.gridy=1;
        this.add(new JLabel(" Nom de l'indice : "),cont);
        cont.gridx=1;
        this.add(label,cont);
        cont.gridy=2;
        cont.gridx=0;
        this.add(new JLabel(" Categorie de l'indice : "),cont);
        cont.gridx=1;
        this.add(category,cont);
        cont.gridy=3;
        cont.gridx=0;
        this.add(new JLabel(" X : "),cont);
        cont.gridx=1;
        this.add(posx,cont);
        cont.gridy=4;
        cont.gridx=0;
        this.add(new JLabel(" Y : "),cont);
        cont.gridx=1;
        this.add(posy,cont);
        cont.gridy=5;
        cont.gridx=0;
        this.add(log,cont);
        cont.gridx=1;
        this.add(valid,cont);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==valid){
            if(AddController.AddHintController(zones, list_zones.getSelectedItem().toString(),label.getText(),category.getText(),posx.getText(),posy.getText())){
                log.setText(" Indice ajouté avec succés ");
                this.init();
            }else{
                log.setText(" Erreur dans l'ajout de l'indice ");
                this.init();
            }
        }
    }
}
