package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15650 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[M];
        boolean[] isVisited = new boolean[N];
        find(arr, isVisited, 0);
        System.out.print(sb.toString());
    }

    public static void find(int[] arr, boolean[] isVisited, int idx) {
        if (idx == arr.length) {
            for (int i = 0; i < idx; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < isVisited.length; i++) {
            if (0 < idx && i < arr[idx - 1]) // 이전 놈보다 작은 경우
                continue;
            if (isVisited[i]) // 이미 조사한 경우
                continue;

            isVisited[i] = true;
            arr[idx] = i + 1;
            find(arr, isVisited, idx + 1);
            isVisited[i] = false;
        }

    }
}
