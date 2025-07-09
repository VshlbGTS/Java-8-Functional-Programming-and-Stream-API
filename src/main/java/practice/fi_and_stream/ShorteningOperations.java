package practice.fi_and_stream;

import java.util.stream.Stream;

public class ShorteningOperations {

    public Stream<Character> findFirstWord(Stream<Character> charStream) {
//        return charStream.findFirst().
        return charStream.filter(ch -> !Character.isWhitespace(ch));
    }
}
