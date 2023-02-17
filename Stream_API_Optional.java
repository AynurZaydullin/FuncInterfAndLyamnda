import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_API_Optional {
    public static void main(String[] args) {
        // Задание 1.
        // Создание неотсортированного списка целых чисел.
        List<Integer> listForProcessing = new ArrayList<>();
        listForProcessing.add(2);
        listForProcessing.add(1);
        listForProcessing.add(5);
        listForProcessing.add(3);
        Stream<Integer> streamOfListForProcessing = listForProcessing.stream();
        Comparator <? super Integer> order = Comparator.naturalOrder();
        BiConsumer <? super Integer, ? super Integer> minMaxConsumer = (x, y) ->
                System.out.println("Минимальный элемент равен: " + x + '\n' + "Максимальный элемент равен: " + y);
        findMinMax(streamOfListForProcessing,order, minMaxConsumer);

        //Задание 2.
        System.out.println();
        System.out.println("Задание 2.");
        List<Integer> integerList = List.of(2, 3, 4, 1, 8);
//        Stream<Integer> integerStream = integerList.stream();
        printEvenNumbersAndTheirCount(integerList);
    }
    public static void findMinMax(Stream <? extends Integer> stream, Comparator <? super Integer> order,
                                  BiConsumer<? super Integer, ? super Integer> minMaxConsumer) {
        List<Integer> maxMin = stream.sorted(order).collect(Collectors.toList());
        // Передача в minMaxConsumer минимального и максимального значения.
        // Так как список сортируется в порядке возрастания, то минимальный элемент будет в начале списка, а максимальный - в конце.
        minMaxConsumer.accept(maxMin.get(0), maxMin.get(maxMin.size()-1));
    }

    public static void printEvenNumbersAndTheirCount(List<Integer> integerList) {
        System.out.println("Количество четных элементов равно: " +
                integerList.stream().filter(x -> x%2 == 0).peek(x -> System.out.println("Четные числа: " + x)).count());
        /* Второе рабочее решение. Но первое решение я считаю лучше.
        List<Integer> evenNumbers = integerList.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        evenNumbers.stream().forEachOrdered(x -> System.out.println("Чётные числа: " + x));
        System.out.println("Количество чётных элементов равно: " + evenNumbers.stream().count());
         */
    }
}


