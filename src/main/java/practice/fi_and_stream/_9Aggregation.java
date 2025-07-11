package practice.fi_and_stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class _9Aggregation {

    public String getNameWithHighestValue(Stream<Prop> propStream) {
//        return propStream.max(Comparator.comparingInt(Prop::value)).get().name();
        return propStream.sorted(Comparator.comparingInt(Prop::value).reversed()).findFirst().get().name();
    }
}
