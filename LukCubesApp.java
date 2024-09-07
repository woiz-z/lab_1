import java.util.Scanner;

class LukCubesCalculator {

    private int N;  // Кількість чисел Люка

    public LukCubesCalculator(int N) {
        this.N = N;
    }

    // Метод для перевірки, чи є число кубом
    private boolean isCube(long number) {
        long cubeRoot = Math.round(Math.cbrt(number));
        return cubeRoot * cubeRoot * cubeRoot == number;
    }

    // Метод для отримання перших N чисел Люка
    public long[] getLukNumbers() {
        long[] lukNumbers = new long[N];
        if (N > 0) lukNumbers[0] = 2;
        if (N > 1) lukNumbers[1] = 1;
        for (int i = 2; i < N; i++) {
            lukNumbers[i] = lukNumbers[i - 1] + lukNumbers[i - 2];
        }
        return lukNumbers;
    }

    // Метод для отримання чисел Люка, які є кубами
    public long[] getLukCubes() {
        long[] lukNumbers = getLukNumbers();
        long[] cubes = new long[N];
        int cubeCount = 0;
        for (long num : lukNumbers) {
            if (isCube(num)) {
                cubes[cubeCount++] = num;
            }
        }

        // Повертаємо тільки ті числа, які є кубами
        long[] result = new long[cubeCount];
        System.arraycopy(cubes, 0, result, 0, cubeCount);
        return result;
    }
}

public class LukCubesApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість чисел Люка (N): ");
        int N = scanner.nextInt();
        scanner.close();  // Закриваємо Scanner після використання

        LukCubesCalculator calculator = new LukCubesCalculator(N);

        // Отримуємо та виводимо всі числа Люка
        long[] lukNumbers = calculator.getLukNumbers();
        System.out.println("Перші " + N + " чисел Люка:");
        for (long num : lukNumbers) {
            System.out.println(num);
        }

        // Отримуємо та виводимо числа Люка, які є кубами
        long[] cubes = calculator.getLukCubes();
        System.out.println("\nЧисла Люка, які є кубами:");
        for (long cube : cubes) {
            System.out.println(cube);
        }
    }
}
