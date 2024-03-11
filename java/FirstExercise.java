import java.util.Arrays;
import java.util.Random;

public class FirstExercise {

    public static void main(String[] args) {

        int length = 10;
        int[] nums = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(50);
        }
        long result = Arrays.stream(nums).filter(i -> i % 2==0).count();

        System.out.println(Arrays.toString(nums));

        System.out.println(result);
       }
    }



