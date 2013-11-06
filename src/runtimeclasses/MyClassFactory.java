/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimeclasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class MyClassFactory {
    
    private static File configFile = new File("src" + File.separatorChar + "config.properties");
    private static Properties props = new Properties();
    private static FileInputStream fIn;// 
    private static String varClass="runTimeConfigClass";
    
    /**
     * playing with creating Class.java files
     * This method creates and so overwrites the existing MyClass.java
     * and the associated config file
     */
    private static final void createClass(){
         //create a class at run time...no method bodies yet
        boolean fileAppend=true;
       PrintWriter fOut=null;
       char c=13;
       char r=10;
       
       String runClasses="src" + File.separatorChar + "RunTimeClasses" + File.separatorChar + "MyClass.java";
       try{
           fOut=new PrintWriter(new BufferedWriter(new FileWriter(runClasses,false)));
           
           String line = "package runtimeclasses;";
           fOut.write(line);
           fOut.write(c);
           fOut.write(r);
           
           line="/**@author user created at RunTime**/";
           fOut.write(line);
           fOut.write(c);
           fOut.write(r);
           
           line="public class MyClass extends BaseClass{";
           
           fOut.write(line);
           fOut.write(c);
           fOut.write(r);
           
           line="public MyClass(){}";
           fOut.write(line);
           fOut.write(c);
           fOut.write(r);
           
           line="}";
           fOut.write(line);
           fOut.write(c);
           fOut.write(r);
           
           
       }catch(IOException ioE){
           System.out.println("Could not write to package RunTimeClasses" + ioE);
       }finally{
           try{
               fOut.close();
           }catch(Exception e){
               System.out.println("Could not close package RunTimeClasses" + e);
           }      
       }
       
       //create the config file
       String config="src" + File.separatorChar + "config.properties";
       String var="runTimeConfig";
       try{
           fOut=new PrintWriter(new BufferedWriter(new FileWriter(config,false)));
           
           String line = var + "Class runtimeclasses.MyClass";
           fOut.write(line);
           fOut.write(c);
           fOut.write(r);
           
//           
//           line="/**@author user created at RunTime**/";
//           fOut.write(line);
//           fOut.write(c);
//           fOut.write(r);
//           
//           line="public class MyClass {";
//           
//           fOut.write(line);
//           fOut.write(c);
//           fOut.write(r);
//           
//           line="public MyClass(){}";
//           fOut.write(line);
//           fOut.write(c);
//           fOut.write(r);
//           
//           line="}";
//           fOut.write(line);
//           fOut.write(c);
//           fOut.write(r);
           
           
       }catch(IOException ioE){
           System.out.println("Could not write to configFile" + ioE);
       }finally{
           try{
               fOut.close();
           }catch(Exception e){
               System.out.println("Could not close configFile" + e);
           }      
       }
       
    }
    
    /**
     * Checks to see if the config file and associated Class are created
     * if false, create Class and config file
     * @return if configFile exists, this method returns an instance of MyClass
     */
    public static BaseClass getMyClass(){
        BaseClass m=null;//base class
        if(configFile.exists()){
            try{
                fIn=new FileInputStream(configFile);
                props.load(fIn);
                try{
                    fIn.close();
                }catch(Exception e){
                    System.out.println("Cannot close configFileStream" + e);
                }

                String clssName = props.getProperty(varClass);
                Class clss = Class.forName(clssName);
                m= (BaseClass)clss.newInstance();


            }catch(Exception e){
                System.out.println("configFile exception" + e);
            }

        }else{
            m=new BaseClass_Provided();
            createClass();
           
        }
        return m;
    
    }
    
    /**
     * Looks for Config.properties file in a MyClassFactory variable specified path
     * @return true or false file found at configFile variable path destination
     */
    public static boolean doesConfigFileExist(){
        return configFile.exists();
    }
}
