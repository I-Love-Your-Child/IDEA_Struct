package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 10:36 2020-05-27
 */

import java.util.concurrent.locks.*;


/**
 *
 * @ClassName: 多线程
 * @Description TODO
 * @Author:
 * @Date: 2020-05-27 10:36 
 * @Version" 1.0
 */
public class 多线程
{
    static Lock lock = new ReentrantLock();
    static Condition A = lock.newCondition();
    static  Condition B = lock.newCondition();
    static  Condition C = lock.newCondition();

    public static void main(String[] args) throws InterruptedException
    {
        new Thread(()->{

            try
            {
                lock.lock();
                while (true)
                {
                    System.out.print("a");
                    B.signalAll();
                    A.await();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally
            {
                lock.unlock();
            }
        }).start();
        Thread.sleep(1);
        new Thread(()->{
            try
            {
                lock.lock();
                while (true)
                {
                    System.out.print("b");
                    C.signalAll();
                    B.await();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally
            {
                lock.unlock();
            }
        }).start();
        Thread.sleep(1);
        new Thread(()->{
            try
            {
                lock.lock();
                while (true)
                {
                    System.out.print("c");
                    A.signalAll();
                    C.await();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally
            {
                lock.unlock();
            }
        }).start();
    }
}
