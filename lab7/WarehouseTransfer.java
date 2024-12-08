package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WarehouseTransfer {
    private static final int MAX_WEIGHT = 150;
    private static final int NUM_WORKERS = 3;

    public static void main(String[] args) {
        List<Integer> items = generateItems(20);

        // Создаем пул потоков и CompletionService
        ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        List<Integer> currentBatch = new ArrayList<>();
        int currentWeight = 0;
        int batchCount = 0;


        for (int itemWeight : items) {
            if (currentWeight + itemWeight > MAX_WEIGHT) {
                completionService.submit(new TransferTask(currentBatch));
                batchCount++;
                currentBatch = new ArrayList<>();
                currentWeight = 0;
            }

            currentBatch.add(itemWeight);
            currentWeight += itemWeight;
        }

        if (!currentBatch.isEmpty()) {
            completionService.submit(new TransferTask(currentBatch));
            batchCount++;
        }

        executor.shutdown();

        try {
            for (int i = 0; i < batchCount; i++) {
                Future<String> result = completionService.take();
                System.out.println(result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> generateItems(int count) {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add((int) (Math.random() * 50));
        }
        System.out.println("Generated items: " + items);
        return items;
    }
}

class TransferTask implements Callable<String> {
    private final List<Integer> batch;

    public TransferTask(List<Integer> batch) {
        this.batch = batch;
    }

    @Override
    public String call() throws Exception {
        int totalWeight = 0;
        for (int weight : batch) {
            totalWeight += weight;
        }
        System.out.println("Processing batch: " + batch + " Total weight: " + totalWeight + " кг");
        Thread.sleep(3000);
        return "Batch delivered: " + batch + " Total weight: " + totalWeight + " кг";
    }
}
