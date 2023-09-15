package simulation;

import java.util.*;
import java.io.*;

public class BOJ15683 {
    public static int[][] room;
    public static LinkedList<int[]> cctvList = new LinkedList<>();
    public static LinkedList<int[]> byukList = new LinkedList<>();
    public static int N;
    public static int M;
    public static int sagak = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                // cctv 등록
                if (0 < room[i][j] && room[i][j] < 6) {
                    cctvList.add(new int[] { room[i][j], i, j });

                    // 벽 등록
                } else if (room[i][j] == 6) {
                    byukList.add(new int[] { i, j });
                }
            }
        }

        // 경우의 수 모두 구하기
        int[] arr = new int[cctvList.size()];
        find_arr(arr, 0);

        System.out.println(sagak);
    }

    public static void find_arr(int[] arr, int depth) {
        if (depth == cctvList.size()) {
            sagak = Math.min(sagak, find_sagak(arr));
            return;
        }

        int c_type = cctvList.get(depth)[0];
        if (c_type == 1 || c_type == 3 || c_type == 4) {
            for (int i = 0; i < 4; i++) {
                arr[depth] = i;
                find_arr(arr, depth + 1);
            }
        } else if (c_type == 2) {
            for (int i = 0; i < 2; i++) {
                arr[depth] = i;
                find_arr(arr, depth + 1);
            }
        } else if (c_type == 5) {
            arr[depth] = 0;
            find_arr(arr, depth + 1);
        }

    }

    // CCTV 정보와 방향 정보를 줬을 때 사각지대 크기 구하기
    public static int find_sagak(int[] direction) {
        int watch = 0;
        int[] cctv;
        int d;
        int[][] visitRoom = new int[N][M];

        int[] byuk;
        for (int i = 0; i < byukList.size(); i++) {
            byuk = byukList.get(i);
            visitRoom[byuk[0]][byuk[1]] = 6;
        }

        for (int i = 0; i < cctvList.size(); i++) {
            cctv = cctvList.get(i);
            d = direction[i];

            if (cctv[0] == 1) {
                if (d == 0) { // 상
                    // 감시하기
                    watch += gamsi(visitRoom, cctv, 0);
                } else if (d == 1) { // 하
                    watch += gamsi(visitRoom, cctv, 1);
                } else if (d == 2) { // 좌
                    watch += gamsi(visitRoom, cctv, 2);
                } else if (d == 3) { // 우
                    watch += gamsi(visitRoom, cctv, 3);

                }
            } else if (cctv[0] == 2) {
                if (d == 0) { // 좌우
                    watch += gamsi(visitRoom, cctv, 2);
                    watch += gamsi(visitRoom, cctv, 3);
                } else if (d == 1) { // 상하
                    watch += gamsi(visitRoom, cctv, 0);
                    watch += gamsi(visitRoom, cctv, 1);
                }

            } else if (cctv[0] == 3) {
                if (d == 0) { // 상우
                    watch += gamsi(visitRoom, cctv, 0);
                    watch += gamsi(visitRoom, cctv, 3);

                } else if (d == 1) { // 우하
                    watch += gamsi(visitRoom, cctv, 3);
                    watch += gamsi(visitRoom, cctv, 1);

                } else if (d == 2) { // 하좌
                    watch += gamsi(visitRoom, cctv, 1);
                    watch += gamsi(visitRoom, cctv, 2);

                } else if (d == 3) { // 좌상
                    watch += gamsi(visitRoom, cctv, 2);
                    watch += gamsi(visitRoom, cctv, 0);
                }

            } else if (cctv[0] == 4) {
                if (d == 0) { // 하좌우
                    watch += gamsi(visitRoom, cctv, 1);
                    watch += gamsi(visitRoom, cctv, 2);
                    watch += gamsi(visitRoom, cctv, 3);
                } else if (d == 1) { // 상좌우
                    watch += gamsi(visitRoom, cctv, 0);
                    watch += gamsi(visitRoom, cctv, 2);
                    watch += gamsi(visitRoom, cctv, 3);

                } else if (d == 2) { // 상하우
                    watch += gamsi(visitRoom, cctv, 0);
                    watch += gamsi(visitRoom, cctv, 1);
                    watch += gamsi(visitRoom, cctv, 3);

                } else if (d == 3) { // 상하좌
                    watch += gamsi(visitRoom, cctv, 0);
                    watch += gamsi(visitRoom, cctv, 1);
                    watch += gamsi(visitRoom, cctv, 2);

                }

            } else if (cctv[0] == 5) {
                watch += gamsi(visitRoom, cctv, 0);
                watch += gamsi(visitRoom, cctv, 1);
                watch += gamsi(visitRoom, cctv, 2);
                watch += gamsi(visitRoom, cctv, 3);
            }
        }

        return N * M - byukList.size() - watch;
    }

    public static int gamsi(int[][] visitRoom, int[] cctv, int d) {
        int watch = 0;
        if (d == 0) { // 상
            int c = cctv[2];
            for (int r = cctv[1]; r >= 0; r--) {
                if (visitRoom[r][c] == 6)
                    break;
                if (visitRoom[r][c] != 0)
                    continue;
                visitRoom[r][c] = -1;
                watch++;
            }
        } else if (d == 1) { // 하
            int c = cctv[2];
            for (int r = cctv[1]; r < N; r++) {
                if (visitRoom[r][c] == 6)
                    break;
                if (visitRoom[r][c] != 0)
                    continue;
                visitRoom[r][c] = -1;
                watch++;
            }
        } else if (d == 2) { // 좌
            int r = cctv[1];
            for (int c = cctv[2]; c >= 0; c--) {
                if (visitRoom[r][c] == 6)
                    break;
                if (visitRoom[r][c] != 0)
                    continue;
                visitRoom[r][c] = -1;
                watch++;
            }
        } else if (d == 3) { // 우
            int r = cctv[1];
            for (int c = cctv[2]; c < M; c++) {
                if (visitRoom[r][c] == 6)
                    break;
                if (visitRoom[r][c] != 0)
                    continue;
                visitRoom[r][c] = -1;
                watch++;
            }
        }

        return watch;
    }
}
