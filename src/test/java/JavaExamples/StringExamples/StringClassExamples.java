package JavaExamples.StringExamples;

import java.util.Scanner;

public class StringClassExamples {
    public static void main(String[] args) {

        String s1=new String("vamsi");
        String s2=new String("vamsi");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        /*
        * String is an immutable class because if value are same it will store in same memory
        * */

        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        System.out.println(sc.hashCode());
        System.out.println(sc1.hashCode());

        StringBuffer sb1=new StringBuffer("vamsi");
        StringBuffer sb2=new StringBuffer("vamsi");
        System.out.println(sb1.hashCode());
        System.out.println(sb2.hashCode());

    }
}
