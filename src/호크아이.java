import java.util.ArrayList;

public class 호크아이 extends Player implements Shootable, Hittable {
	
	int 활쏘기 = 80;
	주먹 r = new 주먹("주먹",20);
	활 a = new 활("활_호크아이 스페셜",5);
	
	
	public 호크아이(String name) {
		this.name = name;
		this.setHp(400);
		this.setPower(20);
		this.setImgfile("C:\\Users\\kirin\\Desktop\\객체지향프로그래밍\\객짚이미지\\s.jpeg");
	
	}
	
	

	public void 쏘기(활 w,Player p) {
		if(w.get화살()<=0) {
			System.out.println(w.name+" :  화살이 다 떨어져 공격하지 못합니다");
			System.out.println(w.name+" :  무기창고에서 제거");
			this.removeWeapons(w);
			this.show_w();
		}
		else{
			p.setHp(p.getHp() - 활쏘기 - w.getPower());
			w.set화살(w.get화살() - 1);
			System.out.println("남은 화살: " + w.get화살());
		}
		
	}

	public void 쏘기(총 w, Player p) {

	}

	public void 때리기(Player p) {
		p.setHp(p.getHp()-this.getPower());
	}

	
	
	public void attack(Player p) {
		
		cur_weapon = choose_Weapon();
		
		System.out.println(this.name+":  "+cur_weapon.name+"(으)로   "+p.name +" 공격!");
	    
	    if(cur_weapon instanceof 주먹) {
	    	this.때리기(p);
	    }
	    if(cur_weapon instanceof 활) {
	    	this.쏘기((활)cur_weapon,p);
	    }
	    this.show_header();
		this.show();
		p.show();

	}
	
	public void attact_choose(Player p, Weapon w) {
        System.out.println(this.name+":  "+w.name+"(으)로   "+p.name +" 공격!");
	    
	    if(w instanceof 주먹) {
	    	this.때리기(p);
	    }
	    if(w instanceof 활) {
	    	this.쏘기((활)w,p);
	    }

	    this.show_header();
		this.show();
		p.show();
		
	}
	
	public void settingWeapons(ArrayList<Weapon> garrage, int num) {

		setWeapons(r);
		
		//호크아이의 기본 무기인 활을 무기창고에 미리 넣어놓는다.
		setWeapons(a);
	
		
		for(int i =0;i<num;) {
			int k = (int)((Math.random()*10))%garrage.size();
			if(garrage.get(k) instanceof 총 || garrage.get(k) instanceof 칼 || garrage.get(k) instanceof 망치 ) continue;
			if(garrage.get(k) instanceof 활) {
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
