package fibonacci;

import Auxiliary.FastScanner;
import Auxiliary.StressTester;
import java.util.Arrays;


class PascalPeriod{
    static int recursive_fibonacci(int n, int m){
	if(n==0) return 0;
	if(n==1) return 1;
	else return (recursive_fibonacci(n-1, m)%m + recursive_fibonacci(n-2, m)%m)%m;
    }
    static int regular_fibonacci(int n, int m){
	int[] arr = new int[n+1];
	Arrays.fill(arr, 0);
	arr[1]=1;
	for(int i=2; i<=n; i++){
	    arr[i]=(arr[i-1]%m+arr[i-2]%m)%m;
	}
	return arr[n];
    }
    public static void main(String[] args){

	run_stress_testing();
	//FastScanner scanner = new FastScanner(System.in);
	//long n = scanner.nextInt();
	//int m = scanner.nextInt();
	//int n_prime = (int)(n % m);
	//System.out.println(regular_fibonacci(n_prime, m));
	    
    }

    public static void run_stress_testing(){
	while(true){
	    int n_prime = (int)(Math.random()*(20)+2);  
	    int m = (int)(Math.random()*(100)+50);  

	    int n = (int)(n_prime % m);
	    
	    System.out.println("Input: "+n+","+m);
		
	    int a = recursive_fibonacci(n,m);
	    int b = regular_fibonacci(n,m);
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
