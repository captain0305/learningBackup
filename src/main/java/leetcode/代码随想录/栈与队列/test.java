package leetcode.代码随想录.栈与队列;

import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public void test(){
        String s="abbaca";
        Stack<Character> stack=new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                System.out.println(stack);
                continue;
            }
            if(stack.peek().equals(s.charAt(i))){
                stack.pop();
            } else if (!stack.peek().equals(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            System.out.println(stack);
        }
        System.out.println(stack);
        StringBuffer buffer=new StringBuffer();
        while (!stack.isEmpty()){
            buffer.append(stack.pop());
        }


        System.out.println(buffer.reverse().toString());
    }


    public class keyvalue{
        public int key;
        public int value;
        public keyvalue(){}

        public keyvalue(int key, int value) {
            this.key = key;
            this.value = value;
        }

        /**
         * 获取
         * @return key
         */
        public int getKey() {
            return key;
        }

        /**
         * 设置
         * @param key
         */
        public void setKey(int key) {
            this.key = key;
        }

        /**
         * 获取
         * @return value
         */
        public int getValue() {
            return value;
        }

        /**
         * 设置
         * @param value
         */
        public void setValue(int value) {
            this.value = value;
        }

        public String toString() {
            return "keyvalue{key = " + key + ", value = " + value + "}";
        }
    }
    @Test
    public void topKFrequent() {
        int k=2;
        int[] nums={1,1,1,2,2,3};
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1 );
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        keyvalue[] a=new keyvalue[map.size()];
        for (int i = 0; i < map.size(); i++) {
            a[i]=new keyvalue();
        }
        int i=0;



        for (Map.Entry<Integer, Integer> entry : entries) {
            a[i].key=entry.getKey();
            System.out.println(a[i].key);
            a[i].value=entry.getValue();
            i++;
        }
        Arrays.sort(a, new Comparator<keyvalue>() {
            @Override
            public int compare(keyvalue o1, keyvalue o2) {
                return o2.value-o1.value;
            }
        });
        int[] res=new int[k];
        for (int j = 0; j < k; j++) {
            res[j]=a[j].key;
        }
    }

    @Test
    public void testEquals(){
        char[] a={'a','c','b'};
        char[] b={'c','b','a'};
        char[] c=Arrays.copyOf(b,3);
        System.out.println(b);
        System.out.println(c);
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        Arrays.sort(a);
        Arrays.sort(b);



    }
}
