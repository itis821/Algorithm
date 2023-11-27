package backtracking;

import java.io.*;
import java.util.*;

class BOJ15657 {

    static StringBuilder sb = new StringBuilder();
    static int[] result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result = new int[M];

        find(0, 0, N, M);
        System.out.println(sb);
    }

    static void find(int depth, int at, int N, int M) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < N; i++) {
            result[depth] = arr[i];
            find(depth + 1, i, N, M);
        }
    }
}