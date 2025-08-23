package theme5_java_functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _04_Stream {
    public static void main(String[] args) {
        // Arrays.stream()
        int[]  scores= {100,95,90,85,80};
        IntStream scoreStream = Arrays.stream(scores);
        String[] langs = {"python","java","javascript","c","c#"};
        Stream<String> langStream = Arrays.stream(langs);
        // Collection.Stream()
        List<String> langList = new ArrayList<>();
        langList = Arrays.asList("python","java","javascript","c","c#");
        Stream<String> langListStream = langList.stream();
        // Stream.of()
        Stream<String> langListOfStream = Stream.of("python", "java", "javascript", "c", "c#");

        // Stream 사용
        // 중간 연산(Intermediate Operation) : filter , map , sorted , distinct , skip ...
        // 최종 연산(Terminal Operation) : count, min, max, forEach,  anyMatch, allMatch...

        Arrays.stream(scores).filter(x -> x >= 90).forEach(x -> System.out.println(x));
//        Arrays.stream(scores).filter(x -> x >= 90).forEach(System.out::println);
        System.out.println("========================================================");
        int count = (int) Arrays.stream(scores).filter(x -> x >= 90).count();
        System.out.println(count);
        System.out.println("========================================================");
        int sum = Arrays.stream(scores).filter(x->x >=90).sum();
        System.out.println(sum);
        System.out.println("========================================================");
        Arrays.stream(scores).filter(x -> x >= 90).sorted().forEach(System.out::println);
        System.out.println("========================================================");
        Arrays.stream(langs).filter(x -> x.startsWith("c")).forEach(System.out::println);
        System.out.println("========================================================");
        Arrays.stream(langs).filter(x -> x.contains("java")).forEach(System.out::println);
        System.out.println("========================================================");
        langList.stream().filter(x -> x.length() <= 4).sorted().forEach(System.out::println);
        System.out.println("========================================================");
        langList.stream()
                .filter(x -> x.length() <= 4)
                .filter(x -> x.contains("c"))
                .sorted()
                .forEach(System.out::println);
        System.out.println("========================================================");
        boolean anyMatch = langList.stream()
                .filter(x -> x.length() <= 4)
                .anyMatch(x -> x.contains("c"));
        System.out.println(anyMatch);
        System.out.println("========================================================");
        langList.stream()
                .filter(x -> x.length() <= 4)
                .filter(x -> x.contains("c"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("========================================================");
        List<String> langListStartsWithC = langList.stream()
                .filter(x -> x.length() <= 4)
                .filter(x -> x.contains("c"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(langListStartsWithC);
        System.out.println("========================================================");
    }
}
