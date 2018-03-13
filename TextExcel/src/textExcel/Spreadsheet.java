package textExcel;


public class Spreadsheet implements Grid{
	private Cell[][] arrayOfCells;

	public Spreadsheet() {
		arrayOfCells = new Cell[20][12];
	}
	public String processCommand(String command){
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
			column = column + 1;
		}
		for(int i = 0; i < getRows(); i++) {
			for(int j = 0; j < getCols(); j++) {
				
			}
		}
		return null;
	}

}
