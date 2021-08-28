package MaxPairwiseProduct;

public class StressTester extends MaxPairwiseProduct{
    public static void run_stress_testing(){
	while(true){
		FastScanner scanner = new FastScanner(System.in);
		int n = (int)(Math.random()*(5)+2);  
		int[] numbers = new int[n];
		for(int i=0; i<n; i++){
		    numbers[i] = (int)(Math.random()*(100));
		}
		int a = getMaxPairwiseProduct_1(numbers);
		int b = getMaxPairwiseProduct_2(numbers);

		if(a!=b){
		    System.out.println("Exception Encountered!");
		    print_input(numbers);
		    print_output(a,b);
		    break;
		} else {
		    print_input(numbers);
		    System.out.println("Ok.");
		}
	}
    }
    public static void print_input(int[] arr){
	for(int i=0; i< arr.length; i++) System.out.print(arr[i]+" ");
	System.out.println("");
    }
    public static void print_output(int x, int y){
	System.out.println("Output: " + x + " != " + y);
    }
}
