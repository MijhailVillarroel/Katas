import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mijhailvillarroel on 7/7/2016.
 */
public class Bank {

    private static final String regexZero = " _ | ||_|";

    private static final String regexOne = "     |  |";

    private static final String regexTwo = " _  _||_ ";

    private static final String regexThree = " _  _| _|";

    private static final String regexFour = "   |_|  |";

    private static final String regexFive = " _ |_  _|";

    private static final String regexSix = " _ |_ |_|";

    private static final String regexSeven = " _   |  |";

    private static final String regexEight = " _ |_||_|";

    private static final String regexNine = " _ |_| _|";

    private static final String QUESTION = "?";

    private static final String STRING_ERROR = "Bank.java";

    private static final String STRING_ILLEGAL = "ILL";

    private static final String TARGET = "-1";

    private static final Map<String, Integer> stores = new HashMap<>();
    static {
        stores.put(regexZero, 0);
        stores.put(regexOne, 1);
        stores.put(regexTwo, 2);
        stores.put(regexThree, 3);
        stores.put(regexFour, 4);
        stores.put(regexFive, 5);
        stores.put(regexSix, 6);
        stores.put(regexSeven, 7);
        stores.put(regexEight, 8);
        stores.put(regexNine, 9);
    }

    /**
     * This Method convert in a list a string send with lines and pipes.
     *
     * @param numberString
     * @return List the string numbers
     */
    public List<String> readEntry(String numberString) {
        String line1 = numberString.substring(0, 27);
        String line2 = numberString.substring(27, 54);
        String line3 = numberString.substring(54, 81);
        List<String> list = new ArrayList<>();
        int j = 0;
        for (int i = 3; i <= 27; i += 3) {
            list.add(line1.substring(j, i) + "" + line2.substring(j, i) + "" + line3.substring(j, i));
            j = i;
        }
        return list;

    }

    /**
     * This Method convert the read Number to String Number
     *
     * @param values the String the values is lines and pipes
     * @return Number in string
     */
    public String convertReadNumberToStringNumber(List<String> values) {
        StringBuilder result = new StringBuilder();
        for (String value : values) {
            result.append(convertStringNumberToIntNumber(value));
        }
        return result.toString().replace(TARGET, QUESTION);
    }

    /**
     *This method convert string a number
     *
     * @param number
     * @return int a number
     * return -1 when not find a regex a numbers
     */
    public int convertStringNumberToIntNumber(String number) {
        for (Map.Entry<String, Integer> value : stores.entrySet()) {
            if (value.getKey().equalsIgnoreCase(number)) {
                return value.getValue();
            }
        }
        return -1;
    }

    /**
     *This method give a format a number
     * ########?ILL -> when the number reading illegal
     * #########ERR -> When the number not is mod the eleven
     * ######### -> When a number is correct not add nothings
     *
     * @param numberString
     * @return String whit format
     */
    public String formatAccountNumbers(String numberString) {
        StringBuilder result = new StringBuilder();
        result.append(numberString);
        if (!numberString.contains(QUESTION)) {
            if (!(modNumber(numberString) % 11 == 0)) {
                result.append(" ");
                result.append(STRING_ERROR);
            }
        } else {
            result.append(STRING_ILLEGAL);
        }
        return result.toString();
    }

    /**
     *This Method calculate the mode that numberString
     *
     * @param numberString
     * @return log number
     */
    private long modNumber(String numberString) {
        final char[] chars = numberString.toCharArray();
        int add = 2;
        long result = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            result *= Integer.parseInt(String.valueOf(chars[i])) + add++;
        }
        return result;
    }

}
