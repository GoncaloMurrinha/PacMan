
 
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.Color;

public class pmanc extends JFrame {
	public int score=0;
	
	boolean start=false;
	boolean parede=true;
	int tentativa=0;
	String sentido="DIREITA";
	Image left,right,up,down,heart,ghost;
	boolean andar=true;
	Image[] imagens = new Image[3];
	private JPanel contentPane;
	private JLabel DOT39;
	private Timer timer;
	private Aux tarefaAux;
	private boolean emPause = false;
// ...

	int total;
	int u=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pmanc frame = new pmanc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	public boolean choque(JLabel a, JLabel b) {

		boolean x=false;

		Rectangle r1 = a.getBounds();

		Rectangle r2 = b.getBounds();

		if(r2.intersects(r1)) {
			
			 x=true;
			 
			 if (a.getText()!= "pc" && a.getText()!="fn"&& a.getText()!="DOT" && a.getText()!="canto_1" && a.getText()!="canto_2" ) {
				 
				 
				 if( a.getText()!="DOT1" && a.getText()!="DOT2"  && a.getText()!="DOT3" && a.getText()!="DOT4" && a.getText()!="DOT5" && a.getText()!="DOT6" && a.getText()!="DOT7" && a.getText()!="DOT8" && a.getText()!="DOT9"
			    			&& a.getText()!="DOT10"&& a.getText()!="DOT11"&& a.getText()!="DOT12"&& a.getText()!="DOT13"&& a.getText()!="DOT14"&& a.getText()!="DOT15"&& a.getText()!="DOT16"&& a.getText()!="DOT17"&& a.getText()!="DOT18"
			    			&& a.getText()!="DOT19"&& a.getText()!="DOT20"&& a.getText()!="DOT21"&& a.getText()!="DOT22"&& a.getText()!="DOT23"&& a.getText()!="DOT24"&& a.getText()!="DOT25"&& a.getText()!="DOT26"&& a.getText()!="DOT27"
			    			&& a.getText()!="DOT28"&& a.getText()!="DOT29" && a.getText()!="DOT30"&& a.getText()!="DOT31"&& a.getText()!="DOT32"&& a.getText()!="DOT33"&& a.getText()!="DOT34"&& a.getText()!="DOT35"&& a.getText()!="DOT36"
			    			&& a.getText()!="DOT37"&& a.getText()!="DOT38"&& a.getText()!="DOT39") {
			    		
			    		
			  
					 	
			    	

		    		
		    	
				 	x=false;
		    
				 	System.out.println("llllllllllllll-" +a.getText());
				 	parede=false;
				 	
		    	
		    	
		
		    		}
			
			}
				

		}
		  else {

			

			x=false;

		}
		
		if(parede==false) {
		
		}

			return x;	 

		}

	 private void loadImages() {
		 
     	down = new ImageIcon("/src/images/DOWN.gif").getImage();
     	up = new ImageIcon("/src/images/UP.gif").getImage();
     	left = new ImageIcon("/src/images/LEFT.gif").getImage();
     	right = new ImageIcon("/src/images/RIGHT.gif").getImage();
         ghost = new ImageIcon("/src/images/ghost.gif").getImage();
         heart = new ImageIcon("/src/images/heart.png").getImage();
         
         imagens[0]=left;
         imagens[1]=right;
         imagens[2]=up;
         imagens[3]=down;
         
     }
	/**
	 * Create the frame.
	
	 */
	public pmanc() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 643);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon ii=new ImageIcon(new ImageIcon("C:\\Users\\so.COOPTECNICA\\Downloads\\cenario pac.png").getImage().getScaledInstance(1000,1000,Image.SCALE_DEFAULT));
		
		JButton starts = new JButton("Start");
		starts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starts.setVisible(false);
				starts.setEnabled(false);
				start=true;
				setVisible(true);
				toFront();
				requestFocus();
			}
		});
		
		JLabel coração1 = new JLabel("");
		coração1.setBackground(Color.BLACK);
		coração1.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/HEARTH.png")));
		coração1.setBounds(719, 573, 30, 30);
		contentPane.add(coração1);
		
		JLabel coração2 = new JLabel("");
		coração2.setBackground(new Color(240, 240, 240));
		coração2.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/HEARTH.png")));
		coração2.setBounds(810, 574, 30, 30);
		contentPane.add(coração2);
		
		JLabel coração3 = new JLabel("");
		coração3.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/HEARTH.png")));
		coração3.setBounds(766, 573, 30, 30);
		contentPane.add(coração3);
		starts.setBounds(390, 395, 89, 23);
		contentPane.add(starts);
		
		JLabel pacman = new JLabel("pc");
		pacman.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/RIGHT.gif")));
		
		pacman.setBounds(417, 318, 30, 23);
		contentPane.add(pacman);
		
		JLabel Ghost = new JLabel("gh");
		Ghost.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/Ghost4.gif")));
		
		Ghost.setBounds(192, 36, 40, 39);
		contentPane.add(Ghost);
		
		JLabel Ghost4 = new JLabel("gh");
		Ghost4.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/Ghost2.gif")));
		Ghost4.setBounds(192, 86, 40, 39);
		contentPane.add(Ghost4);
		
		JLabel Ghost3 = new JLabel("gh");
		Ghost3.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/Ghost3.gif")));
		Ghost3.setBounds(637, 25, 40, 39);
		contentPane.add(Ghost3);
		
		JLabel Ghost2 = new JLabel("gh");
		Ghost2.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/Ghost1.gif")));
		Ghost2.setBounds(192, 527, 37, 31);
		contentPane.add(Ghost2);
		
		JLabel DOT31 = new JLabel("DOT31");
		DOT31.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT31.setBounds(49, 84, 40, 39);
		contentPane.add(DOT31);
		
		JLabel DOT32 = new JLabel("DOT32");
		DOT32.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT32.setBounds(112, 84, 40, 39);
		contentPane.add(DOT32);
		
		JLabel DOT33 = new JLabel("DOT33");
		DOT33.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT33.setBounds(271, 86, 40, 39);
		contentPane.add(DOT33);
		
		JLabel DOT34 = new JLabel("DOT34");
		DOT34.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT34.setBounds(330, 86, 40, 39);
		contentPane.add(DOT34);
		
		JLabel DOT35 = new JLabel("DOT35");
		DOT35.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT35.setBounds(412, 86, 40, 39);
		contentPane.add(DOT35);
		
		JLabel DOT36 = new JLabel("DOT36");
		DOT36.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT36.setBounds(477, 84, 40, 39);
		contentPane.add(DOT36);
		
		JLabel DOT38 = new JLabel("DOT38");
		DOT38.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT38.setBounds(709, 84, 40, 39);
		contentPane.add(DOT38);
		
		JLabel DOT37 = new JLabel("DOT37");
		DOT37.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT37.setBounds(556, 86, 40, 39);
		contentPane.add(DOT37);
		
		DOT39 = new JLabel("DOT39");
		DOT39.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT39.setBounds(781, 84, 40, 39);
		contentPane.add(DOT39);
		
		JLabel DOT30 = new JLabel("DOT30");
		DOT30.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT30.setBounds(637, 212, 37, 35);
		contentPane.add(DOT30);
		
		JLabel DOT29 = new JLabel("DOT29");
		DOT29.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT29.setBounds(637, 275, 37, 35);
		contentPane.add(DOT29);
		
		JLabel DOT28 = new JLabel("DOT28");
		DOT28.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT28.setBounds(640, 337, 37, 35);
		contentPane.add(DOT28);
		
		JLabel DOT27 = new JLabel("DOT27");
		DOT27.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT27.setBounds(637, 399, 37, 35);
		contentPane.add(DOT27);
		
		JLabel DOT26 = new JLabel("DOT26");
		DOT26.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT26.setBounds(637, 462, 37, 35);
		contentPane.add(DOT26);
		
		JLabel DOT25 = new JLabel("DOT25");
		DOT25.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT25.setBounds(737, 527, 37, 35);
		contentPane.add(DOT25);
		
		JLabel DOT24 = new JLabel("DOT24");
		DOT24.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT24.setBounds(640, 159, 37, 35);
		contentPane.add(DOT24);
		
		JLabel DOT23 = new JLabel("DOT23");
		DOT23.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT23.setBounds(640, 88, 37, 35);
		contentPane.add(DOT23);
		
		JLabel DOT22 = new JLabel("DOT22");
		DOT22.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT22.setBounds(637, 38, 37, 35);
		contentPane.add(DOT22);
		
		JLabel DOT13 = new JLabel("DOT13");
		DOT13.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT13.setBounds(390, 525, 37, 35);
		contentPane.add(DOT13);
		
		JLabel DOT14 = new JLabel("DOT14");
		DOT14.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT14.setBounds(737, 525, 37, 35);
		contentPane.add(DOT14);
		
		JLabel DOT15 = new JLabel("DOT15");
		DOT15.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT15.setBounds(437, 525, 37, 35);
		contentPane.add(DOT15);
		
		JLabel DOT16 = new JLabel("DOT16");
		DOT16.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT16.setBounds(495, 525, 37, 35);
		contentPane.add(DOT16);
		
		JLabel DOT17 = new JLabel("DOT17");
		DOT17.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT17.setBounds(556, 525, 37, 35);
		contentPane.add(DOT17);
		
		JLabel DOT18 = new JLabel("DOT18");
		DOT18.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT18.setBounds(621, 525, 37, 35);
		contentPane.add(DOT18);
		
		JLabel DOT19 = new JLabel("DOT19");
		DOT19.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT19.setBounds(679, 525, 37, 35);
		contentPane.add(DOT19);
		
		JLabel DOT21 = new JLabel("DOT21");
		DOT21.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT21.setBounds(333, 526, 37, 33);
		contentPane.add(DOT21);
		
		JLabel DOT12 = new JLabel("DOT12");
		DOT12.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT12.setBounds(280, 526, 37, 33);
		contentPane.add(DOT12);
		
		JLabel DOT11 = new JLabel("DOT11");
		DOT11.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT11.setBounds(220, 525, 37, 35);
		contentPane.add(DOT11);
		
		JLabel DOT20 = new JLabel("DOT20");
		DOT20.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT20.setBounds(784, 523, 37, 35);
		contentPane.add(DOT20);
		
		JLabel DOT10 = new JLabel("DOT10");
		DOT10.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT10.setBounds(162, 530, 35, 25);
		contentPane.add(DOT10);
		
		JLabel DOT9 = new JLabel("DOT9");
		DOT9.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT9.setBounds(100, 525, 37, 35);
		contentPane.add(DOT9);
		
		JLabel DOT8 = new JLabel("DOT");
		DOT8.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT8.setBounds(192, 335, 40, 39);
		contentPane.add(DOT8);
		
		JLabel DOT7 = new JLabel("DOT1");
		DOT7.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT7.setBounds(192, 275, 40, 39);
		contentPane.add(DOT7);
		
		JLabel DOT6 = new JLabel("DOT2");
		DOT6.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT6.setBounds(192, 212, 40, 39);
		contentPane.add(DOT6);
		
		JLabel DOT5 = new JLabel("DOT3");
		DOT5.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT5.setBounds(192, 37, 40, 39);
		contentPane.add(DOT5);
		
		JLabel DOT4 = new JLabel("DOT4");
		DOT4.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT4.setBounds(192, 144, 40, 39);
		contentPane.add(DOT4);
		
		JLabel DOT3 = new JLabel("DOT5");
		DOT3.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT3.setBounds(192, 397, 40, 39);
		contentPane.add(DOT3);
		
		JLabel DOT2 = new JLabel("DOT6");
		DOT2.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT2.setBounds(192, 458, 40, 39);
		contentPane.add(DOT2);
		
		JLabel DOT1 = new JLabel("DOT7");
		DOT1.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT1.setBounds(41, 523, 40, 39);
		contentPane.add(DOT1);
		
		JLabel DOT = new JLabel("DOT8");
		DOT.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOT.png")));
		DOT.setBounds(192, 86, 40, 39);
		contentPane.add(DOT);
		
		JLabel caixafantasma2_2_2_1 = new JLabel("");
		caixafantasma2_2_2_1.setBounds(831, 344, 31, 229);
		contentPane.add(caixafantasma2_2_2_1);
		
		JLabel caixafantasma5_1_2_1_2_3_1 = new JLabel("");
		caixafantasma5_1_2_1_2_3_1.setBounds(784, 451, 78, 20);
		contentPane.add(caixafantasma5_1_2_1_2_3_1);
		
		JLabel caixafantasma5_1_1_1_1_1_1 = new JLabel("");
		caixafantasma5_1_1_1_1_1_1.setBounds(10, 571, 830, 12);
		contentPane.add(caixafantasma5_1_1_1_1_1_1);
		
		JLabel caixafantasma2_2_2 = new JLabel("");
		caixafantasma2_2_2.setBounds(0, 344, 31, 229);
		contentPane.add(caixafantasma2_2_2);
		
		JLabel caixafantasma5_1_2_1_2 = new JLabel("");
		caixafantasma5_1_2_1_2.setBounds(103, 398, 78, 20);
		contentPane.add(caixafantasma5_1_2_1_2);
		
		JLabel caixafantasma5_1_2_1_2_3 = new JLabel("");
		caixafantasma5_1_2_1_2_3.setBounds(0, 451, 89, 20);
		contentPane.add(caixafantasma5_1_2_1_2_3);
		
		JLabel caixafantasma5_1_2_1_2_1 = new JLabel("");
		caixafantasma5_1_2_1_2_1.setBounds(244, 398, 111, 20);
		contentPane.add(caixafantasma5_1_2_1_2_1);
		
		JLabel caixafantasma5_1_2_1_2_1_1 = new JLabel("");
		caixafantasma5_1_2_1_2_1_1.setBounds(515, 399, 99, 12);
		contentPane.add(caixafantasma5_1_2_1_2_1_1);
		
		JLabel caixafantasma5_1_2_1_1_1_1 = new JLabel("");
		caixafantasma5_1_2_1_1_1_1.setBounds(515, 505, 249, 20);
		contentPane.add(caixafantasma5_1_2_1_1_1_1);
		
		JLabel caixafantasma2_1_2_3_1_1_1_1 = new JLabel("");
		caixafantasma2_1_2_3_1_1_1_1.setBounds(684, 421, 32, 39);
		contentPane.add(caixafantasma2_1_2_3_1_1_1_1);
		
		JLabel caixafantasma2_1_2_3_1_1_2 = new JLabel("");
		caixafantasma2_1_2_3_1_1_2.setBounds(596, 462, 30, 39);
		contentPane.add(caixafantasma2_1_2_3_1_1_2);
		
		JLabel caixafantasma5_1_2_1_2_2 = new JLabel("");
		caixafantasma5_1_2_1_2_2.setBounds(684, 406, 78, 12);
		contentPane.add(caixafantasma5_1_2_1_2_2);
		
		JLabel caixafantasma5_1_2_1_1_1 = new JLabel("");
		caixafantasma5_1_2_1_1_1.setBounds(98, 508, 257, 12);
		contentPane.add(caixafantasma5_1_2_1_1_1);
		
		JLabel caixafantasma2_1_2_3_1_1_1 = new JLabel("");
		caixafantasma2_1_2_3_1_1_1.setBounds(149, 421, 32, 39);
		contentPane.add(caixafantasma2_1_2_3_1_1_1);
		
		JLabel caixafantasma5_1_2_1_1 = new JLabel("");
		caixafantasma5_1_2_1_1.setBounds(333, 459, 199, 12);
		contentPane.add(caixafantasma5_1_2_1_1);
		
		JLabel caixafantasma2_1_2_3_1_1 = new JLabel("");
		caixafantasma2_1_2_3_1_1.setBounds(238, 451, 30, 50);
		contentPane.add(caixafantasma2_1_2_3_1_1);
		
		JLabel caixafantasma2_1_2_3_1 = new JLabel("");
		caixafantasma2_1_2_3_1.setBounds(417, 474, 30, 40);
		contentPane.add(caixafantasma2_1_2_3_1);
		
		JLabel caixafantasma5_1_2_1 = new JLabel("");
		caixafantasma5_1_2_1.setBounds(330, 352, 191, 12);
		contentPane.add(caixafantasma5_1_2_1);
		
		JLabel caixafantasma2_1_2_3 = new JLabel("");
		caixafantasma2_1_2_3.setBounds(417, 368, 30, 39);
		contentPane.add(caixafantasma2_1_2_3);
		
		JLabel caixafantasma2_1_1_1_1 = new JLabel("");
		caixafantasma2_1_1_1_1.setBounds(596, 296, 30, 58);
		contentPane.add(caixafantasma2_1_1_1_1);
		
		JLabel caixafantasma3_1_1_1_2_1 = new JLabel("");
		caixafantasma3_1_1_1_2_1.setBounds(687, 344, 175, 20);
		contentPane.add(caixafantasma3_1_1_1_2_1);
		
		JLabel caixafantasma2_1_1_1 = new JLabel("");
		caixafantasma2_1_1_1.setBounds(237, 295, 30, 65);
		contentPane.add(caixafantasma2_1_1_1);
		
		JLabel caixafantasma3_1_1_1_2 = new JLabel("");
		caixafantasma3_1_1_1_2.setBounds(687, 294, 153, 20);
		contentPane.add(caixafantasma3_1_1_1_2);
		
		JLabel caixafantasma2_1_2_2_1_2 = new JLabel("");
		caixafantasma2_1_2_2_1_2.setBounds(687, 303, 30, 50);
		contentPane.add(caixafantasma2_1_2_2_1_2);
		
		JLabel caixafantasma2_1_2_2_1_1 = new JLabel("");
		caixafantasma2_1_2_2_1_1.setBounds(152, 303, 30, 50);
		contentPane.add(caixafantasma2_1_2_2_1_1);
		
		JLabel caixafantasma5_1_1_1_1 = new JLabel("");
		caixafantasma5_1_1_1_1.setBounds(685, 129, 92, 14);
		contentPane.add(caixafantasma5_1_1_1_1);
		
		JLabel caixafantasma2_1_3_2 = new JLabel("");
		caixafantasma2_1_3_2.setBounds(515, 64, 105, 11);
		contentPane.add(caixafantasma2_1_3_2);
		
		JLabel caixafantasma2_1_3_1_1 = new JLabel("");
		caixafantasma2_1_3_1_1.setBounds(699, 64, 61, 11);
		contentPane.add(caixafantasma2_1_3_1_1);
		
		JLabel caixafantasma5_1_1_1_1_1 = new JLabel("");
		caixafantasma5_1_1_1_1_1.setBounds(20, 0, 830, 14);
		contentPane.add(caixafantasma5_1_1_1_1_1);
		
		JLabel caixafantasma2_1_2_1 = new JLabel("");
		caixafantasma2_1_2_1.setBounds(417, 11, 30, 79);
		contentPane.add(caixafantasma2_1_2_1);
		
		JLabel caixafantasma2_2 = new JLabel("");
		caixafantasma2_2.setBounds(0, 11, 22, 185);
		contentPane.add(caixafantasma2_2);
		
		JLabel caixafantasma2_2_1 = new JLabel("");
		caixafantasma2_2_1.setBounds(831, 12, 31, 185);
		contentPane.add(caixafantasma2_2_1);
		
		JLabel caixafantasma3_1 = new JLabel("");
		caixafantasma3_1.setBounds(29, 183, 134, 14);
		contentPane.add(caixafantasma3_1);
		
		JLabel caixafantasma3_1_1 = new JLabel("");
		caixafantasma3_1_1.setBounds(687, 183, 153, 14);
		contentPane.add(caixafantasma3_1_1);
		
		JLabel caixafantasma3_1_1_1_1 = new JLabel("");
		caixafantasma3_1_1_1_1.setBounds(10, 237, 153, 10);
		contentPane.add(caixafantasma3_1_1_1_1);
		
		JLabel caixafantasma2_1_2_2_1 = new JLabel("");
		caixafantasma2_1_2_2_1.setBounds(152, 196, 22, 50);
		contentPane.add(caixafantasma2_1_2_2_1);
		
		JLabel caixafantasma2_1_2_2 = new JLabel("");
		caixafantasma2_1_2_2.setBounds(687, 196, 30, 50);
		contentPane.add(caixafantasma2_1_2_2);
		
		JLabel caixafantasma3_1_1_1_1_1 = new JLabel("");
		caixafantasma3_1_1_1_1_1.setBounds(20, 302, 153, 12);
		contentPane.add(caixafantasma3_1_1_1_1_1);
		
		JLabel caixafantasma3_1_1_1 = new JLabel("");
		caixafantasma3_1_1_1.setBounds(687, 237, 153, 14);
		contentPane.add(caixafantasma3_1_1_1);
		
		JLabel caixafantasma5 = new JLabel("");
		caixafantasma5.setBounds(477, 237, 55, 9);
		contentPane.add(caixafantasma5);
		
		JLabel caixafantasma5_1_1_1 = new JLabel("");
		caixafantasma5_1_1_1.setBounds(97, 134, 71, 9);
		contentPane.add(caixafantasma5_1_1_1);
		
		JLabel caixafantasma2_1_3_1 = new JLabel("");
		caixafantasma2_1_3_1.setBounds(97, 67, 71, 12);
		contentPane.add(caixafantasma2_1_3_1);
		
		JLabel caixafantasma2_1_3 = new JLabel("");
		caixafantasma2_1_3.setBounds(244, 64, 105, 14);
		contentPane.add(caixafantasma2_1_3);
		
		JLabel caixafantasma5_1_2 = new JLabel("");
		caixafantasma5_1_2.setBounds(340, 136, 177, 7);
		contentPane.add(caixafantasma5_1_2);
		
		JLabel caixafantasma2_1_2 = new JLabel("");
		caixafantasma2_1_2.setBounds(422, 144, 14, 50);
		contentPane.add(caixafantasma2_1_2);
		
		JLabel caixafantasma5_1 = new JLabel("");
		caixafantasma5_1.setBounds(515, 183, 78, 12);
		contentPane.add(caixafantasma5_1);
		
		JLabel caixafantasma2_1_1 = new JLabel("");
		caixafantasma2_1_1.setBounds(245, 134, 22, 111);
		contentPane.add(caixafantasma2_1_1);
		
		JLabel caixafantasma2_1 = new JLabel("");
		caixafantasma2_1.setBounds(596, 127, 30, 128);
		contentPane.add(caixafantasma2_1);
		
		JLabel caixafantasma5_1_1 = new JLabel("");
		caixafantasma5_1_1.setBounds(271, 183, 78, 14);
		contentPane.add(caixafantasma5_1_1);
		
		JLabel caixafantasma2 = new JLabel("");
		caixafantasma2.setBounds(524, 232, 14, 70);
		contentPane.add(caixafantasma2);
		
		JLabel caixafantasma4 = new JLabel("");
		caixafantasma4.setBounds(327, 232, 14, 70);
		contentPane.add(caixafantasma4);
		
		JLabel caixafantasma3 = new JLabel("");
		caixafantasma3.setBounds(323, 237, 61, 9);
		contentPane.add(caixafantasma3);
		
		JLabel caixafantasma1 = new JLabel("");
		caixafantasma1.setBounds(333, 299, 199, 0);
		contentPane.add(caixafantasma1);
		
		JLabel canto_1 = new JLabel("");
		canto_1.setBounds(10, 254, 21, 39);
		contentPane.add(canto_1);
		
		JLabel canto_2 = new JLabel("");
		canto_2.setBounds(831, 254, 21, 39);
		contentPane.add(canto_2);
		
		JLabel gameover = new JLabel("fn");
		gameover.setVerticalAlignment(SwingConstants.TOP);
		gameover.setBounds(0, 0, 850, 573);
		contentPane.add(gameover);
		
		JLabel text = new JLabel("Score:");
		text.setForeground(Color.BLACK);
		text.setBounds(10, 579, 40, 25);
		contentPane.add(text);
		
		JLabel secor = new JLabel("0");
		secor.setForeground(Color.BLACK);
		secor.setBounds(51, 573, 40, 36);
		contentPane.add(secor);
		
		JLabel fundo = new JLabel("fn");
		fundo.setVerticalAlignment(SwingConstants.TOP);
		fundo.setBounds(0, 0, 850, 573);
		
		fundo.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/cenario pac.png")));
		contentPane.add(fundo);
		
		
		addKeyListener(new KeyAdapter() {
			public void retomarJogo() {
				if (emPause) {
					timer = new javax.swing.Timer();
					tarefaAux = new Aux();
					timer.scheduleAtFixedRate(tarefaAux, 0, 1000);
					emPause = false;
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				start=true;
				if (start=true) {

					if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
						Pause pause = new Pause(this);
						pause.setVisible(true);
					}

				if(e.getKeyCode()==KeyEvent.VK_RIGHT && parede==true) {

					pacman.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/RIGHT.gif")));

					pacman.setLocation(pacman.getLocation().x+10,pacman.getLocation().y);
					 sentido="DIREITA";

				}

				if(sentido.equals("DIREITA")) {


					 if(parede==false) {

						pacman.setLocation(pacman.getLocation().x-5,pacman.getLocation().y);

						parede=true;

					}

				}

					if(e.getKeyCode()==KeyEvent.VK_LEFT && parede==true) {

						pacman.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/LEFT.gif")));

						pacman.setLocation(pacman.getLocation().x-10,pacman.getLocation().y);


						sentido="ESQUERDA";


					}


					if(sentido.equals("ESQUERDA")) {

							if( parede==false){

								pacman.setLocation(pacman.getLocation().x+5,pacman.getLocation().y);


								parede=true;

						}
					}








				if(e.getKeyCode()==KeyEvent.VK_UP && parede==true) {

					pacman.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/UP.gif")));

					pacman.setLocation(pacman.getLocation().x,pacman.getLocation().y-10);

					sentido="UP";

				}

				if (sentido.equals("UP")) {

						if(parede==false) {

							pacman.setLocation(pacman.getLocation().x,pacman.getLocation().y+5);

							parede=true;

					}

				}


				if(e.getKeyCode()==KeyEvent.VK_DOWN && parede==true) {

					pacman.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/DOWN.gif")));


					pacman.setLocation(pacman.getLocation().x,pacman.getLocation().y+10);
				sentido="DOWN";
				}

				if(sentido.equals("DOWN"))
				 if(parede==false){

					pacman.setLocation(pacman.getLocation().x,pacman.getLocation().y-5);

					parede=true;


				}
			}

			}
		});	
		
		Timer timer = new Timer();
	}
		class Aux extends TimerTask{
			private int life=0;
			private boolean andar2=true;

			@Override
			public void run() {
				secor.setText(""+score);

				// TODO Auto-generated method stub
				if (start && !emPause) {

				if (andar) {

					if(Ghost.getLocation().y>25 && Ghost3.getLocation().y>456) {




						andar=false;




					}
					else {



					Ghost.setLocation(Ghost.getLocation().x, Ghost.getLocation().y+10);
					Ghost3.setLocation(Ghost3.getLocation().x, Ghost3.getLocation().y+10);
					}



				}
				else {

					if(Ghost.getLocation().y<455 && Ghost3.getLocation().y<26) {



						andar=true;



					}
					else {



						Ghost.setLocation(Ghost.getLocation().x, Ghost.getLocation().y-10);
						Ghost3.setLocation(Ghost3.getLocation().x, Ghost3.getLocation().y-10);
					}



				}


				if (andar2) {

					if(Ghost2.getLocation().x<45 && Ghost4.getLocation().x<790) {



						andar2=false;



					}
					else {



					Ghost2.setLocation(Ghost2.getLocation().x-10, Ghost2.getLocation().y);
					Ghost4.setLocation(Ghost4.getLocation().x-10, Ghost4.getLocation().y);
					}



				}

				else {

					if(Ghost2.getLocation().x>785 && Ghost4.getLocation().x>50) {



						andar2=true;



					}
					else {



						Ghost2.setLocation(Ghost2.getLocation().x+10, Ghost2.getLocation().y);
						Ghost4.setLocation(Ghost4.getLocation().x+10, Ghost4.getLocation().y);
					}



				}
				if(choque((JLabel)pacman,DOT39)) {
			    	DOT39.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT39.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT38)) {
			    	DOT38.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT38.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT37)) {
			    	DOT37.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT37.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT36)) {
			    	DOT36.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT36.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT35)) {
			    	DOT35.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT35.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT34)) {
			    	DOT34.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT34.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT33)) {
			    	DOT33.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT33.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT32)) {
			    	DOT32.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT32.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT31)) {
			    	DOT31.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT31.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT30)) {
			    	DOT30.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT30.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT29)) {
			    	DOT29.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT29.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT28)) {
			    	DOT28.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT28.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT27)) {
			    	DOT27.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT27.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT26)) {
			    	DOT26.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT26.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT25)) {
			    	DOT25.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT25.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT24)) {
			    	DOT24.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT24.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT23)) {
			    	DOT23.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT23.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT22)) {
			    	DOT22.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT22.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT21)) {
			    	DOT21.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT21.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT20)) {
			    	DOT20.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT20.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT19)) {
			    	DOT19.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT19.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT18)) {
			    	DOT18.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT18.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT17)) {
			    	DOT17.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT17.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT16)) {
			    	DOT16.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT16.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT15)) {
			    	DOT15.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT15.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT14)) {
			    	DOT14.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT14.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT13)) {
			    	DOT13.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT13.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT12)) {
			    	DOT12.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT12.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT11)) {
			    	DOT11.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT11.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT10)) {
			    	DOT10.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT10.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT9)) {
			    	DOT9.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT9.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT8)) {
			    	DOT8.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT8.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT7)) {
			    	DOT7.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT7.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT6)) {
			    	DOT6.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT6.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT5)) {
			    	DOT5.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT5.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT4)) {
			    	DOT4.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT4.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT3)) {
			    	DOT3.setVisible(false);
			    	score+=10;
			    	u+=1;
			    	DOT3.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT2)) {
			    	DOT2.setVisible(false);
			    	u+=1;
			    	DOT2.setLocation(-100, -100);

			    }
				if(choque((JLabel)pacman,DOT1)) {
			    	DOT1.setVisible(false);
			    	u+=1;
			    	DOT1.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,DOT)) {
			    	DOT.setVisible(false);
			    	u+=1;
			    	DOT.setLocation(-100, -100);
			    }
				if(choque((JLabel)pacman,Ghost4)) {
			    	life=life+1;
			    	tentativa=tentativa+1;
			    }
				if(choque((JLabel)pacman,Ghost3)) {
			    	life=life+1;
			    	tentativa=tentativa+1;
			    }
				if(choque((JLabel)pacman,Ghost2)) {
			    	life=life+1;
			    	tentativa=tentativa+1;
			    }
				if(choque((JLabel)pacman,Ghost)) {
					    	life=life+1;
					    	tentativa=tentativa+1;
					    }

				if (choque(pacman,canto_1)) {

					pacman.setLocation(pacman.getLocation().x+750, pacman.getLocation().y);

					pacman.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/LEFT.gif")));
				}
				if (choque(pacman,canto_2)) {

					pacman.setLocation(pacman.getLocation().x=40, pacman.getLocation().y);

					pacman.setIcon(new ImageIcon(pmanc.class.getResource("/imagens/RIGHT.gif")));
				}




				System.out.println(tentativa);

				if(u==40) {
					JFrame frame = new JFrame("Bem Jogado!");

					JOptionPane.showMessageDialog(frame,"Bem Jogado!");

					u+=1;

				}
			    if(u==41) {

			    	u+=1;

					timer.cancel();

					Win win=new Win() ;

					win.setVisible(true);

					dispose();
				}



				if (choque(pacman,Ghost4)&&tentativa>=1 && tentativa<=2) {

					if(tentativa==1) {
						coração1.setVisible(false);
					}
					if(tentativa==2) {
						coração2.setVisible(false);
					}

					JFrame frame = new JFrame("Boa Tentativa!");

					  pacman.setLocation(410,310);

					  JOptionPane.showMessageDialog(frame,"Recomece!");


				}
				else if(tentativa>3) {


				if (choque(pacman,Ghost4) && life>=3) {
					coração3.setVisible(false);
					timer.cancel();

					gameover go=new gameover();
					go.setVisible(true);
					dispose();



				}
				}
				if (choque(pacman,Ghost2)&&tentativa>=1 && tentativa<=2) {

					if(tentativa==1) {
						coração1.setVisible(false);
					}
					if(tentativa==2) {
						coração2.setVisible(false);
					}


					JFrame frame = new JFrame("Boa Tentativa!");

					  pacman.setLocation(417,318);

					  JOptionPane.showMessageDialog(frame,"Recomece!");


				}
				else if(tentativa>3) {


				if (choque(pacman,Ghost2) && life>=3) {

					coração3.setVisible(false);

					timer.cancel();

					gameover go=new gameover();
					go.setVisible(true);
					dispose();

				}}
				if (choque(pacman,Ghost3)&&tentativa>=1 && tentativa<=2) {

					if(tentativa==1) {
						coração1.setVisible(false);
					}
					if(tentativa==2) {
						coração2.setVisible(false);
					}


					JFrame frame = new JFrame("Boa Tentativa!");

					  pacman.setLocation(417,318);

					  JOptionPane.showMessageDialog(frame,"Recomece!");


				}
				else if(tentativa>3) {


				if (choque(pacman,Ghost3) && life>=3) {
					coração3.setVisible(false);
					timer.cancel();

					gameover go=new gameover();
					go.setVisible(true);
					dispose();


				}
				}

				if (choque(pacman,Ghost)&&tentativa>=1 && tentativa<=2) {

					if(tentativa==1) {
						coração1.setVisible(false);
					}
					if(tentativa==2) {
						coração2.setVisible(false);
					}


					JFrame frame = new JFrame("Boa Tentativa!");

					  pacman.setLocation(417,318);

					  JOptionPane.showMessageDialog(frame,"Recomece!");


				}
				else if(tentativa>3) {


				if (choque(pacman,Ghost) && life>=3) {


					timer.cancel();

					gameover go=new gameover();
					go.setVisible(true);
					dispose();

				}
}


				  for (Component c : contentPane.getComponents()) {

					    if (c instanceof JLabel) {

					    	if( choque((JLabel)c,pacman) ) {

					    		 System.out.println("choque");

					    		}

					    }
				  }

				}
			}

		}
		 
		TimerTask task = new Aux(); 
      timer.schedule(task, 50, 50);
        



			}
			
	
		

