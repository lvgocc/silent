package com.lvgo.unname;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lvgo
 * @version 1.0
 * @package com
 * @description: //TODO һ�仰������������
 * @date 2019/9/24 11:42
 */
public class TestThreadPool {
    @Test
    public void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.execute(()-> System.out.println("123"));
    }
}
