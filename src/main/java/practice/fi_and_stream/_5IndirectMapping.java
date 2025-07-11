package practice.fi_and_stream;

import java.util.Objects;
import java.util.stream.Stream;

public class _5IndirectMapping {

    public Stream<String> getStringStream(Stream<Prop> propStream) {

        return propStream.map(prop -> {
            String str = "";
            if (Objects.nonNull(prop.id())) {
                str += prop.id() + " ";
            }
            if (Objects.nonNull(prop.name())) {
                str += prop.name() + " ";
            }
            str += prop.value();
            return str;
        });
    }
}
