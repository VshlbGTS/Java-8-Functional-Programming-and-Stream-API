package practice.fi_and_stream;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Stream Generation: ");
//        1. Stream Generation
        new _1StreamGeneration().generate(5).forEach(System.out::println);

        System.out.println("_2Flattening: ");
//        2. _2Flattening
        new _2Flattening().toIds(List.of(new _1StreamGeneration().generate(5).toList(),
                new _1StreamGeneration().generate(5).toList())).forEach(System.out::println);

        System.out.println("_3Counts: ");
//        3. _3Counts
        System.out.println(new _3Counts().evenFinder(Stream.of(1, 2, 3, 4, 5, 6, 7, 8,
                9)));

        System.out.println("Shortening Operations: ");
//        4. Shortening Operations - TODO
        new _4ShorteningOperations().findFirstWord(Stream.of('H', 'i', ' ', 'T',
                'e', 's', 't')).forEach(System.out::println);

        System.out.println("Indirect Mapping: ");
//        5 - Indirect Mapping
        new _5IndirectMapping().getStringStream(new _1StreamGeneration().generate(5)).forEach(System.out::println);

        System.out.println("_6Sorting: ");
//        6 - _6Sorting
        new _6Sorting().sort(new _1StreamGeneration().generateProps()).forEach(System.out::println);

        System.out.println("Filter by Property");
//        7 - Filter by Property
        new _7FilterByProperty().filterByProp(new _1StreamGeneration().generatePropsWithNullNames()).forEach(System.out::println);

        System.out.println("Stateful filter: ");
//        8 - Stateful filter
        new _8StatefulFilter().filterDuplicates(new _1StreamGeneration().generatePropsWithDuplicateIds()).forEach(System.out::println);

        System.out.println("_9Aggregation:");
//        9 - _9Aggregation
        System.out.println(new _9Aggregation().getNameWithHighestValue(new _1StreamGeneration().generateProps()));

        System.out.println("Combining Collectors:");
//        10 - Combining Collectors
        new _10CombiningCollectors().propsWithRepeatedNames(new _1StreamGeneration().generatePropsWithDuplicateNames()).forEach(System.out::println);

        System.out.println("Stateful Collectors:");
//        11 - Stateful Collectors
        new _11StatefulCollectors().getNamesAndSum(new _1StreamGeneration().generateProps()).forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("Collector Chaining:");
//        12 - Collector Chaining
        new _12CollectorChaining().sumOfOddAndEven(Stream.of(1, 2, 3, 4, 5, 6,
                7, 8, 9, 10)).forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("Custom _9Aggregation:");
//        13 - Custom _9Aggregation
        new _13CustomAggregation().getNamesWithMinMaxValues(new _1StreamGeneration().generateProps()).forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("");
    }
}
