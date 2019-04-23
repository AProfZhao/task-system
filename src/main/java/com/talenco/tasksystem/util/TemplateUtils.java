package com.talenco.tasksystem.util;

import org.slf4j.Logger;

import java.util.function.BooleanSupplier;

/**
 * 版本工具类
 * 对通用的模版的封装以消除模版代码
 *
 * @author echcz
 * @date 2019-04-23 16:29:23
 */
public class TemplateUtils {
    private TemplateUtils() {
    }

    /**
     * 如果出现异常则返回false并且记录异常信息到日志
     *
     * @param logger 日志记录者
     * @param booleanSupplier 返回boolean的回调函数
     * @return 如果出现异常则返回false，否则返回原值
     */
    public static boolean falseAndLogIfException(Logger logger, BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn(e.toString());
            return false;
        }
    }

    /**
     * 如果出现异常则返回false
     *
     * @param booleanSupplier 返回boolean的回调函数
     * @return 如果出现异常则返回false，否则返回原值
     */
    public static boolean falseIfException(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
