package dp;

import java.io.*;

public class BOJ5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray(); // 1 <= str.length <= 4,000
        char[] str2 = br.readLine().toCharArray();

        int N = str1.length;
        int M = str2.length;

        int[][] LCS = new int[N][M];

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (str1[i] == str2[j]) {
                    if (i > 0 && j > 0) {
                        LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    } else {
                        LCS[i][j] = 1;
                    }
                } else {
                    LCS[i][j] = 0;
                }
                max = Math.max(max, LCS[i][j]);
            }
        }

        System.out.println(max);
    }

}
