import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mijhailvillarroel on 7/7/2016.
 */
public class Bank {

    public static final String regexZero = " _ | ||_|";

    public static final String regexOne = "     |  |";

    public static final String regexTwo = " _  _||_ ";

    public static final String regexThree = " _  _| _|";

    public static final String regexFour = "   |_|  |";

    public static final String regexFive = " _ |_  _|";

    public static final String regexSix = " _ |_ |_|";

    public static final String regexSeven = " _   |  |";

    public static final String regexEight = " _ |_||_|";

    public static final String regexNine = " _ |_| _|";

    private Map<String, Integer> stores;

    public Bank() {
        initializeMap();
    }

    /**
     * This Method initialize the regex and add into collection Map
     */
    private void initializeMap() {
        stores = new HashMap<String, Integer>();
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

    public String convertReadNumberToStringNumber(List<String> values) {
        StringBuilder result =  new StringBuilder();
        for (String value : values) {
            result.append(convertStringNumberToIntNumber(value));
        }
        return result.toString().replace("-1", "?");
    }

    public int convertStringNumberToIntNumber(String number) {
        for (Map.Entry<String, Integer> value : stores.entrySet()) {
            if (value.getKey().equalsIgnoreCase(number)) {
                return value.getValue();
            }
        }
        return -1;
    }

    public String formatAccountNumbers(String numberString) {
        StringBuilder result =  new StringBuilder();
        result.append(numberString);
        if (!numberString.contains("?")) {
            if (!(modNumber(numberString) % 11 == 0)) {
                result.append("ERR");
            }
        } else {
            result.append("ILL");
        }
        return result.toString();
    }

    public long modNumber(String numberString) {
        final char[] chars = numberString.toCharArray();
        int add = 2;
        long result = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            result *= Integer.parseInt(String.valueOf(chars[i])) + add++;
        }
        return result;
    }

}
