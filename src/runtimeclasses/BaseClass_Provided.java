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
public class BaseClass_Provided extends BaseClass{
    
    public void baseMethod(){
        System.out.println("This is the provided BaseClass when no config file is present.");
    }
    
}
