package heap;

/**
 * 最小堆，
 * 非叶子节点的索引范围是 0到 n/2 -1
 * 节点 n 的左节点2(n+1)-1， 右节点 2(n+1)
 * Create by huangwei on 2020/5/21 0021
 */
public class MinHeap {
    // 需要维护的堆
    int[] arr;

    public MinHeap(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        // 遍历所有的非叶子节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * 以这个为根节点，进行堆调整，i 为这个根节点的数组索引
     *
     * @param i
     */
    private void heapify(int i) {
        // 记录最小值的数组索引
        int smallest = i;
        int left = leftNodeIndex(i);
        int right = rightNodeIndex(i);
        // 左节点的索引需要小于数组的长度，
        if (left < arr.length && arr[left] < arr[smallest]) {
            smallest = left;
        }
        // 右节点的索引需要小于数组的长度，
        if (right < arr.length && arr[right] < arr[smallest]) {
            smallest = right;
        }
        // 如果当前最小值就是 i 对应的元素，直接返回
        if (smallest == i) {
            return;
        }
        // 交换这两个位置的元素
        swap(i, smallest);
        // 交换后，以smallest索引 为根节点的树可能不满足堆了，重新构建
        heapify(smallest);
    }

    /**
     * 左节点的索引
     *
     * @param i
     * @return
     */
    private int leftNodeIndex(int i) {
        return 2 * (i + 1) - 1;
    }

    /**
     * 右节点的索引
     *
     * @param i
     * @return
     */
    private int rightNodeIndex(int i) {
        return 2 * (i + 1);
    }

    /**
     * 交换两个元素
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 获取这个堆
     * @return
     */
    public int[] getHeapArr(){
        return this.arr;
    }

    /**
     * 获取最小值
     * @return
     */
    public int getMin(){
        return arr[0];
    }

    /**
     * 重新设置根
     */
    private void setRoot(int a){
        this.arr[0] = a;
        heapify(0);
    }

    /**
     * 获取最大的 k 个数
     * @param k
     * @return
     */
    public int[] getTopk(int k){
        // 如果要获取的个数大于堆的大小，直接把堆返回
        if(k >= this.arr.length) return this.arr;
        // 构建一个大小为k 的堆
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = this.arr[i];
        }
        MinHeap minHeap = new MinHeap(res);
        // 遍历剩下的数据，重新过k 堆
        for (int i = k; i < this.arr.length; i++) {
            int root = minHeap.getMin();
            if(this.arr[i] > root){
                minHeap.setRoot(this.arr[i]);
            }
        }
        return res;
    }
}
