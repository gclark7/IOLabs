/*
 * Flexible reader takes in a path
 * methods read the file and return records
 * 
 */
package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class ReadFile {
     /*//school path
    private String path="H:" + File.separatorChar +"WCTC" +File.separatorChar+ "Semester3" + File.separatorChar +
               "AdvJava"+File.separatorChar+"IOlab1_textFileLocation" + File.separatorChar+"IOlab1_ContactInfo.txt";
       */
       
    private String path="E:" + File.separatorChar +"WCTC" +File.separatorChar+ "Semester3" + File.separatorChar +
               "AdvJava"+File.separatorChar+"IOlab1_textFileLocation" + File.separatorChar+"IOlab1_ContactInfo.txt";;
    
    private int linesPerRecord=4;
    
    //Constructors
    public ReadFile(){
        
    }
    
    public ReadFile(String path){
        this.path=path;
    }
    
    
    //Methods
    
    /**
     * default record finder will use current path or default path in ReadFile Class
     * @param i index of record in file, line 1 is index 0
     */
    public void showRecordAtSpecifiedIndex(int x){
        int recordsInFile=0;
        int findRecord=x;
        int countRecord=0;
       File file= new File(path);
       BufferedReader fIn=null;
       
        
         //Check number of records prior to search & output
        try{
           fIn= new BufferedReader(new FileReader(file));
           String line = fIn.readLine();
           
            while(line!=null){
                recordsInFile++;
                for(int i=0;i<linesPerRecord;i++){
                   line=fIn.readLine();//need to continue reading file
                }
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
        //*************Step 2 check records in file agains index requested*******************************
       
        if(recordsInFile<findRecord){
            System.out.println("There are only "+recordsInFile + " records");
        }else{
            try{
           fIn= new BufferedReader(new FileReader(file));
           String line = fIn.readLine();
           
           while(line!=null){
               countRecord++;
               for(int i=0;i<linesPerRecord;i++){
                   if(countRecord==findRecord){
                   System.out.println(line);
                   }
                   line=fIn.readLine();//need to continue reading file
                   //System.out.println(line);
                   
                   
               }
               if(countRecord==findRecord){
               System.out.println(line+"\n");
               }
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
      }

    }//method
    
    /**
     * record finder will use path provided to find the record at provided index
     * line 1 is index 0
     * @param path file location
     * @param i index of the line in the file
     */
     public void showRecordAtSpecifiedIndex(String userPath, int x){
        int recordsInFile=0;
        int findRecord=x;
        int countRecord=0;
       File file= new File(userPath);
       BufferedReader fIn=null;
       
        
         //Check number of records prior to search & output
        try{
           fIn= new BufferedReader(new FileReader(file));
           String line = fIn.readLine();
           
            while(line!=null){
                recordsInFile++;
                for(int i=0;i<linesPerRecord;i++){
                   line=fIn.readLine();//need to continue reading file
                }
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
         
        //*************Step 2 check records in file agains index requested*******************************
        if(recordsInFile<findRecord){
            System.out.println("There are only "+recordsInFile + " records");
        }else{
            try{
           fIn= new BufferedReader(new FileReader(file));
           String line = fIn.readLine();
           
           while(line!=null){
               countRecord++;
               for(int i=0;i<linesPerRecord;i++){
                   if(countRecord==findRecord){
                   System.out.println(line);
                   }
                   line=fIn.readLine();//need to continue reading file
                   //System.out.println(line);
                   
                   
               }
               if(countRecord==findRecord){
               System.out.println(line+"\n");
               }
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
      }
    }

    //Getters & Setters
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLinesPerRecord() {
        return linesPerRecord;
    }

    public void setLinesPerRecord(int linesPerRecord) {
        this.linesPerRecord = linesPerRecord;
    }
     
    
}
