/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublycircularlist;

/**
 *
 * @author ashish gupta
 */
public class DoublyCircularList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserMethod list=new UserMethod();
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        list.addHead(4);
        list.addHead(5);
        list.addHead(6);
        list.addTail(8);
        list.removeTail();
        list.print();
    }
    
}
