package javacode.projects.collections.task1;

import java.lang.reflect.Array;

public class ArrayFilter {

    public static <T> T[] filter(T[] inputArray, Filter filter) {
        Class<?> arrayType = inputArray.getClass().getComponentType();

        T[] filteredArray = (T[]) Array.newInstance(arrayType, inputArray.length);

        for (int i = 0; i < inputArray.length; i++) {
            filteredArray[i] = (T) filter.apply(inputArray[i]);
        }

        return filteredArray;
    }
}
