import java.io.*;
import java.util.*;

/*

Result: Accepted

https://www.codechef.com/SEPT17/problems/CHEFSUM

Input:
2
3
1 2 3
4
2 1 3 1

Output:
1
2

*/


public class LittleChefAndSums {

    static class Question {
        int N;
        long SUM;
        int[] A;
        
        public int solve() {
            long min = Long.MAX_VALUE;
            int idx = -1;
            long ps = A[0];
            long ss = SUM;
            if (ps + ss < min) {
                min = ps + ss;
                idx = 1;
            }
            
            for (int i = 1; i < N; i++) {
                ps += A[i];
                ss -= A[i-1];
                if (ps + ss < min) {
                    min = ps + ss;
                    idx = i+1;
                }
            }
            return idx;
        }
        
        public void main(FastScanner in, PrintWriter out) {
            int q = in.nextInt();
            while (q-->0) {
                N = in.nextInt();
                SUM = 0L;
                A = new int[N];
                for (int i = 0; i < N; i++) {
                    int n = in.nextInt();
                    A[i] = n;
                    SUM += n;
                }
                out.println( solve() );
            }
        }
        
        public void p(Object o) { System.out.print(o); }
        public void pl(Object o) { System.out.println(o); }
        public void arp(int[] o) { pl( Arrays.toString(o) ); }
        public void arpp(int[][] o) { 
            for (int i = 0; i < o.length; i++) {
                for (int j = 0; j < o[0].length; j++) { p( o[i][j] + " " ); } pl("");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Question q = new Question();
        q.main(in, out);
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
        public void close() throws IOException { br.close(); }
    }
}
