package dp;

import java.io.*;

public class BOJ11727 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1<= n <=1000

        dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 3;
        }

        System.out.println(find(n));
    }

    static int find(int n) {
        if (dp[n] == 0) {
            // 한 칸 전
            dp[n] = (find(n - 1) + find(n - 2) * 2) % 10007;
        }
        return dp[n];
    }

}
