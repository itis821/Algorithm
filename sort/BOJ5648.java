package sort;

import java.io.*;
import java.util.*;

public class BOJ5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        while (list.size() < n) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
        }

        List<Long> numList = new ArrayList<>();
        changeNum(list, numList);
        Collections.sort(numList);

        StringBuilder sb = new StringBuilder();
        for (Long l : numList) {
            sb.append(l).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void changeNum(List<String> list, List<Long> numList) {
        int size = list.size();

        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder(list.get(i));
            sb = sb.reverse();
            numList.add(Long.parseLong(sb.toString()));
        }
    }

}
