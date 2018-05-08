/*Darren Lim
 * May 7, 2018
 * this is a cell -> real cell -> formula cell
 * 
 */

package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell{
	
	private String formula;
	private String originalFormula;
	private Spreadsheet spreadsheet;
	
	public FormulaCell(String command, Spreadsheet spreadsheet) {
		super(command);
		this.originalFormula = command.substring(command.indexOf("(") + 1, command.indexOf(")"));
		this.formula = command.substring(command.indexOf("(") + 1, command.indexOf(")")).toUpperCase();
		//I want the field to exclude the parentheses
		this.spreadsheet = spreadsheet;
	}
	//abbreviated cell text will return the double value calculated
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
	//full cell text reveals the entered formula (with the same cases)
	public String fullCellText() {
		
		return "(" + originalFormula + ")";
	}

	public double getDoubleValue() {		
		String[] splitFormula = formula.split(" ");
		//every odd number of splitformula will be an operator
		//should ignore first index because it is a parentheses
		//should getDoubleValue of all first
		if(splitFormula[1].toUpperCase().contains("SUM")) {
			return sum(splitFormula);
		}else if(splitFormula[1].toUpperCase().contains("AVG")) {
			return (sum(splitFormula)) / spreadsheet.getCells(splitFormula[2]).size();
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
	//sends in split formula
	//first a parentheses and then SUM or AVG 
	//then something like c1-a4
	public double sum(String[] splitFormula) {
		double answer = 0.0;
		String cellRange = splitFormula[2];
		ArrayList<Cell> allCells = spreadsheet.getCells(cellRange);
		for(Cell c: allCells) {
			if(c instanceof RealCell) {
				RealCell cell = (RealCell) (c);
				answer += cell.getDoubleValue();
			}
			
			
		}
		return answer;
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
