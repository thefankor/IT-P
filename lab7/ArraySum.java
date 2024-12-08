package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ArraySum {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int threadCount = 4;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> results = new ArrayList<>();

        int chunkSize = (int) Math.ceil((double) array.length / threadCount);
        for (int i = 0; i < threadCount; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            results.add(executor.submit(new ArraySumTask(array, start, end)));
        }

        int totalSum = 0;
        try {
            for (Future<Integer> result : results) {
                totalSum += result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println("Total sum: " + totalSum);
    }

}

class ArraySumTask implements Callable<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
