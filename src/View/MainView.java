/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddController;
import Model.Zone;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author julien
 */
public class MainView extends JFrame implements ActionListener {
    JMenuBar menubar =new JMenuBar();
    JMenuItem save,new_zone,new_hint,search;
    JPanel panel= new JPanel();
    ArrayList<Zone> zones= new ArrayList<>();
    
    public MainView(){
        this.loadAll();
        save= new JMenuItem(" Sauvegarder ");
        search = new JMenuItem(" Rechercher un indice ");
        new_zone = new JMenuItem(" Ajouter une Zone ");
        new_hint = new JMenuItem(" Ajouter un indice ");
        
        save.addActionListener(this);
        search.addActionListener(this);
        new_zone.addActionListener(this);
        new_hint.addActionListener(this);
        
        
        save.setBackground(Color.white);
        search.setBackground(Color.gray);
        new_zone.setBackground(Color.white);
        new_hint.setBackground(Color.gray);
                
        menubar.add(save);
        menubar.add(search);
        menubar.add(new_zone);
        menubar.add(new_hint);
        
        this.setContentPane(panel);
        this.setJMenuBar(menubar);
        this.pack();
        this.setVisible(true);
        this.setTitle(" Aide chasse aux trésors Dofus ");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                
    }
    
    public void updatePanel(JPanel pano){
        panel.removeAll();
        panel=pano;
        this.setContentPane(panel);
        this.pack();
    }
    
    public void save(){
        for(int i=0;i<zones.size();i++){
            zones.get(i).SaveZone();
        }
    }
    
    public void loadAll(){
        if(zones.size()!=0){
            zones.clear();
        }
        File directory = new File ("src/Data/");
        String[] zones_label=directory.list();
        for(int i=0;i<zones_label.length;i++){
            zones.add(new Zone());
            zones.get(i).LoadZone(zones_label[i]);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==this.save){
            this.save();
            JPanel tmp = new JPanel();
            tmp.add(new JLabel(" Sauvegarde effectuée avec succés "));
            this.updatePanel(tmp);
        }
        if(e.getSource()==this.new_zone){
           NewZonePanel nzp = new NewZonePanel(zones);
            this.updatePanel(nzp);
        }
        if(e.getSource()==this.new_hint){
            NewHintPanel nhp = new NewHintPanel(zones);
             this.updatePanel(nhp);
        }
    
    }
    
}
