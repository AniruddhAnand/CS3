import java.io.*;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree
{
	String fileName;
	private Node root;

	private Node current;

	private class Node{
		String val;
		Node left;
		Node right;
		Node(String s){
			val = s;
		}
	}
	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *          this is the name of the file we need to import the game questions
	 *          and answers from.
	 */
	public GameTree(String fileName)
	{
		this.fileName = fileName;
		try {
			BufferedReader f = new BufferedReader(new FileReader(fileName));
			Scanner console = new Scanner(f);
//			root = new Node(console.nextLine());
//			current = root;
//			while(console.hasNext()){
//				buildTree(root,console.nextLine().strip());
//			}
			root = buildTree(console);
			current = root;
		}catch(Exception e){
			System.out.println("Invalid File");
		}
		//print(root,1);
	}
	private String toString(Node root, int currentHeight) {
		if(root==null){
			return "";
		}
		String s = "";
		s+= toString(root.right,currentHeight+1);
		for(int i=0;i<currentHeight-1;i++) s+="- ";
		s+=root.val + "\n";
		s+= toString(root.left,currentHeight+1);
		return s;
	}

//	private boolean buildTree(Node n,String s){
//		if(n==null||n.val.charAt(n.val.length()-1)!='?'){
//			return false;
//		}
//		if(n.left==null){
//			n.left = new Node(s);
//			return true;
//		}else{
//			if(!buildTree(n.left,s)){
//				if(n.right==null){
//					n.right = new Node(s);
//					return true;
//				}else{
//					return buildTree(n.right,s);
//				}
//			}else{
//				return true;
//			}
//		}
//	}

//	private Node buildTree(Node n, String s){
//		if(n.val.charAt(n.val.length()-1)=='?'){
//			if(n.left==null){
//				n.left = new Node(s);
//				return n.left;
//			}else {
//				Node n2 = buildTree(n.left, s);
//				if (n2 == null) {
//					if(n.right==null){
//						n.right = new Node(s);
//						return n.right;
//					}else {
//						return buildTree(n.right, s);
//					}
//				}
//			}
//		}
//		return null;
//	}

	private Node buildTree(Scanner console){
		if(!console.hasNext()){
			return null;
		}
		Node n = new Node(console.nextLine().strip());
		if(n.val.charAt(n.val.length()-1)=='?'){
			n.left = buildTree(console);
			n.right = buildTree(console);
		}
		return n;
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken  horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *          The question to add where the old answer was.
	 * @param newA
	 *          The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
//		Node old = current.left;
//		Node question = new Node(newQ);
//		current.left = question;
//		question.left = new Node(newA);
//		question.right = old;
		String old = current.val;
		current.val = newQ;
		current.left = new Node(newA);
		current.right = new Node(old);
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		String s = getCurrent();
		return s.charAt(s.length()-1)!='?';
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.  Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		return current.val; //replace
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		current = yesOrNo == Choice.Yes?current.left:current.right;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		current = root;
	}

	@Override
	public String toString()
	{
		return toString(root,1);
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 *
	 */
	private void saveGame(Node root, PrintWriter p) {
		if(root==null){
			return;
		}
		p.println(root.val);
		saveGame(root.left,p);
		saveGame(root.right,p);
	}
	public void saveGame(){
		try {
			PrintWriter p = new PrintWriter(fileName);
			saveGame(root, p);
			p.close();
		}catch(IOException e){
			System.out.println("Wrong File");
		}
	}

	public static void main(String[] args) {
		GameTree x = new GameTree("animals_long.txt");
		System.out.println(x.toString());
	}
}
