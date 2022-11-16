package DifferentSearchTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = BigInteger.valueOf(Integer.parseInt(reader.readLine()));
        BigInteger result = findAmountOfBST(n.multiply(BigInteger.valueOf(2))).
                divide(findAmountOfBST(n).
                        multiply(findAmountOfBST(n.add(BigInteger.valueOf(1)))));
        System.out.println(result);
    }

    static BigInteger findAmountOfBST(BigInteger n) {
        if (n.equals(BigInteger.valueOf(0))) {
            return BigInteger.valueOf(1);
        }
        return findAmountOfBST(n.subtract(BigInteger.valueOf(1))).multiply(n);
    }
}
