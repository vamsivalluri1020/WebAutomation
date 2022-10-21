package JavaExamples.StringExamples;

public class StringReverseSentence {
    public static void main(String[] args) {
        String x="vamsi krishna valluri";
        String[] words=x.split(" ");
        String output="";
        for(String word:words)
        {
            for(int i=word.length()-1;i>=0;i--)
            {
                char c=word.charAt(i);
                output=output+c;
            }
            output=output+" ";
        }
        System.out.println(output);
    }
}
