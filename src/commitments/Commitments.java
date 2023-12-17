package commitments;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DataBase.DbException;

public class Commitments {

	private Long id;
	private String Name;
	private String Local;
	private Date DateStart;
	private Date DateEnd;
	private String Description;
	private String table = "commitments";
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	public Date getDateStart() {
		return DateStart;
	}
	public void setDateStart(Date dateStart) {
		DateStart = dateStart;
	}
	public Date getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		DateEnd = dateEnd;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public Commitments(String name, String local, Date dateStart, Date dateEnd, String description) {
		this.setName(name);
		this.setLocal(local);
		this.setDateStart(dateStart);
		this.setDateEnd(dateEnd);
		this.setDescription(description);		
	}
	public Commitments() {
	}
	
	/*O METODO registerCommitments
	 * SERVE PARA CADASTRAR
	 * UM COMPROMISSO NO
	 * BANCO DE DADOS
	 */
	
	public void registerCommitments(Commitments commitments) throws SQLException {
		Connection conn = DataBase.DB.getConnection();
		Statement statement = conn.createStatement();

		String sql;

		sql = String.format("INSERT INTO %s (name, local, date_start, date_end, description) VALUES (", this.table);
		sql += "'" + commitments.getName() + "',";
		sql += "'" + commitments.getLocal() + "',";
		sql += "'" + commitments.getDateStart() + "',";
		sql += "'" + commitments.getDateEnd() + "',";
		sql += "'" + commitments.getDescription() + "')";
		
		statement.executeUpdate(sql);
		statement.close();
	
	}//registerCommitments final;
	
	
	/*O METODO searchCommitments
	 * SERVE PARA BUSCAR INFORMA��ES
	 * SOBRE UM COMPROMISSO
	 * NO BANCO DE DADOS
	 */

	public List<Commitments> searchCommitments() throws SQLException {
		Connection conn = DataBase.DB.getConnection();
		Statement statement = conn.createStatement();
		
		ArrayList<Commitments> commitments = new ArrayList <Commitments> ();
			
		ResultSet rs = statement.executeQuery("SELECT * FROM " + this.table);
		
		while(rs.next()) {
			Commitments commitment = new Commitments();
			commitment.setId(Long.valueOf(rs.getString("id")));
			commitment.setName(rs.getString("name"));
			commitment.setLocal(rs.getString("local"));
			commitment.setDateStart(rs.getDate("date_start"));
			commitment.setDateEnd(rs.getDate("date_end"));
			commitment.setDescription(rs.getString("description"));
			commitments.add(commitment);
		}
		
		return commitments;
	}

	public Commitments getById(Long id) throws SQLException{
		Connection conn = DataBase.DB.getConnection();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM " + this.table + " WHERE id = " + id);
		
		Commitments commitment = new Commitments();
		
		if (!rs.next()) {
			throw new DbException("Commitment não encontrado;");
		}
		
		commitment.setName(rs.getString("name"));
		commitment.setLocal(rs.getString("local"));
		commitment.setDateStart(rs.getDate("date_start"));
		commitment.setDateEnd(rs.getDate("date_end"));
		commitment.setDescription(rs.getString("description"));
	
		return commitment;
	}

	public void deleteCommitments(Long id) throws SQLException {
		
		Connection conn = DataBase.DB.getConnection();
		Statement statement = conn.createStatement();

		String sql = "DELETE FROM "+ this.table + " WHERE id = " + id;
		statement.executeUpdate(sql);
		statement.close();
	}
	public void updateCommitments(Commitments commitments) throws SQLException {
		
		Connection conn = DataBase.DB.getConnection();
	
		Statement statement = conn.createStatement();
		String sql ="UPDATE " + this.table + " SET " 
									+ "name ='" + commitments.getName() + "', "
									+ "local = '" + commitments.getLocal() + "', "
									+ "date_start = '" + commitments.getDateStart() + "', "
									+ "date_end = '" + commitments.getDateEnd() + "', "
									+ "description = '" + commitments.getDescription() + "'"
									+ "WHERE id = "+ commitments.getId() +";" ;
		statement.executeUpdate(sql);
		statement.close();
	}
	
	public static int countRegisters() throws SQLException {
		
		Connection conn = DataBase.DB.getConnection();
		Statement statement = conn.createStatement();
		String tabela = "commitments";
		int resultado = 0;
		
		ResultSet rs = statement.executeQuery("select count (*) from "+tabela);

		
		if(rs.next()) {
			resultado = rs.getInt(1);
		}
		return resultado;
	}
	
	
	
	
	public static String findDate(){
		
		Date Date = new Date();
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
		String result = out.format(Date); 
			return result;
	}

}
