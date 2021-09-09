package greedy;

import java.util.Arrays;
import auxiliary.FastScanner;
class FreelanceProjectProblem {
    // Returns maximum income
    private static int greedy_solution(int[] arr){
	Arrays.sort(arr);
	int n = arr.length;
	if (arr.length >= 3){
	    int ans = arr[n - 1] + arr[n - 2] + arr[n - 3];
	    return ans;
	} else if(arr.length==2){
	    int ans = arr[n - 1] + arr[n - 2];
	    return ans;
	} else
	    return arr[0];
    }

    private static int naive_solution(int[] arr){
	int n = arr.length;
	int current_sum=0;
	int max_sum=0;

	if(n<=3){
	    if(n==3) return arr[0]+arr[1]+arr[2];
	    if(n==2) return arr[0]+arr[1];
	    if(n==1) return arr[0];
	}
	
	for(int i=0; i<n-2; i++){
	    for(int j=i+1; j<n-1; j++){
		for(int k=j+1; k<n; k++){
		    current_sum = arr[i]+arr[j]+arr[k];
		    max_sum = Math.max(current_sum, max_sum);
		}
	    }
	}
	return max_sum;
    }
    
    public static void main(String[] args){
	//FastScanner scanner = new FastScanner(System.in);
	//int n = scanner.nextInt();
	//int[] arr = new int[n];
	//for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
	//System.out.println(greedy_solution(arr));
	stress_testing();
    }

    private static void stress_testing(){
	while(true){
	    int n = (int)(Math.random()*10)+1;
	    int[] arr = new int[n];
	    for(int i=0; i<n; i++) arr[i] = (int)(Math.random()*100);
	    print_input(arr);
	    int a = greedy_solution(arr);
	    int b = naive_solution(arr);
	    if(a!=b){
		System.out.println("Mismatch found!");
		System.out.printf("greedy=%d, naive=%d\n",a,b);
		break;
	    }
	    else {
		System.out.println("Ok.");
		System.out.printf("greedy=%d, naive=%d\n",a,b);
	    }
	}
    } 

    private static void print_input(int[] arr){
	System.out.println("n="+arr.length);
	for(int i=0; i<arr.length; i++){
	    System.out.print(arr[i]+" ");
	}
	System.out.print("\n");
    }
}
