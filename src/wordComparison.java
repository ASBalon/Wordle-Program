//Austin Balon
public class wordComparison {
	private int green;
	private int yellow;
	private boolean[] accounted={false,false,false,false,false};
	
	public wordComparison(String word1, String word2) {
		int prevIndex=0;
		green=0;
		yellow=0;
		for(int i=0;i<word1.length();i++)
			for(int j=0;j<word2.length();j++)
				if(word1.charAt(i)==word2.charAt(j) && !accounted[j]) {
					if(i==j)
						green++;
					else
						yellow++;
					accounted[j]=true;
				}
			
	}
	public int getGreen() {
		return green;
	}
	public int getYellow() {
		return yellow;
	}
	public double getScore() {
		return green+yellow;
	}
	public double getWeightedScore() {
		return green*1.5+yellow;
	}
	public double getSmartScore() {
		return green*(2-0.2*green)+yellow;
	}
}
