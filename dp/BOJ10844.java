package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1<= N <=100
        dp = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dp[i] = -1;
        }

        dp[1] = 9;
        if (N >= 2) {
            dp[2] = 17;
        }

        System.out.println(find(N));
    }

    static long find(int N) {
        if (dp[N] == -1) {
            dp[N] = (2 * find(N - 1) - 2) % 1000000000;
        }

        return dp[N];
    }
}
