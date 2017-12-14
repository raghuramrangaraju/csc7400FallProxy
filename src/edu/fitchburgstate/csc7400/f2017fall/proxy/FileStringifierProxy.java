/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 10
 * Students: Raghuram Rangaraju (@01377909), Vihar kodakandla (@01392814) 
 */

package edu.fitchburgstate.csc7400.f2017fall.proxy;

import java.io.PrintWriter;

/**
 * File stringifier proxy a placeholder for SlowFileStringifier
 */
public class FileStringifierProxy extends Thread {

	/**
	 * Create a file stringifier with a file name
	 * 
	 * @param filename file name of file
	 */
	public FileStringifierProxy(String filename){
		this.filename = filename;
		
	}
	
	/**
	 * Checking the real SlowFileStringifier object.
	 * 
	 * @param out the output print writer
	 */
	public void display(PrintWriter out) {
		this.out = out;
		if(slowFileStringifier == null){
			slowFileStringifier = new SlowFileStringifier(filename);
		} 
		readFile();
	}

	/**
	 * Prints the filename 
	 */
	public void readFile(){
			System.out.println("Reading "+ this.filename);
			
	}
	

	/**
	 *Thread for SlowStringifier display method
	 */
	@Override
	public void run() {
		slowFileStringifier.display(out);
	}
	
  private PrintWriter out;
  private SlowFileStringifier slowFileStringifier;
	private String filename;
	
}
