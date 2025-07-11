package practice.fi_and_stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _12CollectorChaining {
    public Map<String, Integer> sumOfOddAndEven(Stream<Integer> integerStream) {
        return integerStream.collect(Collectors.groupingBy(num -> num%2!=0 ?
                "Odd" : "Even", Collectors.summingInt(num-> num)));
    }

    /*public static Map<String, Integer> calculateSums(Stream<Integer> numbersStream) {
        return numbersStream
                .filter(Objects::nonNull) // Ensure the stream doesn't contain nulls
                .collect(Collectors.partitioningBy(
                        num -> num % 2 == 0, // Partition based on whether the number is even
                        Collectors.summingInt(Integer::intValue) // Sum the numbers in each group
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey() ? "Even" : "Odd", // Convert true/false keys to "Even" and "Odd"
                        Map.Entry::getValue
                ));
    }*/
}
