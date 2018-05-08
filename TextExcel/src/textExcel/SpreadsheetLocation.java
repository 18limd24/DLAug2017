/*Darren Lim
 * May 7, 2018
 * implements location to hold the location of a cell
 */
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
    //takes the cell name like a1 or c12 in a string form
    //should ignore case
    public SpreadsheetLocation(String cellName){
    	cellName = cellName.toLowerCase();
    	this.cellName = cellName;
        row = Integer.parseInt(cellName.substring(1)) -1;
        column = cellName.toLowerCase().charAt(0) - 97;
    }
}
