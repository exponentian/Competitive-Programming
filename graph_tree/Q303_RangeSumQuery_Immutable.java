import java.util.*;

/*

Result: Accepted

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

*/

public class Q303_RangeSumQuery_Immutable {

    class NumArray {
        int[] arr;
        int[] tree;

        public NumArray(int[] nums) {
            int len = nums.length;
            if (len >  0) {
                arr = Arrays.copyOf(nums, len);

                int height = (int) (Math.ceil(Math.log(len) / Math.log(2)));
                int max = 2 * (int) Math.pow(2, height) - 1;

                tree = new int[max];
                segmentTree(0, len - 1, 0);
            }
        }

        public void segmentTree(int low, int high, int idx) {
            if (low == high) {
                tree[idx] = arr[low];
                return;
            }
            int mid = (low + high) / 2;
            int leftPos = 2 * idx + 1;
            int rightPos = 2 * idx + 2;
            segmentTree(low, mid, leftPos);
            segmentTree(mid+1, high, rightPos);
            tree[idx] = tree[leftPos] + tree[rightPos];
        }

        public int sumRange(int i, int j) {
            return find(i, j, 0, arr.length-1, 0);
        }

        public int find(int qLow, int qHigh, int low, int high, int idx) {
            if (qLow <= low && qHigh >= high) return tree[idx];
            if (qLow > high || qHigh < low) return 0;
            
            int mid = (low + high) / 2;
            int left = find(qLow, qHigh, low, mid, 2*idx+1);
            int right = find(qLow, qHigh, mid+1, high, 2*idx+2);

            return left + right;
        }
    }    

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 3, -5, 2, -1};
        Q303_RangeSumQuery_Immutable q = new Q303_RangeSumQuery_Immutable();
        Q303_RangeSumQuery_Immutable.NumArray obj = q.new NumArray(arr);
        pl( obj.sumRange(0, 2) );
        pl( obj.sumRange(2, 5) );
        pl( obj.sumRange(0, 5) );
    }
    
    public static void p(Object o) { System.out.print(o); }
    public static void pl(Object o) { System.out.println(o); }
    public static void arp(int[] o) { pl( Arrays.toString(o) ); }
    public static void arpp(int[][] o) { 
        for (int i = 0; i < o.length; i++) {
            for (int j = 0; j < o[0].length; j++) p( o[i][j] + " " );
            pl("");
        }
    }
}
