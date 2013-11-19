/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Instlogin
 */
public class CustomErrorHandling {
    
     public static final boolean isNull_Empty(Object o){
        boolean b=true;
        if(o==null||o==""||o==" "){
            b=true;
        }else{b=false;}
        return b;
    }

    
}
