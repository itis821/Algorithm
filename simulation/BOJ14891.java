package simulation;

import java.util.*;
import java.io.*;

public class BOJ14891 {
    // 1:시계, -1:반시계
    // 0:N, 1:S
    public static int[] topny_at = new int[4]; // 톱니 시작점
    public static int[][] topny = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] temp = new char[8];

        for (int i = 0; i < 4; i++) {
            temp = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                topny[i][j] = temp[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] info = new int[2]; // {톱니 번호, 회전 방향}
        int[] rotates = new int[4]; // {0,0,0,0}
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            info[0] = Integer.parseInt(st.nextToken()) - 1;
            info[1] = Integer.parseInt(st.nextToken());
            // 돌아갈 톱니 판단
            rotates = find_topny(info[0], info[1]);
            // 톱니 회전 (시작 인덱스를 변경)
            rotate_topny(rotates);
        }
        // 톱니 계산
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (topny[i][topny_at[i] % 8] == 1) {
                count += (int) Math.pow(2.0, (double) i);
            }
        }
        System.out.println(count);
    }

    public static void rotate_topny(int[] rotates) {
        for (int i = 0; i < 4; i++) {
            topny_at[i] -= rotates[i];
            if (topny_at[i] == -1) {
                topny_at[i] = 7;
            }
        }
    }// rotate_topny

    public static int[] find_topny(int index, int rotate) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[4];
        int[] rotates = new int[4];

        queue.offer(index);
        isVisited[index] = true;
        rotates[index] = rotate;

        int c, l, r, cl, cr, lr, rl;

        while (!queue.isEmpty()) {
            c = queue.poll();
            l = c - 1;
            r = c + 1;

            // 왼쪽
            if (0 <= l && !isVisited[l]) {
                cl = (6 + topny_at[c]) % 8;
                lr = (2 + topny_at[l]) % 8;
                if (topny[c][cl] != topny[l][lr]) {
                    isVisited[l] = true;
                    queue.offer(l);
                    rotates[l] = (rotates[c] == 1 ? -1 : 1);
                }

            }
            // 오른쪽
            if (r < 4 && !isVisited[r]) {
                cr = (2 + topny_at[c]) % 8;
                rl = (6 + topny_at[r]) % 8;
                if (topny[c][cr] != topny[r][rl]) {
                    isVisited[r] = true;
                    queue.offer(r);
                    rotates[r] = (rotates[c] == 1 ? -1 : 1);
                }
            }

        }
        return rotates;
    } // find_topny()
}
