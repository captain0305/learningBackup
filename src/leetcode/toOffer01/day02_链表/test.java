package leetcode.toOffer01.day02_链表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class test {
    @Test
    public void linked_list(){
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(2);
        System.out.println(a);
        System.out.println(a.get(2));
    }

    @Test
    public void hashmap(){
        HashMap<Integer,Double> a=new HashMap<>();
        a.put(1,2.0);
        a.put(1,2.0);
        a.put(3,6.1);
        System.out.println(a);

    }
}
