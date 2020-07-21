import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyView2 extends JFrame {

	private JPanel contentPane;
	JPanel panel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyView2 frame = new MyView2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyView2() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 724);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(43, 25, 192, 636);
		contentPane.add(panel);
		panel.setLayout(null);
	}

    public MyView2(Player p1, Player p2, JTextArea a,JProgressBar p1Bar,JProgressBar p2Bar,JTextPane p1Hp,JTextPane p2Hp,JPanel panel1,JPanel panel2) {
    	this();
    	JButton [] weap_button = new JButton[p1.getWeapons().size()];
		for(int i=0;i<p1.getWeapons().size();i++) {
			weap_button[i] = new JButton("button");
			weap_button[i].setText(p1.getWeapons().get(i).name);
			weap_button[i].setFont(new Font("a옛날사진관4", Font.PLAIN, 13));
			weap_button[i].setBounds(25, 62+i*75, 130, 52);
			panel.add(weap_button[i]);
			
		}

		for (int k=0; k < p1.getWeapons().size(); k++) {
		 final int temp = k;
		 weap_button[k].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					p1.attact_choose(p2, p1.getWeapons().get(temp));
					a.append("\n" + p1.name + ":  " + p1.getWeapons().get(temp).name + "(으)로   " + p2.name
							+ " 공격!\n\n");
					//Game Window에서 Hp Bar와 text 바꾸기 위한 코드
					change_HpInfo(p1,p2,p1Bar,p2Bar,p1Hp,p2Hp); 
					
					//활 or 총은 공격 후에 남은 화살 or 총알 정보를 보여줌 (헐크는 활/총도 던지기 때문에 정보 필요없음)
					if(!(p1 instanceof 헐크) && p1.getWeapons().get(temp) instanceof 활) {
						show_arrow((활)p1.getWeapons().get(temp),p1,a);
					}
					if(!(p1 instanceof 헐크) && p1.getWeapons().get(temp) instanceof 총) {
						show_bullet(p1,(총)p1.getWeapons().get(temp),a);
					}

					showPlayer(p1, a);
					showPlayer(p2, a);
					
					end_game(p1, p2, a, panel1, panel2);
				    
			}
		 });
		
		}
    }
    public void showPlayer(Player p, JTextArea a) {
 	   a.append(p.name+"|  HP: "+p.getHp()+"   POWER: "+p.getPower()+" \n");
    }
    public void show_w(Player p, JTextArea textArea) {
 	   textArea.append("============================\n");
 	   textArea.append(">>>>>>>"+p.name+" 무기창고\n");
 	   textArea.append("----------------------------\n");
 	   
 	   textArea.append("무기이름    무기power\n");
 	   textArea.append("----------------------------\n");
 	   for(int i=0; i<p.getWeapons().size();i++) {
 		  
 		   textArea.append(p.getWeapons().get(i).name+"    "+ p.getWeapons().get(i).getPower()+"\n");
 	   }

 	   textArea.append("============================\n");
 	   
    }
    public void end_game(Player p1, Player p2, JTextArea a, JPanel panel1, JPanel panel2) {
 	   if(p1.getHp()<0 || p2.getHp()<0) {
 		    System.out.println("\n===========GAME OVER===========\n");
 		    a.append("\n===========GAME OVER===========\n");
 			if(p1.getHp()>0) {
 				a.append(p1.name+" Win!");
 				System.out.println(p1.name+" Win!");
 				panel1.setBackground(Color.GREEN);
				panel2.setBackground(Color.RED);
 			}
 			else {
 				a.append(p2.name+" Win!");
 				System.out.println(p2.name+" Win!");
 				panel1.setBackground(Color.RED);
				panel2.setBackground(Color.GREEN);
 			}
 		}
    }
    public void show_arrow(활 w,Player p, JTextArea a) {
    	if(w.get화살()<=0) {
    		a.append("남은 화살: " + w.get화살()+"\n");
			a.append(w.name+" :  화살이 다 떨어져 공격하지 못합니다\n");
			a.append(w.name+" :  무기창고에서 제거\n");
			p.removeWeapons(w);
			show_w(p,a);
		}
		else{
			a.append("남은 화살: " + w.get화살()+"\n");
		}
    }
    public void show_bullet(Player p,총 w, JTextArea a) {
    	if(w.get총알()<=0) {
    		a.append("남은 총알: " + w.get총알()+"\n");
			a.append(w.name+" :  총알이 다 떨어져 공격하지 못합니다\n");
			a.append(w.name+" :  무기창고에서 제거\n");
			p.removeWeapons(w);
			
			show_w(p,a);
		}
		else{
			a.append("남은 총알: " + w.get총알()+"\n");
		}
    }
    public void change_HpInfo(Player p1, Player p2,JProgressBar p1Bar,JProgressBar p2Bar,JTextPane p1Hp,JTextPane p2Hp) {
    	p1Bar.setValue(p1.getHp());
    	p2Bar.setValue(p2.getHp());
    	p1Hp.setText(Integer.toString(p1.getHp()));
    	p2Hp.setText(Integer.toString(p2.getHp()));
    	
    }
}
