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

    public Stream<Character> findFirstWordNonEmptyWhitespace(Stream<Character> charStream) {
        AtomicBoolean wordFound = new AtomicBoolean(false);
        return charStream.dropWhile(Character::isWhitespace)
                .takeWhile(character -> {
                    if (Character.isWhitespace(character)){
                        wordFound.set(true);
                    }
                    return !wordFound.get();
                });
    }

    public Stream<Character> findFirstWordInefficient1(Stream<Character> charStream) {
        AtomicInteger i = new AtomicInteger(-1);
        AtomicInteger counter = new AtomicInteger(-1);
        return charStream.filter(character -> {
            boolean res = true;
            counter.getAndIncrement();
            if (Character.isWhitespace(character)) {
                res = false;
            }
            if (!res && i.get() == -1) {
                i.set(counter.get());
            }
            return res;
        }).toList().stream().limit(i.get());
    }

    public Stream<Character> findFirstWordAIEmptyForLeadingWhitepsace(Stream<Character> charStream) {
        AtomicBoolean wordEnded = new AtomicBoolean(false);

        return charStream.takeWhile(c -> {
            if (Character.isWhitespace(c)) {
                wordEnded.set(true);
                return false;
            }
            return !wordEnded.get();
        });
    }

    public Stream<Character> findFirstWordWithFilterAI(Stream<Character> charStream) {
        AtomicBoolean leadingWhitespace = new AtomicBoolean(true); // Track leading whitespace
        AtomicBoolean wordEndDetected = new AtomicBoolean(false); // Once the word ends, stop processing

        return charStream
                .filter(c -> {
                    if (wordEndDetected.get()) {
                        return false; // Skip remaining elements after the first word
                    }

                    if (Character.isWhitespace(c)) {
                        if (leadingWhitespace.get()) {
                            // Skip leading whitespace
                            return false;
                        } else {
                            // Whitespace after a word ends the word
                            wordEndDetected.set(true);
                            return false;
                        }
                    }

                    // First non-whitespace means leading whitespace is over
                    leadingWhitespace.set(false);
                    return true; // Part of the first word
                });
    }
}
