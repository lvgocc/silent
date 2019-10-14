package com.lvgo.unname;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskHandlerTest {

    private List<String> testData = new ArrayList<>();

    @BeforeEach
    public void initParam() {
        for (int i = 0; i <= 100; i++) {
            testData.add("��" + i + "������");
        }
    }

    @Test
    void sync() {
        new TaskHandler<String>(testData) {
            @Override
            public void runTask(String s) {
                Integer index = Integer.valueOf(s);
                if (index % 100 == 0) {
                    System.out.println(index);
                }
            }
        }.sync(false).execute(10);

        System.out.println("�ҳ���������������Ϊͬ�����У� ����Ϊ�첽");
    }

    @Test
    void execute() {
    }

    @Test
    void execute1() {
    }

    @Test
    void execute2() {
    }

    @Test
    void execute3() {
    }
}