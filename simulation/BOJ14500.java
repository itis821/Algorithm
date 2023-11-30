package simulation;

import java.io.*;
import java.util.*;

public class BOJ14500 {
    static int max = -1;

    static int[][][] dohyung = {
            // 1번
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },

            // 2번
            { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },

            // 3번
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, -1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, -1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 0 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } },

            // 4번
            { { 0, 0 }, { 0, 1 }, { -1, 0 }, { 1, 1 } },
            { { 0, 0 }, { 0, 1 }, { -1, 1 }, { 1, 0 } },
            { { 0, 0 }, { 1, 0 }, { 0, -1 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, -1 } },

            // 5번
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 1 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, -1 } }

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        find(map);

        // output
        System.out.println(max);

    }// main()

    static void find(int[][] map) {
        int N = map.length;
        int M = map[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 도형이 되는지 확인
                for (int k = 0; k < dohyung.length; k++) {
                    int[][] curr = dohyung[k];

                    if (isPossible(curr, N, M, i, j)) {
                        max = Math.max(calculate(curr, i, j, map), max);
                    }
                }
            }
        }

    }// find()

    static boolean isPossible(int[][] curr, int N, int M, int r, int c) {
        boolean val = true;

        for (int i = 0; i < 4; i++) {
            if (r + curr[i][0] < 0 || r + curr[i][0] >= N || c + curr[i][1] < 0 || c + curr[i][1] >= M) {
                val = false;
                break;
            }
        }

        return val;
    }

    static int calculate(int[][] curr, int r, int c, int[][] map) {
        int val = 0;

        for (int i = 0; i < 4; i++) {
            int x = r + curr[i][0];
            int y = c + curr[i][1];

            val += map[x][y];
        }

        return val;
    }

}
