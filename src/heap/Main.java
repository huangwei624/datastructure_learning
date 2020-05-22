package heap;

import java.util.Arrays;

/**
 * Create by huangwei on 2020/5/22 0022
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 22, 12, 8};
        MinHeap heap = new MinHeap(arr);
        Arrays.stream(heap.getHeapArr()).forEach(System.out::println);
        System.out.println("========");
        Arrays.stream(heap.getTopk(4)).forEach(System.out::println);
    }
}
