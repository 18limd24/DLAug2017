package textExcel;


public class Spreadsheet implements Grid{
	private Cell[][] arrayOfCells;

	public Spreadsheet() {
		arrayOfCells = new Cell[20][12];
	}
	public String processCommand(String command){
		if(command.length() == 2 || command.length() == 3) {
			command = command.toLowerCase();
			char column = command.charAt(0);
			int row = Integer.parseInt(command.substring(1));
			int columnNumber = column - 97;
			return arrayOfCells[row - 1][columnNumber].fullCellText();
		}else if(command.toLowerCase().equals("clear")) {
			new Spreadsheet();
			return getGridText();
		}else if(command.contains("=")) {
			
			
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
		String gridText = "";
		for(int i = 0; i<getRows(); i++) {
			char column = 'A';
			gridText += "|" + column + "        ";
			column = (char) (column + 1);
		}
		gridText += "\n";
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				gridText += "|" + arrayOfCells[i][j].abbreviatedCellText();
			}
			gridText += "\n" + (i + 1);
		}
		return gridText;
	}

}
