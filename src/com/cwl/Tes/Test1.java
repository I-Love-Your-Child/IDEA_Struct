package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 18:14 2020-05-21
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @ClassName: Test1
 * @Description TODO
 * @Author:
 * @Date: 2020-05-21 18:14 
 * @Version" 1.0
 */
public class Test1
{
    public static Lock lock  = new ReentrantLock();
    public static Condition a =  lock.newCondition();
    public static Condition b =  lock.newCondition();
    public static void main(String[] args) throws Exception
    {
        Runnable a_lam = () ->
        {
            while(true)
            {
                System.out.println("a");
                try
                {
                    a.await();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                } finally
                {
                    b.signalAll();
                }
            }
        };
        Runnable b_lam = () ->
        {
            while(true)
            {
                System.out.println("b");
                try
                {
                    b.await();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }finally
                {
                    a.signalAll();
                }
            }

        };
        Thread A = new Thread(a_lam);
        Thread B = new Thread(b_lam);
        A.start();
        Thread.sleep(1);
        B.start();
//        A.join();
//        B.join();

    }
}
