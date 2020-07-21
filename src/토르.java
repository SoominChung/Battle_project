import java.util.ArrayList;

public class 토르 extends Player implements Hittable, Useable{
	int 망치쓰기 = 90;
	int 칼다루기 =10;
	주먹 r = new 주먹("주먹",60);
	망치 h = new 망치("망치_토르 스페셜",140);
	Weapon 술 = new Weapon("술",-10);
	Weapon 필살기 = new Weapon("필살기",150);
	//토르의 특별한 공격 메소드 두 가지를 실현하기 위한 무기도 넣어둔다.
	
	public 토르(String name) {
		this.name = name;
		this.setHp(500);
		this.setPower(60);
		this.setImgfile("C:\\Users\\kirin\\Desktop\\\uAC1D\uC9DA\uC774\uBBF8\uC9C0\\\uADF8\uB9BC01.jpg");
	}

    public void 술마시기(){
    	//술마시면 자신의 HP가 떨어지게 구현하기
    	this.setHp(this.getHp()+술.getPower());
    }
    
	public void 때리기(Player p) {
		p.setHp(p.getHp()-this.getPower());
	}


	public void 사용하기(망치 w, Player p) {
		p.setHp(p.getHp()-망치쓰기);
	}
	
	public void 사용하기(칼 w, Player p) {
		p.setHp(p.getHp()-w.getPower()-this.칼다루기);
	}
	
	public void 사용하기(Weapon t, Player p) {
		if(t.name == "필살기") p.setHp(p.getHp()-t.getPower());
	}


	public void attack(Player p) {
		
	    cur_weapon = choose_Weapon();
	    
	    System.out.println(this.name+":  "+cur_weapon.name+"(으)로   "+p.name +" 공격!");
	   
	    if(cur_weapon instanceof 망치) {
	    	this.사용하기(cur_weapon, p);
	    }
	    if(cur_weapon instanceof 주먹) {
	    	this.때리기(p);
	    }
	    if(cur_weapon instanceof 칼) {
	    	this.사용하기(cur_weapon, p);
	    }
	    if(cur_weapon.name == "필살기") {
        	this.사용하기(cur_weapon, p);
	    }
	    
	    if(cur_weapon.name == "술") {
	    	this.술마시기();
	    	System.out.println("술에 취해 상대를 공격 못하고 자신의 HP가 닳았습니다.");
	    }
	    this.show_header();
		this.show();
		p.show();
	    
	}
	
	@Override
	public void attact_choose(Player p, Weapon w) {
		 System.out.println(this.name+":  "+w.name+"(으)로   "+p.name +" 공격!");
		   
		 if(w instanceof 망치) {
		    	this.사용하기(w, p);
		 }
		 if(w instanceof 주먹) {
		    	this.때리기(p);
		 }
		 if(w instanceof 칼) {
		    	this.사용하기(w, p);
		 }
		 if(w.name == "필살기") {
	        	this.사용하기(w, p);
		 }
		    
		 if(w.name == "술") {
		    	this.술마시기();
		    	System.out.println("술에 취해 상대를 공격 못하고 자신의 HP가 닳았습니다.");
		 }
		 this.show_header();
		 this.show();
		 p.show();
	}

	


	
	public void settingWeapons(ArrayList<Weapon> garrage, int num) {
		
		//토르의 기본 무기인 망치를 무기창고에 미리 넣어놓는다.
		
		setWeapons(r);
		setWeapons(h);
		
		setWeapons(술);
		setWeapons(필살기);
		
		
		for(int i =0;i<num;) {
			int k = (int)((Math.random()*10))%garrage.size();
			if(garrage.get(k) instanceof 총 || garrage.get(k) instanceof 활 ) continue;
			setWeapons(garrage.get(k));
			i++;
		}
		//그 외의 무기들은 사용자가 지정한 숫자 만큼 추가적으로 공용 무기창고에서 가져온다.
	}

	




}
