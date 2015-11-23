/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.doscommand.commands;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bishal Aryal
 */
public class RemoveDirectory extends Command{

    @Override
    public String execute(String path) {
        
        if(path!=null){
            if(path.contains("\\")){
                
                File file = new File(path);
                if(!file.exists())
                    return("Directory \"" + path + "\" does not exist.");
                String[] entries = file.list();
                for(String s: entries){
                    File currentFile = new File(file.getPath(),s);
                    currentFile.delete();
                }
            }
            Path n = new Path();
            String np = null;
            try {
                np = n.returnPath();
            } catch (IOException ex) {
                Logger.getLogger(RemoveDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            File file = new File(np + path);
            if(!file.exists())
                return("Directory \"" + path + "\" does not exist.");
            String[] entries = file.list();
            for(String s: entries){
                File currentFile = new File(file.getPath(),s);
                currentFile.delete();
            }
        file.delete();
        return("Directory \"" + path + "\" removed.");
    }
    
    return("The syntax of command is incorrect.");

    }
}
