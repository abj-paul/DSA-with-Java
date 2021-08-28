package MaxPairwiseProduct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FastScanner{
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
