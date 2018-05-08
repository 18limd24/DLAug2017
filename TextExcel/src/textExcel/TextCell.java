/*Darren Lim
 * May 7 2018
 * a cell that stores text
 * must take command between parentheses
 */
package textExcel;

public class TextCell implements Cell {
	
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}

	public String abbreviatedCellText() {
		if(text.length() < 10) {
			int numberOfSpaces = 10 - text.length();
			String spaces = "";
			for(int i = 0; i < numberOfSpaces; i++) {
				spaces += " ";
			}
			return text + spaces;
		}else if(text.length() == 10) {
			return text;
		}else{// if(text.length() > 10) 
			return text.substring(0, 10);
		}
	}
	//only shows parentheses here
	public String fullCellText() {
		
		return "\"" + text + "\"";
	}
	

}
