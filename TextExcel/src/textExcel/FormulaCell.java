package textExcel;

public class FormulaCell extends RealCell{
	
	private String formula;
	
	public FormulaCell() {
		
	}

	public String abbreviatedCellText() {
		if(formula.length() > 10) {
			return formula.substring(0, 10);
		}else {
			int numberOfSpaces = (10 - formula.length());
			for(int i = 0; i < numberOfSpaces; i++) {
				formula += " ";
			}
			return formula;
		}
	}

	public String fullCellText() {
		
		return formula;
	}

	public double getDoubleValue() {
		//calculateFormula();
		return 0;
	}

}
