package SleightOfHand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int k = Integer.parseInt(reader.readLine());
            String[] stringArray = new String[4];
            String line = reader.readLine();
            stringArray[0] = line;
            for (int i = 1; i < 4; i++) {
                line = reader.readLine();
                stringArray[i] = line;
            }

            StringBuilder builder = new StringBuilder();
            for (String s : stringArray) {
                builder.append(s);
            }
            String sumString = builder.toString();

            System.out.println(findResult(sortAndDeleteDots(sumString), k));
        }
    }
    public static String sortAndDeleteDots(String string) {
        String newString = string.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return newString.chars()
                .filter(Character::isDigit)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }
    public static int findResult(String string, int k) {
        int countOuter = 0;
        int countInner = 1;
        if (Objects.equals(string, "")) {
            return 0;
        } else {
            String stringNew = string + " ";
            for (int i = 0; i < stringNew.length() - 1; i++) {
                if (stringNew.charAt(i) == stringNew.charAt(i + 1)) {
                    countInner++;
                    if (i == stringNew.length() - 2) {
                        countOuter++;
                    }
                } else {
                    if (countInner <= 2 * k) {
                        countOuter++;
                    }
                    countInner = 1;
                }
            }
        }
        return countOuter;
    }
}
