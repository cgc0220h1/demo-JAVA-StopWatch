import java.util.Scanner;

public class Main {
    public static void addRandomElement(double[] array) {
        for (int index = 0; index < array.length; index++) {
            array[index] = Math.random() * array.length;
        }
    }

    public static void swap(double num1, double num2) {
        double temp = num1;
        num1 = num2;
        num2 = temp;
    }

    public static void selectionSort(double[] array) {
        for (int indexOuter = 0; indexOuter < array.length; indexOuter++) {
            int min_index = indexOuter;
            for(int indexInner = indexOuter + 1; indexInner < array.length; indexInner++) {
                if (array[indexInner] < array[min_index]) {
                    min_index = indexInner;
                }
            }
            swap(array[min_index], array[indexOuter]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        do {
            System.out.println("Enter 'start' to begin measure the execute time of selection sort");
            System.out.println("Enter 'exit' to exit the program!");
            System.out.print("Enter here: ");
            String choice = scanner.nextLine();
            if (choice.equals("start")) {
                double[] testArray = new double[100000];
                addRandomElement(testArray);
                StopWatch sortTime = new StopWatch();
                sortTime.start();
                selectionSort(testArray);
                sortTime.stop();
                System.out.println("Time of selection sort is: " + sortTime.getElapsedTime() + "\n");
            } else if (choice.equals("exit")) {
                System.out.println("Exit program!");
                isExit = true;
            } else {
                System.out.println("Invalid input!");
            }
        } while (!isExit);
    }
}
