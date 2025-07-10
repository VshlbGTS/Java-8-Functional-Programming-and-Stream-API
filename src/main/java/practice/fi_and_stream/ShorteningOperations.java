package practice.fi_and_stream;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ShorteningOperations {

    public Stream<Character> findFirstWord(Stream<Character> charStream) {
        AtomicInteger i = new AtomicInteger(-1);
        AtomicInteger counter = new AtomicInteger(-1);
        Stream<Character> characterStream = charStream.filter(character -> {
            System.out.println("??????????????????");
            boolean res = true;
            counter.getAndIncrement();
            if (Character.isWhitespace(character)) {
                res = false;
            }
            if (!res && i.get() == -1) {
                i.set(counter.get());
            }
            System.out.println("Counter:" + counter.get());
            System.out.println(i.get());
            return res;
        });


        return characterStream.limit(i.get());


//        return charStream.filter(ch -> !Character.isWhitespace(ch));
    }


    public Stream<Character> findFirstWordAI(Stream<Character> charStream) {
        AtomicInteger counter = new AtomicInteger(-1);

        // First pass: Find the index of the first whitespace
        int splitIndex = charStream
                .peek(character -> counter.incrementAndGet()) // Track index using counter
                .filter(Character::isWhitespace)
                .map(c -> counter.get()) // Extract index when whitespace is found
                .findFirst()
                .orElse(counter.get() + 1); // No whitespace? Limit to the end of stream

        // Second pass: Apply the limit to get the first word
        return charStream
                .limit(splitIndex)
                .filter(c -> !Character.isWhitespace(c));
    }
}
