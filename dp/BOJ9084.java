package dp;

import java.io.*;
import java.util.*;

class BOJ9084 {

    static int[] dp;
    static int N;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 1 <= T <= 10
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); // 1 <= N <= 20
            coin = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken()); // 1 <= coin <= 10,000
            }

            int M = Integer.parseInt(br.readLine()); // 1 <= M <= 10,000
            dp = new int[M + 1];
            for (int i = 1; i < M + 1; i++) {
                dp[i] = -1;
            }

        }
        System.out.println(sb.toString());
    }

}