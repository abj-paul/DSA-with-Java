package MaxPairwiseProduct;
import java.util.*;
import java.io.*;
import MaxPairwiseProduct.StressTester;
import MaxPairwiseProduct.FastScanner;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct_1(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }
        return max_product;
    }

    static int getMaxPairwiseProduct_2(int[] numbers){
	int max_index_one=0;
	int max_index_two=1;
	for(int i=0; i< numbers.length; i++){
	    // NEEDS EDIT
	    if(numbers[max_index_one]<numbers[i] && max_index_two!=i) max_index_one= i;
	}
	for(int i=0; i<numbers.length; i++){
	    if(numbers[max_index_two]<numbers[i] && max_index_one != i) max_index_two=i;
	}
	return numbers[max_index_one]*numbers[max_index_two];
    }
    public static void main(String[] args){
	//StressTester.run_stress_testing();

	FastScanner scanner = new FastScanner(System.in);
	int n = scanner.nextInt();
	int[] numbers = new int[n];
	for(int i=0; i<n; i++) numbers[i] = scanner.nextInt() ;

	System.out.println(getMaxPairwiseProduct_2(numbers));
    }
}
