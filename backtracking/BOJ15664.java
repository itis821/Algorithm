package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15664 {
    static int[] result;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        find(0, 0, arr, M);

        StringBuilder sb = new StringBuilder();

        for (String str : set) {
            sb.append(str).append('\n');
        }

        System.out.print(sb.toString());
    }

    static void find(int depth, int at, int[] arr, int M) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }

            set.add(sb.toString());
            return;
        }

        for (int i = at; i < arr.length; i++) {
            result[depth] = arr[i];
            find(depth + 1, i + 1, arr, M);
        }
    }
}
