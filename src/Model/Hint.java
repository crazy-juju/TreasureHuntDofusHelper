/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author julien
 */
public class Hint {
    public String category,label,posx,posy;

    public Hint(String label, String category, String posx, String posy) {
        this.category = category;
        this.label = label;
        this.posx = posx;
        this.posy = posy;
    }
    
    public Hint(){
        
    }
    public String HintToSave(){
        return this.label+" "+this.category+" "+this.posx+" "+this.posy;
    }
}
