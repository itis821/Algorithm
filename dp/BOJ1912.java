package dp;

import java.io.*;
import java.util.*;

class BOJ1912 {
    public static void main(String[] args) throws IOException {
        int ans = Integer.MIN_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 100,000

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[n]; // -1,000 <= numArr[i] <= 1,000
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = numArr[0];
        ans = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + numArr[i], numArr[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}