package jogo.dados.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jogo.dados.model.Jogador;


public class JogadorDao implements Dao<Jogador> {
    @Override
    public Jogador get(Long id) {
        Jogador jogador = null;
        String sql = "select name, wins from rankingJogadores where id = ?"; // ? is a parameters for the prepared statement
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
                jogador = new Jogador();
                jogador.setId(resultSet.getLong("id"));
                jogador.setNome(resultSet.getString("name"));
                jogador.setWinCount(resultSet.getInt("wins"));
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
        return jogador;
    }
    @Override
    public List<Jogador> getAll() { //listAll (if the database is huge, consider the use of pagination)
        List<Jogador> jogadores = new ArrayList<Jogador>();
        String sql = "select name, wins from rankingJogadores order by"; 
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
                Jogador jogador = new Jogador();
                jogador.setId(resultSet.getLong("id"));
                jogador.setNome(resultSet.getString("name"));
                jogador.setWinCount(resultSet.getInt("wins"));

                jogadores.add(jogador); //add the object filled with database data to products list
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
        return jogadores;
    }

    @Override
    public int save(Jogador jogador) {
        String sql = "insert into tbproducts (name, wins)" + " values (?, ?)"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, jogador.getNome());
            preparedStatement.setLong(2, jogador.getId());
            preparedStatement.setFloat(3, jogador.getWinCount());
            
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
    public boolean update(Jogador jogador, String[] params) {
        // if you use params, use parse methods (parseFloat, parseLong etc.)
        String sql = "update rankingJogadores set name = ?, wins = ? where id = ?"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, jogador.getNome());
            preparedStatement.setInt(2, jogador.getWinCount());
            preparedStatement.setLong(3, jogador.getId());
            
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
    public boolean delete(Jogador jogador) {
        String sql = "delete from rankingJogadores where id = ?"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setLong(1, jogador.getId());
            
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
