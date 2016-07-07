package persistence;

import model.*;
import org.hibernate.*;

public class ClienteDao {
    
    public void salvar(Cliente c, Endereco e)throws Exception{
        
        //obter acesso ao banco de dados
        Session s = HibernateUtil.getSessionFactory().openSession();
        
        //abrir uma transação com o banco de dados
        Transaction t = s.beginTransaction();
        
        //gravar registros
        s.save(c);
        s.save(e);
        
        //confirmar a transação
        t.commit();
    }
    
}
