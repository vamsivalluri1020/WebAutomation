package JavaExamples;


public class NumberPattern {
        public void DisplayNumber1()
        {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
                System.out.println(); //goto new Line
            }
        }
    public void DisplayNumber2()
    {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(); //goto new Line
        }
    }
        public static void main(String[] args) {
            NumberPattern n=new NumberPattern();
            n.DisplayNumber2();
            n.DisplayNumber1();
    }
}
