package JavaExamples.StringExamples;

import java.util.HashMap;
import java.util.Locale;

public class  OccurrencesWordString {
    public static void main(String[] args) {
        String x="vamsi vamsi krishna krishna vamsi vamsi valluri v";
        x=x.trim();
        x=x.toLowerCase();
        String [] words=x.split(" ");
        System.out.println("Length of words is "+words.length);
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        for(int i=0;i< words.length;i++) {

            for (String j : words) {
                if (hm.containsKey(j)) {
                    hm.put(j, hm.get(j) + 1);
                } else {
                    hm.put(j, 1);
                }
            }
        }







        System.out.println(hm);
//        System.out.println("Count of distinct words is "+hm.keySet().size());
//        //Display duplicated words with count of occurrences
//        int count=0;
//        for(String Word:hm.keySet())
//        {
//            System.out.println(Word+" occured"+hm.get(Word));
//            count++;
//        }
//        System.out.println("count of duplicated words is "+count);

    }
}

