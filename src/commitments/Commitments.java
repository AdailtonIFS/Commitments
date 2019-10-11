package commitments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Commitments {

	private String Name;
	private String Local;
	private String DateStart;
	private String DateEnd;
	private String Description;
	private String Codigo;
	
	
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
	public String getDateStart() {
		return DateStart;
	}
	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}
	public String getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public Commitments(String name, String local, String dateStart, String dateEnd, String description, String codigo) {
		super();
		this.setName(name);
		this.setLocal(local);
		this.setDateStart(dateStart);
		this.setDateEnd(dateEnd);
		this.setDescription(description);		
		this.setCodigo(codigo);
	}
	public Commitments() {
		// TODO Auto-generated constructor stub
	}
	
	/*O METODO registerCommitments
	 * SERVE PARA CADASTRAR
	 * UM COMPROMISSO NO
	 * BANCO DE DADOS
	 */
	
	public void registerCommitments(String tabela, ArrayList <String> valores) throws SQLException {
		Connection conn = DataBase.DB.getConnection();
		String sql;
		Statement statement = conn.createStatement();

		sql = String.format("insert into %s values (", tabela);

		for (String valor : valores) {
			sql += "'" + valor + "',";
		}

		sql = sql.substring(0, sql.length() - 1) + ")";

		statement.executeUpdate(sql);
		statement.close();
	
	}//registerCommitments final;
	
	
	/*O METODO searchCommitments
	 * SERVE PARA BUSCAR INFORMAÇÕES
	 * SOBRE UM COMPROMISSO
	 * NO BANCO DE DADOS
	 */

	public static ArrayList<String> searchCommitments(String tabela) throws SQLException {
	Connection conn = DataBase.DB.getConnection();
	Statement statement = conn.createStatement();
	ArrayList<String> valores = new ArrayList <String> ();

	ResultSet rs = statement.executeQuery("select * from "+tabela);
	
	while(rs.next()) {
		valores.add(rs.getString("name"));
		valores.add(rs.getString("local"));
		valores.add(rs.getString("datestart"));
		valores.add(rs.getString("dateend"));
		valores.add(rs.getString("description"));
		valores.add(rs.getString("code"));
	}
	
	return valores;
	
	}//searchCommitments final;
	
	public static void deleteCommitments(String tabela, String codigo) throws SQLException {
		
		Connection conn = DataBase.DB.getConnection();
		String sql;
	
		Statement statement = conn.createStatement();
		sql = "delete from  "+ tabela+" where code = '"+codigo+"'";
		statement.executeUpdate(sql);
		statement.close();
	}
	public static void updateCommitments(String tabela, String atributo, String NewAtributo,String codigo) throws SQLException {
		
		Connection conn = DataBase.DB.getConnection();
		String sql;
	
		Statement statement = conn.createStatement();
		sql ="update "+tabela+" set "+atributo+" = '"+NewAtributo+"' where code = '"+codigo+"'";
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
