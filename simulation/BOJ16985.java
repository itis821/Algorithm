package simulation;

import java.io.*;
import java.util.*;

class BOJ16985 {

    static int ans = 9999;

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
        int[] rotate = new int[5];
        boolean[] blockVisi = new boolean[5];

        find(0, block, rotate, blockVisi, maze);

        // output
        if (ans == 9999) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans);
    }

    // 0, 0, 0 -> 4, 4, 4 까지 길이 있는지

    static void find(int depth, int[] block, int[] rotate, boolean[] blockVisi, int[][][] maze) {
        if (depth == 5) {

            int[][][] myMaze = makeMaze(block, rotate, maze);
            ans = Math.min(ans, bfs(myMaze));

            return;
        }

        // 블록 선택
        for (int i = 0; i < 5; i++) {

            if (blockVisi[i] == true)
                continue;

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
        int[][][] tempMaze = new int[5][5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    tempMaze[i][j][k] = maze[i][j][k];
                }
            }
        }

        // rotate
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= rotate[i]; j++) {
                tempMaze[block[i]] = rotateMaze(tempMaze[block[i]]);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    myMaze[i][j][k] = tempMaze[block[i]][j][k];
                }
            }
        }

        return myMaze;
    }// makeMaze()

    static int[][] rotateMaze(int[][] maze) {
        int[][] myMaze = new int[5][5];

        for (int k = 0; k <= 1; k++) {
            for (int i = 0; i <= 4 - k - 1; i++) {
                // 좌
                myMaze[4 - k - i][k] = maze[k][k + i];
                // 하
                myMaze[4 - k][4 - k - i] = maze[4 - k - i][k];
                // 우
                myMaze[k + i][4 - k] = maze[4 - k][4 - k - i];
                // 상
                myMaze[k][k + i] = maze[k + i][4 - k];
            }
        }

        myMaze[2][2] = maze[2][2];

        return myMaze;
    }// rotateMaze()

    static int bfs(int[][][] myMaze) {

        if (myMaze[0][0][0] == 0 || myMaze[4][4][4] == 0) {
            return 9999;
        }

        int[][][] isVisited = new int[5][5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    isVisited[i][j][k] = -1;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int[] dh = { -1, 1, 0, 0, 0, 0 };
        int[] dr = { 0, 0, -1, 1, 0, 0 };
        int[] dc = { 0, 0, 0, 0, -1, 1 };

        q.offer(new int[] { 0, 0, 0 });
        isVisited[0][0][0] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int h = curr[0];
            int r = curr[1];
            int c = curr[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nh < 0 || nh >= 5 || nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
                    continue;

                if (isVisited[nh][nr][nc] >= 0 || myMaze[nh][nr][nc] == 0)
                    continue;

                isVisited[nh][nr][nc] = isVisited[h][r][c] + 1;

                if (nh == 4 && nr == 4 && nc == 4) {
                    return isVisited[4][4][4];
                }

                q.offer(new int[] { nh, nr, nc });
            }
        }

        return 9999;
    }// bfs()

    static void printMaze(int[][] maze) {
        System.out.println("PRINT MAZE");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }// printMaze()
}