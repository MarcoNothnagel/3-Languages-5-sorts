import java.util.stream.IntStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Algo {
    // Time Complexity: O(n^2)
    // implementation of Bubble Sort
    void bubbleSort(int array[]) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Time Complexity: O(n log(n))
    void mergesort(int[] input) {
        mergesort(input, 0, input.length - 1);
    }

    static void mergesort(int[] input, int start, int end) {

        // break problem into smaller structurally identical problems
        int mid = (start + end) / 2;
        if (start < end) {
            mergesort(input, start, mid);
            mergesort(input, mid + 1, end);
        }

        // merge solved pieces to get solution to original problem
        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];

        while (first <= mid && last <= end) {
            tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
        }
        while (first <= mid) {
            tmp[i++] = input[first++];
        }
        while (last <= end) {
            tmp[i++] = input[last++];
        }
        i = 0;
        while (start <= end) {
            input[start++] = tmp[i++];
        }
    }

    // Time Complexity: O(n^2)
    // implementation of insertion Sort
    void insertionSort(int array[]) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            array[j + 1] = key;
        }
    }

    // Time Complexity: O(n^2)
    // implementation of shell Sort
    void shellSort(int array[]) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= i && array[j - i] > temp; j -= i) {
                    array[j] = array[j - i];
                }
                array[j] = temp;
            }
        }
    }

    // Time Complexity: O(n^2)
    // implementation of selection Sort
    void selectionSort(int array[]) {
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}

class sorting {

    // main class
    public static void main(String[] args) {

        Algo s = new Algo();

        List<String> bubble = new ArrayList<String>();
        bubble.add("Bubble Sort");
        List<String> merges = new ArrayList<String>();
        merges.add("Merge Sort");
        List<String> insertion = new ArrayList<String>();
        insertion.add("Insertion Sort");
        List<String> shell = new ArrayList<String>();
        shell.add("Shell Sort");
        List<String> selection = new ArrayList<String>();
        selection.add("Selection Sort");

        int[] arr_small = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
        int[] arr_medium = IntStream.generate(() -> new Random().nextInt(100)).limit(1000).toArray();
        int[] arr_large = IntStream.generate(() -> new Random().nextInt(100)).limit(10000).toArray();

        String textInBold = "\n Small array sorting times \n";
        // create the bold text
        System.out.println("\033[0;1m" + textInBold);

        // bubble sort execution time for 100 items
        textInBold = "Bubble sort";
        System.out.println("\033[0;1m" + textInBold);

        // claculates execution time for bubble sort in milliseconds
        long start = System.nanoTime();
        s.bubbleSort(arr_small);
        long end = System.nanoTime();
        float elapsed = (end - start) / 1000_000f;
        bubble.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // merge sort execution time for 100 items
        textInBold = "Merge sort";
        // creates text in bold
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution ime for merge sort in milliseconds
        start = System.nanoTime();
        s.mergesort(arr_small);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        merges.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // insertion sort execution time for 100 items
        textInBold = "Insertion sort";
        // creates text in bold
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution ime for inertion sort in milliseconds
        start = System.nanoTime();
        s.insertionSort(arr_small);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        insertion.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // shell sort execution time for 100 items
        textInBold = "Shell sort";
        // creates text in bold
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution ime for shell sort in milliseconds
        start = System.nanoTime();
        s.shellSort(arr_small);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        shell.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // selection sort execution time for 100 items
        textInBold = "Selection sort";
        // creates text in bold
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution ime for selection sort in milliseconds
        start = System.nanoTime();
        s.selectionSort(arr_small);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        selection.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // medium array sorting times
        textInBold = "\n Medium array sorting times \n";
        System.out.println("\033[0;1m" + textInBold);

        // bubble sort execution time for 100 items
        textInBold = "Bubble sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution ime for bubble sort in milliseconds
        start = System.nanoTime();
        s.bubbleSort(arr_medium);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        bubble.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // merge sort execution time for 100 items
        textInBold = "Merge sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution ime for merge sort in milliseconds
        start = System.nanoTime();
        s.mergesort(arr_medium);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        merges.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // insertion sort execution time for 100 items
        textInBold = "Insertion sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution time for inertion sort in milliseconds
        start = System.nanoTime();
        s.insertionSort(arr_medium);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        insertion.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // shell sort execution time for 100 items
        textInBold = "Shell sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution time for shell sort in milliseconds
        start = System.nanoTime();
        s.shellSort(arr_medium);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        shell.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // selection sort execution time for 100 items
        textInBold = "Selection sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution time for selection sort in milliseconds
        start = System.nanoTime();
        s.selectionSort(arr_medium);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        selection.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // large array sorting times
        textInBold = "\n Large array sorting times \n";
        System.out.println("\033[0;1m" + textInBold);

        // bubble sort execution time for 100 items
        textInBold = "Bubble sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution time for bubble sort in milliseconds
        start = System.nanoTime();
        s.bubbleSort(arr_large);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        bubble.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // merge sort execution time for 100 items
        textInBold = "Merge sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution Time for merge sort in milliseconds
        start = System.nanoTime();
        s.mergesort(arr_large);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        merges.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // insertion sort execution time for 100 items
        textInBold = "Insertion sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution time for insertion sort in milliseconds
        start = System.nanoTime();
        s.insertionSort(arr_large);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        insertion.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // shell sort execution time for 100 items
        textInBold = "Shell sort";
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution time for shell sort in milliseconds
        start = System.nanoTime();
        s.shellSort(arr_large);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        shell.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        // selection sort execution time for 100 items
        textInBold = "Selection sort";
        // makes the text bold
        System.out.println("\033[0;1m" + textInBold);

        // calculates execution ime for selection sort in milliseconds
        start = System.nanoTime();
        s.selectionSort(arr_large);
        end = System.nanoTime();
        elapsed = (end - start) / 1000_000f;
        selection.add(Float.toString(elapsed));
        System.out.println("Time elapsed \t" + Float.toString(elapsed) + " ms ");

        String bubbleData = String.join("/", bubble);
        String mergesData = String.join("/", merges);
        String insertionData = String.join("/", insertion);
        String shellData = String.join("/", shell);
        String selectionData = String.join("/", selection);

        try {
            FileWriter w = new FileWriter("javafile.txt");
            w.write(bubbleData + "\n");
            w.write(mergesData + "\n");
            w.write(insertionData + "\n");
            w.write(shellData + "\n");
            w.write(selectionData);
            w.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
