package javacode.projects.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DuplicatorMap duplicatorMap = new DuplicatorMap();

        List objects = new ArrayList<>();
        objects.add(2);
        objects.add(2);
        objects.add("50");
        objects.add("50");
        objects.add(new Object());
        for (int i = 1; i <= 5; i++) {
            objects.add(i);
        }
        Map duplicatedMap = duplicatorMap.getDuplicatedMap(objects);
        System.out.println(duplicatedMap);
    }
}
