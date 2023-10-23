


import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    
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

            ps.execute();
            JOptionPane.showMessageDialog(null," Cadastro do produto realizado !");
        } catch (SQLException sqle) {
          JOptionPane.showMessageDialog(null," Erro ao cadastrar! "+sqle.getMessage());

        }

        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
                        conn = new conectaDAO().connectDB();
                String sql = "SELECT * FROM produtosL"; 
                
                try {
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();            
                    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

                    while (rs.next()) { 
                    ProdutosDTO p = new ProdutosDTO();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setValor(rs.findColumn("valor"));
                    p.setStatus(rs.getString("status"));
                    listagem.add(p);
                    }
                    return listagem;
                    
                } catch (Exception e) {
                    return null;
                }
        
        
        
    }
    
    
    
        
}

