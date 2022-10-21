package JavaExamples.StringExamples;

import java.util.HashMap;

public class charsinsentence {
    public static void main(String[] args) {
        String x="vamsi vamsi krishna krishna vamsi vamsi valluri v";
        x=x.trim();
        x=x.toLowerCase();
        String [] words=x.split(" ");
        System.out.println("Length of words is "+words.length);
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        //for(int i=0;i< words.length;i++)
        for(String i:words)
        {
            if(hm.containsKey(i))
            {
                hm.put(i,hm.get(i)+1);
            }
            else
            {
                hm.put(i,1);
            }
        }
        System.out.println(hm);
    }
}
