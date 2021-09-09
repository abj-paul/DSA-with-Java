// Number 5
package fibonacci;

import Auxiliary.FastScanner;
import Auxiliary.StressTester;
import java.util.Arrays;


class PisanoPeriod{
    static long pisano_period(int m){
	// Calculate and return Pisano Period
	// The length of a Pisano Period for
	// a given m ranges from 3 to m * m
	long prev = 0;
	long curr = 1;
	long res = 0;
	
	for(int i = 0; i < m * m; i++)
	    {
		long temp = 0;
		temp = curr;
		curr = (prev + curr) % m;
		prev = temp;
		
		if (prev == 0 && curr == 1)
		    res = i + 1;
	    }
	return res;
    }
    static int recursive_fibonacci(int n, int m){
	if(n==0) return 0;
	if(n==1) return 1;
	else return (recursive_fibonacci(n-1, m)%m + recursive_fibonacci(n-2, m)%m)%m;
    }
    static int naive_fibonacci(int n, int m){
	int[] arr = new int[n+1];
	Arrays.fill(arr, 0);
	arr[1]=1;
	for(int i=2; i<=n; i++){
	    arr[i]=(arr[i-1]%m+arr[i-2]%m)%m;
	}
	return arr[n];
    }

    static int fibonacci_modulo_m(long n, int m){
	long pisano_period = pisano_period(m);
	n = n % pisano_period;
	return naive_fibonacci((int)n, (int)m);
    }
    public static void main(String[] args){

	//run_stress_testing();
	FastScanner scanner = new FastScanner(System.in);
	long n = scanner.nextLong();
	int m = scanner.nextInt();
	System.out.println(fibonacci_modulo_m(n, m));
	    
    }

    public static void run_stress_testing(){
	while(true){
	    long n = (long)(Math.random()*(100)+2);  
	    int m = (int)(Math.random()*(100)+50);  
	    
	    System.out.println("Input: "+n+","+m);
		
	    int a = naive_fibonacci((int)n,m);
	    int b = fibonacci_modulo_m(n,m);
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
