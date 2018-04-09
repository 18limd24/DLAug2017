package textExcel;

public class FormulaCell extends RealCell{
	
	private String formula;
	
	public FormulaCell(String command) {
		super(command);
		this.formula = command.substring(command.indexOf("(") + 1, command.indexOf(")")).toUpperCase();
		//I want the field to exclude the parentheses
	}

	public String abbreviatedCellText() {
		/*formula = "(" + formula + ")";
		if(formula.length() > 10) {
			return formula.substring(0, 10) ;
		}else {
			int numberOfSpaces = (10 - formula.length());
			for(int i = 0; i < numberOfSpaces; i++) {
				formula += " ";
			}
			return formula;
		}
		*/
		String answer = "" + getDoubleValue();
		if(answer.length() > 10) {
			return answer.substring(0, 10) ;
		}else {
			int numberOfSpaces = (10 - answer.length());
			for(int i = 0; i < numberOfSpaces; i++) {
				answer += " ";
			}
			return answer;
		}
	}

	public String fullCellText() {
		
		return "(" + formula + ")";
	}

	public double getDoubleValue() {
		//calculateFormula();
		
		String[] splitFormula = formula.split(" ");
		//every odd number of splitformula will be an operator
		//should ignore first index because it is a parentheses
		//should getDoubleValue of all first
		for(int i = 0; i < splitFormula.length; i++) {
			if((splitFormula[i].length() == 2 || splitFormula[i].length() == 3) && splitFormula[i].) {
				
			}
		}
		double result = Double.parseDouble(splitFormula[1]);
		for(int i = 1; i + 2 < splitFormula.length; i+= 2) {//will go through odd indexes
			
				if (splitFormula[i + 1].equals("+")) {
					result += Double.parseDouble(splitFormula[i + 2]);
				} else if (splitFormula[i + 1].equals("-")) {
					result -= Double.parseDouble(splitFormula[i + 2]);					
				} else if (splitFormula[i + 1].equals("*")) {
					result *= Double.parseDouble(splitFormula[i + 2]);
				} else if (splitFormula[i + 1].equals("/")) {
					result /= Double.parseDouble(splitFormula[i + 2]);
				}
			
		}
		return result;
	}

}
