/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julien
 */
public class Zone {
    public ArrayList<Hint> hints= new ArrayList<>();
    public String label;

    public Zone(String label) {
        this.label = label;
    }
    
    
    public Zone(){
        
    }
    public void LoadZone(String zone_label){
        try {
            File f=new File("src/Data/"+zone_label);
            Scanner sc=new Scanner(f);
            this.label=sc.next();
            while(sc.hasNext()){
                this.AddHint(sc.next(), sc.next(), sc.next(), sc.next());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Zone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SaveZone(){
        File f = new File("src/Data/"+this.label+".thdhsave");       
        try
        {
            if(f.exists()==false){              
                if(f.createNewFile()==true){
                    System.out.println("Fichier créé avec succés");
                }
            }
            PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (f)));
            
            pw.println(this.label);
            for(int i=0;i<this.hints.size();i++){
                pw.println(this.hints.get(i).HintToSave());
            }
            pw.close();
        }   
        catch (IOException exception)
        {
            System.out.println ("Erreur lors de l'écriture : " + exception.getMessage());
        }
        
    }
    
    public void AddHint(String hint_label,String hint_category,String hint_pos_x,String hint_pos_y){
        this.hints.add(new Hint(hint_label,hint_category,hint_pos_x,hint_pos_y));
    }
}