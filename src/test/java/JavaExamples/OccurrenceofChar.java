package JavaExamples;

public class OccurrenceofChar {

    public static void main(String[] args) {
        String x="Vamsi Krishna Valluri";
        //int index=x.indexOf('V');
        //System.out.println(index);
       // int index2=x.indexOf('V',10);
       // System.out.println(index2);
        int temp=0;
        for(int i=0;i<x.length();i++)
        {
            if(x.charAt(i)=='a')
            {
                //System.out.print(i+" ");
                temp++;
            }
        }
        System.out.println(temp);
    }
}
