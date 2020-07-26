package com.cwl.Test;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 03:36 2020-05-15
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @ClassName: 输出文档
 * @Description TODO
 * @Author:
 * @Date: 2020-05-15 03:36 
 * @Version" 1.0
 */
public class 输出文档
{

    public static void main(String[] args) throws IOException
    {

        int id = 0;
        String name= "样本";
        int num = 0;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/book/Downloads/文件.txt"));)
        {
            for (int i = 0; i < 100000000; i++)
            {

                bw.write(i+"");
                bw.write(" ");
                bw.write(name+i);
                bw.write(" ");
                bw.write(i+"");
                bw.newLine();
            }
        }

    }
}
