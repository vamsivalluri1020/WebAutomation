package JavaExamples.StringExamples;

public class StringReverse {
    public static void main(String[] args) {
        //String Reverse logic
        String x="vamsi";
        String y="";
        for(int i=x.length()-1;i>=0;i--)
        {
            char c=x.charAt(i);
            y=y+c;
        }
        System.out.println("wordReverse Output is "+y);

        //String Reverse using String Buffer class
        StringBuffer sb=new StringBuffer(x);
        StringBuffer s=sb.reverse();
        System.out.println("String Buffer Output is "+s);

        //Reverse each word in given sentence


        String sentence="my name is vamsi krishna valluri";
        String [] words=sentence.split(" ");
        //Reverse each word in given sentence
        String fi="";
        for(String word:words)
        {
            String reversedword="";
            for(int i=word.length()-1;i>=0;i--)
            {
                reversedword=reversedword+word.charAt(i);
            }
            fi=fi+reversedword+" ";
        }
        //Display out put
        System.out.println("Full reverse word by word "+fi.trim());


        String s1="my name is vamsi krishna valluri";
        String [] ws=sentence.split(" ");
        String x1="";
        for(int i=ws.length-1;i>=0;i--)
        {
            x1=x1+ws[i]+" ";
        }
        System.out.println("sentence in reverse order "+x1.trim());
    }





}
