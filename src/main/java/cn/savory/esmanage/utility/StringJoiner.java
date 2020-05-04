package cn.savory.esmanage.utility;

import java.util.List;

public class StringJoiner {

    public static String joinIntList(List<Integer> values) {
        return joinIntList(values, ",");
    }

    public static String joinIntList(List<Integer> values, String spliter) {

        if (values == null || values.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0, length = values.size(); i < length; i++) {
            if (i > 0) {
                builder.append(spliter);
            }
            builder.append(values.get(i));
        }

        return builder.toString();
    }

    public static String joinLongList(List<Long> values) {
        return joinLongList(values, ",");
    }

    public static String joinLongList(List<Long> values, String spliter) {

        if (values == null || values.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0, length = values.size(); i < length; i++) {
            if (i > 0) {
                builder.append(spliter);
            }
            builder.append(values.get(i));
        }

        return builder.toString();
    }
}
