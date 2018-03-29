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
		
		//return "(" + formula + ")";
		return "" + getDoubleValue();
	}

	public double getDoubleValue() {
		//calculateFormula();
		
		String[] splitFormula = formula.split(" ");
		//every odd number of splitformula will be an operator
		double result = Double.parseDouble(splitFormula[0]); 
		for(int i = 0; i < splitFormula.length; i+= 2) {//will go through even numbers
			if (splitFormula.length > i + 1) {
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
		}
		return result;
	}

}
