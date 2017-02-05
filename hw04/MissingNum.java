public class MissingNum  {

    public static int missingNum(int[] arr) {
	for (int i : arr)
	    System.out.print(i + " ");
	System.out.println();
	int n = arr.length;
	int diff =n*(1+n)/2;
	for (int i : arr)
	    diff -= i;
	System.out.println("diff"+diff);
	double mult = 1;
	for (int i = 1; i <= n; i++) {
	    mult *= i;
	    mult /= arr[i - 1];
	}
	System.out.println("mult"+mult);
	return (int) (diff/(mult - 1));
    }
    
    public static void main(String[] args) {
	int[] a = {2,2};
	int[] b = {1, 2, 2};
	int[] c = {1, 3, 3};
	int[] d = {2, 1, 1};
	int[] e = {2, 3, 3};
	int[] f = {3, 1, 1};
	int[] g = {3, 2, 2};
	System.out.println(missingNum(a));
	System.out.println(missingNum(b));
	System.out.println(missingNum(c));
	System.out.println(missingNum(a));
	System.out.println(missingNum(e));
	System.out.println(missingNum(f));
	System.out.println(missingNum(g));
    }

}
