package leetcode.代码随想录.回溯算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test {
    @Test
    public void testCollections(){
        List<List<String>> tickets = new ArrayList<>();
        ArrayList<String> a=new ArrayList<>();
        ArrayList<String> b=new ArrayList<>();
        a.add("JFK");
        a.add("LGB");
        b.add("JFK");
        b.add("LGA");
        tickets.add(a);
        tickets.add(b);
        System.out.println(tickets);
        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1));//
            }
        });

        Collections.sort(tickets, (m, n) -> m.get(1).compareTo(n.get(1)));
        System.out.println(tickets);
    }
}
