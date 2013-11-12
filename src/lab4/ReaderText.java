/*
 * Just playing with reading a config file to instantiate objects by calling the converter and passing in the reader
 */
package lab4;

import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class ReaderText extends Reader{

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
