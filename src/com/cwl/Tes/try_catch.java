package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 17:25 2020-05-24
 */

/**
 *
 * @ClassName: try_catch
 * @Description TODO
 * @Author:
 * @Date: 2020-05-24 17:25 
 * @Version" 1.0
 */
public class try_catch
{
     static class A
    {
        int value;

        public A(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }
    }
    public static A getA()
    {
        A a = new A(100);

        try
        {
            return a;
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally
        {
            
            a.setValue(-100);
            
        }
        return  a;
    }

    public static void main(String[] args)
    {
        System.out.println(getA().getValue());
    }
}
