/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class File_WriterText implements File_Writer {
    private String MSG_NULL="Null or empty value was given.";
    private String path;
    private String fileName;
    
    
    public File_WriterText(){
        
    }

   

    @Override
    public void writeFile(Map m, String path, String fileName) throws IOException{
        if(CustomErrorHandling.isNull_Empty(m)|| CustomErrorHandling.isNull_Empty(path) || CustomErrorHandling.isNull_Empty(fileName)){
            throw new UnsupportedOperationException(MSG_NULL);
        }else{
            File f = new File(path+fileName);
           PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(f, false)));
           String s="";
           Map<String,Map> mapped = m;
           for(Object md:mapped.values()){
                Map toFile = (Map)md; 
                for(Object data:toFile.keySet()){
                    System.out.println(toFile.get(data).toString());
                    s=data.toString() + toFile.get(data);
                    //writer.write(toFile.get(data).toString());
                    //writer.write("\n");
                    //writer.print(toFile.get(data));
                    writer.print(s);
                    writer.print("\n");
                } 
                writer.close();
           }
        }
    }

    @Override
    public void writeFile(Map m) throws IOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPath(String path) throws IOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFileName(String fileName) throws IOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeLine(String line) throws IOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
