/*Darren Lim
 * May 7, 2018
 * Spreadsheet will hold/store the grid in a 20 row 12 column sheet
 */

package textExcel;

import java.util.ArrayList;

public class Spreadsheet implements Grid{
	private Cell[][] arrayOfCells;

	public Spreadsheet() {
		arrayOfCells = new Cell[20][12];
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				arrayOfCells[i][j] = new EmptyCell();
			}
		}
	}
	//process command takes in the command and processes it
	//if command is 
	//A1 show cell
	//a1 = then sets cell to correct type
	//clear then clears whole sheet, or clear A1 to clear the cell
	public String processCommand(String command){
		//keeps original command for formula cell
		String originalCommand = command;
		command = command.toUpperCase();
		if(command.length() == 2 || command.length() == 3) {
			//show cell
			char column = command.charAt(0);
			int row = Integer.parseInt(command.substring(1));
			int columnNumber = column - 65;
			return arrayOfCells[row - 1][columnNumber].fullCellText();
			
		}else if(command.toUpperCase().equals("CLEAR")) {
			clear();
			return getGridText();
			
		}else if(command.contains("=")) {
			//set with =
			String[] splitCommand = command.split(" ");
			SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[0]);
			
			if(command.contains("\"")) {
				setText(command,cell);
			}else if(command.contains("%")) {
				setPercent(command,cell);
			}else if(command.contains("(")) {
				//sends in non-Uppercase version for formula cell
				setFormula(originalCommand,cell);
			}else {
				setValue(command,cell);
			}
			return getGridText();
			
		}else if(command.toUpperCase().contains("CLEAR") && command.length() > 5) {
			//clear A1
			String[] splitCommand = command.split(" ");
			SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[0]);
			
			clearCell(cell);
			return getGridText();
		}else if(command.toUpperCase().contains("%")) {
			//set percent
			
			return getGridText();
		}
		return "";
	}
	//returns number of rows
	public int getRows(){
		return 20;
	}
	//returns number of columns
	public int getCols(){
		return 12;
	}
	//gets the cell if given a spreadsheetLocation
	public Cell getCell(Location loc){
		return arrayOfCells[loc.getRow()][loc.getCol()];
	}
	//gets cell if given the location via row and column number
	public Cell getCell(int row, int col) {
		return arrayOfCells[row][col];
	}
	
	//returns full grid text
	public String getGridText(){//use abbbreviatedCellText method
		String gridText = "   ";
		for(char i = 'A'; i <= 'L'; i++) {
			gridText += "|" + i + "         ";
			
		}
		gridText += "|";
		for (int i = 0; i < getRows(); i++) {
			gridText += "\n";
			if (i < 9) {
				gridText += (i + 1) + "  |";
			} else {
				gridText += (i + 1) + " |";
			}
			for (int j = 0; j < getCols(); j++) {
				gridText += arrayOfCells[i][j].abbreviatedCellText() + "|";
			}
			
		}
		gridText += "\n";
		return gridText;
		
	}
	//clears entire spreadsheet
	public void clear() {
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				arrayOfCells[i][j] = new EmptyCell();
			}
		}
	}
	//all set methods send in the command and the location of the cell
	//command is in UPPERCASE except for formula cell
	//commands are still in "a1 = whatever" form
	public void setText(String command, SpreadsheetLocation cell) {
		arrayOfCells[cell.getRow()][cell.getCol()] = new TextCell(command.substring(command.indexOf("\"") + 1, command.length() - 1));			
	}
	public void setPercent(String command, SpreadsheetLocation cell) {
		arrayOfCells[cell.getRow()][cell.getCol()] = new PercentCell(command);
	}
	public void clearCell(SpreadsheetLocation cell) {
		arrayOfCells[cell.getRow()][cell.getCol()] = new EmptyCell();
	}
	public void setFormula(String command, SpreadsheetLocation cell) {
		arrayOfCells[cell.getRow()][cell.getCol()] = new FormulaCell(command, this);
	}
	public void setValue(String command, SpreadsheetLocation cell) {
		arrayOfCells[cell.getRow()][cell.getCol()] = new ValueCell(command);
	}
	//used for the sum and average for formula cells. takes the cell range and returns an arraylist of cells
	public ArrayList<Cell> getCells(String cellRange){
		//cell range will be like c1-d5
		ArrayList<Cell> allCells = new ArrayList<Cell>();
		SpreadsheetLocation firstCellLocation = new SpreadsheetLocation(cellRange.substring(0, cellRange.indexOf("-")));
		SpreadsheetLocation secondCellLocation = new SpreadsheetLocation(cellRange.substring(cellRange.indexOf("-") + 1, cellRange.length()));
		
		
		int startingRow = firstCellLocation.getRow();
		int startingColumn = firstCellLocation.getCol();
		
		int endRow = secondCellLocation.getRow();
		int endColumn = secondCellLocation.getCol();
		
		for(int i = startingRow; i <= endRow; i ++) {
			for(int j = startingColumn; j <= endColumn; j ++) {
				Cell cell = (getCell(i,j));
				allCells.add(cell);
			}
		}
		return allCells;
	}

}
