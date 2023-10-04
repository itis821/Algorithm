package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15654 {
    static int M;
    static int N;
    static int[] arr;
    static LinkedList<Integer> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 1 <= N <= 8
        M = Integer.parseInt(st.nextToken()); // 1 <= M <= 8
        HashSet<Integer> set = new HashSet<>();

        arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        int tmp;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (!set.contains(tmp)) {
                set.add(tmp);
                list.add(tmp);
            }
        }

        isVisited = new boolean[list.size()];

        Collections.sort(list);

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

        for (int i = 0; i < list.size(); i++) {
            if (isVisited[i])
                continue;

            arr[depth] = list.get(i);
            isVisited[i] = true;
            find(depth + 1);
            isVisited[i] = false;
        }
    }
}
