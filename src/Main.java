import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		
	
		호크아이 Hawkeye = new 호크아이("호크아이");
		토르 Thor = new 토르("토르");
		헐크 Hulk = new 헐크("헐크");
		블랙위도우 Blackwidow = new 블랙위도우("블랙위도우");
		아이언맨 Ironman= new 아이언맨("아이언맨");
		
		총 a1 = new 총("총_공용1",3);
		총 a2 = new 총("총_공용2",4);
		칼 b = new 칼("칼_공용");
		망치 c = new 망치("망치_공용");
		활 d1 = new 활("활_공용1",3);
		활 d2 = new 활("활_공용2",2);
		활 d3 = new 활("활_공용3",4);
		
		ArrayList<Weapon> garrage = new ArrayList<Weapon>();
		garrage.add(a1);
		garrage.add(a2);
		garrage.add(b);
		garrage.add(c);
		garrage.add(d1);
		garrage.add(d2);
		garrage.add(d3);
		
		
		Hawkeye.settingWeapons(garrage, 2);
		Thor.settingWeapons(garrage, 2);
		Hulk.settingWeapons(garrage, 2);
		Blackwidow.settingWeapons(garrage, 2);
		Ironman.settingWeapons(garrage, 2);
		
		Ironman.show_header();
		Ironman.show();
		Hawkeye.show();
		
		Ironman.show_w();
		Hawkeye.show_w();
		
		GameWindow gamewindow = new GameWindow(Ironman,Hawkeye);
		gamewindow.setVisible(true);

		
	}

}
