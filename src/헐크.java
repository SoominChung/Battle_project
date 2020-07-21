import java.util.ArrayList;

public class 헐크 extends Player implements Throwable, Hittable {

	int 던지기 = 50;
	주먹 r = new 주먹("불주먹",80);
	
	public 헐크(String name) {
		this.name = name;
		this.setHp(500);
		this.setPower(80);
		
		this.setImgfile("C:\\Users\\kirin\\Desktop\\\uAC1D\uC9DA\uC774\uBBF8\uC9C0\\\uB0B4\uAC00 \uCC10 \uD5D0\uD06C\uB2E4.jpg");
	}
	
	public void 던지기(Player p) {
		p.setHp(p.getHp()-던지기);
		
	}
	
	public void 때리기(Player p) {
		
		p.setHp(p.getHp()-this.getPower());
	}


	public void attack(Player p) {
        
		cur_weapon = choose_Weapon();
        
        System.out.println(this.name+":  "+cur_weapon.name+"(으)로   "+p.name +" 공격!");
	    
        if(cur_weapon instanceof 주먹) this.때리기(p);
	    else {
	    	this.던지기(p);
	    	System.out.println(cur_weapon.name+"을 던졌음");}
        this.show_header();
		this.show();
		p.show();
        
		
	}
	
	public void attact_choose(Player p, Weapon w) {
		System.out.println(this.name+":  "+w.name+"(으)로   "+p.name +" 공격!");
		if(w instanceof 주먹) this.때리기(p);
	    else {
	    	this.던지기(p);
	    	System.out.println(w.name+"을 던졌음");}
		this.show_header();
		this.show();
		p.show();
	}

	public void settingWeapons(ArrayList<Weapon> garrage, int num) {

		setWeapons(r);
		for(int i =0;i<num;) {
			int k = (int)((Math.random()*10))%garrage.size();
			if(garrage.get(k) instanceof 망치 ) continue;
			setWeapons(garrage.get(k));
			i++;
		}
		//그 외의 무기들은 사용자가 지정한 숫자 만큼 추가적으로 공용 무기창고에서 가져온다.
	
		
	}


}
