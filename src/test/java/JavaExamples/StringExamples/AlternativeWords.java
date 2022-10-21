package JavaExamples.StringExamples;

public class AlternativeWords {

    public AlternativeWords(){
    }

    public static void main(String[] args) {
        String x = "veeruNaidu";
        int v =x.length();

        System.out.println(v);
        for (int i=0;i<v;i+=3){

            System.out.println(x.charAt(i));
        }

    }
}
