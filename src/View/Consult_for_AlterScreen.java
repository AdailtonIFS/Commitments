package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import commitments.Commitments;

public class Consult_for_AlterScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String code;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consult_for_AlterScreen frame = new Consult_for_AlterScreen();
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
	public Consult_for_AlterScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Consult_for_AlterScreen.class.getResource("/images/seo.png")));
		setTitle("Search Commitments");

		Font dropthegame1 = null;
		
		try {
			dropthegame1 = Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")).deriveFont(82f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")));
		} catch(IOException | FontFormatException e){
			
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 794, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		JLabel lblSearch = new JLabel("Searching");
		lblSearch.setBackground(Color.WHITE);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setBounds(0, -12, 794, 80);
		lblSearch.setFont(dropthegame1);
		panel.add(lblSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 412, 794, 53);
		contentPane.add(panel_1);
		
		List listNames = new List();
		listNames.setEnabled(false);
		listNames.setBackground(Color.LIGHT_GRAY);
		listNames.setBounds(145, 131, 358, 246);
		contentPane.add(listNames);
		
		List listCodes = new List();
		listCodes.setBounds(499, 131, 147, 246);
		contentPane.add(listCodes);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblName.setBounds(145, 100, 338, 27);
		contentPane.add(lblName);
		
		JLabel lblCode = new JLabel("CODE");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setForeground(Color.BLACK);
		lblCode.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblCode.setBounds(499, 100, 147, 27);
		contentPane.add(lblCode);
				
		ArrayList<String> valores = new ArrayList<String>();
		String tabela = "Commitments";
		
		try {
			valores.addAll(Commitments.searchCommitments(tabela));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < valores.size(); i++) {

				listNames.add(valores.get(i));
				
				listCodes.add(valores.get(i+5));
				
			i += 5;
		
		}
		listCodes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					code = listCodes.getSelectedItem();				
					AlterCommitmentsScreen frame = new AlterCommitmentsScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
				
	
	}
}
