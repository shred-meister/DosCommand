/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leapfrog.doscommand;
import com.leapfrog.doscommand.commands.Command;
import com.leapfrog.doscommand.commands.DosFactory;
import com.leapfrog.doscommand.commands.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Bishal Aryal
 */
public class Program {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Path n = new Path();
        n.setPath("C:\\Java\\");
        
        DosFactory factory = new DosFactory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command=null;
        do{
            System.out.print(n.returnPath()+">");
            command = reader.readLine();
            String tokens[] = command.split(" ");
            Command c = factory.get(tokens[0]);
            if(c!=null)
                System.out.println(c.execute(tokens[1])+"\n");
            else
                System.out.println("\"" + command + "\" not found.");
        }while(!command.equalsIgnoreCase("exit"));
//        System.out.println("1. Type md for creating new directory.");
//        System.out.println("2. Type cd for changing directory.");
//        System.out.println("3. Type rd for removing directory.");
//        System.out.println("4. Type dir for listing the directory.");
//        System.out.println("5. Type copycon for creating a new file.");
        
        
        
        
        
        
    }

}
