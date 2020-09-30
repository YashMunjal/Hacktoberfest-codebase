// Adding each node at last ie. insertion singly linked list at the end......
 
public class LinkedList
{
  class Node
  {
    int data;
    Node next;
    public Node(int d)
    {
      data = d;
      next = null;
    }
  }
  public Node head = null;
  public Node tail = null;
  public void add(int d)
  {
   Node newNode =  new Node(d);
   if(head == null)
   {
     head = newNode;
     tail = newNode;
   }
   else
   {
     tail.next = newNode;
     tail = newNode;
   }
  }
 
  public void display()
  {
    Node current = head;
    if(current == null)
    {
      System.out.println("Empty List");
    }
    else
    {
      while(current != null)
      {
        System.out.println(current.data);
        current = current.next;
      }
    }
  }
    
  
  public static void main(String args[])
  {
    LinkedList li = new LinkedList();
    li.add(1);
    li.add(2);
    li.add(3);
    li.add(4);
    li.add(5);
    li.display();
  }
}