package textExcel;


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
		if(command.length() == 2 || command.length() == 3) {
			//show cell
			command = command.toLowerCase();
			char column = command.charAt(0);
			int row = Integer.parseInt(command.substring(1));
			int columnNumber = column - 97;
			return arrayOfCells[row - 1][columnNumber].fullCellText();
		}else if(command.toLowerCase().equals("clear")) {
			clear();
			return getGridText();
		}else if(command.contains("=")) {
			//set with =
			if(command.contains("\"")) {
				setText(command);
			}else if(command.contains("%")) {
				setPercent(command);
			}else if(command.contains("(")) {
				setFormula(command);
			}else {
				setValue(command);
			}
			return getGridText();
		}else if(command.toLowerCase().contains("clear") && command.length() > 5) {
			//clear A1
			clearCell(command);
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
	public void setText(String command) {
		String[] splitCommand = command.split(" ");
		SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[0]);
		int row = cell.getRow();
		int col = cell.getCol();
		arrayOfCells[row][col] = new TextCell(command.substring(command.indexOf("\"") + 1, command.length() - 1));			
	}
	public void setPercent(String command) {
		String[] splitCommand = command.split(" ");
		SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[0]);
		arrayOfCells[cell.getRow()][cell.getCol()] = new PercentCell(command);
	}
	public void clearCell(String command) {
		String[] splitCommand = command.split(" ");
		SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[1]);
		arrayOfCells[cell.getRow()][cell.getCol()] = new EmptyCell();
	}
	public void setFormula(String command) {
		String[] splitCommand = command.split(" ");
		SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[0]);
		arrayOfCells[cell.getRow()][cell.getCol()] = new FormulaCell(command);
	}
	public void setValue(String command) {
		String[] splitCommand = command.split(" ");
		SpreadsheetLocation cell = new SpreadsheetLocation(splitCommand[0]);
		arrayOfCells[cell.getRow()][cell.getCol()] = new ValueCell(command);
	}

}
