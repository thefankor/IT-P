package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedMatrixMax {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(10, 10);
        int threadCount = 4;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> results = new ArrayList<>();

        int rowsPerThread = (int) Math.ceil((double) matrix.length / threadCount);
        for (int i = 0; i < threadCount; i++) {
            int startRow = i * rowsPerThread;
            int endRow = Math.min(startRow + rowsPerThread, matrix.length);
            results.add(executor.submit(new MatrixMaxTask(matrix, startRow, endRow)));
        }

        int globalMax = Integer.MIN_VALUE;
        try {
            for (Future<Integer> result : results) {
                int localMax = result.get();
                globalMax = Math.max(globalMax, localMax); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println("Максимальный элемент в матрице: " + globalMax);
    }

    private static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
        return matrix;
    }
}
class MatrixMaxTask implements Callable<Integer> {
    private final int[][] matrix;
    private final int startRow;
    private final int endRow;

    public MatrixMaxTask(int[][] matrix, int startRow, int endRow) {
        this.matrix = matrix;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public Integer call() {
        int max = Integer.MIN_VALUE;
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }
}
