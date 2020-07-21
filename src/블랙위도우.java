import java.util.ArrayList;

public class 블랙위도우 extends Player implements Shootable,Hittable,Useable{

	int 총쏘기 = 20;
	int 칼다루기 = 20;
	주먹 r = new 주먹("주먹",100);
	
	
	public 블랙위도우(String name) {
		this.name = name;
		this.setHp(500);
		this.setPower(100);
		this.setImgfile("C:\\\\Users\\\\kirin\\\\Desktop\\\\객체지향프로그래밍\\\\객짚이미지\\\\pls.png");
		
	}

	//각 무기에 따른 사용 방법 메소드
	public void 쏘기(총 w,Player p) {
		if(w.get총알()<=0) {
			//총알 0개일 때 총으로 공격하기 하면 그 차례에는 공격 못하고 무기창고에서 총도 뺌
			System.out.println(w.name+" :  총알이 다 떨어져 공격하지 못합니다");
			System.out.println(w.name+" :  무기창고에서 제거");
			this.removeWeapons(w);
			this.show_w();
		}
		else {
		p.setHp(p.getHp()-총쏘기-w.getPower());
		w.set총알(w.get총알()-1);
		System.out.println("남은 총알: "+ w.get총알());
		}
	}
	
	public void 쏘기(활 w,Player p) {}
	
	
	public void 때리기(Player p) {

		p.setHp(p.getHp()-this.getPower());
	}
	

	public void 사용하기(Weapon t, Player p) {
		 p.setHp(p.getHp()-t.getPower()-this.칼다루기);
	}


    //랜덤하게 자신의 무기중에 골라서 공격
	public void attack(Player p) {
        cur_weapon = choose_Weapon();
        
        System.out.println(this.name+":  "+cur_weapon.name+"(으)로   "+p.name +" 공격!");
	    
	    if(cur_weapon instanceof 주먹) {
	    	this.때리기(p);
	    }
	    if(cur_weapon instanceof 총) {
	    	this.쏘기((총)cur_weapon, p);
	    }
	    if(cur_weapon instanceof 칼) {
	    	this.사용하기(cur_weapon, p);
	    }
	    this.show_header();
		this.show();
		p.show();
        
	}


    //무기 직접 골라서 공격
	public void attact_choose(Player p, Weapon w) {
        System.out.println(this.name+":  "+w.name+"(으)로   "+p.name +" 공격!");
	    
	    if(w instanceof 주먹) {
	    	this.때리기(p);
	    }
	    if(w instanceof 총) {
	    	this.쏘기((총)w, p);
	    }
	    if(w instanceof 칼) {
	    	this.사용하기(w, p);
	    }
	    this.show_header();
		this.show();
		p.show();
	}



	//갖고 태어나는 무기들과 공용창고에서 가져온 무기들로 채우는 내 무기창고 
	public void settingWeapons(ArrayList<Weapon> garrage, int num) {
		
		setWeapons(r);
		
		for(int i =0;i<num;) {
			int k = (int)((Math.random()*10))%garrage.size();
			if(garrage.get(k) instanceof 활 || garrage.get(k) instanceof 망치 ) continue;
			if(garrage.get(k) instanceof 총 ) {
				if(getWeapons().contains(garrage.get(k))) {
					continue;
				}
			}
			setWeapons(garrage.get(k));
			i++;
		}
		//그 외의 무기들은 사용자가 지정한 숫자 만큼 추가적으로 공용 무기창고에서 가져온다.
		

	}



	
}
