package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe `User` destinada a realizar operações no banco de dados, como a validação 
 * de credenciais (login e senha). Ela oferece métodos para estabelecer conexões 
 * e verificar informações dos usuários.
 */
public class User {
    /**
     * Método responsável por iniciar uma conexão com o banco de dados MySQL.
     * Utiliza o DriverManager para carregar o driver necessário e configurar 
     * os parâmetros de conexão.
     *
     * @return Connection Um objeto que representa a conexão com o banco de dados.
     * @throws SQLException Lança uma exceção caso a conexão falhe.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance(); // Carrega o driver
            String url = "jbdc:mysql://127.0.0.1/test?user=lopes&password=123"; // URL do banco
        } catch (Exception e) {
            // Trate possíveis erros de inicialização aqui
        }

        return conn; // Retorna a conexão criada (ou null em caso de falha)
    }

    /**
     * Variável utilizada para armazenar o nome do usuário recuperado na consulta ao banco.
     */
    public String nome = "";

    /**
     * Indicador que sinaliza se a verificação do usuário foi bem-sucedida.
     * True: Usuário encontrado. False: Usuário não localizado.
     */
    public boolean result = false;

    /**
     * Realiza a validação de credenciais (login e senha) para verificar 
     * a existência do usuário no banco de dados.
     * 
     * @param login O identificador (login) fornecido pelo usuário.
     * @param senha A senha associada ao login fornecido.
     * @return boolean Retorna `true` caso o usuário seja encontrado, ou `false` caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; // String usada para criar a consulta SQL
        Connection conn = conectarBD(); // Estabelece conexão com o banco de dados

        // Montagem da consulta SQL que busca pelo usuário informado
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            Statement st = conn.createStatement(); // Prepara a execução do comando SQL
            ResultSet rs = st.executeQuery(sql); // Executa a consulta e retorna o resultado

            // Se houver resultado, significa que o usuário foi encontrado
            if (rs.next()) {
                result = true; // Marca o resultado como verdadeiro
                nome = rs.getString("nome"); // Armazena o nome do usuário encontrado
            }
        } catch (Exception e) {
            // Trate aqui possíveis falhas de execução
        }

        return result; // Retorna o status da validação do usuário
    }
} // Encerramento da classe
