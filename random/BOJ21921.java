package random;

import java.io.*;
import java.util.*;

class BOJ21921 {

    static int[] bangmoon;
    static int N;
    static int cnt;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 1<=X<=250,000
        int X = Integer.parseInt(st.nextToken()); // 0<=방문자수 <= 8000
        // 250000 * 8000 = 2,000,000,000 // 2억

        bangmoon = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            bangmoon[i] = Integer.parseInt(st.nextToken());
        }

        find(X);

        if (max == 0) {
            System.out.println("SAD"); // X일 동안 최대 방문자 수가 0명이면 SAD
        } else {
            System.out.println(max); // X일 동안 가장 많이 들어온 방문자 수
            System.out.println(cnt); // 기간 몇 개 있는지
        }

    } // main

    static void find(int X) {
        int start = 1;
        int end = X;
        max = 0;
        cnt = 1;

        // 초기
        for (int i = start; i <= end; i++) {
            max += bangmoon[i];
        }

        int tmp = max;

        while (end + 1 <= N) {
            tmp = tmp - bangmoon[start] + bangmoon[end + 1];

            start++;
            end++;

            if (tmp > max) {
                max = tmp;
                cnt = 1;
            } else if (tmp == max) {
                cnt++;
            }
        }
    }
}