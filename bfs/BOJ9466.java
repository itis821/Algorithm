package bfs;

import java.io.*;
import java.util.*;

public class BOJ9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());
        int N;
        int[] fromTo;
        int[] toFrom;
        int num_team;

        boolean[] isVisited;
        boolean[] haveTeam;

        while (T > 0) {

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            num_team = 0;

            fromTo = new int[N + 1];
            toFrom = new int[N + 1];
            haveTeam = new boolean[N + 1];
            isVisited = new boolean[N + 1];

            for (int from = 1; from <= N; from++) {
                int to = Integer.parseInt(st.nextToken());
                fromTo[from] = to;
                toFrom[to] = from;
            }

            // 한 놈씩 검사
            for (int i = 1; i <= N; i++) {

                if (isVisited[i] == true)
                    continue;

                q.offer(i);
                isVisited[i] = true;

                while (!q.isEmpty()) {

                    int curr = q.poll();
                    int next = fromTo[curr];

                    if (next == i) {
                        while (true) {
                            haveTeam[i] = true;
                            toFrom[i] = true;
                        }
                        for (int j = 1; j <= N; j++) {
                            if (isVisited[j]) {
                                haveTeam[j] = true;
                                num_team++;
                            }
                        }
                        break;
                    }

                    if (isVisited[next]) {
                        break;
                    } else {
                        isVisited[next] = true;
                        q.offer(next);
                    }

                }

            }
            sb.append(N - num_team).append('\n');
            T--;
        }

        System.out.println(sb);
    }

}
