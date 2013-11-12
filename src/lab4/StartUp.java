/*
 * All best practices have been adhered to in order to develop the most efficient 
 * way of building an application
 * 
 * 
 */
package lab4;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author gclark7
 */
public class StartUp {
    
    public static void main(String[] args) {
        
        //testing as we go
        //Test 1
        
        FileManager fm = new FileManager();
        fm.setReader(new File_ReaderText(new File_FormatConverter_ConfigFile(),"src" + File.separatorChar + "configFileManager.properties"));
        //fm.getReader().mapFile();
        
        
        
        //Test2
//        FileManager fm=Factory_InitialConfig.getDefaultFileManager();
//        fm.getReader().setPath("src" + File.separatorChar + "CSV.csv");
//        
//        System.out.println(fm.mapFile());
//        
//        System.out.println("************Custom Delimited*************");
//        fm.getReader().setPath("src" + File.separatorChar + "CustomDelimited.dlm");
//        fm.getReader().getFile_FormatConverter().setDelimiter('|');
        
        
        
        System.out.println(fm.mapFile());
        System.out.println("********Loop trial*-*****");
        Map<String,Map> mappy = fm.mapFile();
        //Map mappy = fm.mapFile();
        for(Object m:mappy.values()){
            System.out.println(m);
            //Map mps = m;
            //mappy.get(m);
            Map s=(Map)m;
            for(Object r:s.keySet()){
                System.out.println(r + " " +s.get(r) );
                //System.out.print(s.get(r));
                
            }
//            System.out.println(fm.mapFile().get(m).);
//            for(Object r:map.keySet())
        }
        
        System.out.println("*************ConfigData***************");
         for(Object m:mappy.values()){
            System.out.println(m);
            //Map mps = m;
            //mappy.get(m);
            Map<Object,Object> s=(Map)m;
            
            for(Object r:s.keySet()){
                System.out.println(r + " " +s.get(r) );
                //System.out.print(s.get(r));
                
            }
         }
        

    }
}
