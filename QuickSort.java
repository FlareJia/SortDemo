package SortDemo;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 3, 6, 2, 8, 1, 9, 5, 4, 10};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) { // 仅有一个元素
            return;
        }
        int mid = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, mid - 1);
        sort(arr, mid + 1, rightBound);
    }

    private static int partition(int[] arr, int leftBound, int rightBound) {// 分区
        int pivot = arr[rightBound]; // 基准
        int left = leftBound; // 左指针
        int right = rightBound - 1; // 右指针
        while (left < right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        if (pivot < arr[left]) {
            swap(arr, left, rightBound);// 将基准放到两个分区的中间
        }


        return left;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
