package JavaExamples;


public class DisplayPatternA {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("Vamsi ");
            }
            System.out.println(); //goto new Line
        }
    }
}
