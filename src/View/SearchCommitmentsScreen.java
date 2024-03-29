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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import commitments.Commitments;

public class SearchCommitmentsScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public SearchCommitmentsScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchCommitmentsScreen.class.getResource("/images/seo.png")));
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
		panel.setBackground(new Color(255, 99, 71));
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
		panel_1.setBackground(new Color(255, 99, 71));
		panel_1.setBounds(0, 412, 794, 53);
		contentPane.add(panel_1);
		
		Font customFont = new Font("Arial", Font.BOLD, 14);

		List listNames = new List();
		listNames.setEnabled(false);
		listNames.setBounds(145, 131, 358, 246);
		listNames.setFont(customFont);
		contentPane.add(listNames);
		
		JLabel label_1 = new JLabel("NAME");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		label_1.setBounds(145, 98, 358, 27);
		contentPane.add(label_1);
		
		List listID = new List();
		listID.setBounds(499, 131, 147, 246);
		contentPane.add(listID);
				
		ArrayList<Commitments> commitmentsList = new ArrayList<Commitments>();

		try {
			Commitments commitments = new Commitments();
			commitmentsList.addAll(commitments.searchCommitments());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Commitments commitment : commitmentsList) {
			listNames.add(commitment.getName());	
			listID.add(commitment.getId().toString());			
		}
		listID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Long id = Long.valueOf(listID.getSelectedItem());
					ConsultCommitmentsScreen frame = new ConsultCommitmentsScreen(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel label_2 = new JLabel("CODE");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		label_2.setBounds(499, 98, 147, 27);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SearchCommitmentsScreen.class.getResource("/images/pontos-de-interroga\u00E7\u00E3o-coloridos-dos-bilhetes-escritos-fundo-lembretes-do-quadro-pe\u00E7a-ou-conceito-neg\u00F3cio-com-espa\u00E7o-da-111730210.jpg")));
		label.setBounds(0, 69, 794, 345);
		contentPane.add(label);
	}
}
