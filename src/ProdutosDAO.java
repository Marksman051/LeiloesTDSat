


import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (){
        
        
        conn = new conectaDAO().connectDB();
        ProdutosDTO produto = new ProdutosDTO();
        PreparedStatement ps;
        String sql = "insert into produtosL values (?,?,?)";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1,produto.getNome());
            ps.setDouble(2,produto.getValor());
            ps.setString(3,produto.getStatus());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null," Cadastro do produto realizado !");
        } catch (SQLException sqle) {
          JOptionPane.showMessageDialog(null," erro ao cadastrar!"+sqle.getMessage());

        }

        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

