package bfs;

import java.io.*;
import java.util.*;

public class BOJ9205 {
    static int n;
    static int[] home;
    static int[][] shop;
    static int[] fest;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.out.println(ganeung(new int[] { 0, 0 }, new int[] { 0, 1000 }));
        // 빈 병만 버림
        // 최대 20
        // 편의점 나설 때 맥주
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // t<= 50
        while (t > 0) {
            t--; // tc 감소

            n = Integer.parseInt(br.readLine()); // 0 <= n <= 100
            home = new int[2]; // 집
            shop = new int[n][2]; // 편의점
            fest = new int[2];
            isVisited = new boolean[n];

            // -32768 <= 좌표 <= 32767
            // 두 좌표 사이 거리 = x좌표 차이 + y좌표 차이

            // 집
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            // 편의점
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                shop[i][0] = Integer.parseInt(st.nextToken());
                shop[i][1] = Integer.parseInt(st.nextToken());
            }

            // 락 페
            st = new StringTokenizer(br.readLine(), " ");
            fest[0] = Integer.parseInt(st.nextToken());
            fest[1] = Integer.parseInt(st.nextToken());
            // 좌표 설정 끝

            find();

        } // tc
        System.out.println(sb);
    }// main

    static void find() {

        Queue<int[]> q = new LinkedList<>();

        // 맥주 한 박스 20개, 50미터에 한병
        if (ganeung(home, fest)) {
            sb.append("happy").append('\n');
            return;
        } else { // 한 번에 못가는 경우
            q.offer(home);

            while (!q.isEmpty()) {

                int[] curr = q.poll();

                if (ganeung(curr, fest)) {
                    sb.append("happy").append('\n');
                    return;
                }

                // 근처 가능한 편의점으로 감
                for (int i = 0; i < n; i++) {
                    // 편의점에서 가능한지 체크
                    if (!isVisited[i] && ganeung(curr, shop[i])) {
                        q.offer(shop[i]);
                        isVisited[i] = true;
                    }
                }
            }

            sb.append("sad").append('\n');
        }

    }

    static boolean ganeung(int[] a, int[] b) {
        if (guri(a, b) == 0) {
            return false;
        } else if (guri(a, b) <= 20 * 50) {
            return true;
        } else {
            return false;
        }
    }

    static int guri(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
