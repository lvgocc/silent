package com.lvgo.unname.util;

import java.util.List;

/**
 * //TODO һ�仰������������
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/29 9:32
 */
public class ListUtil {

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(List list) {
        return list != null && list.size() != 0;
    }
}
