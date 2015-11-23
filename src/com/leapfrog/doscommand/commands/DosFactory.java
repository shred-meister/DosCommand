/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.doscommand.commands;

import java.util.HashMap;

/**
 *
 * @author Bishal Aryal
 */
public class DosFactory {
      
    public static Command get(String key){

        if(key.equalsIgnoreCase("md")){
            return new MakeDirectory();
        }
        else if(key.equalsIgnoreCase("cd")){
            return new ChangeDirectory();
        }
        else if(key.equalsIgnoreCase("rd")){
            return new RemoveDirectory();
        }
        else if(key.equalsIgnoreCase("dir")){
            return new Directory();
        }
        else if(key.equalsIgnoreCase("copycon")){
            return new CopyCon();
        }
        return null;
    }
    
                
}
