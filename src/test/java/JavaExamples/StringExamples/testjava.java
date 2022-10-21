package JavaExamples.StringExamples;

public class testjava {
    public static void main(String[] args) {
        String s = "Vamsi Krishna Valluri";
        String x=s.replace(" ","");
        System.out.println(x);
        System.out.println("");
        for(int i=0;i<x.length();i+=2) {

            System.out.print(s.charAt(i));

        }
    }
}
