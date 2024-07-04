class Solution {
    List<String> fullJustify(String[] words, int maxWidth) {
		int wordCount = 0; 
	    List<List<String>> lines = new ArrayList<>();
	    List<String> curLine = new ArrayList<>();
	    String lineStr = "";
	    
	    for(int currWord=0;currWord < words.length;currWord++) {
	    	if((wordCount + words[currWord].length()) > maxWidth) {
	    		lines.add(curLine);
	    		curLine = new ArrayList<>();
	    		wordCount = 0;
	    		
	    	}
	    	if(wordCount + words[currWord].length() <= maxWidth) {
	    		curLine.add(words[currWord]);
	    		wordCount += words[currWord].length();
	    		wordCount++;
	    	} 
	    	
	    	
	    	
    		
	    }
	    if(curLine.size() > 0) {
		    lines.add(curLine);
			curLine = new ArrayList<>();
			wordCount = 0;
	    }
	    for(int i=0;i<lines.size();i++) {
	    	System.out.println(lines.get(i));
	    }
	    
	    
	    
	    int neededSpace = 0;
	    int divisor = 0;
	    int reminder = 0;
	    int endL = 0;

	    String replaceWith = " ";
	    for(int i=0;i<lines.size();i++) {
	    	int totWords = lines.get(i).size();
	    	int wordCounts = 0;
	    	for(int j=0;j<lines.get(i).size();j++) {
	    		wordCounts += lines.get(i).get(j).length();
	    	}
	    	neededSpace = maxWidth - wordCounts;
	    	if(neededSpace < 0) {
	    		neededSpace = 0;
	    	}
	    	
	    	if(totWords == 1) {
	    		lines.get(i).add(replaceWith.repeat(neededSpace));
	    	} else if(i == lines.size()-1) {
	    		curLine =  new ArrayList<>();
	    		wordCount = 0;
	    		for(int j=0;j<lines.get(i).size();j++) {
	    			if(curLine.size() != 0) {
	    				curLine.add(replaceWith);
	    				wordCount++;
	    			}
	    			wordCount += lines.get(i).get(j).length();
	    			curLine.add(lines.get(i).get(j));
	    		}
	    		System.out.println(curLine);
	    		System.out.println(maxWidth - wordCount);
	    		if(maxWidth - wordCount > 0) {
		    		curLine.add(replaceWith.repeat(maxWidth - wordCount));
	    		}
		    		lines.remove(i);
		    		lines.add(curLine);
	    		System.out.println("See");
	    		System.out.println(curLine);
	    		
	    	}
	    	else {
	    		
			    	divisor = neededSpace / (totWords - 1);
			    	reminder = neededSpace % (totWords - 1);
	    		
		    	endL = lines.get(i).size()-1;
		    	for(int j=0;j<endL;j++) {
//		    		System.out.println("i"+i+"j"+j);
		    		if(reminder>j) {
		    			lines.get(i).add((2*j+1), replaceWith.repeat(divisor + 1));
		    		} else {
		    			lines.get(i).add((2*j+1), replaceWith.repeat(divisor));
		    		}
		    	}
	    	}
	    	System.out.println("Res-"+i+"tw-"+totWords+"wc-"+wordCount+"ns-"+neededSpace+"div-"+divisor+"rem-"+reminder);
	    }
	 
	    System.out.println("Results");
	    for(int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
		}
	    String st =  "";
	    
	    curLine = new ArrayList<>();
	    for(int i=0;i<lines.size();i++) {
	    	curLine.add(String.join("",lines.get(i)));
	    }
	
	    return  curLine;
	}
}
