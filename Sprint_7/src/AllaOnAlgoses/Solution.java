package AllaOnAlgoses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] F = new int[n + 1];
        int INF = 100000;
        F[0] = 0;

        int m, i;

        for (m = 1; m <= n; m++)
        {
            F[m] = INF;
            for (i = 0; i < k; ++i)
            {
                if (m >= a[i] && F[m - a[i]] + 1 < F[m])
                    F[m] = F[m - a[i]] + 1;
            }
        }

        if (F[n] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(F[n]);
        }
    }
}
