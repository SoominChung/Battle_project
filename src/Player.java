import java.util.ArrayList;

public abstract class Player{
    public String name;
    private int hp;
    private int power;
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private String imgfile;
    public  Weapon cur_weapon;
    

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public String getImgfile() {
		return imgfile;
	}
	
	public void setImgfile(String s) {
		this.imgfile = s;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	
	public void setWeapons(Weapon w) {
		this.weapons.add(w);
		
	}
	
	public void removeWeapons(Weapon w) {
		this.weapons.remove(w);
	}
	
	//각 캐릭터마다 디폴트 무기나 필살기가 존재하는 캐릭터가 있으므로 구현이 다 달라서 abstract로 설정해놓고
	//각 캐릭터에서 직접 셋팅
	public abstract void settingWeapons(ArrayList<Weapon> garrage, int num);
	
    public abstract void attack(Player p);
	    
    public abstract void attact_choose(Player p, Weapon w);
    
	public Weapon choose_Weapon() {
		int a = this.weapons.size();
		int rand = (int)((Math.random()*10))%a;
		return this.weapons.get(rand);
	}
	
	public void show_header() {
		System.out.println("-------------------------------------");
    	System.out.printf("%10s %10s %12s\n","이름","hp","power") ;
    	System.out.println("-------------------------------------");
	}
	
	
    public void show() {
    	System.out.printf("%10s%10d%10d",this.name,this.getHp(),this.getPower()) ;
        System.out.println();
   }

   public void show_w() {
	   System.out.println("=====================================");
	   System.out.println(">>>>>>>"+this.name+" 무기창고");
	   System.out.println("-------------------------------------");
	   
	   System.out.printf("%10s %10s\n", "무기이름", "무기power");
	   System.out.println("-------------------------------------");
	   for(int i=0; i<weapons.size();i++) {
		  
		   System.out.printf("%10s %10d\n", weapons.get(i).name, weapons.get(i).getPower());
	   }

	   System.out.println("=====================================");
   }
    
    
	
}
	    
 
