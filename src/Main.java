import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[6];
        long answer = 0;

        // 주사위 정보 입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        // 주사위 하나로만 이루어진 정육면체
        if (n == 1) {
            Arrays.sort(arr);

            for (int i = 0; i < arr.length - 1; i++) {
                answer += arr[i];
            }
            System.out.println(answer);

            return;
        }

        // 마주보는 주사위 면 중 최소값
        int min1 = Math.min(arr[0], arr[5]);
        int min2 = Math.min(arr[1], arr[4]);
        int min3 = Math.min(arr[2], arr[3]);

        // 1. 3가지 면이 보이는 경우
        long answer3 = 4L * (min1 + min2 + min3);

        // 2. 2가지 면이 보이는 경우
        long tmp2 = 4L * (n - 1) + 4L * (n - 2);
        long answer2 = tmp2 * (Math.min(Math.min(min1 + min2, min1 + min3), min2 + min3));

        // 3. 1가지 면이 보이는 경우
        long tmp1 = (4L * (n - 2) * (n - 1) + (long)(Math.pow(n - 2, 2)));
        long answer1 = tmp1 * Math.min(Math.min(min1, min2), min3);

        answer = answer1 + answer2 + answer3;
        System.out.println(answer);
    }
}
