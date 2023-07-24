package basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10869 {

    int[][] triangle;

    public static void main(int n) {
        int[] answer = new int[n*(n-1)/2];
        int count = 0;
        this.triangle = new int[n][n];
        makeTriangle(0,0,n,1);

        for(int row=0; row<n ; row++) {
            for (int col = 0; col <= row; col++) {
                answer[count++] = this.triangle[row][col];
            }
        }
    }
    void makeTriangle(int row, int col, int size, int num){
        // down
        for(int i=0; i<size; i++){
            this.triangle[row+i][col] = num++;
        }
        // left
        for(int i=1; i<size; i++){
            this.triangle[row+size-1][col+i] = num++;
        }
        // diagonal
        for(int i=1; i<size-1; i++){
            this.triangle[row+size-1-i][col+size-1-i] = num++;
        }

        size = size-3;
        if(size <= 0) return;
        else makeTriangle(row+2, col+1, size, num);
    }
}
