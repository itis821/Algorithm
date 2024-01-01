package simulation;

import java.io.*;
import java.util.*;

class BOJ14890 {

    public static void main(String[] args) throws IOException {
        // N x N 지도 (2 <= N <= 100)
        // L (1 <= L <= N) 경사로 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 2 <= N <= 100
        int L = Integer.parseInt(st.nextToken()); // 1 <= L <= N
        int[][] map = new int[N][N];
        int[][] gsmap = new int[N][N];

        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2N 개의 길 (4 <= 2N <= 200)

        // 경사로 없이 건널 수 있는 길 확인
        // for문으로 순회하며 길 찾기(높이가 같은지)
        // 행길
        for (int i = 0; i < N; i++) {

            boolean vali = true;
            int bigy = map[i][0];

            for (int j = 1; j < N; j++) {

                int curr = map[i][j];

                // 높이가 다를 경우
                if (curr != bigy) {

                    // 높이차가 1보다 큰 경우
                    if (Math.abs(curr - bigy) > 1) {
                        vali = false;
                        break;
                    }
                    // 높이차가 1인 경우
                    else {
                        // 오르막길

                        // 내리막길
                    }
                }
                // 높이가 같을 경우
                else {
                    continue;
                }
            }

            if (vali) {
                ans++;
            }

        }
        // 높이가 같다면
        // 건널 수 있는 길
        // 높이가 다르다면
        // 차가 1인 경우
        // 경사로 놓아보기(길이가 되는지 확인)
        // 길이가 된다면
        // 경사로 놓기 (경사로 맵에 1씩 더하기)
        // 길이가 안된다면
        // 못 건너는 길
        // 차가 1보다 큰 경우
        // 못 건너는 길
        // 경사로 맵에서 1보다 큰 경사로 제거
        // if 경사로 값이 최대 1이라면 ok
        // 길 별로 경사로값 확인(총 2N개의 길)
        //

    }

    static boolean isInBumwee(int i, int j, boolean isUp) {
        if (isUp) { // 오르막길

        } else if (!isUp) { // 내리막길

        }
    }
}