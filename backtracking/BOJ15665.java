package backtracking;

import java.io.*;
import java.util.*;

class BOJ15665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Set<String> set = new LinkedHashSet<>();
        find(0, M, N, result, arr, set);

        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            sb.append(str).append('\n');
        }

        System.out.println(sb.toString());
    }

    static void find(int depth, int M, int N, int[] result, int[] arr, Set<String> set) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            result[depth] = arr[i];
            find(depth + 1, M, N, result, arr, set);
        }

    }
}