package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 2<= N <= 100,000
        int[] arr = new int[N]; // -10억 <= 특성값 <= 10억

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 특성값이 0에 가장 가까운 용액 만들기
        // arr 중 2개 선택

        // 음수 + 양수일 경우 체급 비슷한 애들끼리
        // 부호가 같은 수 덧셈일 경우 바로 옆에 있는 애랑

        // 합이 작아지는 방향으로 가야함

        int[] ans = new int[3];
        for (int i = 0; i < N; i++) {
            // ans[0], ans[1], ans[2] = max
            ans = binarySearch(i);
        }
    }

    static int[] binarySearch(int i){
        // i가 음수일 경우
        // 
        int lo
    }

    // 두 수의 합은 음수인가?
    static boolean check(int a, int b) {
        if ((a + b) < 0) {
            return true;
        } else
            return false;
    }

}
