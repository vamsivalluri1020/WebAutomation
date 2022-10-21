package JavaExamples.StringExamples;

import java.util.HashMap;

public class OccurrencesofEachcharinString {
    public static void main(String[] args) {
        String x="vamsiKrishna";
        char[] chars=x.toCharArray();
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        for(char c:chars)
        {
            if(hm.containsKey(c))
            {
                hm.put(c,hm.get(c)+1);
            }
            else
            {
                hm.put(c,1);
            }
        }
        System.out.println(hm);
    }
}
