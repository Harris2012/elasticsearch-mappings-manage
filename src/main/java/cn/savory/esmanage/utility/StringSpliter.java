package cn.savory.esmanage.utility;

import java.util.ArrayList;
import java.util.List;

public class StringSpliter {

    /**
     * 将指定字符串分割成由若干个数字组成的数组
     */
    public static List<Integer> toIntList(String ids) {
        return toIntList(ids, ",");
    }

    /**
     * 将指定字符串分割成由若干个数字组成的数组
     */
    public static List<Long> toLongList(String ids) {
        return toLongList(ids, ",");
    }

    /**
     * 将用逗号分隔的数字转换为int数组
     */
    public static List<Integer> toIntList(String ids, String regex) {
        if (ids == null || ids.isEmpty()) {
            return null;
        }

        String[] items = ids.split(regex);
        if (items == null || items.length == 0) {
            return null;
        }

        List<Integer> integers = new ArrayList<>();
        for (String item : items) {
            integers.add(Integer.valueOf(item));
        }

        return integers;
    }

    /**
     * 将用逗号分隔的数字转换为long数组
     */
    public static List<Long> toLongList(String ids, String regex) {
        if (ids == null || ids.isEmpty()) {
            return null;
        }

        String[] items = ids.split(regex);
        if (items == null || items.length == 0) {
            return null;
        }

        List<Long> integers = new ArrayList<>();
        for (String item : items) {
            integers.add(Long.valueOf(item));
        }

        return integers;
    }
}
