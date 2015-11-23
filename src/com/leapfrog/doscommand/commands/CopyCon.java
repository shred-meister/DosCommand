/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.doscommand.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bishal Aryal
 */
public class CopyCon extends Command{

    @Override
    public String execute(String path) {
        
        if(path!=null){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String fileName;
            String pathName = null;
            if(path.contains("\\")){
                String[] ftoken;
                String ps = path.replace("\\", " ");
                ftoken = ps.split(" ");
                fileName = ftoken[ftoken.length - 1];
                pathName = path.substring(0, path.lastIndexOf("\\")+1);
            }
            else{
                fileName = path;
                Path n = new Path();
                try {
                    pathName = n.returnPath();
                } catch (IOException ex) {
                    Logger.getLogger(MakeDirectory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.print("Content of file: ");
            String content = null;
            try {
                content = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(CopyCon.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            File file = new File(pathName + fileName);
            FileWriter fw = null;
            try {
                fw = new FileWriter(file.getAbsoluteFile());
            } catch (IOException ex) {
                Logger.getLogger(ChangeDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }

            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
                File cd = new File(content);
                if(!cd.exists()){
                    cd.mkdir();
                }
            } catch (IOException ex) {
                Logger.getLogger(ChangeDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }

           return("File " + fileName + " written.");
        }
    
        return("The syntax of command is incorrect.");
    }
   
}
