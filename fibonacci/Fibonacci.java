package fibonacci;

import Auxiliary.FastScanner;
import Auxiliary.StressTester;
import java.util.Arrays;
 
class Fibonacci{
    static int recursive_fibonacci(int n){
	if(n==0) return 0;
	if(n==1) return 1;
	else return recursive_fibonacci(n-1) + recursive_fibonacci(n-2);
    }
    static int regular_fibonacci(int n){
	int[] arr = new int[n+1];
	Arrays.fill(arr, 0);
	arr[1]=1;
	for(int i=2; i<=n; i++){
	    arr[i]=arr[i-1]+arr[i-2];
	}
	return arr[n];
    }
    public static void main(String[] args){

	run_stress_testing();
	//FastScanner scanner = new FastScanner(System.in);
	//int n = scanner.nextInt();
	//System.out.println(recursive_fibonacci(n)+" "+regular_fibonacci(n));
	    
    }

    public static void run_stress_testing(){
	while(true){
	    int n = (int)(Math.random()*(10)+2);  
	    int a = recursive_fibonacci(n);
	    int b = regular_fibonacci(n);
	    if(a!=b){
		System.out.println("Exception encounterd!");
		System.out.println("n="+n+", a="+a+", b="+b);;
		break;
	    }else{
		System.out.println("Ok.");
		System.out.println("n="+n);;
	    }
	}
    }
    
}
