// Number 7
package fibonacci;

import Auxiliary.FastScanner;
import Auxiliary.StressTester;
import java.util.Arrays;


class LastDigitSumLimit{
    static int naive_fibonacci(int start, int end, int m){
	int sum=0;
	int[] arr = new int[end+1];
	Arrays.fill(arr, 0);

	// Finding m-1 and m-2 so that we can start from F_m.
	if(arr.length>=2) arr[1]=1;
	for(int i=2; i<=start-1; i++){
	    arr[i]=(arr[i-1]%m+arr[i-2]%m)%m;
	}
	
	for(int i=start; i<=end; i++){
	    arr[i]=(arr[i-1]%m+arr[i-2]%m)%m;
	    sum=(sum+arr[i])%m;
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

    static int minus(int number1, int number2, int limit){
	if(number1>=number2) return number1 - number2; //3-1 = 2
	else if (number1 == 0) return limit - number2; // 0-1 = 10-1 = 9
	else if(number1<number2) return limit+number1-number2; //2-5=10+2-5=7
	return -1; // error occurred
    }
    
    static int pisano_fibonacci(long start, long end, int m){
	long pisano_period = pisano_period(m);
	end=end+2; //because-> sum of (f_n) = f_(n+2)
	end = end % pisano_period;
	start=start+1; 
	start = start % pisano_period;

	int n1 = nth_fibonacci((int)end, (int)m);
	int n2 = nth_fibonacci((int)start, (int)m);
	return minus(n1, n2, 10);
    }

    public static void main(String[] args){

	//run_stress_testing();
	FastScanner scanner = new FastScanner(System.in);
	long start = scanner.nextLong();
	long end = scanner.nextLong();
	System.out.println(pisano_fibonacci(start, end, 10));
	    
    }

    public static void run_stress_testing(){
	while(true){
	    long end = (long)(Math.random()*(100)+2);  
	    long start = (long)(Math.random()*(end-1)+2);  

	    System.out.println("Input: "+start+", "+end);;
		
	    int a = naive_fibonacci((int)start, (int)end, 10);
	    int b = pisano_fibonacci(start, end, 10);
	    if(a!=b){
		System.out.println("Exception encounterd!");
		System.out.println("Output: "+a+", "+b);;
		break;
	    }else{
		System.out.println("Ok.");
		//System.out.println("Input: "+start+", "+end);;
		System.out.println("Output: "+a+", "+b);;
	    }
	}
    }

}
