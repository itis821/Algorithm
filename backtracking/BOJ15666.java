package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15666 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 line
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2 line
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // logic
        int[] result = new int[M];
        Set<String> set = new LinkedHashSet<>();
        find(0, 0, M, N, result, arr, set);

        // output
        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            sb.append(str).append('\n');
        }

        System.out.print(sb.toString());

    }

    static void find(int depth, int at, int M, int N, int[] result, int[] arr, Set<String> set) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }

            set.add(sb.toString());
            return;
        }

        for (int i = at; i < N; i++) {
            result[depth] = arr[i];
            find(depth + 1, i, M, N, result, arr, set);
        }
    }

}
