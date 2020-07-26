package 设计模式;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 23:03 2020-07-18
 */

/**
 *
 * @ClassName: 生产者消费者模式
 * @Description TODO
 * @Author:
 * @Date: 2020-07-18 23:03 
 * @Version" 1.0
 */

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个生产者 + 三个消费者
 * @author book
 *
 */

public class 生产者消费者问题
{
    static Lock lock = new ReentrantLock();
    static boolean flags = true;
    static volatile ArrayList<String> list = new ArrayList<String>(); //存放数据的缓存队列
    // 只读对象可以不需要volatile修饰
    static int num = 5; /* 仓库容量为3 */
    static Condition 生产者等待队列 = lock.newCondition();
    static Condition 消费者等待队列 = lock.newCondition();
    public static void main(
            String[] args)
            throws InterruptedException
    {
        Runnable 生产者任务 = () ->
        {
            try
            {
                lock.lock();
                while (true)
                {
                    if (list.size() != num) /* 仓库没满 */
                    {
                        System.out.println(
                                Thread.currentThread()
                                        .getName()
                                        + "：生产了一个货物！"
                        );
                        list.add("货物");
                        /* 一个生产者只生成一个就行 */
                        生产者等待队列.signalAll(); /* 叫别的兄弟来干 */
                        生产者等待队列.await();
                    }else /* 仓库满了 */
                    {
                        消费者等待队列.signalAll();/* 唤醒全部消费者 */
                        生产者等待队列.await();/* 仓库满了，生产者休息 */
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
            }
        };
        Runnable 消费者任务 = () ->
        {
            try
            {
                lock.lock();
                while (true)
                {
                    if (list.size()!=0)/* 仓库有货 */
                    {
                        System.out.println(
                                Thread.currentThread()
                                        .getName()
                                        + "：消费了一个货物！"
                        );
                        list.remove(0);
                        /*
                         * 一个人只拿一个
                         */
                        消费者等待队列.signalAll();/* 叫别的兄弟来消费 */
                        消费者等待队列.await();
                    }else /* 仓库没货 */
                    {
                        生产者等待队列.signalAll();
                        消费者等待队列.await();
                    }


                }
            } catch (Exception e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
            }
        };
        Thread A = new Thread(生产者任务, "生产者A");
        Thread B = new Thread(消费者任务, "消费者B");
        Thread A1 = new Thread(生产者任务, "生产者A1");
        Thread A2 = new Thread(生产者任务, "生产者A2");
        Thread B1 = new Thread(消费者任务, "消费者B1");
        Thread B2 = new Thread(消费者任务, "消费者B2");
        A.start();
        Thread.sleep(1);
        A1.start();
        Thread.sleep(1);
        A2.start();
        Thread.sleep(1);
        B.start();
        Thread.sleep(1);
        B1.start();
        Thread.sleep(1);
        B2.start();
    }

}




