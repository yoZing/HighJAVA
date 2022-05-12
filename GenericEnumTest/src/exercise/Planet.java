package exercise;

public enum Planet {
	수성(2439), 
	금성(6052), 
	지구(6371), 
	화성(3390), 
	목성(69911), 
	토성(58232), 
	천왕성(25362), 
	해왕성(24622);
	
	private double redius;

	private Planet(double redius) {
		this.redius = redius;
	}

	public double getRedius() {
		return redius;
	}
	
	public static void main(String[] args) {
		
		
		for (Planet area : Planet.values()) {
			System.out.println(area);
			System.out.println(area.getRedius());
			System.out.println(area + " : " + area.getRedius()*area.getRedius()*4*Math.PI);
		}
		
		
	}
	
	
	
}
