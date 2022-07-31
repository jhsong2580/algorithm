package algorithm.algorithm.algo_20220731;

public class algo_1 {

    private static final char MIN_NUMBER = (char) '0';
    private static final char MAX_NUMBER = (char) '9';

    public int myAtoi(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String source = s.trim(); //빈칸제거
        int index = 0;
        char isPositive = '+';
        if (source.equals("") || source.equals("+") || source.equals("-")) {
            return 0;
        }
        if (sourceIsPlus(source.charAt(index)) || sourceIsMinus(source.charAt(index))) {
            isPositive = source.charAt(index);
            index += 1;
        }

        if (sourceIsNonDigit(source.charAt(index))) {
            return 0;
        }

        for (int i = index; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c <= (char) '9' && c >= (char) '0') {
                stringBuilder.append(c);
                continue;
            }
            break;
        }
        if (stringBuilder.length() == 0) {
            return 0;
        }
        stringBuilder.insert(0, isPositive);
        String result = stringBuilder.toString();

        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            if (result.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }

    private boolean sourceIsPlus(char source) {
        return source == '+';
    }

    private boolean sourceIsMinus(char source) {
        return source == '-';
    }

    private boolean sourceIsNonDigit(char source) {
        return source > MAX_NUMBER && source < MIN_NUMBER;
    }
}
