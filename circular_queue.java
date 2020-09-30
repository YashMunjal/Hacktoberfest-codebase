import java.util.*;
import java.io.*;
class circular_queue
{
	static  int size;
	public int top;
	static int front;
	static int rear;
	static int qarr[];
	circular_queue(int s)
	{
		size = s;
		front = -1;
		rear = -1;
		qarr = new int[size];
	}
	public static void enqueue(int num)
	{
		if(rear == (front-1)%(size-1) || front == 0 && rear == size-1)
		{
			System.out.println("Queue is full");
			return;
		}	
		if(front == -1 && rear == -1)
		{
			front++;
			rear++;
		}
		else if(rear == size-1 && front!=0)
		{
			rear = 0;
		}
		else
		{
			rear++;
		}
		qarr[rear] = num;
	}

	public static int dequeue()
	{	
		
		if(front == -1 )
		{	System.out.println("queue is empty");
			return -1;
		}

		int temp = qarr[front];
		if(front == rear)
			front = rear =-1;
		else if(front == size-1)
		{
			front = 0;
		}
		else
			front++;
		
		return temp;
	}

	public static void main(String args[])
	{
		circular_queue c = new circular_queue(5);
		c.enqueue(5);
		c.enqueue(4);
		c.enqueue(3);
		c.enqueue(2);
		c.enqueue(1);
		System.out.println(c.dequeue());
		c.enqueue(0);
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
		System.out.println(c.dequeue());
	}
}
