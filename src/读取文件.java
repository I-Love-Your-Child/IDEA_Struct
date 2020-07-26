/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 7:09 下午 2020/7/25
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName: 读取文件
 * @Description TODO
 * @Author:
 * @Date: 2020/7/25 7:09 下午
 * @Version" 1.0
 */

class NNN
{
    String url;

    public NNN()
    {
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public NNN(String url, long sum, long count, long[] hourSum, long[] hourCount, String[] window)
    {
        this.url = url;
        Sum = sum;
        this.count = count;
        this.hourSum = hourSum;
        this.hourCount = hourCount;
        this.window = window;
    }

    public long Sum = 0;
    public long count = 0;
    public long[] hourSum = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public long[] hourCount = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public String[] window = {
            "0:00-1:00",
            "1:00-2:00",
            "2:00-3:00",
            "3:00-4:00",
            "4:00-5:00",
            "5:00-6:00",
            "6:00-7:00",
            "7:00-8:00",
            "8:00-9:00",
            "9:00-10:00",
            "10:00-11:00",
            "11:00-12:00",
            "12:00-13:00",
            "13:00-14:00",
            "14:00-15:00",
            "15:00-16:00",
            "16:00-17:00",
            "17:00-18:00",
            "18:00-19:00",
            "19:00-20:00",
            "20:00-21:00",
            "21:00-22:00",
            "22:00-23:00",
            "23:00-24:00",
    };


    public long getSum()
    {
        return Sum;
    }

    public void setSum(long sum)
    {
        Sum = sum;
    }

    public long getCount()
    {
        return count;
    }

    public void setCount(long count)
    {
        this.count = count;
    }

    public long[] getHourSum()
    {
        return hourSum;
    }

    public void setHourSum(long[] hourSum)
    {
        this.hourSum = hourSum;
    }

    public long[] getHourCount()
    {
        return hourCount;
    }

    public void setHourCount(long[] hourCount)
    {
        this.hourCount = hourCount;
    }

    public String[] getWindow()
    {
        return window;
    }

    public void setWindow(String[] window)
    {
        this.window = window;
    }
}

public class 读取文件
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new FileReader("文件/2015-09-08.log"));
        String tmp = "";
        int count = 0;
        ArrayList<NNN> list = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
         System.out.println("读取文件中...");
        while ((tmp = r.readLine()) != null)
        {
            count++;
            hashSet.add((tmp.split(" ")[4]));
        }
        hashSet.forEach((a)->System.out.println(a));
        for (String s : hashSet)
        {
            NNN nnn = new NNN();
            nnn.setUrl(s);
            list.add(nnn);
        }

        System.out.println("读取文件结束...");
        r.close();
        System.out.println("---------------- 我是分隔符 ----------------");

        try (BufferedReader bufferreader = new BufferedReader(new FileReader("文件/2015-09-08.log")))
        {
            String t = "";
            while ((t = bufferreader.readLine()) != null)
            {
                for (NNN nnn : list)
                {
                    if (t.split(" ")[4].equals(nnn.url))
                    {
                        nnn.count++;
                        nnn.Sum += Long.parseLong(t.split(" ")[t.split(" ").length - 1]);
                        int hourIndex = Integer.parseInt(t.split(" ")[1].split(":")[1]);
                        nnn.hourSum[hourIndex] += Long.parseLong(t.split(" ")[t.split(" ").length - 1]);
                        nnn.hourCount[hourIndex]++;
                        break;
                    }
                }

            }

        }

        for (NNN nnn : list)
        {
            String filename = nnn.url.replaceAll("/","-");
            FileWriter fileWriter = new FileWriter("/Users/book/Downloads/"+filename+".txt");
            fileWriter.write(nnn.url+" : " + nnn.Sum/(nnn.count*1.0));
            fileWriter.write("\n");
            System.out.println(nnn.url+" : " + nnn.Sum/(nnn.count*1.0));
            for (int i = 0; i < 24; i++)
            {
                if(nnn.hourSum[i]==0&&nnn.hourCount[i]==0)
                {
                    continue;
                }
                double result1 = nnn.hourSum[i] / (nnn.hourCount[i] * 1.0);
                fileWriter.write(nnn.window[i]+" : "+result1);
                fileWriter.write("\n");
                System.out.println(nnn.window[i]+" : "+result1);
            }
            fileWriter.close();
        }
    }
}
