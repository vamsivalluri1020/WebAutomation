package JavaExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {

        List<Integer> x= Arrays.asList(2,3,5,3,3,2,1);
        List<Integer> y=x.stream().map(a->(int)Math.pow(a,a)).collect(Collectors.toList());
        System.out.println(y);
    }
}
