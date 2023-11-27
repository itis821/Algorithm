package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15663 {
    static int[] result;
    static int[] before;
    static boolean[] isVisited;
    static HashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N];
        result = new int[M];
        before = new int[M];

        for (int i = 0; i < M; i++) {
            before[i] = 0;
        }

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        find(0, arr, M);

        StringBuilder sb = new StringBuilder();
        for (String ans : set) {
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static void find(int depth, int[] arr, int M) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (isVisited[i])
                continue;
            result[depth] = arr[i];
            isVisited[i] = true;
            find(depth + 1, arr, M);
            isVisited[i] = false;
        }
    }
}
