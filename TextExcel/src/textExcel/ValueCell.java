package textExcel;

public class ValueCell extends RealCell{
	
	private double value;
	
	public ValueCell(double value) {
		this.value = value;
	}
	
	public ValueCell(int value) {
		this.value = (double) value;
	}
	
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
		String answer = "" + value;
		return value;
	}

}
