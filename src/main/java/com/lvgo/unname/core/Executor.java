package com.lvgo.unname.core;

/**
 * //TODO һ�仰������������
 *
 * @author lvgo
 * @version 1.0
 * @date 2019/9/29 9:56
 */
@FunctionalInterface
public interface Executor<T> {
    void execute(T t);
}
