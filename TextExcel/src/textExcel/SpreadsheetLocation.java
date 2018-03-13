package textExcel;

public class SpreadsheetLocation implements Location{
	private String cellName;
	private int row;
	private int column;
	
    public int getRow(){
        return row;
    }

    public int getCol(){
        return column;
    }
    
    public SpreadsheetLocation(String cellName){
    	this.cellName = cellName;
        row = Integer.parseInt(cellName.substring(1)) -1;
        column = cellName.charAt(0) - 65;
    }

}
