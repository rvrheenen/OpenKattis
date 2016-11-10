import java.io.*;
import java.util.*;

public class MemoryMatch {
	public static void main(String[] args) throws IOException{
		IO io = new IO(System.in);
		
		int cards = io.nextInt();
		int turns = io.nextInt();
		
		ArrayList<String> kaarten = new ArrayList<String>();
		
		for(int i=0;i<cards;i++){
			kaarten.add(i, "Unknown");
		}
		
		for(int i=0;i<turns;i++){
			int card1 = io.nextInt()-1;
			int card2 = io.nextInt()-1;
			kaarten.set(card1,io.next());
			kaarten.set(card2,io.next());
			if(kaarten.get(card1).equals(kaarten.get(card2))){
				kaarten.set(card1, "ErikIsKut");
				kaarten.set(card2, "ErikIsKut");
			}
		}
		
		for(int i=cards-1;i>=0;i--){
			if(kaarten.get(i)=="ErikIsKut"){
				kaarten.remove(i);
			}
		}
		
		int doubles = 0;
		
		for(int i=0;i<kaarten.size();i++){
			for(int j=0;j<kaarten.size();j++){
				if(i==j) continue;
				if(kaarten.get(i)=="Unknown") continue;
				if(kaarten.get(i).equals(kaarten.get(j))){
					doubles++;
				}
			}
		}
		
		int unknown = 0;
		for(int i=0;i<kaarten.size();i++){
			if(kaarten.get(i)=="Unknown"){
				unknown++;
			}
		}
		
		int known = kaarten.size()-doubles-unknown;
		
		int score = (doubles/2);
		if(known >= unknown){
			score += known;
		} else if(unknown==2){
			score+=1;
		}
		
		System.out.println(score);
				
		io.close();
	}
	
	static class IO extends PrintWriter{
		static BufferedReader r;
		static StringTokenizer t;
		
		public IO(InputStream i){
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
			t = new StringTokenizer("");
		}
		
		public String next() throws IOException {
			while(!t.hasMoreTokens()){
				t =  new StringTokenizer(r.readLine());
			}
			return t.nextToken();
		}
		
		public int nextInt() throws IOException{
			return Integer.parseInt(next());
		}
		
		public long nextLong() throws IOException{
			return Long.parseLong(next());
		}
		
		public double nextDouble() throws IOException{
			return Double.parseDouble(next());
		}
	}
}
