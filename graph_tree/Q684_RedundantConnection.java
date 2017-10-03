import java.util.*;

/*

Result: Accepted

https://leetcode.com/problems/redundant-connection/description/

Input: [[1,2], [1,3], [2,3]]
Output: [2,3]

Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]

*/

public class Q684_RedundantConnection {
        
    private static int findSet(int n, int[] parent) {
        while (n != parent[n]) {
            parent[n] = parent[ parent[n] ];
            n = parent[n];
        }
        return n;
    }
    
    private static void union(int u, int v, int[] parent) {
        parent[v] = parent[u];
    }
    
    public static int[] findRedundantConnection(int[][] edges) {
        int MAX = 2001;
        int[] parent = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            parent[i] = i;
        }
        int[] ret = new int[2];
        int N = edges.length;
        for (int i = 0; i < N; i++) {
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            int pu = findSet(u, parent);
            int pv = findSet(v, parent);
            if (pu != pv) {
                union(pu, pv, parent);
            } else {
                ret[0] = u+1;
                ret[1] = v+1;
            }
        }        
        return ret;
    }
        
    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {1,2}, {1,3}, {2,3}
        };
        arp( findRedundantConnection(arr) );
    }
    
    public static void p(Object o) { System.out.print(o); }
    public static void pl(Object o) { System.out.println(o); }
    public static void arp(int[] o) { pl( Arrays.toString(o) ); }
    public static void arpp(int[][] o) { 
        for (int i = 0; i < o.length; i++) {
            for (int j = 0; j < o[0].length; j++) { p( o[i][j] + " " ); } pl("");
        }
    }
    public static void ck(Object o1, Object o2) { pl(o1 + " " + o2); }
    public static void ckk(Object o1, Object o2, Object o3) { pl(o1 + " " + o2 + " " + o3); }
    public static void ckkk(Object o1, Object o2, Object o3, Object o4) { 
        pl(o1 + " " + o2 + " " + o3 + " " + o4); 
    }
}
