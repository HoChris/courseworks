package combuilder;

public class Computer {

	private Case towerCase;//these are for the objects
	private Monitor monitor;
	private CPU cpu;
	private VideoCard videoCard;
	private HardDrive hardDrive;
	private Memory memory;
	
	
	public Computer(){
		towerCase = new Case();
		monitor = new Monitor();
		cpu = new CPU();
		videoCard = new VideoCard();
		hardDrive = new HardDrive();
		memory = new Memory();
	}

	public Computer(Case towerCase, Monitor monitor, CPU cpu,
			VideoCard videoCard, HardDrive hardDrive, Memory memory) {
		this.towerCase = towerCase;
		this.monitor = monitor;
		this.cpu = cpu;
		this.videoCard = videoCard;
		this.hardDrive = hardDrive;
		this.memory = memory;
	}


	public Case getTowerCase() {
		return this.towerCase;
	}

	public Monitor getMonitor() {
		return this.monitor;
	}

	public CPU getCpu() {
		return this.cpu;
	}

	public VideoCard getVideoCard() {
		return this.videoCard;
	}

	public HardDrive getHardDrive() {
		return this.hardDrive;
	}

	public Memory getMemory() {
		return this.memory;
	}

//	public double getTotalCost(){
//		return something;
//	}

	public void displayReceipt(){
		
		System.out.println("hhelo" + memory.toString());
		

	}
}
