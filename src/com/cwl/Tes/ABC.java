package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 23:33 2020-07-18
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @ClassName: ABD
 * @Description TODO
 * @Author:
 * @Date: 2020-07-18 23:33 
 * @Version" 1.0
 */
public class ABC
{
   static Lock lock = new ReentrantLock();
    static Condition c1 = lock.newCondition();
    static Condition c2 = lock.newCondition();
    static Condition c3 = lock.newCondition();
    static int count = 1;
    public static void main(String[] args) throws InterruptedException
    {
        Runnable r1 = () ->
        {
            try
            {
                lock.lock();
                while (true)
                {
                    if(count == 101)
                    {
                        /* 如果缺少唤醒，那么最后结束的时候线程无法正常退出 */
                        c1.signalAll();
                        c2.signalAll();
                        c3.signalAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+" : "+count++);
                    c2.signalAll();
                    c1.await();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally
            {
                lock.unlock();
            }

        }   ;
        Runnable r2 = () ->
        {
            try
            {
                lock.lock();
                while (true)
                {
                    if(count == 101)
                    {
                        /* 如果缺少唤醒，那么最后结束的时候线程无法正常退出 */
                        c1.signalAll();
                        c2.signalAll();
                        c3.signalAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+" : "+count++);
                    c3.signalAll();
                    c2.await();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally
            {
                lock.unlock();
            }

        }   ;
        Runnable r3 = () ->
        {
            try
            {
                lock.lock();
                while (true)
                {
                    if(count == 101)
                    {
                        /* 如果缺少唤醒，那么最后结束的时候线程无法正常退出 */
                        c1.signalAll();
                        c2.signalAll();
                        c3.signalAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+" : "+count++);
                    c1.signalAll();
                    c3.await();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally
            {
                lock.unlock();
            }

        }   ;

        Thread t1 = new Thread(r1,"线程1");
        Thread t2 = new Thread(r2,"线程2");
        Thread t3 = new Thread(r3,"线程3");
        t1.start();
        Thread.sleep(1); // 一定要抛出异常
        t2.start();
        Thread.sleep(1);
        t3.start();
        Thread.sleep(1);

        /* 如果没有break后面的唤醒语句，你最后会发现退出的时候还有两个线程，就是说只有线程2退出了。 */

    }
}
