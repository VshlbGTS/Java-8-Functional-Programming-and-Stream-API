package practice.fi_and_stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Sorting {

    public List<Prop> sort(Stream<Prop> propStream) {
        return propStream.sorted(Comparator.comparingInt(Prop::value)
                .thenComparing(Prop::name)).toList();
    }
}
