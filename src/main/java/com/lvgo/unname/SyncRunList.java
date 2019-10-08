package com.lvgo.unname;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ͬ��������̴߳��������
 */
public abstract class SyncRunList<E> {

    /**
     * ���д�ȡ�໤��
     */
    private final ReentrantLock lock;
    /**
     * ��������
     */
    private Map<String, Object> args;
    /**
     * Ԫ������
     */
    private List<E> tasks;
    /**
     * ��һ����ִ��Ԫ������
     */
    private int takeIdx;

    protected SyncRunList(List<E> tasks) {
        this(tasks, null);
    }

    /**
     * ���캯��
     *
     * @param tasks Ԫ������
     * @param args  ��������
     */
    protected SyncRunList(List<E> tasks, Map<String, Object> args) {
        this.lock = new ReentrantLock(false);
        this.tasks = tasks;
        this.args = args;
    }

    /**
     * ��ȡ��һ����ִ��Ԫ��
     *
     * @return
     */
    public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (takeIdx >= tasks.size()) {
                return null;
            }
            return tasks.get(takeIdx++);
        } finally {
            lock.unlock();
        }
    }

    /**
     * ɾ��������ָ��Ԫ��
     *
     * @param o
     * @return
     */
    public boolean remove(E o) {
        if (o == null) {
            return false;
        }
        final List<E> ls = this.tasks;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int idx = ls.indexOf(o);
            ls.remove(idx);
            if (idx < takeIdx) {
                takeIdx--;
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * ��Ԫ������ִ��
     *
     * @param task Ԫ��
     */
    protected abstract void taskRun(E task);

    /**
     * ���������߳�ִ�н�������
     *
     * @param syncRunnable
     */
    protected void afterRun(SyncRunnable syncRunnable) {
    }

    /**
     * ����ִ���߳�
     *
     * @return ִ���߳�
     */
    private SyncRunnable syncRunnable() {
        return new SyncRunnable();
    }

    /**
     * ���̳߳ػ����±�������Ԫ�أ�ִ�и�������������
     *
     * @param executor  ִ������
     * @param taskCount ������������
     */
    public void execute(Executor executor, int taskCount) {
        for (int r = 0; r < taskCount; ) {
            try {
                executor.execute(syncRunnable());
                r++;
            } catch (Exception e) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e1) {
                }
            }
        }
    }

    public List<E> getTasks() {
        return tasks;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    /**
     * ����ִ���߳�
     */
    protected class SyncRunnable implements Runnable {
        @Override
        public void run() {
            try {
                E item;
                while ((item = poll()) != null) {
                    taskRun(item);
                }
            } finally {
                afterRun(this);
            }
        }
    }

}
