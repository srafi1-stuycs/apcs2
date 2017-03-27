public class Driver  {
    public static String flip(Latkes s) {
	Latkes ret = new Latkes(s.getSize());
    }

    public static boolean allMatched(String s) {
	for (int i = 0; i < s.length()/2 - 1; i++) {
	    if (s.charAt(i) != s.charAt(s.length()-i-1))
		return false;
	}
	return true;
    }

    public static void main(String[] args) {
	System.out.println("asdf");
	System.out.println(flip("asdf"));
	System.out.println("");
	System.out.println(flip("race"));
	System.out.println("{}");
	System.out.println(allMatched("{}"));
    }

}

{{{()}{}}}
