package com.lvgo.unname.factory;

import com.lvgo.unname.ThreadPool;

import java.util.function.Supplier;

/**
 * �̳߳ع�����
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/24 16:24
 */
public interface ThreadPoolBuilder {

    /**
     * ��ʼ����
     *
     * @param threadPoolType �̳߳�����
     * @param supplier       ��Ӧ�̳߳�
     */
    void build(ThreadPoolType threadPoolType, Supplier<ThreadPool> supplier);
}
