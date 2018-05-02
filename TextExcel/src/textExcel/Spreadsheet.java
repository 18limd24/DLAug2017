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
	public String processCommand(String command){
		command = command.toLowerCase();
		if(command.length() == 2 || command.length() == 3) {
			//show cell
			char column = command.charAt(0);
			int row = Integer.parseInt(command.substring(1));
			int columnNumber = column - 97;
			return arrayOfCells[row - 1][columnNumber].fullCellText();
		}else if(command.toLowerCase().equals("clear")) {
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
				setFormula(command,cell);
			}else {
				setValue(command,cell);
			}
			return getGridText();
		}else if(command.toLowerCase().contains("clear") && command.length() > 5) {
			//clear A1
			String[] splitCommand = command.split(" ");
			SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[0]);
			
			clearCell(cell);
			return getGridText();
		}else if(command.toLowerCase().contains("%")) {
			//set percent
			
			return getGridText();
		}
		return "";
	}

	public int getRows(){
		return 20;
	}

	public int getCols(){
		return 12;
	}

	public Cell getCell(Location loc){
		return arrayOfCells[loc.getRow()][loc.getCol()];
	}
	public Cell getCell(int row, int col) {
		return arrayOfCells[row][col];
	}
	

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
	public void clear() {
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				arrayOfCells[i][j] = new EmptyCell();
			}
		}
	}
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
	public ArrayList<Cell> getCells(String cellRange){
		//cell range will be like c1-d5
		ArrayList<Cell> allCells = new ArrayList<Cell>();
		SpreadsheetLocation firstCellLocation = new SpreadsheetLocation(cellRange.substring(0, cellRange.indexOf("-")));
		SpreadsheetLocation secondCellLocation = new SpreadsheetLocation(cellRange.substring(cellRange.indexOf("-") + 1, cellRange.length()));
		
		
		int startingRow = firstCellLocation.getRow();
		int startingColumn = firstCellLocation.getCol();
		
		int endRow = secondCellLocation.getRow();
		int endColumn = secondCellLocation.getCol();
		
		for(int i = startingRow; i < endRow; i ++) {
			for(int j = startingColumn; j < endColumn; j ++) {
				Cell cell = (RealCell)(getCell(i,j));
				allCells.add(cell);
			}
		}
		return allCells;
	}

}
