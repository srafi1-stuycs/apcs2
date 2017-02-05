public class MissingNum  {

    public static int missingNum(int[] arr) {
	int num = 0;
	while (num + 1 != arr[num]) {
	    int a = arr[num];
	    arr[num] = arr[a - 1];
	    arr[a - 1] = a;
	    3 2 2 4
		2 1 3 4
	}
    }
    
    public static void main(String[] args) {
	
    }

}
