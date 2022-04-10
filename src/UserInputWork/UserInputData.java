package UserInputWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;

public class UserInputData {
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

            String query = "insert into students(name,email,country) values(?,?,?)";

            //now we need to make a prepared statements
            PreparedStatement pstment = connection.prepareStatement(query);

            // buffer library to take line by line
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Name: ?");
            String name=br.readLine();
            System.out.println("Enter Your email: ?");
            String email=br.readLine();
            System.out.println("Enter Your country: ?");
            String country=br.readLine();


            //now enter the students' data. you can enter the data as many as you want

            pstment.setString(1,name);
            pstment.setString(2,email);
            pstment.setString(3,country);




            pstment.executeUpdate();

            System.out.println("Successfully inserted into DB");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
