import java.io.*;
import java.util.*;

/*

Result: Accepted

https://www.hackerrank.com/challenges/fibonacci-finding-easy/problem

Sample Input
8  
2 3 1  
9 1 7  
9 8 3  
2 4 9  
1 7 2  
1 8 1  
4 3 1  
3 7 5  

Sample Output
3  
85  
25  
178  
8  
8  
3  
44

*/

public class FibonacciFinding {

    static class Question {
        int a, b, N;
        long[][] A = new long[][]{ {1,1}, {1,0} };
        final int mod = 1000000007;
        
        public void multiply(long arr[][], long A[][]) {
            long x =  ( ( (arr[0][0] % mod) * (A[0][0] % mod) ) % mod 
                    + ( (arr[0][1] % mod) * (A[1][0] % mod) ) % mod ) % mod;
            long y =  ( ( (arr[0][0] % mod) * (A[0][1] % mod) ) % mod 
                    + ( (arr[0][1] % mod) * (A[1][1] % mod) ) % mod ) % mod;
            long z =  ( ( (arr[1][0] % mod) * (A[0][0] % mod) ) % mod 
                    + ( (arr[1][1] % mod) * (A[1][0] % mod) ) % mod ) % mod;
            long w =  ( ( (arr[1][0] % mod) * (A[0][1] % mod) ) % mod 
                    + ( (arr[1][1] % mod) * (A[1][1] % mod) ) % mod ) % mod;
            arr[0][0] = x;
            arr[0][1] = y;
            arr[1][0] = z;
            arr[1][1] = w;
        }
        
        public void power(long F[][], int n) {
            if( n == 0 || n == 1) return;
            long M[][] = new long[][]{{1,1},{1,0}};
            power(F, n/2);
            multiply(F, F);
            if (n % 2 != 0) multiply(F, M);
        }
        
        public long solve() {
            if (N == 1) return b;
            long[][] arr = new long[][]{ {1,1}, {1,0} };
            power(arr, N-1);
            long ans = ( ( (arr[0][0] % mod) * (b % mod) ) % mod 
                    + ( (arr[0][1] % mod) * (a % mod) ) %  mod ) % mod;
            return ans;
        }
        
        public void main(FastScanner in, PrintWriter out) {
            int q = in.nextInt();
            while (q-->0) {
                a = in.nextInt();
                b = in.nextInt();
                N = in.nextInt();
                out.println( solve() );
            }
        }
        
        public void p(Object o) { System.out.print(o); }
        public void pl(Object o) { System.out.println(o); }
        public void arp(int[] o) { pl( Arrays.toString(o) ); }
        public void arpp(long[][] o) { 
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
