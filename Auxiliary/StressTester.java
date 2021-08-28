package Auxiliary;

public abstract class StressTester{
    public void run_stress_testing(){}; /*{
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
		}*/

    public void print_input(){};
    public void print_output(){};
}


