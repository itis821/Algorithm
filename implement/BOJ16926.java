package implement;

import java.io.*;
import java.util.*;

class BOJ16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 2 <= N <= 300
        int M = Integer.parseInt(st.nextToken()); // 2 <= M <= 300
        int R = Integer.parseInt(st.nextToken()); // 1 <= R <= 1,000

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        for (int i = 0; i < R; i++) {
            arr = rotate(arr, N, M);
        }

        // output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }// main

    static int[][] rotate(int[][] arr, int N, int M) {
        int[][] myArr = new int[N][M];
        int kMax = Math.min(N, M) / 2;

        for (int k = 1; k <= kMax; k++) {
            // 상
            for (int i = k; i <= M - k; i++) {
                myArr[k - 1][i - 1] = arr[k - 1][i];
            }

            // 좌
            for (int i = k - 1; i <= N - k - 1; i++) {
                myArr[i + 1][k - 1] = arr[i][k - 1];
            }

            // 하
            for (int i = k - 1; i <= M - k - 1; i++) {
                myArr[N - k][i + 1] = arr[N - k][i];
            }

            // 우
            for (int i = k; i <= N - k; i++) {
                myArr[i - 1][M - k] = arr[i][M - k];
            }

        }

        return myArr;
    }

}

// 1번째 껍데기
// 상
// [0][0] ~ [0][M-1]
// 좌
// [0][0] ~ [N-1][0]
// 하
// [N-1][0] ~ [N-1][M-1]
// 우
// [0][M-1] ~ [N-1][M-1]

// k번째 껍데기 (k = 1 .. min(N,M) / 2)
// 상 (-1열 이동)
// [k-1][k] ~ [k-1][M-k]
// 좌 (+1행 이동)
// [k-1][k-1] ~ [N-k-1][k-1]
// 하 (+1열 이동)
// [N-k][k-1] ~ [N-k][M-k-1]
// 우 (-1열 이동)
// [k][M-k] ~ [N-k][M-k]