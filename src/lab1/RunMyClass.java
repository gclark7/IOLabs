/*
 * For learning purposes magic numbers rules have been violated
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

//import java.lang.reflect.Type;
//import com.sun.org.apache.bcel.internal.generic.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import runtimeclasses.*;
import runtimeclasses.MyClassFactory;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class RunMyClass {
    
    public static void main(String[] args) {
        
        //11/5/2013 factory creates config file & associated MyClass
        BaseClass m=MyClassFactory.getMyClass();
        m.baseMethod();
        //issue is creating a file in the same package does not refresh until runtime is complete
        //consider creating and running files from outside the package
        //research another way to restart the system after creation
//         try {
//            Thread.sleep(7000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(IOlab1.class.getName()).log(Level.SEVERE, null, ex);
//        }
         //wont find the configFile or class until after runtime
        //addding a check in the factory for fileExists()
//        BaseClass myC=null;
//        if(MyClassFactory.doesConfigFileExist()){
//       myC= MyClassFactory.getMyClass();
//        }else{myC=new BaseClass_Provided();}
//       myC.baseMethod();
       
        
        /*//playing with the use of generics...pretty sure this is not the intent of the T diamond
        // Flower <T extends Rose & Flower>br = new <T extends Rose & Flower>BeautifulRose();
       // Flower <Rose, Flower>br = new <Rose,Flower>BeautifulRose();
       BeautifulRose br = new BeautifulRose();
        Rose r;
        r=(Rose)br;
        r.bloom();
        */
        //it seems bounded and multibounded is for compareTo() not for composition.
    }
    
}
