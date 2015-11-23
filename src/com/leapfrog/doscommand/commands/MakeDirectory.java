/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.doscommand.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bishal Aryal
 */
public class MakeDirectory extends Command{
    
    @Override
    public String execute(String path) {
        if(path!=null){
            if(path.contains("\\")){
                File pfile = new File(path);
                if(!pfile.exists()){
                    if(pfile.mkdir())
                        return("New directory \"" + path + "\" created.");
                   }
            }
            
            Path n = new Path();
            String p = null;
            try {
                p = n.returnPath()+path;
            } catch (IOException ex) {
                Logger.getLogger(MakeDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            File dfile = new File(p);
            if(!dfile.exists()){
                if(dfile.mkdir())
                    return("New directory \"" + p + "\" created.");
            }
        }
    return("Failed to create a directory.");
    }


}
