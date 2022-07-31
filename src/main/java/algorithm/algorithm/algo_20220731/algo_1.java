package algorithm.algorithm.algo_20220731;

public class algo_1 {

    private static final char MIN_NUMBER = (char) '0';
    private static final char MAX_NUMBER = (char) '9';
    private static final char BASE_NUMBER = (char) '0';

    public int myAtoi(String s) {
        String source = s.trim();
        int index = 0;
        double result = 0;
        if (source.equals("") || source.equals("+") || source.equals("-")) {
            return 0;
        }

        if (sourceIsPlus(source.charAt(index)) || sourceIsMinus(source.charAt(index))) {
            index += 1;
        }

        for (int i = index; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c <= MAX_NUMBER && c >= MIN_NUMBER) {
                result = result * 10 + c - BASE_NUMBER;
                continue;
            }
            break;
        }

        if (source.charAt(0) == '-') {
            result = result * -1;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }


    private boolean sourceIsPlus(char source) {
        return source == '+';
    }

    private boolean sourceIsMinus(char source) {
        return source == '-';
    }
}
