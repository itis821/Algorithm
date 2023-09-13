package bfs;

import java.util.*;
import java.io.*;

public class BOJ2206 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 시작지점과 도착지점이 같을 경우
        if(N-1 == 0 && M-1 == 0){
            System.out.print(1)
            System.exit(0);
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        char[][] miro = new char[N][M];
        int[][] dist = new int[N][M];
        boolean[][][] visit = new boolean[2][N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                miro[i][j] = s.charAt(j);
            }
        }

        // 시작점 세팅 (x, y, crash 여부)
        q.offer(new int[]{0,0,0});

        while(!q.isEmpty()){
            int[] current = q.poll();

            for(int i=0; i<4; i++){
                int nX = current[0] + dx[i];
                int nY = current[1] + dy[i];

                // 범위 검사
                if(nX < 0 || nX >= N || nY < 0 || nY >= M)
                    continue;

                if(miro[nX][nY] == '1'){ // 다음 칸에 벽이 있을 때
                    if(current[2] == 0 && !visit[current[2]][nX][nY]){ // 현재 노드가 벽을 부순 적이 없고(유효성 검사) 다음 칸에 방문한 적 있는지(방문 검사)
                        visit[0][nX][nY] = true;    // 방문 처리
                        dist[nX][nY] = dist[current[0]][current[1]] + 1;    // 거리 측정
                        q.offer(new int[]{nX, nY, 1});
                    }
                }
                // 벽이 아닐 경우 -> 벽을 "부순 여부"에 따른 방문을 했는지 체크
                else{
                    if(!visit[current[2]][nX][nY]){
                        visit[current[2]][nX][nY] = true;
                        dist[nX][nY] = dist[current[0]][current[1]] + 1;
                        q.offer(new int[]{nX, nY, current[2]});
                    }
                }
                // 도착지점에 도달 했을 때 출력하고 종료!
                if(nX == N-1 && nY == M-1){
                    System.out.print(dist[nX][nY] + 1);
                    System.exit(0);
                }
            }
        }
        // 도달을 못했으므로 -1 출력
        System.out.print(-1);

    }

}
