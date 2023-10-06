package dp;

import java.io.*;

public class BOJ10844 {
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        dp = new long[N + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int n = 2; n <= N; n++) {
            dp[n][0] = (dp[n - 1][1]) % 1000000000;

            for (int i = 1; i <= 8; i++) {
                dp[n][i] = (dp[n - 1][i + 1] + dp[n - 1][i - 1]) % 1000000000;
            }

            dp[n][9] = dp[n - 1][8] % 1000000000;
        }

        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }

        System.out.println(answer % 1000000000);
    }

}