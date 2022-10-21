package JavaExamples.lamdaExpresions;

import java.util.ArrayList;

public class foreachloop {
    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach((n)->{System.out.println(n);});
    }
}
