/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Hint;
import Model.Zone;
import java.util.ArrayList;

/**
 *
 * @author julien
 */
public class AddController {
    
    public static boolean AddZoneController(ArrayList<Zone> zones,String name){
        if(name == null || name.isEmpty() || ZoneAlreayExist(zones, name) ){
            return false;
        }
        zones.add(new Zone(name));
        return true;
    }
    
    public static boolean AddHintController(ArrayList<Zone> zones,String zone_label,String label,String category,String x,String y){

        if(label == null || label.isEmpty() || category == null || category.isEmpty() || x==null || x.isEmpty() || y==null || y.isEmpty() || HintAlreadyExist(zones, zone_label, label)){
            
            return false;
        }
        int cpt= 0 ;
        for(int i=0;i<zones.size();i++){
            if(zones.get(i).label.equals(zone_label)){
                cpt=i;
                break;
            }
        }
        zones.get(cpt).hints.add(new Hint(label,category,x,y));
        return true;
    }
    
    public static boolean ZoneAlreayExist(ArrayList<Zone> zones,String name){
        boolean result= false;
        for(int i=0;i<zones.size();i++){
            if(zones.get(i).label.equals(name)){
                result=true;
                break;
            }
        }
        return result;
    }
    
    public static boolean HintAlreadyExist(ArrayList<Zone> zones,String zone_label,String label){
        for(int i=0;i<zones.size();i++){
            for(int j=0;j<zones.get(i).hints.size();j++){
                if(zones.get(i).label.equals(zone_label) && zones.get(i).hints.get(j).label.equals(label)){
                    return true;
                }
            }
        }      
        return false;
    }
}
