import java.util.ArrayList;

public class 아이언맨 extends Player implements Hittable,Shootable {
	
	
	주먹 r = new 주먹("주먹",50);
	Weapon 아이언빔 = new Weapon("아이언빔", 100);
	Weapon 슈트오작동 = new Weapon("슈트오작동",-40);
	
	public 아이언맨(String name) {
		this.name = name;
		this.setHp(400);
		this.setPower(50);
		this.setImgfile("C:\\Users\\kirin\\Desktop\\객체지향프로그래밍\\객짚이미지\\ii.png");

	}


    public void 슈트오작동(){
    	this.setHp(this.getHp()-40);
    	System.out.println("슈트 오작동에 의해 상대를 공격 못하고 자신의 HP가 닳았습니다.");
    }
    
    public void 아이언빔(Player p) {
    	//100만큼의 공격력
    	p.setHp(p.getHp()-100);
    }
    


	public void 때리기(Player p) {
		p.setHp(p.getHp()-this.getPower());
	}


	public void 쏘기(총 w,Player p) {
		if(w.get총알()<=0) {
			System.out.println(w.name+" :  총알이 다 떨어져 공격하지 못합니다");
			System.out.println(w.name+" :  무기창고에서 제거");
			this.removeWeapons(w);
			this.show_w();
		}
		else {
		p.setHp(p.getHp()-w.getPower());
		w.set총알(w.get총알()-1);
		System.out.println("남은 총알: "+ w.get총알());
		}
	}
	
	public void 쏘기(활 w,Player p) {}
	


	public void attack(Player p) {
		cur_weapon = choose_Weapon();
		
		System.out.println(this.name+":  "+cur_weapon.name+"(으)로   "+p.name +" 공격!");
	  
	    if(cur_weapon instanceof 주먹) {
	    	p.setHp(p.getHp()-this.getPower());
	    }
	    if(cur_weapon instanceof 총) {
	    	쏘기((총)cur_weapon,p);
	    }
	    if(cur_weapon.name == "아이언빔") {
        	아이언빔(p);
	    }
	    
	    if(cur_weapon.name == "슈트오작동") {
	    	슈트오작동();
	    	
	    }		
	    this.show_header();
		this.show();
		p.show();
	 
	}
	@Override
	public void attact_choose(Player p, Weapon w) {
		System.out.println(this.name+":  "+w.name+"(으)로   "+p.name +" 공격!");
		  
	    if(w instanceof 주먹) {
	    	p.setHp(p.getHp()-this.getPower());
	    }
	    if(w instanceof 총) {
	    	쏘기((총)w,p);
	    }
	    if(w.name == "아이언빔") {
        	아이언빔(p);
	    }
	    
	    if(w.name == "슈트오작동") {
	    	슈트오작동();
	    	
	    }		
	    this.show_header();
		this.show();
		p.show();
	}

	
	public void settingWeapons(ArrayList<Weapon> garrage, int num) {
		
		setWeapons(r);
		
		//아이언맨의 기본 무기인 슈트오작동과 아이언빔은 무기창고에 미리 넣어놓는다. 
		setWeapons(슈트오작동);
		setWeapons(아이언빔);
		
		
		for(int i =0;i<num;) {
			int k = (int)((Math.random()*10))%garrage.size();
			if(garrage.get(k) instanceof 활 || garrage.get(k) instanceof 칼 || garrage.get(k) instanceof 망치 ) continue;
			if(garrage.get(k) instanceof 총 ) {
				if(getWeapons().contains(garrage.get(k))) {
					continue;
				}
			}
			setWeapons(garrage.get(k));
			i++;
		}
		
	}






}
