package practice.fi_and_stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class _13CustomAggregation {
    public Map<String, String> getNamesWithMinMaxValues(Stream<Prop> propStream) {
        Map<String, String> nameMap = new HashMap<>();
        List<Prop> propList = propStream.toList();

        nameMap.put("Min", propList.stream().min(Comparator.comparingInt(Prop::value)).get().name());

        nameMap.put("Max", propList.stream().max(Comparator.comparingInt(Prop::value)).get().name());

//        nameMap.put("Min",
//                propList.stream().min(Comparator.comparingInt(Prop::value)).map(Prop::name).orElse(null));

//        nameMap.put("Max",
//                propList.stream().max(Comparator.comparingInt(Prop::value)).map(Prop::name).orElse(null));

        return nameMap;
    }
}
