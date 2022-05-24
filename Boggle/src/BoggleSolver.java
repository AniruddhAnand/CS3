import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BoggleSolver
{
	public HashMap<Character ,Set<String>> dictionary = new HashMap<>();
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
	public BoggleSolver(String ... dictionaryName)
	{
		try {
			for(String s:dictionaryName) {
				BufferedReader f = new BufferedReader(new FileReader(s));
				StringTokenizer st = new StringTokenizer(f.readLine());
				while (st.hasMoreTokens()) {
					String str = st.nextToken();
					if (!dictionary.containsKey(str.charAt(0))) {
						dictionary.put(str.charAt(0), new HashSet<String>());
					}
					dictionary.get(str.charAt(0)).add(str);
					try {
						st = new StringTokenizer(f.readLine());
					}catch (Exception e){
					}
				}
			}
		}catch(IOException io){
			System.out.println("Invalid Dictionary");
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable object
	public Iterable<String> getAllValidWords(BoggleBoard board)
	{
		HashSet<String> validWords = new HashSet<String>();
		for(int i=0;i<board.rows();i++){
			for(int j=0;j<board.cols();j++){
				allValidPoints(board, i,j,board.getLetter(i,j)+"",validWords,new boolean[board.rows()][board.cols()]);
			}
		}
		return validWords;
	}
	public void allValidPoints(BoggleBoard board, int row, int col, String current,HashSet<String> words,boolean[][] visited){
		//System.out.println(current);
		if(current.length()>2) {
			boolean starts = false;
			for (String s : dictionary.get(current.charAt(0))) {
				if (s.startsWith(current)) {
					starts = true;
					if (s.length() == current.length()) {
						words.add(current);
						break;
					}
				}
			}
			if (!starts) {
				return;
			}
		}
		visited[row][col] = true;
		for(int i=row-1;i<row+2;i++){
			if(i<0||i>=board.rows()){
				continue;
			}
			for(int j=col-1;j<col+2;j++){
				if(j<0||j>=board.cols()||visited[i][j]){
					continue;
				}
				allValidPoints(board,i,j,current+board.getLetter(i,j),words,visited);
			}
		}
		visited[row][col] = false;
	}
	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A - Z.)
	public int scoreOf(String word)
	{
		if(!dictionary.get(word.charAt(0)).contains(word)){
			return 0;
		}
		switch (word.length()){
			case 0: case 1: case 2: return 0;
			case 3: case 4: return 1;
			case 5: return 2;
			case 6: return 3;
			case 7: return 5;
			default: return 11;
		}
	}

	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		System.out.println("WORKING");

		final String PATH   = "./data/";
		BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-yawl.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints); //should print 84

		//new BoggleGame(4,4);
		System.out.println((System.currentTimeMillis()-start)/1000);
	}

}
