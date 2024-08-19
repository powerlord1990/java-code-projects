package javacode.projects.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatorMap {

    public Map<Object, Integer> getDuplicatedMap(List<Object> objects){
        Map<Object, Integer> frequencyMap = new HashMap<>();

        for (Object number : objects) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        return frequencyMap;
    }
}
