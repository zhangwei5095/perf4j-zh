package com.peaceful.perf4j.dashboard.common;

import com.google.common.base.Throwables;
import com.peaceful.common.util.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

/**
 * task console api list
 *
 * @author WangJun <wangjuntytl@163.com>
 * @version 1.0 15/9/16
 * @since 1.6
 */

public class TaskConsoleAPI {


    private static Logger logger = LoggerFactory.getLogger(TaskConsoleAPI.class);

    public static String cat(String method) {
        try {
            if (StringUtils.isEmpty(method)) method = "";
            return HttpClient.get(apiAdd.get() + "?method=" + method);
        } catch (Exception e) {
            logger.error("request found error {}", ExceptionUtils.getStackTrace(e));
            return Throwables.getStackTraceAsString(e);
        }
    }


    /**
     * change console api add on running time
     */
    private static ThreadLocal<String> apiAdd = new ThreadLocal<String>();

    /**
     * Set the API address before invoking it  in the same thread
     *
     * @param add task container api address
     */
    public static void setUrl(String add) {
        apiAdd.set(add);
    }





}
