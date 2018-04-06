import java.io.*;
import java.util.*;

public class IntelligenceInfection {

    public static IO io;
    public static int messages = 0;
    public static Spy[] spies;
    public static boolean debug = false;
    public static boolean printEnemylessGraph = false;
    public static boolean[] cycleReached;
    public static Integer foundCycle;
    public static boolean[] spiesReached;

	public static void main(String[] args) throws IOException {
		io = new IO(System.in);
        int n_spies       = io.nextInt();
        int n_enemies     = io.nextInt();
        int n_connections = io.nextInt();

        spies = new Spy[n_spies];
        spiesReached = new boolean[n_spies];

        for (int i = 0 ; i < n_spies; i++) spies[i] = new Spy(i); // Create spies

        // handle connections input
        int from, to;
        for (int i = 0 ; i < n_connections; i++) {
            from = io.nextInt();
            to   = io.nextInt();
            spies[to].reachedBy.add(from);
            spies[from].reaches.add(to);
        }

        // handle enemies input
        int[] enemies = new int[n_enemies];
        for (int i = 0 ; i < n_enemies; i++) {
            enemies[i] = io.nextInt();
            spies[enemies[i]].isEnemy = true; // set enemies
        }

        // traverse enemies
        if(debug) io.println("enemies");
        for (int i = 0 ; i < n_enemies; i++) {
            traverseEnemies(spies[enemies[i]]);
        }

        // traverse from all sources
        if(debug) io.println("sources");
        int sourceCount = 1;
        while (sourceCount > 0) {
            sourceCount = 0;
            for (int i = 0; i < n_spies; i++){
                if(!spiesReached[i] && spies[i].reachedBy.size() == 0) {
                    if(debug) io.printf("message spy %d\n", i);
                    messages++;
                    sourceCount++;
                    traverseRest(spies[i]);
                }
            }
        }

        // // print graph so far
        // if (printEnemylessGraph) {
        //     int remainingSpyCounter = 0;
        //     int connectionCounter = 0;
        //     for (Spy spy : spies) {
        //         if (!spiesReached[spy.index]) remainingSpyCounter++;
        //         for (Integer s : spy.reachedBy) {
        //             if(s == -1) continue;
        //             if (spiesReached[s]) continue;
        //             io.printf("%d %d\n", spies[s].index, spy.index);
        //             connectionCounter++;
        //         }
        //     }
        //     System.out.printf("%d 0 %d\n", n_spies, connectionCounter);
        //     io.println();
        // }

        // get max reach
        if(debug) io.println("reach");
        int highestReach = 1;
        int highestSpy = -1;
        int reach;
        while (highestReach > 0) {
            highestReach = -1;
            highestSpy = -1;
            for (int i = 0 ; i < n_spies; i++) {
                if(!spiesReached[i]) {
                    cycleReached = new boolean[n_spies];
                    reach = getReach(i);
                    if(debug) io.printf("reach of spy %d is %d\n", i, reach);
                    if (reach > highestReach) {
                        highestReach = reach;
                        highestSpy = i;
                    }
                }
            }
            if (highestReach > -1) {
                if(debug) io.printf("found highest: %d\n", highestReach);
                if(debug) io.printf("message spy %d\n", highestSpy);
                messages++;
                traverseRest(spies[highestSpy]);
            }
        }

        if(!printEnemylessGraph) io.println(messages);

		io.close();
	}

    static int getReach(Integer index) {
        if (cycleReached[index]) {
            return 0;
        }
        cycleReached[index] = true;
        int found = 1;
        for (Integer spy : spies[index].reaches) {
            if (spy == -1) continue;
            found += getReach(spies[spy].index);
        }
        return found;
    }

    static void traverseEnemies(Spy src) {
        // if(debug) io.printf("SPY %d::", src.index);
        if (!src.isEnemy && !spiesReached[src.index]) {
            // if(debug) io.printf("message %d ||", src.index);
            messages++;
        }

        // if(debug) io.printf("remove: ");
        spiesReached[src.index] = true;
        for (Integer s : src.reaches) {
            spies[s].removeReachedBy(src.index);
            // if(debug) io.printf("%d ", s);
        }

        // if(debug) io.printf(" traverse: ");
        for( int i = 0 ; i < src.reachedBy.size(); i++) {
            if (src.reachedBy.get(i) == -1) continue;
            // if(debug) io.printf("%d ", spies[src.reachedBy.get(i)].index);
        }
        // if(debug) io.println();
        for( int i = 0 ; i < src.reachedBy.size(); i++) {
            if (src.reachedBy.get(i) == -1) continue;
            traverseEnemies(spies[src.reachedBy.get(i)]);
        }
    }

    static void traverseRest(Spy src) {
        if (spiesReached[src.index]) return;
        spiesReached[src.index] = true;
        for(Integer s : src.reaches) {
            traverseRest(spies[s]);
        }
    }

    static class Spy {
        public int index;
        public boolean isEnemy;
        public List<Integer> reachedBy;
        public List<Integer> reaches;

        Spy(int i) {
            index = i;
            reachedBy = new ArrayList<Integer>();
            reaches   = new ArrayList<Integer>();
        }

        void removeReachedBy() { // not used
            for (Integer spyReached : reaches) {
                spies[spyReached].reachedBy.removeIf(s -> spies[s].index == this.index);
            }
        }

        void removeReachedBy(int index) {
            for (int i = 0; i < reachedBy.size(); i++) {
                if (reachedBy.get(i) == -1) continue;
                if (spies[reachedBy.get(i)].index == index) {
                    reachedBy.set(i, -1);
                }
            }
        }
    }

	static class IO extends PrintWriter {
		static BufferedReader r;
		static StringTokenizer t;

		public IO(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
			t = new StringTokenizer("");
		}

        public String nextLine() throws IOException {
            return r.readLine();
        }

		public String next() throws IOException {
			while (!t.hasMoreTokens()) {
				t = new StringTokenizer(nextLine());
			}
			return t.nextToken();
		}

		public int nextInt() throws IOException{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}
