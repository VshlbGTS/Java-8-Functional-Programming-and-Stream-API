package practice.fi_and_stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _11StatefulCollectors {

    public Map<String, Integer> getNamesAndSum(Stream<Prop> propStream) {
        return propStream.collect(Collectors.groupingBy(Prop::name, Collectors.summingInt(Prop::value)));
    }
}
