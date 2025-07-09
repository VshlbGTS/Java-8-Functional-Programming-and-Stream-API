package practice.fi_and_stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CombiningCollectors {
    public List<Prop> propsWithRepeatedNames(Stream<Prop> propStream) {
        Set<String> nameSet = new HashSet<>();
        Set<String> repeatedNames = new HashSet<>();
        return propStream.filter(prop -> {
            if (!nameSet.add(prop.name())) {
                return repeatedNames.add(prop.name());
            } else {
                return false;
            }
        }).toList();
    }
}
