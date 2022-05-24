import java.util.*;

public class MyLinkedList
{
	public static final int ID = 201411; //add your student ID here
		
	private ListNode front;

	public class ListNode //******** INNER CLASS ********
	{
		int      data;
		ListNode next;

		public ListNode(int data) { this.data = data; }
		public ListNode(int data, ListNode next) { this.data = data; this.next = next; }

		@Override
		public String toString() { return "" + this.data; }
	}

	public MyLinkedList() //not actually necessary but included for clarity
	{
		front = null;
	}

	public MyLinkedList(int val)
	{
		front = new ListNode(val);
	}

	/** for ease of testing, you can construct a MLL object with initial values:
	 *     MyLinkedList list = new MyLinkedList(1, 2, 3, 4);
	 */
	public MyLinkedList(int... vals)
	{
		if (front == null) front = new ListNode(vals[0]);

		ListNode current = front;

		for (int i = 1; i < vals.length; i++) {
			current.next = new ListNode(vals[i]);
			current = current.next;
		}
	}

	@Override
	public String toString()
	{
		String result = "[";

		ListNode current = front;

		while (current != null)
		{
			if (current.next == null) //reached last element in the list
				result += current.data;

			else
				result += current.data + ", ";

			current = current.next;
		}
		result += "]";

		return result;
	}

	public ListNode getFront() { return this.front; }

	/********************************************
	 ********** QUIZ METHODS BELOW HERE *********
	 ********************************************/

	//#1
	public void replaceLast(int n)
	{
		if(front == null){
			return;
		}
		ListNode current = front;
		while(current.next!=null){
			current = current.next;
		}
		current.data = n;
	}

	//#2
	public int lastIndexOf(int val)
	{
		int index = -1;
		int count = 0;
		ListNode current = front;
		while(current!=null){
			if(current.data==val){
				index = count;
			}
			count++;
			current = current.next;
		}
		return index;
	}

	//#3
	public int countDuplicates()
	{
		int dupes = 0;
		int prev = front.data;
		ListNode current = front.next;
		while(current!=null){
			if(current.data == prev){
				dupes++;
			}
			prev = current.data;
			current = current.next;
		}
		return dupes;
	}

	//#4
	public void stutter()
	{
		ListNode current = front;
		int count = 0;
		while(current!=null){
			if(count%2==0){
				ListNode temp = current.next;
				current.next = new ListNode(current.data);
				current.next.next = temp;
			}
			count++;
			current = current.next;
		}
	}

	//#5
	public void removeAll(int n)
	{
		while(front.data==n){
			front = front.next;
		}
		ListNode current = front;
		while(current.next!=null){
			if(current.next.data == n){
				current.next = current.next.next;
			}
			current = current.next;
		}
	}

	//#6
	public int deleteLast()
	{
		ListNode current = front;
		while(current.next.next!=null){
			current = current.next;
		}
		int val = current.next.data;
		current.next = null;
		return val;
	}

	/** You can test your methods below if you'd like */
	public static void main(String[] args)
	{
		MyLinkedList x = new MyLinkedList(1, 8, 19, 4, 17,17,17);
		x.removeAll(17);
		//System.out.println(x.lastIndexOf(17));
		System.out.println(x);
	}
}
