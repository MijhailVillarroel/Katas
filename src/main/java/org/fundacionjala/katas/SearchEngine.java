package org.fundacionjala.katas;

/**
 * @author Mijhail Villarroel.
 */
public class SearchEngine {

    private static final String WILDCARD = "_";
    private static final String REGEX_SPACE_BLANK = " ";
    private static final String REPLACEMENT_SPACES_BLANKS = "";

    public static int find(String findWord, String wholeText) {
        if (findWord.contains(WILDCARD)) {
            for (String values : wholeText.split(REGEX_SPACE_BLANK)) {
                if (values.length() == findWord.length() &&
                        values.contains(findWord.replace(WILDCARD, REPLACEMENT_SPACES_BLANKS))) {
                    findWord = values;
                }
            }
        }
        return wholeText.indexOf(findWord);
    }
}
