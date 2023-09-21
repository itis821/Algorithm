package dp;

import java.io.*;

public class BOJ2579 {

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(find(N));
    }

    static int find(int n) {
        if (dp[n] == -1) {
            dp[n] = Math.max(find(n - 3) + arr[n - 1], find(n - 2)) + arr[n];
        }

        return dp[n];
    }
}
