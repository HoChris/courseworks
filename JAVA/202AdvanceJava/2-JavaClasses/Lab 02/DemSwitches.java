package combuilder;

import java.util.Scanner;

public class DemSwitches {
	boolean letsGo = false;
	public Computer com = new Computer();//??
	public Memory memory = new Memory();//??
	public DemSwitches(){
	
		while(letsGo !=true){
		
		Scanner input = new Scanner(System.in);

		
		System.out.println("***********Main Menu************\n");
		System.out.println("\t 1. Choose a Case");
		System.out.println("\t 2. Choose a Monitor");
		System.out.println("\t 3. Choose a CPU");
		System.out.println("\t 4. Choose a Video Card");
		System.out.println("\t 5. Choose a Hard Drive");
		System.out.println("\t 6. Choose a Memory");
		System.out.println("\t 7. Delete Current Build");
		System.out.println("\t 8. Display Receipt");
		System.out.println("\t 9. Exit Program");
		System.out.println("\n********************************");
		System.out.print("Please choose an option to build the computer: ");
		int num = input.nextInt();
		
		switch (num) {
		case 1: System.out.println("**********************Case Menu***********************");
				System.out.println("1. Antec Twelve Hundred V3\nType: ATX Full Tower\nDimensions: 20.2\" x 8.39\" x 22.87\""
						+ "\nPrice:.............................................$154.99");
				System.out.println("2. BitPhenix Phenom M Arctic White\nType: MicroATX Mini Tower\nDimensions: 9.8\" x 12.95\" x 14.69\""
						+ "\nPrice:.............................................$89.99");
				System.out.println("3. Corsair 250D\nType: MiniITX Tower\nDimensions: 13.8\" x 10.9\" x 11.4\""
						+ "\nPrice:.............................................$99.9");
				System.out.println("******************************************************"+
						"\n******************************************************");
				int num2 = input.nextInt();
						switch (num2) {
								case 1:
							Case c1= new Case("Antec Twelve Hundred V3",20.2, 8.39,22.87,"ATX Full Tower",154.99);
								
							break;
						case 2:
							Case c2= new Case("BitPhenix Phenom M Arctic White",9.8,12.95,14.69,"MicroATX Mini Tower",89.99);
							break;
						case 3:
							Case c3= new Case("Corsair 250D",13.8,10.9,11.4,"MiniITX Tower",99.99);
							break;
						default: System.out.println("You Didnt pick a Case.");
							break;
						}//end of case
			break;//break 1
		case 2: System.out.println("**********************Monitor Menu***********************"); 
				System.out.println("1. Asus PB278Q\nSize: 27.0\"\nPrice:.............................................$549.99");
				System.out.println("2. Dell U2412M\nSize: 24.0\"\nPrice:.............................................$263.99");
				System.out.println("3. Samsung S22C300H\nSize: 21.5\"\nPrice:.............................................$139.99");
				System.out.println("******************************************************"+
						"\n\n******************************************************");
				int num3 = input.nextInt();
						switch (num3) {
						case 1:
							Monitor m1 = new Monitor("Asus PB278Q",27.0,549.99);
							break;
						case 2:
							Monitor m2 = new Monitor("Dell U2412M",24.0,263.99);
							break;
						case 3:
							Monitor m3 = new Monitor("Samsung S22C300H", 21.5, 139.99);
							break;
						default: System.out.println("You Didnt pick a Monitor");
							break;
						}
			break;//end Monitor
		case 3: System.out.println("**********************CPU Menu***********************"); 
				System.out.println("1. AMD FX-8350\nSpeed: 4.0GHz\nPrice:.............................................$188.99");
				System.out.println("2. Intel Core i5-3570K\nSpeed: 3.4GHz\nPrice:.............................................$179.99");
				System.out.println("3. Intel Core i7-3770K\nSpeed: 3.5GHz\nPrice:.............................................$249.99");
				System.out.println("******************************************************"+
						"\n******************************************************");
				int num4 = input.nextInt();
						switch (num4) {
						case 1:
							CPU cc1 = new CPU("AMD FX-8350",4.0,188.99);
							break;
						case 2:
							CPU cc2 = new CPU("Intel Core i5-3570K",3.4,179.99);
							break;
						case 3:
							CPU cc3 = new CPU("Intel Core i7-3770K", 3.5, 249.99);
							break;
						default: System.out.println("You Didnt pick a CPU");
							break;
				}
		break;// end CPU
		case 4: System.out.println("**********************Video Card Menu***********************"); 
				System.out.println("1. Nvidia GeForce GTX 770\nMemory Size: 2.0GB\nPrice:.............................................$346.99");
				System.out.println("2. Nvidia GeForce GTX 670\nMemory Size: 2.0GB\nPrice:.............................................$333.99");
				System.out.println("3. AMD Radeon HD 7950\nMemory Size: 3.0GB\nPrice:.............................................$399.99");
				System.out.println("******************************************************"+
						"\n******************************************************");
				int num5 = input.nextInt();
						switch (num5) {
						case 1:
							VideoCard v1 = new VideoCard("Nvidia GeForce GTX 770",2,346.99);
							break;
						case 2:
							VideoCard v2 = new VideoCard("Nvidia GeForce GTX 670",2,333.99);
							break;
						case 3:
							VideoCard v3 = new VideoCard("AMD Radeon HD 7950", 3, 399.99);
							break;
						default: System.out.println("You Didnt pick a Video Card");
							break;
		}
		break;//end Vid
		case 5: System.out.println("**********************Hard Drive Menu***********************"); 
				System.out.println("1. Samsung MZ-7PD256BW\nSize: 256GB\nPrice:.............................................$199.99");
				System.out.println("2. Corsair CSSD-F240GBGT-BK\nSize: 240GB\nPrice:.............................................$206.99");
				System.out.println("Crucial CT128M4SSD1\nSize: 128GB\nPrice:.............................................$199.95");
				System.out.println("******************************************************"+
						"\n******************************************************");
				int num6 = input.nextInt();
						switch (num6) {
						case 1:
							HardDrive h1 = new HardDrive("Samsung MZ-7PD256BW",256,199.99);
							break;
						case 2:
							HardDrive h2 = new HardDrive("Corsair CSSD-F240GBGT-BK",240,206.99);
							break;
						case 3:
							HardDrive h3 = new HardDrive("Crucial CT128M4SSD1", 128, 199.95);
							break;
						default: System.out.println("You Didnt pick a Hard Drive");
							break;
						}
		break;//end HardD
		case 6: System.out.println("**********************Memory Menu***********************"); 
				System.out.println("1. Corsair Vengeance\nSize: 8GB\nPrice:.............................................$69.99");
				System.out.println("2. G.Skill Ares Series\nSize: 16GB\nPrice:.............................................$149.99");
				System.out.println("3. Kingston Black Series\nSize: 8GB\nPrice:.............................................$79.99");
				System.out.println("******************************************************"+
						"\n******************************************************");
				int num7 = input.nextInt();
						switch (num7) {
						case 1:
							memory= new Memory("Corsair Vengeance",8,69.99);
							break;
						case 2:
							memory = new Memory("G.Skill Ares Series",16,149.99);
							break;
						case 3:
							memory= new Memory("Kingston Black Series", 8, 79.99);
							break;
						default: System.out.println("You Didnt pick a Memory");
							break;
						}
		break;//end Mem
		case 7:	Computer com1 = new Computer();
				System.out.println("All Selections have been cleared. Begin Again.");
			break;
		case 8: com.displayReceipt();
			break;
		case 9: letsGo = true;
				System.out.println("EXITING NOW.");
			break;
		default:	System.out.println("Please enter a number 1-9 to choose from the Menu.");
			break;
		}//end of the whole switch
}//end of while loop

}
}
