package practice.fi_and_stream;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

public class _8StatefulFilter {
    public Stream<Prop> filterDuplicates(Stream<Prop> propStream) {
        Set<UUID> uuidSet = new HashSet<>();
        return propStream.filter(prop -> uuidSet.add(prop.id()));
    }
}
