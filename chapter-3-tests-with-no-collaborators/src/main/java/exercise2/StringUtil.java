package exercise2;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static String reverse(String s) {
        final List<String> stringList = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            stringList.add(s.substring(i, (i + 1)));
        }

        final StringBuilder reversedStringBuilder = new StringBuilder(s.length());
        for (int i = stringList.size() - 1; i >= 0; i--) {
            reversedStringBuilder.append(stringList.get(i));
        }

        return reversedStringBuilder.toString();
    }
}
