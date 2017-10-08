import java.util.*;
import java.lang.Math.*;
public class Test {
	public static void main(String[] args){
		int[] Age = {15,12,25,30,59,35,60};
		int median = Age.length/2;
		int cpt=0;
  		for (int i=0; i<Age.length; i++){
  			for(int j=0;j<=Age.length-1;j++){
  				if(Age[i]>Age[j]){
  					cpt++;
  				}
  				}
  				if(cpt==median){
  					System.out.println(Age[i]);
  					break;

  				}else{
  					cpt=0;
  			}
    }
}
}

	