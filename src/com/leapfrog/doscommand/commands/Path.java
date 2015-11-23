/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.doscommand.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bishal Aryal
 */
public class Path {
    
    File file = new File("C:\\Java\\path.txt");

    public String getPath() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a new path: ");
        String path = reader.readLine();
        return path;
    }
    
    public void setPath(String path){
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
    }
    
    public String returnPath() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String path = reader.readLine();
        return path;
    }
    
}
