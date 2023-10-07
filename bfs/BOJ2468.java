package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2468 {
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 2<= N <= 100
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 높이가 1부터 100까지 최대 개수를 구함
        for (int h = 0; h <= 100; h++) {
            bfs(getMap(h));
        }

        System.out.println(max);

    }// main

    static void bfs(int[][] myMap) {
        // 안전한 영역 최대 개수 구하기
        boolean[][] isVisited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (myMap[i][j] != 0 && !isVisited[i][j]) {

                    q.offer(new int[] { i, j });
                    isVisited[i][j] = true;
                    // System.out.println("cnt++ : " + "r : " + i + " c : " + j);
                    cnt++;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        int r, c;
                        for (int k = 0; k < 4; k++) {
                            r = curr[0] + dr[k];
                            c = curr[1] + dc[k];

                            if (r < 0 || r >= N || c < 0 || c >= N)
                                continue;

                            if (myMap[r][c] == 0)
                                continue;

                            if (isVisited[r][c])
                                continue;

                            isVisited[r][c] = true;
                            q.offer(new int[] { r, c });

                        }
                    }
                }
            }
        }
        // System.out.println("-----------");
        max = Math.max(max, cnt);
    } // bfs

    static int[][] getMap(int h) {
        int[][] nMap = new int[N][N];

        // System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nMap[i][j] = map[i][j] - h;
                if (nMap[i][j] <= 0) {
                    nMap[i][j] = 0;
                }
                // System.out.print(nMap[i][j] + " ");
            }
            // System.out.println();
        }

        return nMap;
    } // getMap()

}
