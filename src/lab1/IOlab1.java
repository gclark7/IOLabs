/*
 * For learning purposes magic numbers has been violated...and probably some other critical standards :)
 * 
 * This reads the data from the text file then appends 1 record to the end
 * 
 * it also runs the RunMyClass.java file which works with the following...
 * 
 * The MyClassFactory will create a MyClass.java file and config.properties file
 * The MyClassFactory checks for these files and will either create an instance 
 * of the MyClass.java or it will return the BaseClass_Provided instance
 * 
 * Delete the config file in deafault package and MyClass.java in runtimeclasses to see how this works
 * 
 * Possible implementation for this concept :
 *      allow the user to create a preferences config file
 *      Robotic AI - Save and create dynamic objects as a form of learning : 
 *          Competitions are held for robots to learn which blocks to avoid and which blocks to pick up
 *              Extra credit would be to learn a new method to handle unwanted blocks
 *              The quicker the robot recognizes the correct blocks the better the score
 * 
 */
package lab1;
import runtimeclasses.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gclark7
 */
public class IOlab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        int recordLines=2;//0-2 lines per record
        /*//school path
       String fileSource="H:" + File.separatorChar +"WCTC" +File.separatorChar+ "Semester3" + File.separatorChar +
               "AdvJava"+File.separatorChar+"IOlab1_textFileLocation" + File.separatorChar+"IOlab1_Names.txt";
       */
        //other path
        String fileSource="E:" + File.separatorChar +"WCTC" +File.separatorChar+ "Semester3" + File.separatorChar +
               "AdvJava"+File.separatorChar+"IOlab1_textFileLocation" + File.separatorChar+"IOlab1_ContactInfo.txt";
        
       File file= new File(fileSource);
       BufferedReader fIn=null;
       
      
       
       //read from a file - then write to console
       try{
           fIn= new BufferedReader(new FileReader(file));
           String line = fIn.readLine();
           
           while(line!=null){
               for(int i=0;i<recordLines;i++){
                   System.out.println(line);
                   line=fIn.readLine();//need to continue reading file
                   //System.out.println(line);
                   
                   
               }
               System.out.println(line+"\n");
               line=fIn.readLine();//need to continue reading file
           }
           
       }catch(IOException ioError){
           
       System.out.println("Problem! Cannot read file yo" + ioError);
        } finally {
            try {
                fIn.close();
            } catch(Exception e) {
                System.out.println("Cannot Close File...May not have been opened or it has been moved.");
            }
        }
       
        boolean fileAppend=true;
       PrintWriter fOut=null;
       char c=13;
       char r=10;
       
       try{//output to file
            fOut=new PrintWriter(new BufferedWriter(new FileWriter(fileSource,fileAppend)));
            //String line="Jimmie Falson\n\r17888 Westwood Street\n\rSimpleTown, NH 12345";
            
            
            //String line="Jimmie Falson";// + c + "17888 Westwood Street" + c + "SimpleTown, NH 12345";
            //String line= c +r +"Jimmie Falson" + c + r + "17888 Westwood Street" + c + r + "SimpleTown, NH 12345";
            String line="Jimmie Falson";
            fOut.write(c);
            fOut.write(r);
            fOut.write(line);
            //fOut.write(c);
            //fOut.write(r);
            
            line="17888 Westwood Street";
            fOut.write(c);
            fOut.write(r);
            fOut.write(line);
            //fOut.write(c);
            //fOut.write(r);
            
            line= "SimpleTown, NH 12345";
            fOut.write(c);
            fOut.write(r);
            fOut.write(line);
            //fOut.write(c);
            //fOut.write(r);
            
            line= "454.582.6557";
            fOut.write(c);
            fOut.write(r);
            fOut.write(line);
            
            line= "jfalson726@yamaoole.web";
            fOut.write(c);
            fOut.write(r);
            fOut.write(line);
       
       }catch(IOException ioE){
           System.out.println("Cannot write to file" + ioE);
       }finally{
           try{
            fOut.close();
           }catch(Exception e){
               System.out.println("Cannot Close file...May not have been opened");
           }
       }
       
       //Create a Class and config file at runtime
       
       //Playing with factory and configFile
       RunMyClass.main(args);//won't find the new files until restart
       
       
       
//       //moved to factory
//       //create a class at run time...no method bodies yet
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
//       /*
//       //allow netbeans to find the new files
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(IOlab1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        */
//        //could not run this because files were not found until after execute
//       // BaseClass bCmC= MyClassFactory.getMyClass();
//       //bCmC.baseMethod();
//        
//        //moved above commands to runMyClass
      
       
       
       
       
    }//main
}//class
