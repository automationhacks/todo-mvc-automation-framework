package utils;

public class Logger {
    public static void printCurrentThread() {
        long threadId = Thread.currentThread().getId();
        System.out.printf(">>> Thread: %s%n", threadId);
    }

}
