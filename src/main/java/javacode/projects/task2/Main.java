package javacode.projects.task2;


public class Main {
    public static void main(String[] args) {
        String[] strings = {"c++", "java", "python", "ruby", "scala"};

        // Фильтр, который приводит строку к заглавным буквам
        Filter toUpperCaseFilter = o -> ((String) o).toUpperCase();

        String[] result = ArrayFilter.filter(strings, toUpperCaseFilter);
        for (String s : result) {
            System.out.println(s);
        }

        Integer[] numbers = {1, 3, 7, 35, 12};

        // Фильтр, который приводит строку к заглавным буквам
        Filter addOne = o -> {
            int i = (Integer) o;
            return ++i;
        };
        Integer[] numbersPlusOne = ArrayFilter.filter(numbers, addOne);
        for (Integer i : numbersPlusOne) {
            System.out.println(i);
        }
    }
}
