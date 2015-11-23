/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.doscommand.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bishal Aryal
 */
public class ChangeDirectory extends Command{

    @Override
    public String execute(String path) {
        
        if(path!=null){
            File file = new File("C:\\Java\\path.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(file.getAbsoluteFile());
            } catch (IOException ex) {
                Logger.getLogger(ChangeDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }

            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(path);
                File cd = new File(path);
                if(!cd.exists()){
                    cd.mkdir();
                }
            } catch (IOException ex) {
                Logger.getLogger(ChangeDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }

            return("Directory changed to " + path +".");
        }
    return("The syntax of command is incorrect.");  
        
    }

    
}
