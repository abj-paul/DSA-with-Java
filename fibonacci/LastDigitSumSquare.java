// Number 8
package fibonacci;

import Auxiliary.FastScanner;
import Auxiliary.StressTester;
import java.util.Arrays;


class LastDigitSumSquare{
    static int naive_fibonacci(int n, int m){
	int sum=0;
	int[] arr = new int[n+1];
	Arrays.fill(arr, 0);
	if(arr.length>=2){
	    arr[1]=1;
	    sum+=arr[1];
	}
	for(int i=2; i<=n; i++){
	    arr[i]=(arr[i-1]%m+arr[i-2]%m)%m;
	    sum=(sum+(int)Math.pow(arr[i],2))%m;
	}
	return sum;
    }

    static int nth_fibonacci(int n, int m){
	int[] arr = new int[n+1];
	Arrays.fill(arr, 0);
	if(arr.length>=2) arr[1]=1;
	for(int i=2; i<=n; i++){
	    arr[i]=(arr[i-1]%m+arr[i-2]%m)%m;
	}
	return arr[n];
    }

    static long pisano_period(int m){
	// Calculate and return Pisano Period, The length of a Pisano Period for a given m ranges from 3 to m * m
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

    static int pisano_fibonacci(long n, int m){
	long pisano_period = pisano_period(m);
	n = n % pisano_period;
	int n1 = nth_fibonacci((int)n, m);
	n = (n+1)%pisano_period;
	int n2 = nth_fibonacci((int)(n), m); 
	return (n1*n2)%m;
    }

    public static void main(String[] args){

	//run_stress_testing();
	FastScanner scanner = new FastScanner(System.in);
	long n = scanner.nextLong();
	System.out.println(pisano_fibonacci(n, 10));
	    
    }

    public static void run_stress_testing(){
	while(true){
	    long n = (long)(Math.random()*(100)+2);  
	    int a = naive_fibonacci((int)n, 10);
	    int b = pisano_fibonacci(n, 10);
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
