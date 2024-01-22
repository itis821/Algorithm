package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class s1 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 1 <= T <= 1,000

        // 이동 방향
        int d_size = 6;
        int[] dr = { -1, -1, 0, 0, 1, 1 };
        int[] dc = { -1, 0, -1, 1, -1, 0 };

        int[][] triArr = new int[141][141];
        int num = 1;

        // 삼각형 초기화 (141 * 141 = 19,881)
        int tri_size = 141;
        for (int i = 0; i < tri_size; i++) {
            for (int j = 0; j < tri_size; j++) {
                if (j <= i) {
                    triArr[i][j] = num++;
                }
            }
        }

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(tc + 1).append(" ");

            // 시작과 목적지가 같은 경우
            if (s == e) {
                sb.append(0);
                if (tc != T - 1) {
                    sb.append("\n");
                }
                continue;
            }

            // start 좌표 찾기, O(19,881)
            int[] s_idx = { -1, -1 };

            for (int i = 0; i < tri_size; i++) {
                for (int j = 0; j < tri_size; j++) {
                    if (triArr[i][j] == s) {
                        s_idx[0] = i;
                        s_idx[1] = j;
                        break;
                    }
                }

                if (s_idx[0] != -1 && s_idx[1] != -1) {
                    break;
                }
            }

            // bfs
            int ans = -1;
            Queue<int[]> q = new LinkedList<>();
            int[][] isVisited = new int[tri_size][tri_size];
            q.offer(s_idx);
            isVisited[s_idx[0]][s_idx[1]] = 1;

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                for (int i = 0; i < d_size; i++) {
                    int r = curr[0] + dr[i];
                    int c = curr[1] + dc[i];

                    // 좌표가 범위 밖인 경우
                    if (r < 0 || r >= tri_size || c < 0 || c > r) {
                        continue;
                    }

                    // 방문한 적 있는 경우
                    if (isVisited[r][c] != 0) {
                        continue;
                    }

                    // 조건 충족
                    isVisited[r][c] = isVisited[curr[0]][curr[1]] + 1;

                    if (triArr[r][c] == e) {
                        ans = isVisited[r][c] - 1;
                        break;
                    }

                    q.offer(new int[] { r, c });

                }

                if (ans != -1) {
                    break;
                }
            } // while

            sb.append(ans);
            if (tc != T - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}