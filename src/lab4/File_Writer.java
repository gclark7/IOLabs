/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

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
    public abstract void writeFile(Map m, String path);
    public abstract void writeFile(String s, String path);
}
