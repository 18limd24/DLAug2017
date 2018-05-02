package textExcel;

public class FormulaCell extends RealCell{
	
	private String formula;
	private Spreadsheet spreadsheet;
	
	public FormulaCell(String command, Spreadsheet spreadsheet) {
		super(command);
		this.formula = command.substring(command.indexOf("(") + 1, command.indexOf(")")).toUpperCase();
		//I want the field to exclude the parentheses
		this.spreadsheet = spreadsheet;
	}

	public String abbreviatedCellText() {
		
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
		if(splitFormula[1].contains("SUM")) {
			return sum(splitFormula);
		}else if(splitFormula[1].contains("AVG")) {
			return average(splitFormula);
		}
		for(int i = 0; i < splitFormula.length; i++) {
			if((splitFormula[i].length() == 2 || splitFormula[i].length() == 3) && (splitFormula[i].toUpperCase().charAt(0) >= 65 || 
					splitFormula[i].toUpperCase().charAt(0) <= 90)) {
				//recognizes if first index is gonna be a letter
				//now we have the cell
				splitFormula[i] = "" + stringToDouble(splitFormula[i]);
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
	public double average(String[] splitFormula) {
		/*SpreadsheetLocation firstCellLocation = new SpreadsheetLocation(splitFormula[2].substring(0, splitFormula[2].indexOf("-")));
		SpreadsheetLocation secondCellLocation = new SpreadsheetLocation(splitFormula[2].substring(splitFormula[2].indexOf("-"), splitFormula[2].indexOf(" ")));
		int startingRow = firstCellLocation.getRow();
		int startingColumn = firstCellLocation.getCol();
		
		int endRow = secondCellLocation.getRow();
		int endColumn = secondCellLocation.getCol();
		
		double answer = 0.0;
		for(int i = startingRow; i < endRow; i ++) {
			for(int j = startingColumn; j < endColumn; j ++) {
				//Cell cell = spreadsheet.getCell(loc);
				//so this for loop would get a cell and then get double value and add to average
				//how would I send in a loc
				
			}
		}*/
		double answer = 0.0;
		splitFormula[2].substring(0, splitFormula[2].indexOf("-"));
		return answer;
	}
	
	//sends in split formula
	//first a parentheses and then SUM or AVG 
	//then something like c1-a4
	public double sum(String[] splitFormula) {
		double answer = 0.0;
		splitFormula[2].substring(0, splitFormula[2].indexOf("-"));
		return 0.0;
	}
	public double stringToDouble(String command) {
		double result;
		if(Character.isDigit(command.charAt(0)) || command.charAt(0) == '-') {
			//if command is a number, like "47"
			result = Double.parseDouble(command);
		}else {
			//if command is a cell
			result = ((RealCell)spreadsheet.getCell(new SpreadsheetLocation(command))).getDoubleValue();
		}
		return result;
	}

}
