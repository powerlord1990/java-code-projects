package javacode.projects.streams.task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0),
                new Order("Graphical card", 1200)
        );
        //Группируйте заказы по продуктам.
        //Для каждого продукта найдите общую стоимость всех заказов.
        Map<String, Double> groupingByProducts = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)
                ));

        System.out.println(groupingByProducts);
        //Отсортируйте продукты по убыванию общей стоимости.
        //Выберите три самых дорогих продукта.
        List<Map.Entry<String, Double>> topProducts = groupingByProducts.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(topProducts);

        //Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
        topProducts.forEach(entry ->
                System.out.println("Product: " + entry.getKey() + ", Total Cost: " + entry.getValue()));
    }
}
