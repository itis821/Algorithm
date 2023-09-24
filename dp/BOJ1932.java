package dp;

import java.io.*;
import java.util.*;

public class BOJ1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1<= n <=500
        int[][] tri = new int[n][n];
        int[][] dp = new int[n][n];

        StringTokenizer st;
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c <= r; c++) {
                tri[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = tri[r][c];
            }
        }

        for (int r = 0; r < n - 1; r++) {
            for (int c = 0; c <= r; c++) {
                dp[r + 1][c] = Math.max(dp[r + 1][c], dp[r][c] + tri[r + 1][c]);
                dp[r + 1][c + 1] = Math.max(dp[r + 1][c + 1], dp[r][c] + tri[r + 1][c + 1]);
            }
        }

        Arrays.sort(dp[n - 1]);
        System.out.println(dp[n - 1][n - 1]);
    }
}
