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
public class UserMethod {
    private static class Node{
    private int value;
    private Node next;
    private Node prev;
    public Node (int v, Node nxt,Node prv)
    {
        value =v;
        next =nxt;
        prev=prv;
    }
    public Node (int v)
    {
        value=v;
        next=this;
        prev=this;
    }
    }
    private Node head=null;
    private Node tail=null;
    private int size=0;
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public int peekHead()
    {
        if(isEmpty())
            throw new IllegalStateException("EmptyListExeption");
        return head.value;
    }
    
    
    
    
    
   public void addHead(int value)
   {
       Node newnode =new Node (value,null,null);
       if(size==0)
       {
           tail=head=newnode;
           newnode.next=newnode;
           newnode.prev=newnode;
       }
       else
       {
           newnode.next=head;
           newnode.prev=head.prev;
           head.prev=newnode;
           newnode.prev.next=newnode;
           head=newnode;
       }
       size++;
   }
   
   
   
   
   public void print()
   {
       if(isEmpty())
       {
           return;
       }
       Node temp=head;
       while(temp!=tail)
       {
           System.out.println(temp.value+"");
           temp=temp.next;
       }
       System.out.println(temp.value);
   }
   
   
   
   
   public void addTail(int value)
   {
       Node newNode=new Node(value,null,null);
       if(size==0)
       {
           head=tail=newNode;
           newNode.next=newNode;
           newNode.prev=newNode;
       }
       else
       {
           newNode.next=tail.next;
           newNode.prev=tail;
           tail.next=newNode;
           newNode.next.prev=newNode;
           tail=newNode;
       }
       size++;
   }
   
   
   
   
   public void DeleteList()
   {
       head=null;
       tail=null;
       size=0;
   }
   
   
   
   public boolean Ispresent(int key)
   {
       Node temp=head;
       if(head==null)
           return false;
       do{
           if(temp.value==key)
           {
               System.out.println("present");
               return true;
           }
           temp=temp.next;
       }while(temp!=head);
       return false;
   }
   
   
   
   
   
   public int removeHead()
   {
       if(size==0)
           throw new IllegalStateException("EmptyListException");
       int value=head.value;
       size--;
       if(size==0)
       {
           head=null;
           tail=null;
           return value;
       }
       Node n1=head.next;
       n1.prev=tail;
       tail.next=n1;
       head=n1;
       return value;
   }
   
   
   
   
   public int removeTail()
   {
       if(size==0)
           throw new IllegalStateException("EmptyListException");
       int value=tail.value;
       size--;
       if(size==0)
       {
           head=null;
           tail=null;
           return value;
       }
       Node n2=tail.prev;
       n2.next=head;
       head.prev=n2;
       tail=n2;
       return value;
   }
   
   

   
}
