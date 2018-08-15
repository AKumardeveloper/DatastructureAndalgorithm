/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;
/**
 *
 * @author ashish gupta
 */
public class Linkedlist {

  
    public static void main(String[] args) {
        
        UserMethod list=new UserMethod();
        list.insert(2);
        list.insert(4);
        list.insert(7);
        list.insert(18);
        list.insert(29);
        list.insert(7);
        list.loopTypeDetect();
        list.show();
    }
    
}
