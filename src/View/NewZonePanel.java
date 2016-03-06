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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author julien
 */
public class NewZonePanel extends JPanel implements ActionListener {
    JTextField label = new JTextField(30);
    JButton valid= new JButton(" Valider ");
    GridBagConstraints cont = new GridBagConstraints();
    ArrayList<Zone> zones ;
    JLabel log =new JLabel();
    public NewZonePanel(ArrayList<Zone> z){
        zones=z;
        valid.addActionListener(this);
        this.setLayout(new GridBagLayout());
        cont.fill=GridBagConstraints.BOTH;
        log.setBackground(Color.red);
        this.init();
    }
    
    public void init(){
        this.setVisible(false);
        this.removeAll();
        cont.gridx=0;
        cont.gridy=1;
        this.add(new JLabel(" Veuillez entrer le nom de la zone (Ex : Bonta ) : "),cont);
        cont.gridx=1;
        this.add(label,cont);
        cont.gridy=2;
        this.add(valid,cont);

            cont.gridx=0;
            cont.gridy=2;
            this.add(log,cont);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==valid){
            if(AddController.AddZoneController(zones, label.getText())){
                log.setText(" Zone ajoutée avec succés ");
                this.init();
            }else{
                log.setText(" Erreur dans l'ajout de la zone ");
                this.init();
            }
        }
    }
}
