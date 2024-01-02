package dp;

import java.io.*;
import java.util.*;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 15

        int[] T = new int[N]; // 1 <= T[i] <= 5
        // T[0] ~ T[N-1]
        int[] P = new int[N]; // 1 <= P[i] <= 1,000
        // P[0] ~ P[N-1]
        int[] dp = new int[N]; // i번째 상담을 했을 때 최대 수익
        // dp[0] ~ dp[N-1]

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        if (T[0] - 1 > N - 1) {
            dp[0] = 0;
        } else {
            dp[0] = P[0];
        }

        for (int i = 1; i < N; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (j + T[j] - 1 < i) {
                    max = Math.max(dp[j], max);
                }
            }

            if (i + T[i] - 1 > N - 1) {
                dp[i] = 0;
            } else {
                dp[i] = max + P[i];
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N - 1]);
    }
}
