/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S_manager;

import java.util.StringTokenizer;

/**
 *
 * @author Devin
 */
public class NewClass {
    
    int main()
    {
    
    String test="this,is,a,test";
    
    StringTokenizer tokenthing = new StringTokenizer(test,",");
    
    while(tokenthing.hasMoreTokens())
   
    {
        System.out.println(tokenthing.nextToken()+"\n");
        tokenthing.nextToken();
    
    }
    
    return 0;
    }
    
    
    
}
