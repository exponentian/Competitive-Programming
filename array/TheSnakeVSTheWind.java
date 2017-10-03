import java.io.*;
import java.util.*;

/*

Result: Accepted

https://www.hackerrank.com/contests/university-codesprint-3/challenges/the-snake-vs-the-wind

Input0:
2
e
1 0

Output0:
4 3 
1 2

Input1:
4
n
0 0

Output1:
1 2 3 4
8 7 6 5
9 10 11 12
16 15 14 13

*/

public class TheSnakeVSTheWind {
    
    static class Question {
        int N, X, Y;
        String wind;
        
        // left top
        private void traveralNorthLeftTop(int[][] arr, int row, int col) {
            int i = 0, count = 1;
            while (i <= row) {
                for (int j = 0; j <= col; j++) { arr[i][j] = count++; } i++;
                if (i > row) break;
                for (int j = col; j >= 0; j--) { arr[i][j] = count++; } i++;
            }
        }
        
        private void traveralWestLeftTop(int[][] arr, int row, int col) {
            int j = 0, count = 1;
            while (j <= col) {
                for (int i = 0; i <= row; i++) { arr[i][j] = count++; } j++;
                if (j > col) break;
                for (int i = row; i >= 0; i--) { arr[i][j] = count++; } j++;
            }
        }
        
        private void traveralSouthLeftTop(int[][] arr, int row, int col) {
            int i, j = 0, count = 1;
            for (i = 0; i <= row; i++) arr[i][j] = count++;
            i--;
            while (i >= 0) {
                for (j = 1; j <= col; j++) { arr[i][j] = count++; } i--;
                if (i < 0) break;
                for (j = col; j >= 1; j--) { arr[i][j] = count++; } i--;
            }
        }
        
        private void traveralEastLeftTop(int[][] arr, int row, int col) {
            int i = 0, j, count = 1;
            for (j = 0; j <= col; j++) arr[i][j] = count++;
            j--;
            while (j >= 0) {
                for (i = 1; i <= row; i++) { arr[i][j] = count++; } j--;
                if (j < 0) break;
                for (i = row; i >= 1; i--) {arr[i][j] = count++; } j--;
            }
        }

        
        // right top
        private void traveralNorthRightTop(int[][] arr, int row, int col) {
            int i = 0, count = 1;
            while (i <= row) {
                for (int j = col; j >= 0; j--) { arr[i][j] = count++; } i++;
                if (i > row) break;
                for (int j = 0; j <= col; j++) { arr[i][j] = count++; } i++;
            }
        }
        
        private void traveralEastRightTop(int[][] arr, int row, int col) {
            int j = col, count = 1;
            while (j >= 0) {
                for (int i = 0; i <= row; i++) { arr[i][j] = count++; } j--;
                if (j < 0) break;
                for (int i = row; i >= 0; i--) { arr[i][j] = count++; } j--;
            }
        }
        
        private void traveralWestRightTop(int[][] arr, int row, int col) {
            int i = 0, j, count = 1;
            for (j = col; j >= 0; j--) arr[i][j] = count++;
            j++;
            while (j <= col) {
                for (i = 1; i <= row; i++) { arr[i][j] = count++; } j++;
                if (j > col) break;
                for (i = row; i >= 1; i--) { arr[i][j] = count++; } j++;
            }            
        }
        
        private void traveralSouthRightTop(int[][] arr, int row, int col) {
            int i, j = col, count = 1;
            for (i = 0; i <= row; i++) arr[i][j] = count++;
            i--;
            while (i >= 0) {
                for (j = col-1; j >= 0; j--) { arr[i][j] = count++; } i--;
                if (i < 0) break;
                for (j = 0; j <= col-1; j++) { arr[i][j] = count++; } i--;
            }
        }
        
        // right bottom
        private void traveralSouthRightBottom(int[][] arr, int row, int col) {
            int i = row, count = 1;
            while (i >= 0) {
                for (int j = col; j >= 0; j--) { arr[i][j] = count++; } i--;
                if (i < 0) break;
                for (int j = 0; j <= col; j++) { arr[i][j] = count++; } i--;
            }
        }
        
        private void traveralEastRightBottom(int[][] arr, int row, int col) {
             int j = col, count = 1;
             while (j >= 0) {
                for (int i = row; i >= 0; i--) { arr[i][j] = count++; } j--;
                if (j < 0) break;
                for (int i = 0; i <= row; i++) { arr[i][j] = count++; } j--;
             }
        }
        
        private void traveralNorthRightBottom(int[][] arr, int row, int col) {
            int i, j = col, count = 1;
            for (i = row; i >= 0; i--) arr[i][j] = count++;
            i++;
            while (i <= row) {
                for (j = col-1; j >= 0; j--) { arr[i][j] = count++; } i++;
                if (i > row) break;
                for (j = 0; j <= col-1; j++) { arr[i][j] = count++; } i++;
            }
        }
        
        private void traveralWestRightBottom(int[][] arr, int row, int col) {
            int i = row, j, count = 1;
            for (j = col; j >= 0; j--) arr[i][j] = count++;
            j++;
            while (j <= col) {
                for (i = row-1; i >= 0; i--) { arr[i][j] = count++; } j++;
                if (j > col) break;
                for (i = 0; i <= row-1; i++) {arr[i][j] = count++; } j++;
            }
        }
        
        
        // left bottom
        private void traveralSouthLeftBottom(int[][] arr, int row, int col) {
            int i = row, count = 1;
            while (i >= 0) {
                for (int j = 0; j <= col; j++) { arr[i][j] = count++; } i--;
                if (i < 0) break;
                for (int j = col; j >= 0; j--) { arr[i][j] = count++; } i--;
            }
        }
        
        private void traveralWestLeftBottom(int[][] arr, int row, int col) {
            int j = 0, count = 1;
            while (j <= col) {
                for (int i = row; i >= 0; i--) { arr[i][j] = count++; } j++;
                if (j > col) break;
                for (int i = 0; i <= row; i++) { arr[i][j] = count++; } j++;
            }
        }
        
        private void traveralNorthLeftBottom(int[][] arr, int row, int col) {
            int i, j = 0, count = 1;
            for (i = row; i >= 0; i--) arr[i][j] = count++;
            i++;
            while (i <= row) {
                for (j = 1; j <= col; j++) { arr[i][j] = count++; } i++;
                if (i > row) break;
                for (j = col; j >= 1; j--) { arr[i][j] = count++; } i++;
            }
        }
        
        private void traveralEastLeftBottom(int[][] arr, int row, int col) {
            int i = row, j, count = 1;
            for (j = 0; j <= col; j++) arr[i][j] = count++;
            j--;
            while (j >= 0) {
                for (i = row-1; i >= 0; i--) { arr[i][j] = count++; } j--;
                if (j < 0) break;
                for (i = 0; i <= row-1; i++) {arr[i][j] = count++; } j--;
            }
        }
        
        public void solve() {
            int[][] arr = new int[N][N];
            
            // left top
            if (X == 0 && Y == 0) {
                if (wind.equals("n")) {
                    traveralNorthLeftTop(arr, N-1, N-1);
                } else if (wind.equals("w")) {
                    traveralWestLeftTop(arr, N-1, N-1);
                } else if (wind.equals("s")) {
                    traveralSouthLeftTop(arr, N-1, N-1);
                } else if (wind.equals("e")) {
                    traveralEastLeftTop(arr, N-1, N-1);
                }
            }
            
            // right top
            else if (X == 0 && Y == N-1) {
                if (wind.equals("n")) {
                    traveralNorthRightTop(arr, N-1, N-1);
                } else if (wind.equals("w")) {
                    traveralWestRightTop(arr, N-1, N-1);
                } else if (wind.equals("s")) {
                    traveralSouthRightTop(arr, N-1, N-1);
                } else if (wind.equals("e")) {
                    traveralEastRightTop(arr, N-1, N-1);
                }
            }
            
            // right bottom
            else if (X == N-1 && Y == N-1) {
                if (wind.equals("n")) {
                    traveralNorthRightBottom(arr, N-1, N-1);
                } else if (wind.equals("w")) {
                    traveralWestRightBottom(arr, N-1, N-1);
                } else if (wind.equals("s")) {
                    traveralSouthRightBottom(arr, N-1, N-1);
                } else if (wind.equals("e")) {
                    traveralEastRightBottom(arr, N-1, N-1);
                }
            }
            
            // left bottom
            else if (X == N-1 && Y == 0) {
                if (wind.equals("n")) {
                    traveralNorthLeftBottom(arr, N-1, N-1);
                } else if (wind.equals("w")) {
                    traveralWestLeftBottom(arr, N-1, N-1);
                } else if (wind.equals("s")) {
                    traveralSouthLeftBottom(arr, N-1, N-1);
                } else if (wind.equals("e")) {
                    traveralEastLeftBottom(arr, N-1, N-1);
                }
            }
            
            arpp(arr);
        }
        
        public void main(FastScanner in, PrintWriter out) {
            N = in.nextInt();
            wind = in.next().toLowerCase();
            X = in.nextInt();
            Y = in.nextInt();
            solve();
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
        public String nextLine() {
            String str = "";
            try { str = br.readLine();
            } catch (IOException e) { e.printStackTrace(); }
            return str;
        }
        public void close() throws IOException { br.close(); }
    }
}
