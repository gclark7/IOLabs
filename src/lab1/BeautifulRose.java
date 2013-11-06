/*
 * Playing with generics...This does not do what I had hoped
 * Not really a composition technique.
 */
package lab1;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class BeautifulRose <T extends Rose & Flower> {
    //jdk 7 api says "A type variable with multiple bounds is a subtype of all the types listed in the bound. 
    //If one of the bounds is a class, it must be specified first."
    
    //Thought this may be a way of extending a super class or interface
    
    
    
}
