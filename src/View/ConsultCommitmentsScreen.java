package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import commitments.Commitments;

public class ConsultCommitmentsScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLocal;

	public ConsultCommitmentsScreen(Long id) throws SQLException {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainCommitmentsScreen.class.getResource("/images/pagina-inicial.png")));
		setTitle("Consult Commitments");
		
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
		panel.setBackground(new Color(0, 255, 127));
		panel.setBounds(0, 0, 794, 68);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblSearch = new JLabel("Consulting");
		lblSearch.setBackground(Color.WHITE);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setBounds(0, -12, 794, 80);
		lblSearch.setFont(dropthegame1);
		panel.add(lblSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 127));
		panel_1.setBounds(0, 412, 794, 53);
		contentPane.add(panel_1);
		
		txtName = new JTextField();
		txtName.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtName.setBounds(61, 124, 178, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNome = new JLabel("NAME:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNome.setBounds(61, 91, 178, 22);
		contentPane.add(lblNome);
		
		JLabel lblLocal = new JLabel("LOCAL:");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblLocal.setBounds(61, 158, 178, 22);
		contentPane.add(lblLocal);
		
		txtLocal = new JTextField();
		txtLocal.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtLocal.setColumns(10);
		txtLocal.setBounds(61, 193, 178, 22);
		contentPane.add(txtLocal);
		
		JLabel lblInicio = new JLabel("START:");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblInicio.setBounds(61, 288, 178, 22);
		contentPane.add(lblInicio);
		
		JDateChooser txtDateStart = new JDateChooser();
		txtDateStart.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtDateStart.setBounds(61, 319, 178, 22);
		contentPane.add(txtDateStart);
		
		JLabel lblFinal = new JLabel("FINAL:");
		lblFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblFinal.setBounds(61, 349, 178, 22);
		contentPane.add(lblFinal);
		
		JDateChooser txtEnd = new JDateChooser();
		txtEnd.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtEnd.setBounds(61, 379, 178, 22);
		contentPane.add(txtEnd);
				
		TextArea taDescription = new TextArea();
		taDescription.setBounds(314, 129, 338, 200);
		contentPane.add(taDescription);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDescription.setBounds(314, 102, 338, 22);
		contentPane.add(lblDescription);


		Commitments commitment = new Commitments().getById(id);
	
		txtName.setText(commitment.getName());
		txtLocal.setText(commitment.getDescription());
		txtDateStart.setDate(commitment.getDateStart());
		txtEnd.setDate(commitment.getDateEnd());
		taDescription.setText(commitment.getDescription());
		
		Button button = new Button("SALVAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commitments commitment = new Commitments();
				commitment.setId(id);
				commitment.setName(txtName.getText().trim());
				commitment.setLocal(txtLocal.getText().trim());
				commitment.setDateStart(txtDateStart.getDate());
				commitment.setDateEnd(txtEnd.getDate());
				commitment.setDescription(taDescription.getText().trim());

				try {
                    commitment.updateCommitments(commitment);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
			}
		});
		button.setBounds(400, 358, 79, 24);
		contentPane.add(button);

		Button delete = new Button("DELETAR");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    commitment.deleteCommitments(id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }			
			}
		});
		delete.setBackground(Color.RED);
		delete.setBounds(487, 358, 79, 24);
		delete.setFont(new Font("Arial", Font.BOLD, 14));
		delete.setForeground(Color.WHITE);
		contentPane.add(delete);
	}
}