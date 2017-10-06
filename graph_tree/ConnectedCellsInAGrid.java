import java.io.*;
import java.util.*;

/*

Result: Accepted

https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

Sample Input
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

Sample Output
5

*/

public class ConnectedCellsInAGrid {
    
    class Answer {
        int R, C, count;
        int[][] arr;
        boolean[][] visited;
        
        public void search(int r, int c) {
            if (r < 0 || c < 0 || r >= R || c >= C) return;
            if (arr[r][c] == 0 || visited[r][c]) return;

            visited[r][c] = true;
            count++;

            ckk(r, c, count);
            
            search(r+1, c); // down
            search(r, c+1); // right
            search(r, c-1); // up
            search(r-1, c); // left
            search(r+1, c+1); // right-up
            search(r-1, c+1); // right-down
            search(r-1, c-1); // left-up
            search(r+1, c-1); // left-down
        }
        
        public int solve() {
            arpp(arr);
            visited = new boolean[R][C];
            int max = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if ( arr[i][j] == 1 && !visited[i][j] ) {
                        count = 0;
                        search(i, j);
                        max = Math.max(max, count);
                        pl("");
                    }
                }
            }
            arpp(visited);
            return max;
        }
        
        public void main(FastScanner in, PrintWriter out) {
            R = in.nextInt();
            C = in.nextInt();
            arr = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            out.println( solve() );
        }
        
        public void p(Object o) { System.out.print(o); }
        public void pl(Object o) { System.out.println(o); }
        public void arp(int[] o) { pl( Arrays.toString(o) ); }
        public void arpp(int[][] o) { 
            for (int i = 0; i < o.length; i++) {
                for (int j = 0; j < o[0].length; j++) { p(o[i][j] + " "); }
                pl("");
            }
        }
        public void arpp(boolean[][] o) { 
            for (int i = 0; i < o.length; i++) {
                for (int j = 0; j < o[0].length; j++) { p(o[i][j] + " "); }
                pl("");
            }
        }
        public void ck(Object o1, Object o2) { pl(o1 + " " + o2); }
        public void ckk(Object o1, Object o2, Object o3) { pl(o1 + " " + o2 + " " + o3); }
        public void ckkk(Object o1, Object o2, Object o3, Object o4) { 
            pl(o1 + " " + o2 + " " + o3 + " " + o4);
        }
    }

    public static void main(String[] args) throws Exception {
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ConnectedCellsInAGrid problem = new ConnectedCellsInAGrid();
        Answer ans = problem.new Answer();
        ans.main(in, out);
        out.close();
        in.close();
    }
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream in) { br = new BufferedReader(new InputStreamReader(in)); }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); } 
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        public String nextLine() {
            String str = "";
            try { str = br.readLine();
            } catch (IOException e) { e.printStackTrace(); }
            return str;
        }
        public void close() throws IOException { br.close(); }
    }
}