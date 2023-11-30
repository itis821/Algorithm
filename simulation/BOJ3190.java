package simulation;

import java.io.*;
import java.util.*;

class BOJ3190 {
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 2 <= N <= 100
        int[][] map = new int[N][N];

        int K = Integer.parseInt(br.readLine()); // 0 <= K <= 100
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 1; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Integer> X = new LinkedList<>();
        Queue<Character> C = new LinkedList<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            X.offer(Integer.parseInt(st.nextToken()));
            C.offer(st.nextToken().charAt(0));
        }

        // logic
        game(map, X, C);

        // output
        System.out.println(time);
    }// main

    static void game(int[][] map, Queue<Integer> X, Queue<Character> C) {
        int dir = 1; // 0: 상, 1: 우, 2: 하, 3: 좌
        List<int[]> snake = new LinkedList<>();
        snake.add(new int[] { 0, 0 });

        while (true) {
            time++;

            if (!X.isEmpty()) {
                if (X.peek() == time - 1) {
                    X.poll();
                    dir = changeDir(dir, C.poll());
                }
            }

            if (!move(snake, dir, map)) {
                break;
            }

            // printSnake(map, snake);
        }

    }// game()

    static boolean move(List<int[]> snake, int dir, int[][] map) {
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        int r = snake.get(0)[0];
        int c = snake.get(0)[1];

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        int N = map.length;

        // 벽에 부딪힘
        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
            return false;
        }

        // 몸과 부딪힘
        for (int[] body : snake) {
            if (nr == body[0] && nc == body[1]) {
                return false;
            }
        }

        // 머리 이동
        snake.add(0, new int[] { nr, nc });

        // 사과 없으면 몸 성장 x
        if (map[nr][nc] != 1) {
            snake.remove(snake.size() - 1);
        } else if (map[nr][nc] == 1) {
            map[nr][nc] = 0;
        }

        return true;
    }

    static int changeDir(int dir, char C) {
        // 0
        // 3 1
        // 2
        // L : 왼쪽, D : 오른쪽
        if (dir == 0) {
            if (C == 'L') {
                dir = 3;
            } else if (C == 'D') {
                dir = 1;
            }
        } else if (dir == 1) {
            if (C == 'L') {
                dir = 0;
            } else if (C == 'D') {
                dir = 2;
            }
        } else if (dir == 2) {
            if (C == 'L') {
                dir = 1;
            } else if (C == 'D') {
                dir = 3;
            }
        } else if (dir == 3) {
            if (C == 'L') {
                dir = 2;
            } else if (C == 'D') {
                dir = 0;
            }
        }

        return dir;
    }// changeDir()

    static void printSnake(int[][] map, List<int[]> snake) {
        int N = map.length;
        char[][] myMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                myMap[i][j] = '.';
                if (map[i][j] == 1) {
                    myMap[i][j] = 'A';
                }
            }
        }

        for (int[] baem : snake) {
            myMap[baem[0]][baem[1]] = 'B';
        }

        System.out.println("----------------------");
        System.out.println("time : " + time);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(myMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}