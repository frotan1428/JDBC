package ibdc_prepareStatements;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepareStatement {
    public static void main(String[] args) {
        try{
            //loading the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create a database connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "mojib1427";

            //call a connection driver
            Connection connection = DriverManager.getConnection(url,username,password);

            String query = "insert into students(id,name,email,country) values(?,?,?,?)";

            //now we need to make a prepared statements
            PreparedStatement pstment = connection.prepareStatement(query);

            //now enter the students' data. you can enter the data as many as you want
            pstment.setInt(1,5);
            pstment.setNString(2,"Musleh");
            pstment.setNString(3,"frotan1954@gmail.com");
            pstment.setNString(4,"afghanistan");

            //now enter the students' data. you can enter the data as many as you want


            pstment.executeUpdate();

            System.out.println("Successfully inserted into DB");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
