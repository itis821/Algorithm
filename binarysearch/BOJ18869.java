package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ18869 {
    static int[][] mat;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken()); // 2<= 우주의 개수 <= 100
        N = Integer.parseInt(st.nextToken()); // 3<= 행성의 개수 <= 10,000

        mat = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 1 <= 행성의 크기 <= 1,000,000
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //

        // 좌표 압축
        for (int i = 0; i < M; i++) {

            // i 번째 우주
            int[] tmp = new int[N];

            for (int j = 0; j < N; j++) {
                tmp[j] = mat[i][j];
            }

            Arrays.sort(tmp);
            apchuk(i, tmp);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (bigyo(i, j)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean bigyo(int a, int b) {
        boolean ans = true;

        for (int i = 0; i < N; i++) {
            if (mat[a][i] != mat[b][i]) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    static void apchuk(int i, int[] sorted) {
        // i번째 행성의 j번째 크기를 순서로 압축시킴

        for (int j = 0; j < mat[i].length; j++) {
            mat[i][j] = binarySearch(mat[i][j], sorted);
        }

    }

    static int binarySearch(int target, int[] sorted) {
        int lo = 0;
        int hi = sorted.length - 1;

        if (sorted[lo] == target) {
            return lo;
        } else if (sorted[hi] == target) {
            return hi;
        }

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (target <= sorted[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
