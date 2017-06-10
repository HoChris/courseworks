package combuilder;

public class Monitor {

		private String name;
		private double size;
		private double price;
		
		public Monitor(){
			this.name = "Default Generic Monitor";
			this.size = 0.0;
			this.price = 0.0;
		}
		
		public Monitor(String name, double size, double price) {	
			this.name = name;
			this.size = size;
			this.price = price;
		}

		public String getName() {
			return this.name;
		}

		public double getSize() {
			return this.size;
		}

		public double getPrice() {
			return this.price;
		}

	
		public String toString() {
			return "Monitor" + getName() + "\n\tSize: " + getSize() + "\"" + "\n\tPrice:.........................$" + getPrice();
		}
		
		
}
