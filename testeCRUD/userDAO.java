import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class userDAO {

    Connection connect = new connect().getConnect();
    PreparedStatement stmt;
    ResultSet rset;
    ArrayList<user> lista = new ArrayList<>();

    public ResultSet logar(user objUser){

        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";

        try {
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, objUser.getUser());
            stmt.setString(2, objUser.getPassword());
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void cadastrar(user objuser){

        String sql = "INSERT INTO usuario (nome, senha) VALUES (?, ?)";

        try {
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, objuser.getUser());
            stmt.setString(2, objuser.getPassword());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar, nome de usuário já existente.");
        }       
    }

    public ArrayList<user> buscar() {

		String sql = "SELECT * FROM usuario";
        
		try {
			stmt = connect.prepareStatement(sql);
            rset = stmt.executeQuery();
            
            while(rset.next()){
                user objuser = new user();
                objuser.setId(rset.getInt("id"));
                objuser.setUser(rset.getString("nome"));
                objuser.setPassword(rset.getString("senha"));
                lista.add(objuser);
            }
		} catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
		}
        return lista;
	} 

    public void alterar(user objuser) {

        String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE id = ?";

        try {
            stmt = connect.prepareStatement(sql);
            stmt.setString(1, objuser.getUser());
            stmt.setString(2, objuser.getPassword());
            stmt.setInt(3, objuser.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
   }

   public void excluir(user objuser) {

    String sql = "DELETE FROM usuario WHERE id = ?";
    
    try {
        stmt = connect.prepareStatement(sql);
        stmt.setInt(1, objuser.getId());

        stmt.execute();
        stmt.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
   }
}