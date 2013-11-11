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
public interface File_FormatConverter {
    public abstract Map mapFile(String fileData);
    public abstract Map mapFile(List<String> fileData);
    public abstract void setDelimiter(char character);
    public abstract void setCommentCharacter(char character);
    
}
