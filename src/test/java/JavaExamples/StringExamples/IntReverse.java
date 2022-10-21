package JavaExamples.StringExamples;

import java.util.Scanner;

public class IntReverse {
    public static void main(String[] args) {

        int x=4567;
        int y=0;
        int temp=x;
        while(temp!=0)
        {
            int r=temp%10;
            y=y*10+r;
            temp=temp/10;
        }
        System.out.println(y);
    }
}
