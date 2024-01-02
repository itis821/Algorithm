package dp;

import java.io.*;
import java.util.*;

public class BOJ11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1,000
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + arr[i];
        }

        Arrays.sort(dp);
        System.out.println(dp[N - 1]);
    }

}
