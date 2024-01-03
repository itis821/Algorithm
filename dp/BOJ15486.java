package dp;

import java.io.*;
import java.util.*;

public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1,500,000
        int[] T = new int[N + 1]; // 1 <= T[i] <= 50
        int[] P = new int[N + 1]; // 50 <= P[i] <= 1,000
        int[] dp = new int[N + 1];
        // 최대 합 = 1,000 * 1,500,000 = 1,500,000,000 = 15억

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i <= N; i++) {
            int j = i + T[i]; // i일 상담을 마친 후
            if (j < N + 1) {
                dp[j] = Math.max(dp[j], dp[i] + P[i]);
                max = Math.max(max, dp[j]);
            }
        }

        System.out.println(max);
    }

}
