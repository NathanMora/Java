import com.sun.rmi.rmid.ExecPermission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconexion {

    private static final String drive = "com.mysql.jdbc.Driver";
    private static final String db = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "mora";
    private static final String password = "mora";

    private Connection ct;
    private Statement st;

    public DBconexion() {


        try {
            Class.forName(drive);
            ct = DriverManager.getConnection(db, user, password);
            st = ct.createStatement();
            System.out.println("Conexion exitosa");

        } catch ( Exception e ) {
            System.out.println("Conexion no establecida");
        }

    }

    /*public void ShowALL() {

        try {

            ResultSet rs  = st.executeQuery("SELECT * FROM usuario");
            while ( rs.next() ) {
                System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4)
                        + "|" + rs.getString(5) + "|" + rs.getString(6));
            }

        } catch ( Exception e ) {
            System.out.println("Error al realizar la consulta");
        }


    }*/

}
