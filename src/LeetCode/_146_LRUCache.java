package LeetCode;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:05 2020-05-25
 */

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @ClassName: _146_LRUCache
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 16:05 
 * @Version" 1.0
 */
public class _146_LRUCache
{
    private int cap ;
    private Map<Integer , Integer> map = new LinkedHashMap<>();//保持插入顺序


    public _146_LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if(map.keySet().contains(key))
        {
            int value = map.get(key);
            //每次查询了之后，都把这个key放在末尾就行了
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key,value);
            return value;
        }
        return -1;

    }

    public void put(int key, int value) {
        if(map.keySet().contains(key))
        {
            map.remove(key);
        }
        else if(map.size() == cap)
        {
            Iterator<Entry<Integer,Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key,value);
    }
    public static void main(String[] args)
    {

    }
}
