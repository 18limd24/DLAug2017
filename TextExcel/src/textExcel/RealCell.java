package textExcel;

public abstract class RealCell implements Cell{
	
	private String command;
	
	public RealCell(String command) {
		this.command = command;
	}

	public abstract String abbreviatedCellText();

	public abstract String fullCellText();

	public abstract double getDoubleValue();
	
	public String getCommand() {
		return this.command;
	}
}
