package com.softgarden.baselibrary.utils;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by DELL on 2017/9/23.
 */

public class EmptyUtil {
    private EmptyUtil() {
        throw new UnsupportedOperationException("u can't fuck me...");
    }

    /**
     * 判断 list 是否为空
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(@Nullable List<?> list) {
        return !isEmpty(list);
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(@Nullable CharSequence str) {
        return !isEmpty(str);
    }

    /**
     * @param str
     * @return
     */
    public static String nullIfEmpty(@Nullable String str) {
        return isEmpty(str) ? null : str;
    }
}
