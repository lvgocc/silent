package com.lvgo.unname;

/**
 * �̳߳ؽӿ�, ֧��ԭ�����Զ�������ִ�в���
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/24 17:00
 */
public interface ThreadPool {
    /**
     * ԭ���߳�ִ�з���
     *
     * @param runnable jdk ԭ���߳�
     */
    void execute(Runnable runnable);

    /**
     * UnameThread �߳�ִ�з���
     *
     * @param unameThread untitled �߳�
     */
    void execute(UnameThread unameThread);
}