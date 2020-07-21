
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class GameWindow extends JFrame {

	
	private JPanel contentPane;
	JTextPane p1Hp = new JTextPane();
	JTextPane p2Hp = new JTextPane();
	JLabel p2HpLabel = new JLabel("Hp:");
	JProgressBar p2progressBar = new JProgressBar();
	JButton p2무기가져오기 = new JButton("\uBB34\uAE30 \uAC00\uC838\uC624\uAE30");
	JButton p2공격버튼 = new JButton("\uACF5\uACA9\uD558\uAE30");
	JLabel p2사진 = new JLabel("");
	JPanel panel2 = new JPanel();
	JLabel p1HpLabel = new JLabel("Hp:");
	JButton p1무기가져오기 = new JButton("\uBB34\uAE30 \uAC00\uC838\uC624\uAE30");
	JLabel p1사진 = new JLabel("");
	JPanel panel1 = new JPanel();
	JButton p1공격버튼 = new JButton("\uACF5\uACA9\uD558\uAE30");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane();
	JProgressBar p1progressBar = new JProgressBar();
	JButton startbutton = new JButton("Start Game");
	JButton savebutton = new JButton("Save File");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
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
	public GameWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 702);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(12, 10, 292, 632);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		
		p1공격버튼.setFont(new Font("a옛날사진관4", Font.PLAIN, 16));
		p1공격버튼.setBounds(12, 439, 122, 47);
		panel1.add(p1공격버튼);
		
		p2공격버튼.setFont(new Font("a옛날사진관4", Font.PLAIN, 16));
		p2공격버튼.setBounds(29, 422, 125, 42);
		panel2.add(p2공격버튼);
		
		p1사진.setBounds(12, 10, 245, 417);
		
		panel1.add(p1사진);
	
		
		p1무기가져오기.setFont(new Font("a옛날사진관4", Font.PLAIN, 16));
		p1무기가져오기.setBounds(12, 496, 153, 47);
		panel1.add(p1무기가져오기);
		
		
		p2무기가져오기.setBounds(29, 474, 148, 47);
		panel2.add(p2무기가져오기);
		p2무기가져오기.setFont(new Font("a옛날사진관4", Font.PLAIN, 16));
		
		p1HpLabel.setFont(new Font("a옛날사진관4", Font.PLAIN, 14));
		p1HpLabel.setBounds(12, 553, 52, 15);
		panel1.add(p1HpLabel);
		p1progressBar.setForeground(Color.RED);
		
		
		p1progressBar.setBounds(22, 575, 247, 47);
		panel1.add(p1progressBar);
		
		
		p1Hp.setBounds(46, 547, 69, 21);
		panel1.add(p1Hp);
		
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(611, 10, 301, 632);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		p2사진.setBounds(12, 26, 260, 357);
		panel2.add(p2사진);
		
		p2progressBar.setForeground(Color.RED);

		
		p2progressBar.setBackground(Color.WHITE);
		p2progressBar.setBounds(29, 568, 243, 42);
		panel2.add(p2progressBar);
		
		p2HpLabel.setFont(new Font("a옛날사진관4", Font.PLAIN, 14));
		p2HpLabel.setBounds(29, 543, 52, 15);
		panel2.add(p2HpLabel);
	
		p2Hp.setBounds(60, 537, 69, 21);
		panel2.add(p2Hp);
		
		scrollPane.setBounds(326, 28, 260, 524);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);

		
		startbutton.setBackground(SystemColor.activeCaption);
		startbutton.setFont(new Font("a옛날사진관4", Font.PLAIN, 14));
		startbutton.setBounds(326, 579, 132, 58);
		contentPane.add(startbutton);
		
		savebutton.setFont(new Font("a옛날사진관4", Font.PLAIN, 12));
		savebutton.setBounds(470, 586, 116, 46);
		contentPane.add(savebutton);
		
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveToFile();
			}
		}); 
		
		
		
	}
	
	  protected void saveToFile() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("c://game//result.txt");
			pw.println(textArea.getText());
			
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("그런 파일은 없습니다");
			e.printStackTrace();
		}
		
	} 
    public GameWindow(Player p1, Player p2) {
    	
    	this(); //얘해주면 인자 부르기 할 수 있는거였어!!!
    	
    	p1progressBar.setMaximum(p1.getHp());
    	p2progressBar.setMaximum(p2.getHp());
    	p1progressBar.setValue(p1.getHp());
    	p2progressBar.setValue(p2.getHp());
    	p1Hp.setText(Integer.toString(p1.getHp()));
    	p2Hp.setText(Integer.toString(p2.getHp()));
		
		p1사진.setIcon(new ImageIcon(p1.getImgfile()));
		p2사진.setIcon(new ImageIcon(p2.getImgfile()));
		
		startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("<<<<<<<Game Start>>>>>>>\n");
				textArea.append("참가자 1:\n");
			    showPlayer(p1);
			    textArea.append("참가자 2:\n");
			    showPlayer(p2);
			    show_w(p1);
			    show_w(p2);
			}
		});
		
    	p1공격버튼.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.attack(p2);
				p1progressBar.setValue(p1.getHp());
		    	p2progressBar.setValue(p2.getHp());
				p1Hp.setText(Integer.toString(p1.getHp()));
		    	p2Hp.setText(Integer.toString(p2.getHp()));
			    textArea.append("\n"+p1.name+":  "+p1.cur_weapon.name+"(으)로   "+p2.name +" 공격!\n\n");
			    
			    showPlayer(p1);
			    showPlayer(p2);
			    
			    end_game(p1,p2);
 			}
		});
    	
		p2공격버튼.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p2.attack(p1);
				p1progressBar.setValue(p1.getHp());
		    	p2progressBar.setValue(p2.getHp());
		    	p1Hp.setText(Integer.toString(p1.getHp()));
		    	p2Hp.setText(Integer.toString(p2.getHp()));
			    textArea.append("\n"+p2.name+":  "+p2.cur_weapon.name+"(으)로   "+p1.name +" 공격!\n\n");
			   
			    showPlayer(p1);
			    showPlayer(p2);
			    
			    end_game(p1,p2);
			}
		});
		
		p1무기가져오기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyView2 p1무기 = new MyView2(p1,p2,textArea,p1progressBar,p2progressBar,p1Hp,p2Hp,panel1,panel2);
				p1무기.setVisible(true);
				
				}
				
			});
		p2무기가져오기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyView2 p2무기 = new MyView2(p2,p1,textArea,p2progressBar,p1progressBar,p2Hp,p1Hp,panel2,panel1);
				p2무기.setVisible(true);
				}
				
			});
	
    }

   public void showPlayer(Player p) {
	   textArea.append(p.name+"|  HP: "+p.getHp()+"   POWER: "+p.getPower()+" \n");
   }
   
   public void show_w(Player p) {
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
   public void end_game(Player p1,Player p2) {
	   if(p1.getHp()<0 || p2.getHp()<0) {
		    System.out.println("\n===========GAME OVER===========\n");
			textArea.append("\n===========GAME OVER===========\n");
			if(p1.getHp()>0) {
				textArea.append(p1.name+" Win!");
				System.out.println(p1.name+" Win!");
				panel1.setBackground(Color.GREEN);
				panel2.setBackground(Color.RED);
				}
			else {
				textArea.append(p2.name+" Win!");
				System.out.println(p2.name+" Win!");
				panel1.setBackground(Color.RED);
				panel2.setBackground(Color.GREEN);
				}
		}
   }
}


