public class Weapon {
    public String name;
    private int power;

    public Weapon() {};
    public Weapon(String name) {
    	this.name= name;
    };
    public Weapon(String name, int power) {
    	this.name = name;
    	setPower(power);
    }
    public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
