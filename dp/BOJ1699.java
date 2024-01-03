package dp;

import java.io.*;

public class BOJ1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100,000
        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = 100000;
        }

        for (int i = 1; i * i <= N; i++) {
            dp[i * i] = 1;
        }

        if (Math.sqrt((double) N) % 1 == 0) {
            System.out.println(1);
            return;
        }

        System.out.println(getN(dp, N));
    }

    static int getN(int[] dp, int N) {
        if (dp[N] != 100000) {
            return dp[N];
        }

        for (int i = 1; i * i <= N; i++) {
            int sqr = i * i;
            int cnt = N / sqr; // i * i 가 몇 번 들어가나
            int res = N - sqr * cnt; // 나머지

            if (res == 0) {
                dp[N] = Math.min(cnt, dp[N]);
            } else {
                dp[N] = Math.min(cnt + getN(dp, res), dp[N]);
            }

        }

        return dp[N];
    }

}
