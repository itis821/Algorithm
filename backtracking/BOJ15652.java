package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 1~N까지 자연수 중
        M = Integer.parseInt(st.nextToken()); // M개 선택
        arr = new int[M];

        find(0);
        System.out.print(sb);
    }

    static void find(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        if (depth == 0) {
            for (int i = 1; i <= N; i++) {
                arr[depth] = i;
                find(depth + 1);
            }
        } else {
            for (int i = arr[depth - 1]; i <= N; i++) {
                arr[depth] = i;
                find(depth + 1);
            }
        }

    }
}
