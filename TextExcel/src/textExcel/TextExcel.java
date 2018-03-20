package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel{

	public static void main(String[] args){
	    Scanner console = new Scanner(System.in);
	    System.out.println("Welcome to TextExcel, the cheaper WordExcel!");
	    System.out.println("To use, enter a command, or type \"quit\" to exit");
	    Spreadsheet spreadsheet = new Spreadsheet();
	    //TestsALL.Helper th = new TestsALL.Helper();
	    //System.out.println(th.getText());
	    //System.out.println(spreadsheet.getGridText());
	    String next = console.nextLine();

	    while(!next.equalsIgnoreCase("quit")) {
	    	
	    	System.out.println(spreadsheet.processCommand(next));
	    	next = console.nextLine();
	    }
	    System.out.println("System quit");
	    //System.exit(1);
	}
}
