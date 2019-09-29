package com.lvgo.unname.beas;

import com.lvgo.unname.AbstractThreadPool;
import com.lvgo.unname.UnameThread;

/**
 * �̳߳�A
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/24 16:53
 */
public class ThreadPoolA extends AbstractThreadPool {
    /**
     * UnameThread �߳�ִ�з���
     *
     * @param unameThread untitled �߳�
     */
    @Override
    public void execute(UnameThread unameThread) {
        System.out.println("ThreadPoolA.execute");
        unameThread.run();
    }
}
