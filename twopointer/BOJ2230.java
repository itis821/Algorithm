package twopointer;

import java.io.*;
import java.util.*;

public class BOJ2230 {
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 1<= N <= 100,000
        M = Integer.parseInt(st.nextToken()); // 0 <= M <= 20억
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 0 <= arr[i] <= 10억
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        int chai = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            // i인수와 가장 적게 차이가 M이상 나는 수를 구함
            // 이때 차이를 출력
            chai = Math.min(chai, binarySearch(i));
            // System.out.println("i : " + i + " ,chai : " + chai);
        }

        System.out.println(chai);

    } // main

    static int binarySearch(int i) {
        int lo = i + 1; // false
        int hi = arr.length - 1; // true

        if (isChaiOverM(arr[i], arr[lo])) {
            return arr[lo] - arr[i];
        }

        if (!isChaiOverM(arr[i], arr[hi])) {
            return Integer.MAX_VALUE;
        }

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (isChaiOverM(arr[i], arr[mid])) {
                hi = mid;
            } else {
                lo = mid;
            }

        }

        // System.out.println("arr[hi] : " + arr[hi] + ", arr[i] : " + arr[i]);
        return arr[hi] - arr[i];

    }

    static boolean isChaiOverM(int a, int b) {
        if (Math.abs(a - b) >= M) {
            return true;
        } else {
            return false;
        }
    }

}
