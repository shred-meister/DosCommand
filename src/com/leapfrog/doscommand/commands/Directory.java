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
public class Directory extends Command{

    @Override
    public String execute(String path) {
        if(path!=null){
            if(path.contains("\\")){
                displayIt(new File(path));
                return("Directory \"" + path + "\" listed.");
            }
        }
        else{
            Path n = new Path();
            String p = null;
            try {
                p = n.returnPath();
            } catch (IOException ex) {
                Logger.getLogger(Directory.class.getName()).log(Level.SEVERE, null, ex);
            }
            displayIt(new File(p +"\\"));
            return("Directory \"" + p + "\" listed.");
        }
        return("The syntax of command is incorrect.");
   
    }

    private void displayIt(File file) {
        System.out.println(file.getAbsoluteFile());
        
        if(file.isDirectory()){
            String[] entries = file.list();
            for(String filename : entries)
                displayIt(new File(file, filename));
        }
    }


}
