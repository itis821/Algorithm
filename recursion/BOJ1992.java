package recursion;

import java.io.*;
import java.util.*;

public class BOJ1992 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        find(0, 0, N);

        System.out.println(sb.toString());

    }

    static void find(int r, int c, int N) {

        boolean flag = true;

        if (N != 1) {
            int val = arr[r][c];

            for (int i = r; i < r + N; i++) {
                for (int j = c; j < c + N; j++) {
                    if (arr[i][j] != val) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
        }

        if (flag) {
            sb.append(arr[r][c]);
        } else {
            sb.append("(");
            // 상좌
            find(r, c, N / 2);

            // 상우
            find(r, c + N / 2, N / 2);

            // 하좌
            find(r + N / 2, c, N / 2);

            // 하우
            find(r + N / 2, c + N / 2, N / 2);
            sb.append(")");
        }

    }

}
