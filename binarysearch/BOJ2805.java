package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 1<= 나무의 수(N) <= 10^6
        int M = Integer.parseInt(st.nextToken()); // 1<= 갖고 싶은 나무 길이(M) <= 2*10^9

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        // 절단기 높이
        int lo = 0; // false
        int hi = (int) Math.pow(10, 9); // true

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (isValid(mid, trees, M)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        System.out.println(lo);
    }

    // 자른 길이가 M보다 작은가요?
    static boolean isValid(int mid, int[] trees, int M) {
        long sum = 0;

        for (int i = 0; i < trees.length; i++) {
            if (trees[i] > mid) {
                sum += (trees[i] - mid);
            }
        }

        if (sum < M) {
            return true;
        } else {
            return false;
        }
    }

}
