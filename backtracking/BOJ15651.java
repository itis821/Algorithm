package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15651 {

    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        solution(0);
        System.out.print(sb.toString());
    }

    public static void solution(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[idx] = i + 1;
            solution(idx + 1);
        }
    }
}
