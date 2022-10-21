package JavaExamples.StringExamples;

public class StringReverseWord {

    public static void main(String[] args) {

        String x="Krishna";
        String output="";

        for(int i=x.length()-1;i>=0;i--)
        {
            char c=x.charAt(i);
            output=output+c;
        }
        System.out.println(output);
    }
}
