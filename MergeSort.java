package SortDemo;

public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {1, 4, 7, 8, 3, 6, 9};
        int[] arr = {3, 9, 2, 6, 1, 0, 9};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        // 分成两半
        int mid = left + (right - left) / 2;
        // 左边排序
        sort(arr, left, mid);
        // 右边排序
        sort(arr, mid + 1, right);

        merge(arr, left, mid + 1, right);
    }

    // 对有序的两个子数组进行合并
    private static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            // 这里这个=很重要
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
            // 优化: temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        // 检查是否有子数组是否有剩余
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
        }
        // print(temp);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] arr, int i, int j) {

    }
}
