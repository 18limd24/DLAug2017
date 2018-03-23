package textExcel;

public class PercentCell extends RealCell{
	
	private double percent;
	
	public PercentCell(String command) {
		super(command);
		percent = Double.parseDouble(command.toLowerCase().substring(beginIndex, command.indexOf('%')));
	}

	public String abbreviatedCellText() {
		String answer = ""+ percent;
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
		
		return percent + "";
	}

	public double getDoubleValue() {
		
		return percent;
	}

}
