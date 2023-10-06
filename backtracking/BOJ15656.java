package backtracking;

import java.io.*;
import java.util.*;

class BOJ15656 {

    static StringBuilder sb = new StringBuilder();
    static int M;
    static int N;
    static int[] line;
    static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        line = new int[M];
        numArr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);
        find(0);
        System.out.println(sb);
    }

    static void find(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(line[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            line[depth] = numArr[i];
            find(depth + 1);
        }
    }
}