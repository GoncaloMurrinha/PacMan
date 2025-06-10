import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class gameover extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameover frame = new gameover();
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
	public gameover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton recomecar = new JButton("Recomecar!");
		recomecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmanc pacman=new pmanc() ;
				
				pacman.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnVoltar = new JButton("Voltar!");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game game=new game();
				
				game.setVisible(true);
				
				dispose();
			}
		});
		btnVoltar.setBounds(357, 11, 111, 67);
		contentPane.add(btnVoltar);
		recomecar.setBounds(10, 11, 111, 67);
		contentPane.add(recomecar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(gameover.class.getResource("/imagens/pacman-game-over.gif")));
		lblNewLabel.setBounds(0, 0, 478, 455);
		contentPane.add(lblNewLabel);
	}
}
