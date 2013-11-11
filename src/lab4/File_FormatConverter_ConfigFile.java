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
        //removed file reading to keep principle of least knowledge
//        File file= new File(fileData);
//        BufferedReader fIn=null;
        
        for(int i=0;i<fileData.length();i++){
           //testing
            //ascii values: space=32, #=35, newline (maybe)10
            if(fileData.charAt(i)==10){
                System.out.println();
            }
            System.out.print(fileData.charAt(i));
        }
        return m;
    }//mapFile

    @Override
    public Map mapFile(List<String> fileData) {
         Map<String,String> m = new HashMap<String,String>();
        if(CustomErrorHandling.isNull_Empty(fileData)){
            
        }else{
            
           
            /*//need to play with iterators
            Iterator iterate=fileData.listIterator();
            while(iterate.hasNext()){
                //nothing
            }
            * */
            
            //find lines with variables
            for(int i=0;i<fileData.size();i++){
////testing
//            //System.out.println(fileData.size());
//                System.out.println(fileData.get(i));
//            System.out.println(fileData.get(i).charAt(0));
                if(fileData.get(i).charAt(0)!=comment){
                    //break line into useable parts
                    int spaceAt=fileData.get(i).indexOf(delimiter);
                    char[] variable=new char[spaceAt];
                    char[] value=new char[fileData.get(i).length()-spaceAt];
                    
                    fileData.get(i).getChars(0, spaceAt, variable, 0);
                    fileData.get(i).getChars(spaceAt+1, fileData.get(i).length(), value, 0);
//                    
//                    //a loop is not needed...The above method returns the needed chars between delimaters
//                    /*
//                    for(int lineChar=0;lineChar<spaceAt;lineChar++){
//                        //working on this 11-8-2013
//                        //variable+=fileData.get(i).getChars(spaceAt, spaceAt, dst, spaceAt);
//                    }
//                    for(int lineChar=spaceAt+1;lineChar<fileData.get(i).length();lineChar++){
//                        //working on this 11-8-2013
//                        value+=fileData.get(lineChar);
//                    }
//                    * */
                    //convert char array to string
                     String v="";
                     String vd="";
                     for(int x=0;x<variable.length;x++){
                         v+=variable[x];
                     }
                     for(int x=0;x<value.length;x++){
                         vd+=value[x];
                     }
                     
                     m.put(v, vd);//enter strings in to map
                }
            }
                
            
        }
        
        return m;
        
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
