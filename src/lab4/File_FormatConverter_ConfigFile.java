/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gclark7
 */
public class File_FormatConverter_ConfigFile implements File_FormatConverter{

     //ascii values: space=32, #=35, newline (maybe)10
     private char comment=35;//avoid config comments
     private char delimiter=32;//variables and values are separated by a single space
     private char space=32;//spaces must separate # from comment
     private char nl=000;
     private char nline=13;//13 carriage return, 10 line feed
     private String rec="Rec";
     private int recNum=0;

    public File_FormatConverter_ConfigFile(){
        
    }
    /**
     * maps the data and returns it to sender
     * @param fileData String value of a read file
     * @return 
     */
    @Override
    public Map mapFile(String fileData) {
        Map<String,String> m = new HashMap<String,String>();
       
        return m;
    }//mapFile

    
    
    
    
    /**
     * This one is the one I am working with!!!!!!!!!!!!!!!!
     * @param fileData
     * @return 
     */
    @Override
    public Map mapFile(List<String> fileData) {
         Map<String,Map> dataMap = new LinkedHashMap<String,Map>();
         Map<String,String>dataValues=new LinkedHashMap<String,String>();
         String variable="";
         String value="";
         String rec="Rec";
          //String v="";
          //String vd="";
         
        if(!CustomErrorHandling.isNull_Empty(fileData)){
            
//        }else{
            recNum=fileData.size();
            String line; 
//          
            for(int i=0;i<recNum;i++){
                System.out.println(fileData.get(i));
                line= fileData.get(i);
               // if(fileData.get(i).charAt(0)!=nline && fileData.get(i).charAt(0)!=comment && fileData.get(i).charAt(0)!=space ){
                if(!line.isEmpty()){
                    if(fileData.get(i).charAt(0)!=comment && fileData.get(i).charAt(0)!=space ){    
                        int d=line.indexOf(delimiter);
                        variable=line.substring(0, d)+" ";
                        value=line.substring(d+1, line.length());

    //                    System.out.println("from configFile Converter " + variable + " " + value);

                        dataValues.put(variable, value);

                    }else{
                        variable=comment+""+i+" ";
                        //int trm=line.lastIndexOf(comment);
                        int trm=line.indexOf(space);
                        value=line.substring(trm+1, line.length());
                        value=value.trim();

                        dataValues.put(variable, value);
                    }//else line is a comment
                }//if line !isEmpty()
                 
            }//loops through file lines
            dataMap.put(rec, dataValues);
        }
//        for(Object dm:dataMap.keySet()){
//            for(Map m:dataMap.values())
//            System.out.println("From ConfigConverter " + m.get(dm));
//        }
        
        return dataMap;
        
    }
    
    
    
    
    
    
    
    
    
    

    public char getComment() {
        return comment;
    }

   
    public char getDelimiter() {
        return delimiter;
    }

    @Override
    public void setDelimiter(char character) {
        this.delimiter = character;
    }

   
    @Override
    public void setCommentCharacter(char character) {
        comment=character;
    }

   
    
    
    
}
