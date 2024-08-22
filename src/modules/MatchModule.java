package modules;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatchModule {
	private static Scanner sc = new Scanner(System.in);
	//TODO: databaselerin hangisi gelecek ise onları eklemelisin
	
	public static int matchModule() {
		//TODO: databaselerin hangisi gelecek ise onları eklemelisin
		int opt = 0;
		opt = matchModuleMenuOptions(matchModuleMenu());
		return opt;
	}
	public static int matchModuleMenu(){
		while (true){
			System.out.println("### Match Module MENU ###");
			System.out.println("1- Look for Fixture");
			System.out.println("2- List All Leagues");
			System.out.println("0- Return Main Menu...");
			System.out.print("selection: ");
			int opt ;
			try {
				opt = sc.nextInt();
				return opt;
			}catch (InputMismatchException e){
				System.out.println("Please enter a numaric value!");
			}
			finally {
				sc.nextLine();
			}
		}
		
	}
	public static int matchModuleMenuOptions(int opt){
		switch (opt){
			case 1:{ //Look for Fixture
				//TODO: Eğer fixture yoksa fixture yok desin.
				//TODO: Eğer fixture varsa onu listelesin
				break;
			}
			case 2:{ //List All Leagues
				//TODO:League Module içersine yönlendir.
				break;
			}
			case 3:{ //Generate Fixture
				break;
			}
			case 0:{
				System.out.println("Returning to main menu...");
				return opt;
			}
			default:
				System.out.println("Please enter a valid value!");
		}
		return opt;
	}
}