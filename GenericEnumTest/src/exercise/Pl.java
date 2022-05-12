package exercise;

public enum Pl {
	수성(2439), 
	금성(6052), 
	지구(6371), 
	화성(3390), 
	목성(69911), 
	토성(58232), 
	천왕성(25362), 
	해왕성(24622);
	
	private double rdu;
	
	private Pl(double rdu) {
		this.rdu = rdu;
	}

	public double getRdu() {
		return rdu;
	}
	
	public static void main(String[] args) {
		
		for (Pl pl : Pl.values()) {
			System.out.println(pl + "의 면적은 " + pl.getRdu()*pl.getRdu()*Math.PI*4 + " 입니다.");
		}
		
//		r*r*Math.PI*4
		
		
	}
	
}
