package DynamicProgramming;

import java.util.Iterator;
import java.util.Set;

public class WordSegment {

	
	public static int maxLength(Set<String> dict){
		int len = 0;
		Iterator<String> iterator = dict.iterator();
		for(String word : dict){
			if(word.length()>len){
				len = word.length();
			}
		}
		return len;
	}
	public static boolean wordBreak(String s, Set<String> dict){
		
		if(s == null || s.length() == 0){
			return false;
		}
		
		int maxLength = maxLength(dict);
		boolean[] canSegment = new boolean[s.length() + 1];
		
		for(int i = 1; i <= s.length(); i++){
			canSegment[i] = false;
			
			for(int j = 1;j < maxLength && j<=i; j++){
				
				if(!canSegment[i-j]){
					continue;
				}
				
				
			}
			
		}
		
		
	}
}
