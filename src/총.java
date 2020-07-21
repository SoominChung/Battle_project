public class ÃÑ extends Weapon{
    private int ÃÑ¾Ë;
    
    public ÃÑ() {
    	this.setPower(80);
    }
    
    public ÃÑ(String name) {
	      super(name,80);
	 }
    
    public ÃÑ(String name, int ÃÑ¾Ë) {
    	super(name,80);
    	this.setÃÑ¾Ë(ÃÑ¾Ë);
    }

	public int getÃÑ¾Ë() {
		return ÃÑ¾Ë;
	}

	public void setÃÑ¾Ë(int ÃÑ¾Ë) {
		this.ÃÑ¾Ë = ÃÑ¾Ë;
	}


}
