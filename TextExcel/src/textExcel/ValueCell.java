package textExcel;

public class ValueCell extends RealCell{
	
	private double value;
	
	public ValueCell(String command) {//should I make it accept double or a string command
		super(command);
		this.value = Double.parseDouble(command.substring(command.indexOf("=") + 1));
	}
	
	/*public ValueCell(String command) {
		super(command);
		this.value = (double) value;
	}*/
	
	public String abbreviatedCellText() {
		String answer = ""+ value;
		if(answer.length() > 10) {
			return answer.substring(0, 10);
		}else {
			int numberOfSpaces = (10 - answer.length());
			for(int i = 0; i < numberOfSpaces; i++) {
				answer += " ";
			}
			return answer;
		}
	}

	public String fullCellText() {
		String answer = "";
		//if(getDoubleValue() % 1 == 0.0) {
		//	answer += (int)getDoubleValue();
		//}else {
			answer += getDoubleValue();
		//}
		return answer;
	}

	public double getDoubleValue() {
		return this.value;
	}

}
