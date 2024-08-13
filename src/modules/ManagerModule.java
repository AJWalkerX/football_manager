package modules;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerModule {
	static Scanner sc = new Scanner(System.in);
	static int userInput;
	public static void managerMenu(){
		System.out.println("### Menager Menu ###");
		System.out.println("1-Choose Your Team");
		System.out.println("2-Change your Team");
		System.out.println("3-Team Manager");
		System.out.println("4-Team Status");
		System.out.print("selection: ");
		try {
			userInput = sc.nextInt();
		}catch (InputMismatchException e){
		
		}finally {
		
		}
		
	}
}