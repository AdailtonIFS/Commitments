package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import javax.swing.JButton;

public class AlterCommitmentsScreen extends JFrame {

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
					AlterCommitmentsScreen frame = new AlterCommitmentsScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AlterCommitmentsScreen() throws ParseException {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlterCommitmentsScreen.class.getResource("/images/post-it (2).png")));

		Font dropthegame1 = null;
		
		try {
			dropthegame1 = Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")).deriveFont(82f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Cout-Regular.ttf")));
		} catch(IOException | FontFormatException e){
			e.printStackTrace();
		}
		
		setTitle("Alter Commitments");
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
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, -15, 794, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAlter = new JLabel("Altering");
		lblAlter.setBackground(SystemColor.desktop);
		lblAlter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlter.setBounds(0, 13, 794, 66);
		lblAlter.setFont(dropthegame1);
		panel.add(lblAlter);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 412, 794, 53);
		contentPane.add(panel_1);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblName.setBounds(61, 91, 178, 22);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
						if (e.getClickCount() == 2 && !e.isConsumed()) {
							
							String newAtributo = null;	
							txtName.setEditable(true);
							String tabela ="commitments";
							String atributo="name";
							if(!txtName.equals("")) {
								newAtributo = txtName.getText();	
								 try {
										Commitments.updateCommitments(tabela, atributo, newAtributo, Consult_for_AlterScreen.code);
										txtName.setEditable(false);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
							}
							else {
								JOptionPane.showMessageDialog(null, "FOI");
			
							}
					}
			}
		});
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtName.setBounds(61, 124, 178, 22);
		contentPane.add(txtName);

		JLabel lblLocal = new JLabel("LOCAL");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setForeground(Color.BLACK);
		lblLocal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblLocal.setBounds(61, 158, 178, 22);
		contentPane.add(lblLocal);
		
		txtLocal = new JTextField();
		txtLocal.setEditable(false);
		txtLocal.setColumns(10);
		txtLocal.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtLocal.setBounds(61, 188, 178, 22);
		contentPane.add(txtLocal);
		
		JLabel lblCode = new JLabel("CODE");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setForeground(Color.BLACK);
		lblCode.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblCode.setBounds(61, 227, 178, 22);
		contentPane.add(lblCode);
		
		txtCode = new JTextField();
		txtCode.setEditable(false);
		txtCode.setColumns(10);
		txtCode.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCode.setBounds(61, 379, 178, 22);
		contentPane.add(txtCode);
		
		JLabel lblStart = new JLabel("START");
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setForeground(Color.BLACK);
		lblStart.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblStart.setBounds(61, 288, 178, 22);
		contentPane.add(lblStart);
		
		JDateChooser Start = new JDateChooser();
		Start.setEnabled(false);
		Start.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Start.setBounds(61, 258, 178, 22);
		contentPane.add(Start);
		
		JLabel lblFinal = new JLabel("FINAL");
		lblFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinal.setForeground(Color.BLACK);
		lblFinal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblFinal.setBounds(61, 349, 178, 22);
		contentPane.add(lblFinal);
		
		JDateChooser Final = new JDateChooser();
		Final.setEnabled(false);
		Final.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Final.setBounds(61, 319, 178, 22);
		contentPane.add(Final);
		
		TextArea taDescription = new TextArea();
		taDescription.setEditable(false);
		taDescription.setBounds(314, 124, 338, 200);
		contentPane.add(taDescription);
		
		JLabel lblDescription = new JLabel("DESCRIPTION:");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDescription.setBounds(314, 86, 338, 27);
		contentPane.add(lblDescription);
		
		JButton btnNewButton = new JButton("ALTERAR");
		btnNewButton.setBounds(449, 350, 97, 25);
		contentPane.add(btnNewButton);
		

		ArrayList<String> valores = new ArrayList<String>();
		String tabela = "Commitments";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			valores.addAll(Commitments.searchCommitments(tabela));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<valores.size();i++) {
			
			if(Consult_for_AlterScreen.code.equalsIgnoreCase(valores.get(i))) {
				txtName.setText(valores.get(i-5));
				txtLocal.setText(valores.get(i-4));
				Date dataFormatada = formato.parse(valores.get(i-3));
				Date dataFormatadaa = formato.parse(valores.get(i-2));
				Start.setDate(dataFormatada);
				Final.setDate(dataFormatadaa);
				txtCode.setText(valores.get(i));
				taDescription.setText(valores.get(i-1));
				break;
				//PERGUNTAR A DAHAN;
				}
			}
		

		
	}
}
