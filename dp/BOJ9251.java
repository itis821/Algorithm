package dp;

import java.io.*;

public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray(); // str.length <= 1,000
        char[] str2 = br.readLine().toCharArray();

        int N = str1.length;
        int M = str2.length;

        int[][] LCS = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (str1[i] == str2[j]) {
                    if (i > 0 && j > 0) {
                        LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    } else {
                        LCS[i][j] = 1;
                    }
                } else {
                    if (i == 0 && j == 0) {
                        LCS[i][j] = 0;
                    } else if (i == 0) {
                        LCS[i][j] = Math.max(0, LCS[i][j - 1]);
                    } else if (j == 0) {
                        LCS[i][j] = Math.max(LCS[i - 1][j], 0);
                    } else {
                        LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                    }
                }
            }
        }

        System.out.println(LCS[N - 1][M - 1]);

    }

}
