package jogo.dados.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jogo.dados.model.Dado;

public class DadoDao implements Dao<Dado> {
    public Dado get(Long id) {
        Dado dado = null;
        String sql = "select * from dices where id = ?"; // ? is a parameters for the prepared statement
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null; //stores the query result

        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            // sending the parameter to sql execution
            preparedStatement.setInt(1, id.intValue()); // id is an object, not primitive (intValue required)
            resultSet = preparedStatement.executeQuery();
            // iterates the resultSet and stores in the object the column values from the database
            while (resultSet.next()){
                dado = new Dado();
                dado.setId(resultSet.getLong("id"));
                dado.setValorFace(resultSet.getInt("valorFace"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return dado;
    }
    @Override
    public List<Dado> getAll() { //listAll (if the database is huge, consider the use of pagination)
        List<Dado> dados = new ArrayList<Dado>();
        String sql = "select * from dices"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null; //stores the query result

        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            // iterates the resultSet and stores in the object the column values from the database
            while (resultSet.next()){
                Dado dado = new Dado();
                dado.setId(resultSet.getLong("id"));
                dado.setValorFace(resultSet.getInt("valorFace"));

                dados.add(dado); //add the object filled with database data to products list
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return dados;
    }

    @Override
    public int save(Dado dado) {
        String sql = "insert into dices (valorFace)" + " values (?)"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, dado.getValorFace());
            
            preparedStatement.execute(); //it is not a query. It is an insert command
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return 1;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    @Override
    public boolean update(Dado dado, String[] params) {
        // if you use params, use parse methods (parseFloat, parseLong etc.)
        String sql = "update dices set valorFace = ? where id = ?"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, dado.getValorFace());
            preparedStatement.setLong(2, dado.getId());
            
            preparedStatement.execute(); //it is not a query. It is an insert command
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean delete(Dado dado) {
        String sql = "delete from dices where id = ?"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setLong(1, dado.getId());
            
            preparedStatement.execute(); //it is not a query. It is an insert command
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    

}
