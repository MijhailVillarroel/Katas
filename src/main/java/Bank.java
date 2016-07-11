import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mijhailvillarroel on 7/7/2016.
 */
public class Bank {

    private Map<String, Integer> stores;

    public Bank() {
        initializeMap();
    }

    private void initializeMap() {
        stores = new HashMap<>();
        stores.put(" _ | ||_|", 0);
        stores.put("     |  |", 1);
        stores.put(" _  _||_ ", 2);
        stores.put(" _  _| _|", 3);
        stores.put("   |_|  |", 4);
        stores.put(" _ |_  _|", 5);
        stores.put(" _ |_ |_|", 6);
        stores.put(" _   |  |", 7);
        stores.put(" _ |_||_|", 8);
        stores.put(" _ |_| _|", 9);
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
