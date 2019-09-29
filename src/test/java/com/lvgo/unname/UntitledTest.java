package com.lvgo.unname;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * //TODO һ�仰������������
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/29 11:12
 */
public class UntitledTest {


    List<String> testStrArray = new ArrayList<>();
    BlockingQueue<String> tq = new ArrayBlockingQueue<>(100);
    @BeforeEach
    public void be() {
        System.out.println("��ʼ��ʼ������");
        for (int i = 1; i <= 100; i++) {
            testStrArray.add("��" + i + "��");
        }
        for (int i = 1; i <= 100; i++) {
            tq.offer("Ŷ��ľľľ");
        }

        System.out.println("��ʼ���������");
    }


    @Test
    public void test() throws InterruptedException {
        for (int i = 100; i >= 1; i--) {
            int finalI = i;
            new Thread(() -> {
                testStrArray.remove(0);
                System.out.println("���ǵ�" + finalI + "��, �ҵ��߳���Ϣ��" + Thread.currentThread() + ", �ҿ�����������" + testStrArray.size());
            }).start();
        }
        Thread.currentThread().join(10000);
    }


    @Test
    public void test1() throws InterruptedException {
        for (int i = 100; i >= 1; i--) {
            int finalI = i;
            new Thread(() -> {
                try {
                    tq.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("���ǵ�" + finalI + "��, �ҵ��߳���Ϣ��" + Thread.currentThread() + ", �ҿ�����������" + tq.size());

            }).start();
        }
        Thread.currentThread().join(10000);
    }
}
