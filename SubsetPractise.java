import java.util.ArrayList;

public class SubsetPractise {

    public static void permute(ArrayList<Integer> arr) {
        System.out.println(arr);
        if(arr.size() == 1)
            return;

        for(int i = 0; i < arr.size(); i++) {
            int ele = arr.remove(i);
            permute(arr);
            arr.add(ele);
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        permute(arr);

    }
}
