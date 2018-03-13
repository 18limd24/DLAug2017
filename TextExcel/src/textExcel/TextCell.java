package textExcel;

public class TextCell implements Cell {
	
	private String text;

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

	public String fullCellText() {
		
		return "\"" + text + "\"";
	}
	

}
