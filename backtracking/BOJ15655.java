package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15655 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] numArr;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numArr = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);
        find(0, 0);

        System.out.print(sb);
    }

    static void find(int depth, int idx) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[depth] = numArr[i];
            find(depth + 1, i + 1);
        }

    }

}
