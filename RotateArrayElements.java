public class RotateArrayElements {

    
    
    public static void rotate(int a[], int times) {

        int count = 0;
        int [] temp = new int[a.length]; 
        temp[0] = a[0];
        temp[1] = a[1];
        temp[2] = a[2];

        for(int k = 0; k < times-1; k++) {
            if((temp[0] < temp[1]) && (temp[1] < temp[2])) {
                break;
            }
            for(int i = 0; i < a.length; i++) {
                temp[(i+1)%a.length] = a[i];
            }
            count++;
            a[0] = temp[0];
            a[1] = temp[1];
            a[2] = temp[2];
        }
        System.out.println("Rotated " + count  + " times");
        for(int element: temp) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    
        int n = 3;
        int times = 1;

        int arr[] = { 1, 3, 2};
        rotate(arr, 3);
    }
}