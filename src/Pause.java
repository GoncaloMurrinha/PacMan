import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Pause extends JFrame {
    private JPanel contentPane;
    private pmanc pmanc;

    public Pause(pmanc pmanc) {
        this.pmanc = pmanc;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 120));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(300, 200, 400, 220);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(255, 255, 255, 150));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
            }
        };
        contentPane.setOpaque(false);
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Jogo em Pausa");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBounds(60, 10, 280, 40);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle);

        JButton btnInicio = new JButton("Início");
        btnInicio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnInicio.setBounds(30, 80, 100, 45);
        btnInicio.addActionListener(e -> {
            // Exemplo: fechar tudo e voltar ao menu principal (depende de sua implementação)
            pmanc.dispose();
            dispose();
        });
        contentPane.add(btnInicio);

        JButton btnContinue = new JButton("Continuar");
        btnContinue.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnContinue.setBounds(145, 80, 120, 45);
        btnContinue.addActionListener(e -> {
            if (pmanc != null) pmanc.retomarJogo();
            dispose();
        });
        contentPane.add(btnContinue);

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnSair.setBounds(280, 80, 90, 45);
        btnSair.addActionListener(e -> System.exit(0));
        contentPane.add(btnSair);
    }
}