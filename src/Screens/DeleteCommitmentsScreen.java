package Screens;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import commitments.Commitments;
import javax.swing.JButton;

public class DeleteCommitmentsScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCommitmentsScreen frame = new DeleteCommitmentsScreen();
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
	public DeleteCommitmentsScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteCommitmentsScreen.class.getResource("/images/trash (1).png")));
		
		Font dropthegame1 = null;
		
		try {
			dropthegame1 = Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")).deriveFont(82f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")));
		} catch(IOException | FontFormatException e){
			
		}
		
		setTitle("Delete	 Commitments");
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
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 794, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistering = new JLabel("DELETING");
		lblRegistering.setForeground(Color.WHITE);
		lblRegistering.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistering.setBounds(0, -11, 794, 79);
		lblRegistering.setFont(dropthegame1);
		panel.add(lblRegistering);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(0, 412, 794, 53);
		contentPane.add(panel_1);
		
		List listNames = new List();
		listNames.setEnabled(false);
		listNames.setBackground(Color.LIGHT_GRAY);
		listNames.setBounds(144, 112, 358, 246);
		contentPane.add(listNames);

		
		
		List listCodes = new List();
		listCodes.setBounds(498, 112, 147, 246);
		contentPane.add(listCodes);
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

		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tabela ="Commitments";
				ArrayList<String> valores = new ArrayList<String>();

				try {
				
					String code = listCodes.getSelectedItem();
					
					Commitments.deleteCommitments(tabela, code);
					listNames.removeAll();
					listCodes.removeAll();
					JOptionPane.showMessageDialog(null, "OI");
					
				
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					valores.addAll(Commitments.searchCommitments(tabela));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 0; i < valores.size(); i++) {
					
						listNames.add(valores.get(i));
						listCodes.add(valores.get(i+5));
					
					i += 5;
				
				}
			}
		});
		btnDelete.setBounds(360, 378, 89, 23);
		contentPane.add(btnDelete);
		
		
	}
}
