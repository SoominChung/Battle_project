public class 활 extends Weapon {
    private int 화살;

	public 활() {
		this.setPower(40);
		
	}
	
	public 활(String name) {
	      super(name,40);
	      
	 }

	public 활(String name, int 화살) {
		super(name);
		this.set화살(화살);
		this.setPower(40);
	}
	
	public int get화살() {
		return 화살;
	}
	
	public void set화살(int 화살) {
		this.화살 = 화살;
	}
	


}
