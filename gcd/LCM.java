package gcd;
import Auxiliary.FastScanner;

class LCM{
    static int naive_lcm(int a, int b){
	int lcm = Math.max(a,b);
	while(true){
	    if(lcm%a==0 && lcm%b==0) break;
	    lcm++;
	}
	return lcm;
    }
    static int euclidean_gcd(int a, int b){
	if(b==0) return a;
	return euclidean_gcd(b, a%b);
    }
    static long euclidean_lcm(int a, int b){
	int gcd = euclidean_gcd(Math.max(a, b), Math.min(a,b));
	long lcm = (long)(a*b)/(long)gcd;
	return lcm;
    }
    public static void main(String[] args){
	run_stress_testing();
	//FastScanner scanner = new FastScanner(System.in);
	//int a = scanner.nextInt();
	//int b = scanner.nextInt();
	//System.out.println(euclidean_lcm(a, b));
    }
    static void run_stress_testing(){
	while (true) {
	    int a = (int) (Math.random() * 10000)+1;
	    int b = (int) (Math.random() * 10000)+1;
	    int output_1 = naive_lcm(a,b);
	    long output_2 = euclidean_lcm(a, b);
	    if (output_1 != output_2) {
		System.out.println("Exception occured!");
		System.out.println("Input: "+a+","+b);
		System.out.println("Output: "+output_1+" != "+output_2);
		break;
	    }else{
		System.out.println("OK.");
		System.out.println("Input: "+a+","+b);
		System.out.println("Output: "+output_1+" != "+output_2);
	    }
	}
    }
	
}
