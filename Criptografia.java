/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import Configs.HibernateUtility;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Gustavo
 */
public class Criptografia {

    public String CriptografiaSenha(String input) throws NoSuchAlgorithmException {
        String hashed = null;

        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(input.getBytes(), 0, input.length());

        hashed = new BigInteger(1, digest.digest()).toString(16);
        return hashed;
    }

    public Boolean AutenticaUser(String input) throws NoSuchAlgorithmException {
        
        String hashed = CriptografiaSenha(input);
        // pegar usuario do banco chamar DAOUsuario
        // dar .Equals entre usuario.Senha e hashed
        return (hashed.equals(obterUsuario("Putz6")));            
    }
    
    //método fake que deve estar na classe DAOUsuario
    private String obterUsuario(String login)
    {
        String retorno = null;
        Session s = HibernateUtility.getSession();
        Query createSQLQuery = s.createQuery(new String("from Usuarios where Login = :login"));
        createSQLQuery.setParameter("login", login);
        List list = createSQLQuery.list();
                
        return retorno = ((Usuarios)list.get(0)).getSenha();       
    }
}
