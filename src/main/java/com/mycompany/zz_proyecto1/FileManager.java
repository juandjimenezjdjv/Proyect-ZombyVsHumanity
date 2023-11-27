/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zz_proyecto1;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Juan Jimenez
 */
public class FileManager {
    // escribe un objeto
    public static void writeObject (Object obj, String filePath)
    {
        try{
            //use buffering
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try{
                // escribe el objeto
              output.writeObject(obj);
            }
            finally{
              output.close();
            }
        }  
        catch(IOException ex){
              
        }
        
    }
    
      // escribe un objeto
    public static Object readObject(String filePath){
        try{
            //use buffering
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
            try{
              //deserialize the List
              return input.readObject();
            }
            finally{
                input.close();
                }
            }
            catch(ClassNotFoundException ex){
            }
            catch(IOException ex){
        }
        return null;
    } 
}
