/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.Map;

/**
 *
 * @author gclark7
 */
public interface File_Writer {
    
    /**
     * Default writer overwrites existing file
     * writes a file from a Map Object
     * @param m Map of data to be written to file
     * @param path for file to be written to
     */
    public abstract void writeFile(Map m, String path, String fileName)throws IOException;
    /**
     * Uses default path to output file and a default file name
     * This will overwrite an existing file
     * 
     * @param m file map provided by a converter or custom file reader
     */
    public abstract void writeFile(Map m)throws IOException;
    public abstract void setPath(String path)throws IOException;
    public abstract void setFileName(String fileName)throws IOException;
    /**
     * Writes one line at a time to the default path and file
     * Set the default path and name prior to writing to a different file 
     * 
     * @param line String intended to be written to file
     */
    public abstract void writeLine(String line)throws IOException;
    //public abstract void setFileFormatConverter(File_FormatConverter fc);
}
