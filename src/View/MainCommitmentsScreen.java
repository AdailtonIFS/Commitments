package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import commitments.Commitments;

public class MainCommitmentsScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDate;

	public MainCommitmentsScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainCommitmentsScreen.class.getResource("/images/pagina-inicial.png")));
		
		Font dropthegame1 = null;
		
		try {
			dropthegame1 = Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")).deriveFont(82f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")));
		} catch(IOException | FontFormatException e){
			
		}
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		//======================================================================================================
		//============================================buttonRegister============================================
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnRegister.setIcon(new ImageIcon(MainCommitmentsScreen.class.getResource("/images/post-it (1).png")));
		btnRegister.setBounds(37, 177, 130, 130);
		contentPane.add(btnRegister);
		
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnRegister.setBorder(new LineBorder(new Color(0, 204, 255), 2));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnRegister.setBorder(new LineBorder(new Color(0, 0, 0), 2));

			}
		});
	
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegisterCommitmentsScreen frame = new RegisterCommitmentsScreen();
					frame.setVisible(true);
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//=====================================================================================================	
		
		//======================================================================================================
		//=============================================buttonSearch=============================================
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSearch.setIcon(new ImageIcon(MainCommitmentsScreen.class.getResource("/images/notes.png")));
		btnSearch.setBounds(228, 177, 130, 130);
		contentPane.add(btnSearch);
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSearch.setBorder(new LineBorder(new Color(0, 204, 255), 2));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnSearch.setBorder(new LineBorder(new Color(0, 0, 0), 2));

			}
		});
	
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {//verificarCadastrou
					
						int contarDados = Commitments.countRegisters();
						if(contarDados == 0) {
							JOptionPane.showMessageDialog(null, "No commitments registered","Warning",2);
					}
						else {
					SearchCommitmentsScreen frame = new SearchCommitmentsScreen();
					frame.setVisible(true);
						}
						} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		//=====================================================================================================

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(23, 347, 736, 23);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(199, 177, 17, 130);
		contentPane.add(separator_1);
		
		

		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(12, 121, 758, 16);
		contentPane.add(separator_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(255, 255, 102));
		panel.setBounds(0, 412, 794, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("System Developed by Adailton Moura da Silva");
		lblNewLabel.setBounds(0, 0, 551, 53);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtDate = new JTextField();
		txtDate.setBounds(550, 0, 244, 29);
		txtDate.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtDate.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setBackground(new Color(255, 255, 102));
		panel.add(txtDate);
		txtDate.setColumns(10);
		txtDate.setText(Commitments.findDate());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(550, 29, 244, 23);
		panel_2.setBackground(new Color(255, 255, 102));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblHour = new JLabel("");
		lblHour.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		lblHour.setBounds(0, 0, 244, 22);
		panel_2.add(lblHour);
		
		Thread th = new Thread(new Runnable() { //cria uma thread
		        public void run() {
		            while(true) { //roda indefinidamente
		                Date data = Calendar.getInstance().getTime();
		                DateFormat h = DateFormat.getTimeInstance();
		                lblHour.setText(h.format(data));     
		                try {
		                    Thread.sleep(1000); //espera 1 segundo para fazer a nova evolu��o
		                } catch(InterruptedException ex){
						}
					}
				}
			}
		); 
		th.start();
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setIcon(new ImageIcon(MainCommitmentsScreen.class.getResource("/images/alx_postit2_original.jpeg")));
		label.setBounds(0, 66, 794, 347);
		contentPane.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(255, 255, 153));
		panel_1.setBounds(0, 0, 794, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCommitment = new JLabel("Commitments");
		lblCommitment.setBounds(0, -14, 794, 82);
		panel_1.add(lblCommitment);
		lblCommitment.setForeground(Color.BLACK);
		lblCommitment.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommitment.setFont(dropthegame1);
	}
}
