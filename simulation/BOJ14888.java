package simulation;

import java.io.*;
import java.util.*;

class BOJ14888 {
    static int[] nums;
    static int N;
    static int[] yunsans;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        int[] numYunsan = new int[4];
        yunsans = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            numYunsan[i] = Integer.parseInt(st.nextToken());
        }

        // + : 0, - : 1, x : 2, % : 3
        int start = 0;
        int end = start + numYunsan[0];

        for (int j = 0; j < 4; j++) {
            if (j != 0) {
                start = end;
            }
            end = start + numYunsan[j];

            for (int i = start; i < end; i++) {
                yunsans[i] = j;
            }

        }

        // N-1 개 중 중복 없이 순서 상관 없이 N-1개 고르기
        boolean[] isVisited = new boolean[N - 1];
        int[] result = new int[N - 1];
        find(result, 0, isVisited);

        System.out.println(max);
        System.out.println(min);
    }

    static void find(int[] result, int depth, boolean[] isVisited) {
        if (depth == N - 1) {
            calcul(result);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (isVisited[i])
                continue;
            result[depth] = yunsans[i];
            isVisited[i] = true;
            find(result, depth + 1, isVisited);
            isVisited[i] = false;
        }
    }

    static void calcul(int[] result) {
        int curr = nums[0];

        for (int i = 0; i < N - 1; i++) {
            if (result[i] == 0) { // +
                curr += nums[i + 1];
            } else if (result[i] == 1) { // -
                curr -= nums[i + 1];
            } else if (result[i] == 2) { // x
                curr *= nums[i + 1];
            } else if (result[i] == 3) { // %
                if (nums[i + 1] < 0 && curr > 0) {
                    nums[i + 1] = nums[i + 1] * -1;
                    curr /= nums[i + 1];
                    curr *= -1;
                } else {
                    curr /= nums[i + 1];
                }
            }
        }

        max = Math.max(max, curr);
        min = Math.min(min, curr);
    }
}