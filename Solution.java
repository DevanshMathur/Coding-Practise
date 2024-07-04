class Solution {
    int lengthOfLongestSubstring(String s) {
    	if(s.length() < 2 ) {
    		return s.length();
    	}
        Map<Character, Integer> charMap = new HashMap<>();
        String subStr = "";
        int maxLen = 0;
        for(int i=0; i<s.length() ; i++) {
        	for(int j=i;j<s.length();j++) {
        		if(charMap.containsKey(s.charAt(j))) {
        			maxLen = max(maxLen, subStr.length());
        			System.out.println(subStr);
        			subStr = "";
        			charMap = new HashMap<>();
        			break;
        		} else {
        			subStr += s.charAt(j);
        			charMap.put(s.charAt(j), 1);
        		}
        	}
        }
        return maxLen;
    }
    
    int max(int i1, int i2) {
    	if(i1>i2) {
    		return i1;
    	} else {
    		return i2;
    	}
    }
}
