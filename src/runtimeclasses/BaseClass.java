/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimeclasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public abstract class BaseClass {
    
    //Moved to the factory so it is not inherited by subclasses
    //Factory makes more sense to do this anyway.
    
//    public static void createClass(){
//         //create a class at run time...no method bodies yet
//        boolean fileAppend=true;
//       PrintWriter fOut=null;
//       char c=13;
//       char r=10;
//       
//       String runClasses="src" + File.separatorChar + "RunTimeClasses" + File.separatorChar + "MyClass.java";
//       try{
//           fOut=new PrintWriter(new BufferedWriter(new FileWriter(runClasses,false)));
//           
//           String line = "package runtimeclasses;";
//           fOut.write(line);
//           fOut.write(c);
//           fOut.write(r);
//           
//           line="/**@author user created at RunTime**/";
//           fOut.write(line);
//           fOut.write(c);
//           fOut.write(r);
//           
//           line="public class MyClass extends BaseClass{";
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
//           
//           
//       }catch(IOException ioE){
//           System.out.println("Could not write to package RunTimeClasses" + ioE);
//       }finally{
//           try{
//               fOut.close();
//           }catch(Exception e){
//               System.out.println("Could not close package RunTimeClasses" + e);
//           }      
//       }
//       
//       //create the config file
//       String config="src" + File.separatorChar + "config.properties";
//       String var="runTimeConfig";
//       try{
//           fOut=new PrintWriter(new BufferedWriter(new FileWriter(config,false)));
//           
//           String line = var + "Class runtimeclasses.MyClass";
//           fOut.write(line);
//           fOut.write(c);
//           fOut.write(r);
//           
////           
////           line="/**@author user created at RunTime**/";
////           fOut.write(line);
////           fOut.write(c);
////           fOut.write(r);
////           
////           line="public class MyClass {";
////           
////           fOut.write(line);
////           fOut.write(c);
////           fOut.write(r);
////           
////           line="public MyClass(){}";
////           fOut.write(line);
////           fOut.write(c);
////           fOut.write(r);
////           
////           line="}";
////           fOut.write(line);
////           fOut.write(c);
////           fOut.write(r);
//           
//           
//       }catch(IOException ioE){
//           System.out.println("Could not write to configFile" + ioE);
//       }finally{
//           try{
//               fOut.close();
//           }catch(Exception e){
//               System.out.println("Could not close configFile" + e);
//           }      
//       }
//       
//    }
    
    
    public void baseMethod(){
        System.out.println("You've made an extension of the BaseClass");
    }
    
}
