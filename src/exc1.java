import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class exc1 {
    // Поля класса для работы с вводом и генерацией случайных чисел
    private Scanner scanner;
    private Random random;

    public exc1() {
        scanner = new Scanner(System.in); // Инициализируем scanner и random
        random = new Random();
    }

    // ПЕРВОЕ ЗАДАНИЕ

    // Задача 1. Дробная часть числа
    public double fraction(double x) {
        return x - (int)x; // Отнимаем целую часть, остается дробная
    }

    // Задача 2. Проверка положительности числа
    public boolean isPositive(int x) {
        return x > 0;
    }

    // Задача 3. Проверка двузначности числа
    public boolean is2Digits(int x) {
        return x >= 10 && x <= 99 || x <= -10 && x >= -99; // Проверка диапазона для положительных и отрицательных
    }

    // Задача 4. Проверка делимости чисел
    public boolean isDivisor(int a, int b) {
        return (a != 0 && b % a == 0) || (b != 0 && a % b == 0); // Проверяем делимость в обе стороны
    }

    // Задача 5. Проверка равенства трех чисел
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    // ВТОРОЕ ЗАДАНИЕ

    // Задача 1. Проверка делимости на 3 или 5
    public boolean is35(int x) {
        boolean div3 = (x % 3 == 0); // Делится на 3 без остатка?
        boolean div5 = (x % 5 == 0); // Делится на 5 без остатка?
        return (div3 || div5) && !(div3 && div5); // или, но не и
    }

    // Задача 2. Поиск максимального из трех чисел
    public int max3(int x, int y, int z) {
        int max = x; // Предполагаем, что первое число максимальное
        if (y > max) max = y; // Обновляем максимум
        if (z > max) max = z; // Обновляем максимум
        return max;
    }

    // Задача 3. Сумма двух чисел с особым условием
    public int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20; // Если сумма в диапазоне 10-19, возвращаем 20
        }
        else {
            return sum;
        }
    }

    // Задача 4. Форматирование возраста с правильным окончанием
    public String age(int x) {
        int lastDigit = x % 10; // Последняя цифра числа
        int lastTwoDigits = x % 100; // Последние две цифры числа

        // Особые случаи: 11, 12, 13, 14 лет
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return x + " лет";
        }

        switch (lastDigit) {
            case 1: return x + " год";
            case 2:
            case 3:
            case 4: return x + " года";
            default: return x + " лет";
        }
    }

    // Задача 5: Вывод дней недели начиная с заданного
    public void printDays(String day) {
        switch (day.toLowerCase()) { // Приводим к нижнему регистру
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье"); // Последний день
                break; // Выходим из switch
            default:
                System.out.println("это не день недели"); // Неправильный ввод
        }
    }

    // ТРЕТЬЕ ЗАДАНИЕ

    // Задача 1. Вывод чисел в обратном порядке
    public String reverseListNums(int x) {
        StringBuilder result = new StringBuilder();
        if (x >= 0) {
            // Для положительных
            for (int i = x; i >= 0; i--) {
                result.append(i);
                if (i > 0) {
                    result.append(" ");
                }
            }
        } else {ч
            // Для отрицательных
            for (int i = x; i <= 0; i++) {
                result.append(i);
                if (i < 0) {
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }

    // Задача 2. Возведение числа в степень
    public int pow(int x, int y) {
        int result = 1; // Начальное значение
        for (int i = 0; i < y; i++) { // Повторяем y раз
            result *= x; // Умножаем на основание
        }
        return result;
    }

    // Задача 3. Проверка одинаковости всех цифр в числе
    public boolean equalNum(int x) {
        if (x < 10) {
            return true; // Однозначное число имеет одну цифру
        }

        int lastDigit = x % 10; // Запоминаем последнюю цифру
        int temp = x / 10; // Убираем последнюю цифру

        while (temp > 0) {
            int currentDigit = temp % 10; // Берем следующую цифру
            if (currentDigit != lastDigit) {
                return false; // Нашли разные цифры
            }
            temp /= 10; // Убираем проверенную цифру
        }
        return true; // Все цифры одинаковы
    }

    // Задача 4. Вывод треугольника, выровненного по правому краю
    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) { // Цикл по строкам
            for (int j = 0; j < x - i; j++) { // Пробелы для выравнивания
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) { // Звездочки
                System.out.print("*");
            }
            System.out.println(); // Переход на новую строку
        }
    }

    // Задача 5. Игра "Угадай число"
    public void guessGame() {
        int secretNumber = random.nextInt(10); // Случайное число 0-9
        int attempts = 0; // Счетчик попыток
        int userGuess = -1; // Предположение пользователя

        System.out.println("Угадайте число от 0 до 9:");

        while (userGuess != secretNumber) { // Пока не угадал
            userGuess = inputInt("Введите число: ");
            attempts++; // Увеличиваем счетчик

            if (userGuess == secretNumber) {
                System.out.println("Вы угадали!");
            } else {
                System.out.println("Вы не угадали, введите число от 0 до 9:");
            }
        }

        System.out.println("Вы отгадали число за " + attempts + " попытки(ок)");
    }

    // ЧЕТВЕРТОЕ ЗАДАНИЕ

    // Задача 1. Поиск первого вхождения числа в массиве
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) { // Перебираем массив
            if (arr[i] == x) {
                return i; // Нашли - возвращаем индекс
            }
        }
        return -1; // Не нашли
    }

    // Задача 2. Поиск максимального по модулю значения в массиве
    public int maxAbs(int[] arr) {
        int maxAbsValue = Math.abs(arr[0]); // Начальное максимальное значение
        int maxIndex = 0; // Индекс максимального элемента

        for (int i = 1; i < arr.length; i++) { // Начинаем со второго элемента
            int absValue = Math.abs(arr[i]); // Абсолютное значение текущего элемента
            if (absValue > maxAbsValue) {
                maxAbsValue = absValue; // Обновляем максимум
                maxIndex = i; // Запоминаем индекс
            }
        }
        return arr[maxIndex]; // Возвращаем элемент (со знаком)
    }

    // Задача 3. Реверс массива (изменяет исходный массив)
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) { // До середины массива
            int temp = arr[i]; // Сохраняем левый элемент
            arr[i] = arr[arr.length - 1 - i]; // Левый = правый
            arr[arr.length - 1 - i] = temp; // Правый = сохраненный левый
        }
    }

    // Задача 4. Создание нового массива с перевернутыми значениями
    public int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length]; // Новый массив такого же размера
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i]; // Копируем в обратном порядке
        }
        return result;
    }

    // Задача 5. Объединение двух массивов
    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length]; // Новый массив суммарного размера

        for (int i = 0; i < arr1.length; i++) { // Копируем первый массив
            result[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) { // Копируем второй массив
            result[arr1.length + i] = arr2[i]; // После элементов первого
        }

        return result;
    }


    // Вспомогательные private методы

    // Ввод вещественного числа с проверкой корректности
    private double inputDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) { // Пока ввод не число
            System.out.print("Ошибка! Введите корректное число: ");
            scanner.next(); // Очищаем некорректный ввод
        }
        return scanner.nextDouble(); // Возвращаем число
    }

    // Ввод целого числа с проверкой корректности
    private int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) { // Пока ввод не целое число
            System.out.print("Ошибка! Введите целое число: ");
            scanner.next(); // Очищаем некорректный ввод
        }
        return scanner.nextInt(); // Возвращаем число
    }

    // Ввод строки
    private String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    // Ввод массива целых чисел
    private int[] inputArray(String prompt) {
        System.out.print(prompt);
        int size = inputInt("Введите размер массива: "); // Запрашиваем размер
        int[] arr = new int[size]; // Создаем массив
        for (int i = 0; i < size; i++) { // Заполняем поэлементно
            arr[i] = inputInt("Введите элемент [" + i + "]: ");
        }
        return arr;
    }


    // Методы для демонстрации работы задач

    private void demonstrateFraction() {
        System.out.println("Задача 1: Дробная часть числа");
        double userInput = inputDouble("Введите вещественное число: ");
        double result = fraction(userInput);
        System.out.printf("Дробная часть числа %.4f = %.4f%n%n", userInput, result);
    }

    private void demonstrateIsPositive() {
        System.out.println("Задача 2: Проверка положительности числа");
        int userInput = inputInt("Введите целое число: ");
        boolean result = isPositive(userInput);
        System.out.println("Число " + userInput + " положительное: " + result + "\n");
    }

    private void demonstrateIs2Digits() {
        System.out.println("Задача 3: Проверка двузначности числа");
        int userInput = inputInt("Введите целое число: ");
        boolean result = is2Digits(userInput);
        System.out.println("Число " + userInput + " двузначное: " + result + "\n");
    }

    private void demonstrateIsDivisor() {
        System.out.println("Задача 4: Проверка делимости чисел");
        System.out.println("Введите два числа:");
        int a = inputInt("Введите первое число: ");
        int b = inputInt("Введите второе число: ");
        boolean result = isDivisor(a, b);
        System.out.printf("Одно из чисел " + a + " и " + b + " делит другое: " + result + "\n");
    }

    private void demonstrateIsEqual() {
        System.out.println("Задача 5: Проверка равенства трех чисел");
        System.out.println("Введите три числа:");
        int a = inputInt("Введите первое число: ");
        int b = inputInt("Введите второе число: ");
        int c = inputInt("Введите третье число: ");
        boolean result = isEqual(a, b, c);
        System.out.printf("Все три числа (" + a + ", " + b + ", " + c + ") равны: " + result + "\n");
    }

    private void demonstrateIs35() {
        System.out.println("Задача 1: Тридцать пять");
        int number = inputInt("Введите целое число: ");
        boolean result = is35(number);
        System.out.println("Число " + number + " делится на 3 или на 5 (но не на оба): " + result + "\n");
    }

    private void demonstrateMax3() {
        System.out.println("Задача 2: Тройной максимум");
        System.out.println("Введите три числа:");
        int a = inputInt("Введите первое число: ");
        int b = inputInt("Введите второе число: ");
        int c = inputInt("Введите третье число: ");
        int result = max3(a, b, c);
        System.out.println("Максимальное из чисел (" + a + ", " + b + ", " + c + "): " + result + "\n");
    }

    private void demonstrateSum2() {
        System.out.println("Задача 3: Двойная сумма");
        System.out.println("Введите два числа:");
        int a = inputInt("Введите первое число: ");
        int b = inputInt("Введите второе число: ");
        int result = sum2(a, b);
        System.out.println("Результат суммы " + a + " + " + b + ": " + result + "\n");
    }

    private void demonstrateAge() {
        System.out.println("Задача 4: Возраст");
        int number = inputInt("Введите возраст: ");
        String result = age(number);
        System.out.println("Результат: " + result + "\n");
    }

    private void demonstratePrintDays() {
        System.out.println("Задача 5: Вывод дней недели");
        String day = inputString("Введите день недели: ");
        System.out.println("Результат:");
        printDays(day);
        System.out.println();
    }

    private void demonstrateReverseListNums() {
        System.out.println("Задача 1: Числа наоборот");
        int number = inputInt("Введите целое число: ");
        String result = reverseListNums(number);
        System.out.println("Результат: " + result + "\n");
    }

    private void demonstratePow() {
        System.out.println("Задача 2: Степень числа");
        int base = inputInt("Введите основание: ");
        int exponent = inputInt("Введите степень: ");
        int result = pow(base, exponent);
        System.out.println("Результат: " + base + "^" + exponent + " = " + result + "\n");
    }

    private void demonstrateEqualNum() {
        System.out.println("Задача 3: Одинаковость цифр");
        int number = inputInt("Введите целое число: ");
        boolean result = equalNum(number);
        System.out.println("Все цифры числа " + number + " одинаковы: " + result + "\n");
    }

    private void demonstrateRightTriangle() {
        System.out.println("Задача 4: Правый треугольник");
        int height = inputInt("Введите высоту треугольника: ");
        System.out.println("Результат:");
        rightTriangle(height);
        System.out.println();
    }

    private void demonstrateGuessGame() {
        System.out.println("Задача 5: Угадайка");
        guessGame();
        System.out.println();
    }

    private void demonstrateFindFirst() {
        System.out.println("Задача 1: Поиск первого вхождения");
        int[] arr = inputArray("");
        int x = inputInt("Введите число для поиска: ");
        int result = findFirst(arr, x);
        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("Индекс первого вхождения " + x + ": " + result + "\n");
    }

    private void demonstrateMaxAbs() {
        System.out.println("Задача 2: Поиск максимального по модулю");
        int[] arr = inputArray("");
        int result = maxAbs(arr);
        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("Максимальное по модулю значение: " + result + "\n");
    }

    private void demonstrateReverse() {
        System.out.println("Задача 3: Реверс массива");
        int[] arr = inputArray("");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("После реверса: " + Arrays.toString(arr) + "\n");
    }

    private void demonstrateReverseBack() {
        System.out.println("Задача 4: Возвратный реверс");
        int[] arr = inputArray("");
        int[] result = reverseBack(arr);
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Обратный массив: " + Arrays.toString(result) + "\n");
    }

    private void demonstrateConcat() {
        System.out.println("Задача 5: Объединение массивов");
        System.out.println("Ввод первого массива:");
        int[] arr1 = inputArray("");
        System.out.println("Ввод второго массива:");
        int[] arr2 = inputArray("");
        int[] result = concat(arr1, arr2);
        System.out.println("Первый массив: " + Arrays.toString(arr1));
        System.out.println("Второй массив: " + Arrays.toString(arr2));
        System.out.println("Объединенный массив: " + Arrays.toString(result) + "\n");
    }

    // Main

    public static void main(String[] args) {
        exc1 lab = new exc1();

        // Первое задание
        System.out.println("ПЕРВОЕ ЗАДАНИЕ \n");
        lab.demonstrateFraction();
        lab.demonstrateIsPositive();
        lab.demonstrateIs2Digits();
        lab.demonstrateIsDivisor();
        lab.demonstrateIsEqual();

        // Второе задание - Условия
        System.out.println("ВТОРОЕ ЗАДАНИЕ \n");
        lab.demonstrateIs35();
        lab.demonstrateMax3();
        lab.demonstrateSum2();
        lab.demonstrateAge();
        lab.demonstratePrintDays();

        // Третье задание - Циклы
        System.out.println("ТРЕТЬЕ ЗАДАНИЕ \n");
        lab.demonstrateReverseListNums();
        lab.demonstratePow();
        lab.demonstrateEqualNum();
        lab.demonstrateRightTriangle();
        lab.demonstrateGuessGame();

        // Четвертое задание - Массивы
        System.out.println("ЧЕТВЕРТОЕ ЗАДАНИЕ \n");
        lab.demonstrateFindFirst();
        lab.demonstrateMaxAbs();
        lab.demonstrateReverse();
        lab.demonstrateReverseBack();
        lab.demonstrateConcat();

        System.out.println("Все задачи выполнены");
        lab.scanner.close();
    }
}