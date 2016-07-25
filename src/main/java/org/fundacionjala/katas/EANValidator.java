package org.fundacionjala.katas;

/**
 * @author mijhailvillarroel
 */
public class EANValidator {

    private static final String REGEX_BLANK = "";
    private static final int INT_TEN = 10;
    private static final int INT_ZERO = 0;
    private static final int ELEMENT_POSITION_12 = 12;

    public static boolean validate(String number) {
        String[] listElements = number.split(REGEX_BLANK);
        int result = 0;
        for (int i = 1; i < listElements.length; i++) {
            int value = Integer.parseInt(listElements[i - 1]);
            result += (i % 2 == INT_ZERO && i != INT_ZERO) ? value * 3 : value;
        }
        int checksum = result % INT_TEN == INT_ZERO ? INT_ZERO : INT_TEN - (result % INT_TEN);
        return checksum == Integer.parseInt(listElements[ELEMENT_POSITION_12]);
    }
}
