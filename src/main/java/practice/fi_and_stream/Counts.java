package practice.fi_and_stream;

import java.util.stream.Stream;

public class Counts {

    public long evenFinder(Stream<Integer> intStream){
        return intStream.filter(num -> num%2==0).count();
    }
}
