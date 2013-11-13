/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class File_FormatConverter_DelimitedFile implements File_FormatConverter{
    
    
     //ascii values: space=32, #=35, newline (maybe)10, comma=44
     private char comment=35;//avoid config comments
     private char delimiter=44;//variables and values are separated by a single space

    public File_FormatConverter_DelimitedFile(){
        
    }
    
    @Override
    public Map mapFile(String fileData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method maps a delimited file.  First line must be the headers for each data field. <br/>
     * Subsequent lines are the data values for the field.
     * Preset delimeter is the comma.  Set delimiter prior to this method if different from default.
     * @param fileData List created by File_Reader
     * @return fileData HashMap of data  
     */
    @Override
    public Map mapFile(List<String> fileData) {
        Map<String,Map> dataMap = new HashMap<String,Map>();
        Map<String,String> valuesMap= new HashMap<String,String>();
        int recSize=fileData.size();
        String rec="Rec";
        
        if(!CustomErrorHandling.isNull_Empty(fileData)){
            int headerCount=0;
            //iterate over the first line in the list to find field count
            String lineOne=fileData.get(0);
            for(int i=0;i<lineOne.length();i++){
                if(lineOne.charAt(i)==delimiter){
                    headerCount++;
                }
            }
            //create the headers to avoid iterating over the first line again and again
            String[] headerFields = new String[headerCount+1];
            
            char[] c=lineOne.toCharArray();
            //loop through c
            //place values into headerFields
            int x=0;
            String value="";
            for(int i=0;i<c.length;i++){
               if(c[i]==delimiter){
                   headerFields[x]=value;
                   x++;
                   value="";
               }else{value+=c[i];}
                
            }
            //place the last value into headerFields[] because value after last comma is ignored prior to this
            headerFields[x]=value;
            value="";
            x=0;
            
            //map the data starting on 1st line of data values
            for(int i=1;i<recSize;i++){
                c=fileData.get(i).toCharArray();
                for(int j=0;j<c.length;j++){
                    if(c[j]==delimiter){
                        valuesMap.put(headerFields[x], value);
                        x++;
                        value="";
                    }else{value+=c[j];}
                
                }
                //put the last value into valuesMap then reset variables
                valuesMap.put(headerFields[x], value);
                value="";
                x=0;
                dataMap.put(rec+i, valuesMap);
            }
            
        }
        
        return dataMap;
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
