public class Solution {
    public int maximalRectangle(char[][] matrix) {
      if (matrix == null || matrix.length == 0) return 0;
      int m = matrix.length, n = matrix[0].length;
      int res = 0;
      int[] left = new int[n];
      int[] right = new int[n];
      int[] height = new int[n];
      Arrays.fill(right, n);
      for(int i = 0; i < m; i++) {
        int curLeft = 0;
        int curRight = n;
        for(int j = 0; j < n; j++) {
          if (matrix[i][j] == '1') {
            height[j]++;
          } else height[j] = 0;
        }

        for(int j = 0; j < n; j++) {
          if (matrix[i][j] == '1') {
            left[j] = Math.max(left[j], curLeft);
          } else {
            curLeft = j + 1;
            left[j] = 0;
          }
        }

        for(int j = n - 1; j >= 0; j--) {
          if (matrix[i][j] == '1') {
            right[j] = Math.min(right[j], curRight);
          } else {
            curRight = j;
            right[j] = n;
          }
        }

        for(int j = 0; j < n; j++) {
          res = Math.max(res, height[j] * (right[j] - left[j]));
        }
      }

      return res;    
    }
}
