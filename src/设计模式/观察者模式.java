package 设计模式;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 22:34 2020-07-18
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: 观察者模式
 * @Description TODO
 * @Author:
 * @Date: 2020-07-18 22:34 
 * @Version" 1.0
 */
interface 借款方接口
{
    void 借钱(贷款方接口 credit);
    void 通知贷款方还钱();
}

class ZhanSan implements 借款方接口
{
    private List<贷款方接口> 所有贷款方  = new ArrayList<>();


    @Override
    public void 借钱(贷款方接口 credit)
    {
        所有贷款方.add(credit);
    }

    @Override
    public void 通知贷款方还钱()
    {
        所有贷款方.forEach((a1) ->  {  a1.要钱();  } );

    }
}

class  WangWu implements 贷款方接口
{

    @Override
    public void 要钱()
    {
        System.out.println("王五催债");
    }
}

class ZhaoSi implements 贷款方接口
{

    @Override
    public void 要钱()
    {
        System.out.println("赵四催债");
    }
}

interface  贷款方接口
{
    void  要钱();
}


public class 观察者模式
{

    public static void main(String[] args)
    {
        借款方接口 zhanSan  = new ZhanSan();
        zhanSan.借钱(new WangWu());
        zhanSan.借钱(new ZhaoSi());
        //一旦状态改变，他去通知还钱
        zhanSan.通知贷款方还钱();

    }

}
