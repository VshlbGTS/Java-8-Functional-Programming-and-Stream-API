package practice.fi_and_stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Stream Generation: ");
//        1. Stream Generation
        new StreamGeneration().generate(5).forEach(System.out::println);

        System.out.println("Flattening: ");
//        2. Flattening
        new Flattening().toIds(List.of(new StreamGeneration().generate(5).toList(),
                new StreamGeneration().generate(5).toList())).forEach(System.out::println);

        System.out.println("Counts: ");
//        3. Counts
        System.out.println(new Counts().evenFinder(Stream.of(1, 2, 3, 4, 5, 6, 7, 8,
                9)));

        System.out.println("Shortening Operations: ");
//        4. Shortening Operations - TODO
        new ShorteningOperations().findFirstWordAI(Stream.of('H', 'i', ' ', 'T',
                'e', 's', 't')).forEach(System.out::println);

        System.out.println("Indirect Mapping: ");
//        5 - Indirect Mapping
        new IndirectMapping().getStringStream(new StreamGeneration().generate(5)).forEach(System.out::println);

        System.out.println("Sorting: ");
//        6 - Sorting
        new Sorting().sort(new StreamGeneration().generateProps()).forEach(System.out::println);

        System.out.println("Filter by Property");
//        7 - Filter by Property
        new FilterByProperty().filterByProp(new StreamGeneration().generatePropsWithNullNames()).forEach(System.out::println);

        System.out.println("Stateful filter: ");
//        8 - Stateful filter
        new StatefulFilter().filterDuplicates(new StreamGeneration().generatePropsWithDuplicateIds()).forEach(System.out::println);

        System.out.println("Aggregation");
//        9 - Aggregation
        System.out.println(new Aggregation().getNameWithHighestValue(new StreamGeneration().generateProps()));

        System.out.println("Combining Collectors");
//        10 - Combining Collectors
        new CombiningCollectors().propsWithRepeatedNames(new StreamGeneration().generatePropsWithDuplicateNames()).forEach(System.out::println);

        System.out.println("Stateful Collectors");
//        11 - Stateful Collectors
        new StatefulCollectors().getNamesAndSum(new StreamGeneration().generateProps()).forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("");
//        12 - Collector Chaining
        new CollectorChaining().sumOfOddAndEven(Stream.of(1, 2, 3, 4, 5, 6,
                7, 8, 9, 10)).forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("");
//        13 - Custom Aggregation
        new CustomAggregation().getNamesWithMinMaxValues(new StreamGeneration().generateProps()).forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("");
    }
}
