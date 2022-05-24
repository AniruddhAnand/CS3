public class Tour 
{
	private class Node {
		Point p;
		Node  next;
	}
	int size;
	double distance;
	double prevDistance;
	Node head;
	/** create an empty tour */
	public Tour()
	{
		head = new Node();
		size = 0;
		distance = 0;
		head.next = head;
	}
	
	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d)
	{
		this();
		insertNearest(a);insertNearest(b);insertNearest(c);insertNearest(d);
	}
	
	/** print tour (one point per line) to std output */
	public void show()
	{
		Node current = head;
		for(int i=0;i<size;i++,current = current.next){
			System.out.println(current.p);
		}
	}
	
	/** draw the tour using StdDraw */
	public void draw()
	{
		Node current = head;
		for(int i=0;i<size;i++,current = current.next){
			current.p.drawTo(current.next.p);
			//current.p.draw();
		}
	}
	
	/** return number of nodes in the tour */
	public int size()
	{
		return size;
	}
	
	/** return the total distance "traveled", from start to all nodes and back to start */
	public double distance()
	{
		return distance;
	}

	/** insert p using nearest neighbor heuristic */
    public void insertNearest(Point p) 
    {
    	if(size==0){
    		size++;
    		head.p = p;
    		return;
		}
    	Node current = head;
    	Node next = null;
    	double distance = -1;
    	Node point = new Node();point.p = p;
    	for(int i=0;i<size;i++,current=current.next){
    		double dist = current.p.distanceTo(p);
    		if(distance==-1||dist<distance){
    			next = current;
    			distance = dist;
			}
		}
    	insertAtNode(next,point,p);
    }

    private void insertAtNode(Node n, Node point, Point p){
    	prevDistance = distance;
		Node temp = n.next;
		n.next = point;
		this.distance+=n.p.distanceTo(p);
		this.distance+=p.distanceTo(temp.p);
		this.distance-=n.p.distanceTo(temp.p);
		point.next = temp;
		size++;
	}

	private void removeAtNode(Node n){
		n.next = n.next.next;
		size--;
		distance = prevDistance;
	}

	/** insert p using smallest increase heuristic */
    public void insertSmallest(Point p) 
    {
		if(size==0){
			size++;
			head.p = p;
			return;
		}
		Node current = head;
		Node next = null;
		double distance = -1;
		Node point = new Node();point.p = p;
		for(int i=0;i<size;i++,current=current.next){
			double dist = current.p.distanceTo(p)+p.distanceTo(current.next.p)-current.p.distanceTo(current.next.p);
			if(distance==-1||dist<distance){
				next = current;
				distance = dist;
			}
		}
		insertAtNode(next,point,p);
    }

    public void intoxicatedHeuristic(Point p){
		if(size==0){
			size++;
			head.p = p;
			return;
		}
    	int rng = (int)(Math.random()*size);
		Node point = new Node();point.p = p;
    	Node current = head;
    	for(int i=0;i!=rng;i++,current = current.next){}
    	insertAtNode(current,point,p);
	}
}