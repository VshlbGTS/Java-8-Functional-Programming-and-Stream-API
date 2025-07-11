package practice.fi_and_stream;

import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _1StreamGeneration {
    public Stream<Prop> generate(int n){
        return IntStream.range(0, n)
                .mapToObj(i -> new Prop(UUID.randomUUID(), "DefaultName", i));
    }

    public Stream<Prop> generateProps(){
        return Stream.of(
                new Prop(UUID.randomUUID(), "Asdf", 20),
                new Prop(UUID.randomUUID(), "Adfs", 20),
                new Prop(UUID.randomUUID(), "Asdf", 40),
                new Prop(UUID.randomUUID(), "Bsfds", 10),
                new Prop(UUID.randomUUID(), "posdjf", 30),
                new Prop(UUID.randomUUID(), "Tsdgf", 50),
                new Prop(UUID.randomUUID(), "Gsdf", 25)
        );
    }

    public Stream<Prop> generatePropsWithNullNames(){
        return Stream.of(
                new Prop(UUID.randomUUID(), "Asdf", 20),
                new Prop(UUID.randomUUID(), null, 20),
                new Prop(UUID.randomUUID(), null, 40),
                new Prop(UUID.randomUUID(), "Bsfds", 20),
                new Prop(UUID.randomUUID(), "posdjf", 30),
                new Prop(UUID.randomUUID(), "Tsdgf", 50),
                new Prop(UUID.randomUUID(), "Gsdf", 25)
        );
    }

    public Stream<Prop> generatePropsWithDuplicateIds(){
        UUID uuid = UUID.randomUUID();
        return Stream.of(
                new Prop(UUID.randomUUID(), "Asdf", 20),
                new Prop(uuid, "Bsfds", 20),
                new Prop(uuid, "Tsdgf", 50),
                new Prop(UUID.randomUUID(), "Gsdf", 25)
        );
    }

    public Stream<Prop> generatePropsWithDuplicateNames(){
        return Stream.of(
                new Prop(UUID.randomUUID(), "Asdf", 20),
                new Prop(UUID.randomUUID(), "Bsfds", 20),
                new Prop(UUID.randomUUID(), "Bsfds", 20),
                new Prop(UUID.randomUUID(), "Tsdgf", 50),
                new Prop(UUID.randomUUID(), "Gsdf", 25)
        );
    }
}
