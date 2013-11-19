/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author gclark7
 */
public class Factory_InitialConfig implements Comparable{
//    private static String path="src" + File.separatorChar + "configFileManager.properties";
    private static String path="src" + File.separatorChar + "TestConfig.properties";
    private static String dir="src";
    private static File_Reader fr = new File_ReaderText(new File_FormatConverter_ConfigFile(),path);
    private static final String CONFIG_READER="reader";
    private static final String CONFIG_CONVERTER="fileConverter";
    private static final String CONFIG_WRITER="writer";
    
    //did this for practic
    public static Factory_InitialConfig instance;
    
    /**
     * self-contained instantiation
     * @return instance of Factory_InitalConfig
     **/
    public static Factory_InitialConfig getInstance(){
         if(instance==null){
            instance= new Factory_InitialConfig();
             
        }
         return instance;
    }
    /**
     * private constructor to force singleton
     */
    private Factory_InitialConfig(){
       
    }
    /**
     * 
     * @return FileManager fully configured based upon configFile 
     */
    public static FileManager getDefaultFileManager() {
        FileManager fm=null;
        //factory code to read config file
        //utilize internal reader to read configFile ??
        
        /*//Example code for gacParkingGarage
        String className = fileProperties.getProperty(PARKING_FACILITY+i);
                Class clss = Class.forName(className);
                p = (ParkingFacilityStrategy)clss.newInstance();
        */
        //Map<String,String> m = fr.mapFile();
        //Map<Properties,Object> m = fr.mapFile();
        //Map<Properties,String> m = fr.mapFile();
        Map<String,Map> m = fr.mapFile();//changed format to map<String,Map<String,String>>
        
        if(!CustomErrorHandling.isNull_Empty(m)){
            /*//testing
            System.out.println((String)m.get(CONFIG_CONVERTER));
            System.out.println((String)m.get(CONFIG_READER));
            System.out.println((String)m.get(CONFIG_WRITER));
            for(Object ms:m.keySet()){
                System.out.println(ms);
            }
            * */
            
        //create the reader
            try{
                FileInputStream inputFile = new FileInputStream(path);
                Properties props = new Properties();
                props.load(inputFile);
                inputFile.close();
                
                //String className = m.get(CONFIG_CONVERTER);
                String className = props.getProperty(CONFIG_CONVERTER);
                //System.out.println(props.getProperty(CONFIG_CONVERTER));
                //System.out.println(m.get(CONFIG_CONVERTER));
                Class clss = Class.forName(className);
                File_FormatConverter conv = (File_FormatConverter) clss.newInstance();
                
                //className =  m.get(CONFIG_READER);
                className =  props.getProperty(CONFIG_READER);
                clss = Class.forName(className);
                File_Reader r= (File_Reader)clss.newInstance();
                r.setFile_FormatConverter(conv);
                r.setPath(path);
                
                
                //className =  m.get(CONFIG_WRITER);
                className =  props.getProperty(CONFIG_WRITER);
                clss = Class.forName(className);
                File_Writer w= (File_Writer)clss.newInstance();
                
                fm=new FileManager(r,w,path);
                
            }catch(Exception e){//just catching the error righ now
                System.out.println("Something died here" + e);
            }
            
            
        }
        
        return fm;
        
    }
    
    
    
    
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not really sure what to compare it to..This is a singleton."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static final String getDir(){
        return dir;
    }
    
}
