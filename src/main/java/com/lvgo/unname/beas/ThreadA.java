package com.lvgo.unname.beas;

import com.lvgo.unname.UnameThread;

/**
 * //TODO 一句话描述此类作用
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/24 16:53
 */
public class ThreadA<T> extends UnameThread {

    private T task;

    public ThreadA(T task) {
        this.task = task;
    }


    @Override
    public void run() {

    }
}
