package Screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import commitments.Commitments;

public class RegisterCommitmentsScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLocal;
	private JTextField txtCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterCommitmentsScreen frame = new RegisterCommitmentsScreen();
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
	public RegisterCommitmentsScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterCommitmentsScreen.class.getResource("/images/dominio.png")));

		Font dropthegame1 = null;
		
		try {
			dropthegame1 = Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")).deriveFont(82f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")));
		} catch(IOException | FontFormatException e){
			
		}
		
		setTitle("Register Commitments");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(0, 102, 51));
		panel.setBounds(0, 0, 794, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistering = new JLabel("REGISTERING");
		lblRegistering.setForeground(Color.WHITE);
		lblRegistering.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistering.setBounds(0, -11, 794, 79);
		lblRegistering.setFont(dropthegame1);
		panel.add(lblRegistering);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(0, 204, 102));
		panel_1.setBounds(0, 412, 794, 53);
		contentPane.add(panel_1);
		
		txtName = new JTextField();
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtName.setBounds(61, 124, 178, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblName.setBounds(61, 91, 178, 22);
		contentPane.add(lblName);
		
		JDateChooser Start = new JDateChooser();
		Start.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Start.setBounds(61, 319, 178, 22);
		contentPane.add(Start);
		
		JLabel lblIncio = new JLabel("START:");
		lblIncio.setForeground(Color.WHITE);
		lblIncio.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblIncio.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncio.setBounds(61, 288, 178, 22);
		contentPane.add(lblIncio);
		
		JLabel lblLocal = new JLabel("LOCAL:");
		lblLocal.setForeground(Color.WHITE);
		lblLocal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(61, 158, 178, 26);
		contentPane.add(lblLocal);
		
		txtLocal = new JTextField();
		txtLocal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtLocal.setBounds(61, 188, 178, 22);
		contentPane.add(txtLocal);
		txtLocal.setColumns(10);
		
		JDateChooser End = new JDateChooser();
		End.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		End.setBounds(61, 379, 178, 22);
		contentPane.add(End);
		
		JLabel lblFinal = new JLabel("FINAL:");
		lblFinal.setForeground(Color.WHITE);
		lblFinal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinal.setBounds(61, 349, 178, 22);
		contentPane.add(lblFinal);
		
		TextArea taDescription = new TextArea();
		taDescription.setFont(new Font("Arial Black", Font.BOLD, 14));
		taDescription.setBounds(314, 124, 338, 200);
		contentPane.add(taDescription);
		
		JLabel lblDescrio = new JLabel("DESCRIPTION");
		lblDescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDescrio.setBounds(314, 91, 338, 27);
		contentPane.add(lblDescrio);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setIcon(new ImageIcon(RegisterCommitmentsScreen.class.getResource("/images/folder (1).png")));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setBounds(435, 349, 100, 50);
		contentPane.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton.setBorder(new LineBorder(new Color(0, 204, 255), 2));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));

			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Commitments Comm = new Commitments();
				
				if(!txtName.getText().isEmpty() && !txtLocal.getText().isEmpty() && Start != null && End != null && !txtCode.getText().isEmpty()) {
					Comm.setName(txtName.getText());
					Comm.setLocal(txtLocal.getText());
				
					SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
					String result = out.format(Start.getDate());
					Comm.setDateStart(result);
					String result2 = out.format(End.getDate());
					Comm.setDateEnd(result2);
					Comm.setDescription(taDescription.getText());
					Comm.setCodigo(txtCode.getText());
					
					ArrayList<String> valores = new ArrayList<String>();
					String tabela = "Commitments";
					
					valores.add(txtName.getText());
					valores.add(txtLocal.getText());
					valores.add(result);
					valores.add(result2);
					valores.add(taDescription.getText());
					valores.add(txtCode.getText());
					
					
					try {
						Comm.registerCommitments(tabela, valores);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					dispose();
					JOptionPane.showMessageDialog(null, "               COMMITMENTS REGISTERED WITH SUCCEFUL", "SUCCEFUL",-1);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ALERT", 2);
				}
			
			}
		});
		
		JLabel lblCode = new JLabel("CODE:");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setForeground(Color.WHITE);
		lblCode.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblCode.setBounds(61, 227, 178, 22);
		contentPane.add(lblCode);
		
		txtCode = new JTextField();
		txtCode.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtCode.setBounds(61, 258, 178, 22);
		contentPane.add(txtCode);
		txtCode.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setIcon(new ImageIcon(RegisterCommitmentsScreen.class.getResource("/images/danbo-pkmnkats-hobbies-25083724-1920-1200.jpg")));
		label.setBounds(-25, 67, 846, 346);
		contentPane.add(label);
	}
}
