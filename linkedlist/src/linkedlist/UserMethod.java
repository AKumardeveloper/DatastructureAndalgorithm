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
public class UserMethod {
      Node head;
    public void insert(int data)
    {
        Node node=new Node(); 
        node.data=data;
        node.next=null;
        if(head==null)
        {
            head=node;
        }
        else
        {
            Node n=head;
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next=node;
        }
    }
    public void show()
    {
        Node node =head;
        while(node.next!=null)
        {
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }
    public void insertatStart(int data)
    {
        Node node =new Node();
        node.data=data;
        node.next=null;
        node.next=head;
        head=node;
    }
    public void insertAt(int index,int data)
    {
        Node node =new Node();
        node.data=data;
        node.next=null;
        if(index==0)
        {
            insertatStart(data);
        }
        else
        {
        Node n =head;
        for(int i=0;i<index-1;i++)
        {
            n=n.next;
        }
        node.next=n.next;
        n.next=node;
    }
    }
    public void deletion(int index)
    {
        if(index==0)
        {
            head=head.next;
        }
        else
        {
            Node n=head;
            Node n1=null;
            for(int i=0;i<index-1;i++)
            {
                n=n.next;
            }
            n1=n.next;
            n.next=n1.next;
            n1=null;
        }
    }
    public void deletiondata(int data)
    {
        int index=0;
    Node n=head;
    while(n.data!=data)
    {
            n=n.next;
            index++;
        }
        deletion(index);
    }
    public void reverse()
    {
       Node curr=head;
       Node prev=null;
       Node next=null;
       while(curr!=null)
       {
        next=curr.next;//moved one step forword 
        curr.next=prev;//assign null
        prev=curr;//prev me curr ho gya
        curr=next;//curr me previous ho gya 
       }
       head= prev;
    }
    public void sortedInsert(int data)
    {
        Node newNode=new Node();
        Node curr=head;
        if(curr==null|| curr.data>data)
        {
            newNode.next=head;
            head=newNode;
            return;
        }
        while(curr.next!=null && curr.next.data<data)
        {
            curr=curr.next;
        }
        newNode.next=curr.next;
        curr.next=newNode;
    }
    public int lenght()
    {
        Node curr=head;
        int count=0;
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
        System.out.println(count);
        return count;
    }
     public int nthfrombeginning(int index)//for ending startindex=size-index+1
    {
        int size=lenght();
        if(index>size||index<1)
        {
            return Integer.MAX_VALUE;
        }
        Node curr=head;
        int count=0;
        while(curr!=null && count<index-1)
        {
            count++;
            curr=curr.next;
        }
        System.out.println(curr.data);
        return curr.data;
    }
     public boolean loopDetect()
     {
         Node slowptr;
         Node fastptr;
         slowptr=fastptr=head;
         while(fastptr.next!=null && fastptr.next.next!=null)
         {
          slowptr=slowptr.next;
          fastptr=fastptr.next.next;
          if(slowptr==fastptr)
          {
              System.out.println("loop found");
              return true;
          }
         }
        System.out.println("loop not found");
         return false;
     }
      public int loopTypeDetect()
     {
         Node slowptr;
         Node fastptr;
         slowptr=fastptr=head;
         while(fastptr.next!=null && fastptr.next.next!=null)
         {
             if(head==fastptr.next || head==fastptr.next.next)
             {
              System.out.println("Circular loop not found");
              return 2;
             }
          slowptr=slowptr.next;
          fastptr=fastptr.next.next;
          if(slowptr==fastptr)
          {
              System.out.println("loop found");
              return 1;
          }
         }
        System.out.println("loop not found");
         return 0;
     }
      public Node looppointDetect()
     {
         Node slowptr;
         Node fastptr;
         slowptr=fastptr=head;
         while(fastptr.next!=null && fastptr.next.next!=null)
         {
          slowptr=slowptr.next;
          fastptr=fastptr.next.next;
          if(slowptr==fastptr)
          return slowptr;
         }
        System.out.println("loop not found");
         return null;
     }
      public void removeLoop()
      {
          Node looPoint= looppointDetect();
          if (looPoint==null)
              return;
          Node firstptr=head;
          if(looPoint==head)// circular list case
          {
              while(firstptr.next!=head)
                  firstptr=firstptr.next;
              firstptr.next=null;
              return;
          }
          Node secondptr=looPoint;
          while(firstptr.next!=secondptr.next)// general loop case
          {
              firstptr=firstptr.next;
              secondptr=secondptr.next;
          }
          secondptr.next=null;
      }
      public Node findIntersection(Node head, Node head2)
      {
         int l1=0;
         int l2=0;
          Node temphead=head;
          Node temphead2=head2;
          while(temphead!=null)
          {
              l1++;
              temphead=temphead.next;
          }
          while(temphead2!=null)
          {
              l2++;
              temphead2=temphead2.next;
          }
          int diff;
          if(l1<l2)
          {
              Node temp=head;
              head=head2;
              head2=temp;
              diff=l2-l1;
          }
          else 
              diff=l1-l2;
          for(;diff>0;diff--)
              head=head.next;
          while(head!=head2)
          {
              head=head.next;
              head2=head2.next;
          }
          return head;
      }
    
      
}
