package JavaExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {

        List<String> names= Arrays.asList("Vamsi","krishna","valluri","Vamsi");
        List<String> result=names.stream().filter((x->x.toLowerCase().contains("vam"))).collect(Collectors.toList());
        System.out.println(result);
    }
}

