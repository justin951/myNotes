import java.util.ArrayList;
import java.util.List;

public class throwaway {

    public static void main(String[] args) {
        int inputSize = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        int even = 1;
        int odd = 1;
        for (int i = 0; i < inputSize; i++) {
            int current = sc.nextInt();
            if(!(list.contains(current))) {
                list.add(current);
                if(current % 2 == 0) {
                    even *= current;
                } else {
                    odd *= current;
                }
            }
        }
        int result = even - odd;
        System.out.println(result);
    }
}