package gcd;
import Auxiliary.FastScanner;

class GCD{
    static int naive_gcd(int a, int b){
	int gcd = 1;
	for(int i=2; i<=a+b; i++){
	    if(a%i==0 && b%i==0) gcd = i;
	}
	return gcd;
    }
    static int euclidean_gcd(int a, int b){
	if(b==0) return a;
	return euclidean_gcd(b, a%b);
    }
    public static void main(String[] args){
	run_stress_testing();
	//FastScanner scanner = new FastScanner(System.in);
	//int a = scanner.nextInt();
	//int b = scanner.nextInt();
	//System.out.println(euclidean_gcd(Math.max(a,b), Math.min(a, b)));
    }
    static void run_stress_testing(){
	while (true) {
	    int a = (int) (Math.random() * 10000)+1;
	    int b = (int) (Math.random() * 10000)+1;
	    int output_1 = naive_gcd(Math.max(a, b), Math.min(a,b));
	    int output_2 = euclidean_gcd(Math.max(a, b), Math.min(a,b));
	    if (output_1 != output_2) {
		System.out.println("Exception occured!");
		System.out.println("Input: "+a+","+b);
		System.out.println("Output: "+output_1+" != "+output_2);
		break;
	    }else{
		System.out.println("OK.");
		System.out.println(+a+","+b);
		System.out.println("Output: "+output_1+" != "+output_2);
	    }
	}
    }
	
}
