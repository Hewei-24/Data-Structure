import java.util.Random;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();

        System.out.print("原始数组: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.print("\n逆置后数组: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}