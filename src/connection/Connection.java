package connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;


public class Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/form?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String intoQuery = "INSERT INTO  form.request(name,number,street,housenumber,podezd,taxi_class,comment) VALUES (?,?,?,?,?,?,?)";
    static java.sql.Connection connection;
    public static void connection(){        //метод для встановлення зв'язку з БД
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void send(String name,String number,String street,String housenum,String podezd,String tclass,String com){ //метод для відправки данних на сервер
        PreparedStatement st;

        try{st = connection.prepareStatement(intoQuery);
          st.setString(1,name);
          st.setString(2,number);
          st.setString(3,street);
          st.setString(4,housenum);
          st.setString(5,podezd);
          st.setString(6,tclass);
          st.setString(7,com);
          st.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
           /* try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }
}
