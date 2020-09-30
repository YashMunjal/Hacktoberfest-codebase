import java.util.*;
import java.io.*;

class circular_linkedlist
{
	static Node head;
	static Node tail;
	
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}

	}
	
	public void print()
	{
		Node last=head;
		while(last.next!=head)
		{
			System.out.println(last.data);
			last=last.next;
		}
		System.out.println(last.data);
	}
	
	public void delete_beginning()
	{
		Node last=head;
		head=last.next;
		tail.next=head;
	}

	public void delete_end()
	{
		Node last=head;
		while(last.next.next!=head)
		{
			last=last.next;
		}
		last.next=head;
		tail.next=head;
	}

	public void delete_position(int pos)
	{
		Node last=head;
		int count=1;
		while(last.next!=head && count<pos-1)
		{
			last=last.next;
			count++;
		}
		last.next=last.next.next;
	}
	public void insert_beginning(int d)
	{	Node n=new Node(d);
		n.next=head;
		head=n;
		tail.next=head;
	
	}

	public void insert_position(int pos, int d)
	{	Node n=new Node(d);
		Node last=head;
		int count=1;
		if(pos==1)
		{
			n.next=head;
			head=n;
			tail.next=head;
		}
		else
		{
			while(last.next!=head)
			{
				last=last.next;
				count++;
				if(count==pos) 
				{
					n.next=last.next;
					last.next=n;
					break;
				}
			}
			
			if(pos>count) System.out.println("Cannot add at index "+ pos+"th");
		}
		
		
	}

	public void insert_end(int d)
	{	Node n=new Node(d);
		
		if(head==null)
		{
			head=n;
			n.next=head;
			tail=n;
		}
		else
		{
			tail.next=n;
			n.next=head;
			tail=n;
		}
	}

	public static void main(String args[])
	{
		circular_linkedlist l = new circular_linkedlist();
		l.insert_end(1);
		l.insert_end(2);
		l.insert_end(3);
		l.insert_end(4);
		l.insert_beginning(5);
		l.insert_position(1,6);
		
		l.delete_beginning();
		l.delete_end();
		l.delete_position(2);
		l.print();
	}
}
