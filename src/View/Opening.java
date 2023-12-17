package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Opening extends JFrame {
	private static final long serialVersionUID = 1L;
	

	private JPanel contentPane;

	private static Opening frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Opening();
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
	public Opening() {
		setTitle("SUPERMERCADO");
		Font dropthegame1 = null;
		
		try {
			dropthegame1 = Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")).deriveFont(82f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")));
		} catch(IOException | FontFormatException e){
			
		}
		setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBemVindo = new JLabel("BEM VINDO");
		lblBemVindo.setBackground(Color.WHITE);
		lblBemVindo.setForeground(Color.BLACK);
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Comic Sans MS", Font.BOLD, 74));
		lblBemVindo.setBounds(0, 55, 599, 105);
		contentPane.add(lblBemVindo);
		lblBemVindo.setFont(dropthegame1);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.WHITE);
		label_1.setBorder(new MatteBorder(0, 0, 6, 0, (Color) Color.BLACK));
		label_1.setBounds(27, 178, 545, 14);
		contentPane.add(label_1);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.BLACK);
		progressBar.setBackground(Color.WHITE);
		progressBar.setIndeterminate(true);
		progressBar.setBounds(75, 277, 450, 36);
		contentPane.add(progressBar);
		
		JLabel lblEntrada = new JLabel("");
		lblEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrada.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblEntrada.setBounds(0, 356, 599, 16);
		contentPane.add(lblEntrada);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Opening.class.getResource("/images/fists-commitment-team_si.jpg")));
		label.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));

		label.setBounds(0, 0, 599, 422);
		contentPane.add(label);
				
				new Thread (){
					
					
					public void run() {
						
						for(int i = 0; i < 101; i++) {
							
							try {
							    sleep(30);
							    if(i == 25) {
							    	lblEntrada.setText("CARREGANDO O C�DIGO...");
							    }
							    else
							    	if(i == 50) {
							    		lblEntrada.setText("CARREGANDO BANCO DE DADOS...");
							    	}
							    	else
							    		if(i == 75) {
								    		lblEntrada.setText("ENTRANDO...");

							    		}
								progressBar.setValue(i);
								
			
							}catch(InterruptedException ex){
							}
								
						}
						
						
						dispose();
						
						MainCommitmentsScreen frame = new MainCommitmentsScreen();
						frame.setVisible(true);
						
					}
				
				}.start();
				
				
				
		
		
		
	}
}
