package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1463DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int dp[] = new int[X + 1];

        dp[X] = 0;
        if (X % 3 == 0) {
            dp[X / 3] = dp[X] + 1;
        }

        if (X % 2 == 0) {
            dp[X / 2] = dp[X] + 1;
        }

        dp[X + 1] = dp[X] + 1;
    }

}
