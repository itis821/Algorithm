package bfs;

import java.io.*;
import java.util.*;

public class BOJ9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (T > 0) {
            int n = Integer.parseInt(br.readLine()); // 학생 수
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            boolean[] isVisited = new boolean[n];
            boolean[] haveTeam = new boolean[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            // n = 학생 수, arr[i]
            // 2 <= n <= 100,000
            // 방문했던 곳을 다시 방문하면 팀
            // 다시 방문된 곳부터
            // 근데 이게 왜 bfs임?
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            isVisited[0] = true;

            while (q.isEmpty()) {
                int current = q.poll(); // 현재
                int next = arr[current]; // 다음 놈
                // 범위 검사 (없음)

                // 유효성 검사
                if (haveTeam[next])
                    continue; // 팀이 이미 있음
                if (current == next) { // 혼자 팀
                    haveTeam[current] = true;
                    continue;
                }
                if (isVisited[next]) { // 팀이 없는데, 방문한 적 있음
                    int i = next;
                    haveTeam[current] = true;
                    while (true) {
                        haveTeam[i] = true;
                        i = arr[i];
                        if (i == current)
                            break;
                    }
                }

                // 중복검사

                // 방문체크
            }
        }

        T--; // 테스트 케이스 끝
    }

}
