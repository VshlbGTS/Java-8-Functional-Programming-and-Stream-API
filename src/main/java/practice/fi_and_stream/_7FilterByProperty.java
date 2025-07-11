package practice.fi_and_stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class _7FilterByProperty {

    public List<Prop> filterByProp(Stream<Prop> propStream) {
        return propStream.filter(prop -> Objects.nonNull(prop.name())).toList();
    }
}
