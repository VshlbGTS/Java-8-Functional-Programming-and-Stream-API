package practice.fi_and_stream;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Flattening {
    public Stream<UUID> toIds(List<List<Prop>> nestedProps) {
        return nestedProps.stream()
                .flatMap(List::stream)
                .map(Prop::id);
    }
}
