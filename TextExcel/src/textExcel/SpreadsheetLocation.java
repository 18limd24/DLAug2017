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
    	cellName = cellName.toLowerCase();
    	this.cellName = cellName;
        row = Integer.parseInt(cellName.substring(1)) -1;
        column = cellName.toLowerCase().charAt(0) - 97;
    }
    //public SpreadsheetLocation() {
    	
    //}

}
