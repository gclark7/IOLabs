/*
 * This is the top level - Service Class
 */
package lab4;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author gclark7
 */
public class FileManager implements Comparable, Serializable{
    
    private File_Reader reader;
    private File_FormatConverter fc;
    private File_Writer writer;
    private String path ="";
    private File f;
    /**
     * default constructor
     */
    public FileManager(){
        
    }
    
    public FileManager(File_Reader r, File_Writer w, String path){
        setReader(r);
        setWriter(w);
        setPath(path);
        f= new File(path);
    }
    
    /**
     * Alternate constructor sets writer and reader converter and path
     * @param r File_Reader
     * @param w File_Writer
     * @param path default file directory
     */
    public FileManager(File_Reader r, File_FormatConverter fc, File_Writer w, String path){
        setReader(r);
        setFormatConverter(fc);
        setWriter(w);
        setPath(path);
    }
    /**
     * alternative constructor sets directory path
     * @param path is the default path to root directory
     */
    public FileManager(String path){
        this.path=path;
    }

    
    public File_Reader getReader() {
        return reader;
    }

    public void setReader(File_Reader reader) {
        this.reader = reader;
    }

    public File_Writer getWriter() {
        return writer;
    }

    public void setWriter(File_Writer writer) {
        this.writer = writer;
    }

    public File_FormatConverter getFormatConverter() {
        return fc;
    }

    public void setFormatConverter(File_FormatConverter fc) {
        this.fc = fc;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.reader != null ? this.reader.hashCode() : 0);
        hash = 43 * hash + (this.writer != null ? this.writer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileManager other = (FileManager) obj;
        if (this.reader != other.reader && (this.reader == null || !this.reader.equals(other.reader))) {
            return false;
        }
        if (this.writer != other.writer && (this.writer == null || !this.writer.equals(other.writer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FileManager{" + "reader=" + reader + ", writer=" + writer + '}';
    }

    @Override
    public int compareTo(Object o) {
        //need to get the code for this...I remember -1,0,1 but how to compare??
        throw new UnsupportedOperationException("Not supported yet.");//To change body of generated methods, choose Tools | Templates.
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * reads a file and returns a map of the data
     * @return HashMap data map of the file
     */
   public Map mapFile(){
       return reader.mapFile();
   }
   
   public File getFile(){
       return f;
   }
   
   public void setFile(String s){
       f=new File(s);
   }
   
    
    

   
    
    
    
}
