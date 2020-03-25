import java.util.Scanner;

public class Main {
    public static void addRandomElement(double[] array) {
        for (int index = 0; index < array.length; index++) {
            array[index] = Math.random() * array.length;
        }
    }

    public static void swap(double[] array, int indexSrc, int indexDst) {
        double temp = array[indexSrc];
        array[indexSrc] = array[indexDst];
        array[indexDst] = temp;
    }

    public static void swapFake(double num1, double num2) {
        double temp = num1;
        num1 = num2;
        num2 = temp;
    }

    public static void selectionSort(double[] array) {
        for (int indexOuter = 0; indexOuter < array.length - 1; indexOuter++) {
            int minIndex = indexOuter;
            for (int indexInner = indexOuter + 1; indexInner < array.length; indexInner++) {
                if (array[indexInner] < array[minIndex]) {
                    minIndex = indexInner;
                }
            }
            swap(array,minIndex,indexOuter);
        }
    }

    public static void bubbleSort(double[] array) {
        for (int indexOuter = 0; indexOuter < array.length - 1; indexOuter++) {
            for (int indexInner = 0; indexInner < array.length - 1; indexInner++) {
                if (array[indexInner] > array[indexInner + 1]) {
                    swap(array, indexInner, (indexInner + 1));
                }
            }
        }
    }

    public static void displayArray(double[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.printf("%.2f  ", array[index]);
            if (index % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        double[] testArray;
        StopWatch sortTime = new StopWatch();

        do {
            System.out.println("Enter 'startSelection' to begin measure the execute time of selection sort 100000 double");
            System.out.println("Enter 'startBubble' to begin measure the execute time of bubble sort 100000 double");
            System.out.println("Enter 'exit' to exit the program!");
            System.out.print("Enter here: ");
            String choice = scanner.nextLine();
            if (choice.equals("startSelection")) {
                testArray = new double[100000];
                addRandomElement(testArray);
                System.out.println("Array before sort: ");
                displayArray(testArray);
                sortTime.start();
                selectionSort(testArray);
                sortTime.stop();
                System.out.println("Array after sort: ");
                displayArray(testArray);
                System.out.println("Time of selection sort is: " + sortTime.getElapsedTime() + "\n");
            } else if (choice.equals("startBubble")) {
                testArray = new double[100000];
                addRandomElement(testArray);
                System.out.println("Array before sort: ");
                displayArray(testArray);
                sortTime.start();
                bubbleSort(testArray);
                sortTime.stop();
                System.out.println("Array after sort: ");
                displayArray(testArray);
                System.out.println("Time of bubble sort is: " + sortTime.getElapsedTime() + "\n");
            } else if (choice.equals("exit")) {
                System.out.println("Exit program!");
                isExit = true;
            } else {
                System.out.println("Invalid input!");
            }
        } while (!isExit);
    }
}
