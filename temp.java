import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.io.InputStreamReader;


public class temp{
    static long getMaxPairwiseProduct_1(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
				       (long)numbers[first] * numbers[second]);
            }
        }
        return max_product;
    }

    static long getMaxPairwiseProduct_2(int[] numbers){
	int max_index_one=0;
	int max_index_two=1;
	for(int i=0; i< numbers.length; i++){
	    // NEEDS EDIT
	    if(numbers[max_index_one]<numbers[i] && max_index_two!=i) max_index_one= i;
	}
	for(int i=0; i<numbers.length; i++){
	    if(numbers[max_index_two]<numbers[i] && max_index_one != i) max_index_two=i;
	}
	return (long)numbers[max_index_one]*numbers[max_index_two];
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


class FastScanner{
    BufferedReader br;
    StringTokenizer st;
    public FastScanner(InputStream stream){
	try{
	    br = new BufferedReader(new InputStreamReader(stream));
	} catch(Exception e){
	    e.printStackTrace();
	}
    } 
    public String nextToken(){
		while(st==null || !st.hasMoreTokens()){ //hasMoreTokens() test is done by using nextToken method. If nextToken does not return error, then it means it has more tokens.
		    // When we have no more tokens for that line, we create a new tokenizer for the next line.
		    try{
			st = new StringTokenizer(br.readLine());
		    }catch(Exception e){
			e.printStackTrace();
		    }
		}
		return st.nextToken();
    }
    
    public int nextInt(){
	return Integer.parseInt(nextToken());
    }
    public long nextLong(){
	return Long.parseLong(nextToken());
    }
    public double nextDouble(){
	return Double.parseDouble(nextToken());
    }
}
