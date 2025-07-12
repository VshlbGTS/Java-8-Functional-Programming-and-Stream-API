package practice.fi_and_stream;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class _4ShorteningOperations {

    public Stream<Character> findFirstWord(Stream<Character> charStream) {
        AtomicInteger i = new AtomicInteger(-1);
        AtomicInteger counter = new AtomicInteger(-1);

        return charStream.takeWhile(character -> {
            boolean res = true;
            counter.getAndIncrement();
            if (Character.isWhitespace(character)) {
                res = false;
            }
            if (!res && i.get() == -1) {
                i.set(counter.get());
            }
            return i.get() == -1;
        }).toList().stream().limit(i.get());
    }
}
