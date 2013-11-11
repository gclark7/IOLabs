/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gclark7
 */
public class File_ReaderText implements File_Reader {

    private File_FormatConverter fc;
    private String path;
    private String fileLines;
    private List fileRecordList;
    private final String MSG_NULL="Received Null Value from user";
    private final String MSG_FILE_PROBLEM="Problem! Cannot read file yo";
    private final String MSG_FILE_CLOSE_PROBLEM="Cannot Close File...May not have been opened or it has been moved.";
    
    
    
    
    public File_ReaderText(){
        
    }
    
    
    /**
     * default Constructor
     * @param path directory to read file from
     */
    public File_ReaderText(String path){
        
        setPath(path);
    }
    
    /**
     * inclusive constructor provide a file path and format converter
     * @param fc File_FormatConverter
     * @param path file directory
     */
    public File_ReaderText(File_FormatConverter fc, String path){
        setFile_FormatConverter(fc);
        setPath(path);
    }
    
  

    /**
     * Builds a continuous String from file data && an ArrayList of the data
     * then sends the ArrayList to the converter
     * sets the variable lineData = to the string
     */
    @Override
    public void readFile() {
       File file= new File(path);
       BufferedReader fIn=null;
       fileRecordList= new ArrayList();
       
        try{
           fIn= new BufferedReader(new FileReader(file));
           String line = fIn.readLine();

           while(line!=null){
               fileLines+=line;//11/9/2013 I think this is taking a null value
               fileRecordList.add(line);//This is the ArrayList
               line=fIn.readLine();//need to continue reading file
               //fileLines+=line;
               
           }
           
       }catch(IOException ioError){
           
       System.out.println(MSG_FILE_PROBLEM + ioError);
        } finally {
            try {
                fIn.close();
            } catch(Exception e) {
                System.out.println(MSG_FILE_CLOSE_PROBLEM + e);
            }
        }
    }

    @Override
    public void readFile(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * mapping the file is the job of the converter.  This method delegates to the converter provided at instantiation
     * @return Map of file data
     */
    @Override
    public Map mapFile() {
       readFile();
       //return fc.mapFile(fileLines);//original string 
       return fc.mapFile(fileRecordList);
       
    }

    public File_FormatConverter getFc() {
        return fc;
    }

    @Override
    public void setFile_FormatConverter(File_FormatConverter fc) {
        if(CustomErrorHandling.isNull_Empty(fc)){
            throw new UnsupportedOperationException(MSG_NULL);
        }else{this.fc = fc;}
    }
    
    @Override
    public File_FormatConverter getFile_FormatConverter() {
        return fc;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        if(CustomErrorHandling.isNull_Empty(path)){
            throw new UnsupportedOperationException(MSG_NULL);
        }else{this.path = path;}
    }

   

    
}
