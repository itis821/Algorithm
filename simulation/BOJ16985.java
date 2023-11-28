package simulation;

import java.io.*;
import java.util.*;

class BOJ16985 {
    // 11월 28일 17:17 ~
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][][] maze = new int[5][5][5];

        // input
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 5; k++) {
                    maze[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // logic
        int[] block = new int[5];
        boolean[] blockVisi = new boolean[5];
        int[] rotate = new int[5];

        find(0, block, rotate, blockVisi, maze);

        // output
        System.out.println();
    }

    // 0, 0, 0 -> 4, 4, 4 까지 길이 있는지

    static void find(int depth, int[] block, int[] rotate, boolean[] blockVisi, int[][][] maze) {
        if (depth == 5) {
            int[][][] myMaze = makeMaze(block, rotate, maze);
            return;
        }

        // 블록 선택
        for (int i = 0; i < 5; i++) {

            if (blockVisi[i] == true) {

                continue;
            }

            // 회전 선택
            for (int j = 0; j < 4; j++) {
                block[depth] = i;
                rotate[depth] = j;

                blockVisi[i] = true;

                find(depth + 1, block, rotate, blockVisi, maze);
                blockVisi[i] = false;
            }
        }
    } // find()

    static int[][][] makeMaze(int[] block, int[] rotate, int[][][] maze) {
        int[][][] myMaze = new int[5][5][5];

        // rotate
        for (int i = 0; i < 5; i++) {
            maze[block[i]] = rotateMaze(maze[block[i]], rotate[block[i]]);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    myMaze[i][j][k] = maze[block[i]][j][k];
                }
            }
        }

        return myMaze;
    }// makeMaze()

    static int[][] rotateMaze(int[][] maze, int rotate) {
        int[][] myMaze = new int[5][5];

        if (rotate == 1) { // 좌회전 1번

            return myMaze;
        } else if (rotate == 2) { // 좌회전 2번

            return myMaze;
        } else if (rotate == 3) { // 좌회전 3번

            return myMaze;
        }

        // 기본
        return maze;
    }
}