package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 00:09 2020-05-26
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @ClassName: 生产者消费者问题
 * @Description TODO
 * @Author:
 * @Date: 2020-05-26 00:09 
 * @Version" 1.0
 */
public class 生产者消费者问题
{
    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    public static void main(String[] args)
    {

    }
}
