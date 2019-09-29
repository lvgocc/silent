package com.lvgo.unname;

/**
 * �̳߳ؽӿ�
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/24 15:31
 */
public abstract class AbstractThreadPool implements ThreadPool {

    /**
     * ԭ���߳�ִ�з���
     *
     * @param runnable jdk ԭ���߳�
     */
    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}