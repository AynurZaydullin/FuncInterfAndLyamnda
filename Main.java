import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Задание 1 на функциональный интерфейс Predicate.
        // Решение через анонимный класс
        // Создаю массив из тестовых данных.
        System.out.println();
        int[] numberForCheck = new int[]{1, 0, -1};
        System.out.println("Решение через анонимный класс:");
        Predicate<Integer> isNumberPositive1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number > 0;
            }
        };
        for (int number:
                numberForCheck) {
            System.out.println("Число " + number + " больше нуля?" + " - " + isNumberPositive1.test(number));
        }
        //Решение через лямду:
        System.out.println();
        System.out.println("Решение через лямду: ");
        Predicate<Integer> isNumberPositiveUsingLambda = number -> number > 0;
        for (int number:
                numberForCheck) {
            System.out.println("Число " + number + " больше нуля?" + " - " + isNumberPositiveUsingLambda.test(number));
        }

        //Задание 2 на функциональный интерфейс Consumer.
        System.out.println();
        System.out.println("Решение задачи на функциональный интерфейс Consumer через анонимный класс.");
        Consumer<String> helloName = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет, " + s);
            }
        };
        helloName.accept("Ольга!");
        System.out.println();
        //Решение через лямду
        System.out.println("Решение задачи на функциональный интерфейс Consumer через лямду.");
        Consumer<String> helloNameUsingLambda = s -> System.out.println("Привет, " + s);
        helloNameUsingLambda.accept("Айнур!");

        // Задание 3 на функциональный интерфейс Function.
        // Решение через анонимный класс.
        System.out.println();
        Function<Double, Long> roundingDoubleToLong = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println("Решение задачи на функциональный интерфейс Function через анонимный класс.");
        System.out.println("Число 2.233 округляется до " + roundingDoubleToLong.apply(2.233));
        System.out.println();
        //Решение через лмбду.
        Function<Double, Long> roundingDoubleToLongUsingLambda = f -> Math.round(f);
        System.out.println("Решение задачи на функциональный интерфейс Function через лямбду.");
        System.out.println("Число 3.44 округляется до " + roundingDoubleToLongUsingLambda.apply(3.44));
        System.out.println();

        //Задание 4 на функциональный интерфейс Supplier.
        System.out.println("Решение задачи на функциональный интерфейс Supplier через анонимный класс.");
        for (int i = 0; i < 10; i++) {
            System.out.print(generatingIntegerRandom.get() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Решение задачи на функциональный интерфейс Supplier через лямбду.");
        for (int i = 0; i < 10; i++) {
            System.out.print(generatingIntegerRandomUsingLambda.get() + " ");
        }
        System.out.println();
        System.out.println();

        // Задание 5 на комбинирование функцинальных операторов.
        System.out.println("Решение задачи на комбинирование функцинальных операторов.");
        for (int number:
                numberForCheck) {
            System.out.println("Число " + number + " больше нуля?" + " - " +
                    ternaryOperator(isNumberPositive1, isTrue, isFalse).apply(number));
        }
    }
    // Задание 4 на функциональный интерфейс Supplier. Решение через анонимный класс.
    public static Supplier<Integer> generatingIntegerRandom = new Supplier<Integer>() {
        @Override
        public Integer get() {
            return (int) (Math.random() * 100);
        }
    };
    //Решение через лямду
    public static
    Supplier<Integer> generatingIntegerRandomUsingLambda = () -> (int) (Math.random()*100);

    // Задание 5 на комбинирование функцинальных операторов.
    public static Function<Integer, String> ternaryOperator(Predicate<Integer> condition, Function<Integer, String> ifTrue,
                                              Function<Integer, String> ifFalse){
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
    public static
    Function<Integer, String> isTrue = x -> "Истина.";
    public static  Function<Integer, String> isFalse = x -> "Ложь!";
}