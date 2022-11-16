package Monitoring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        int matrixHeight = Integer.parseInt(reader.readLine());
        int matrixWidth = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[matrixHeight][matrixWidth];

        for (int i = 0; i < matrixHeight; i++) {
            lines.add(reader.readLine());
            String[] line = lines.get(i).split(" ");
            System.arraycopy(line, 0, matrix[i], 0, matrixWidth);
        }

        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixHeight; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
