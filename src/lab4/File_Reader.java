/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.List;
import java.util.Map;

/**
 *
 * @author gclark7
 */
public interface File_Reader {
    /**
     * sets the file format converter for the reader object to map out data
     * @param fc File_FormatConverter Object
     */
    public abstract void setFile_FormatConverter(File_FormatConverter fc);
    public abstract File_FormatConverter getFile_FormatConverter();
    /**
     * uses default file path
     */
    public abstract void readFile();
    /**
     * alternative read to a provided directory
     * @param path is the provided directory to read file from -- will not use default path
     */
    public abstract void readFile(String path);
    
    /**
     * used to return a dataMap of the file after reading the file
     * @return dataMap of file -- 
     */
    public abstract Map mapFile();
    
    public abstract void setPath(String path);
    
    
}
