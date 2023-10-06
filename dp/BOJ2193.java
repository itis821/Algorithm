package dp;

import java.io.*;

class BOJ2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <=90

        long[][] cnt = new long[N + 1][2];

        cnt[1][0] = 0;
        cnt[1][1] = 1;

        for (int i = 2; i < N + 1; i++) {
            cnt[i][0] = cnt[i - 1][0] + cnt[i - 1][1];
            cnt[i][1] = cnt[i - 1][0];
        }

        System.out.println(cnt[N][0] + cnt[N][1]);
    }
}