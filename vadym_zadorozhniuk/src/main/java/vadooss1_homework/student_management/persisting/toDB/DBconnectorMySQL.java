package vadooss1_homework.student_management.persisting.toDB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static vadooss1_homework.student_management.persisting.toDB.ConfigLoader.passwordDB;
import static vadooss1_homework.student_management.persisting.toDB.ConfigLoader.urlDB;
import static vadooss1_homework.student_management.persisting.toDB.ConfigLoader.userDB;

public class DBconnectorMySQL {
    final static Logger logger = Logger.getLogger(DBconnectorMySQL.class);

    public DBconnectorMySQL(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            logger.error("Invalid driver", e);
        }
    }

    public Connection getConnection(){
        Connection connection=null;
        try{
         connection = DriverManager.getConnection(urlDB, userDB, passwordDB);
        }catch(SQLException e){
            logger.error("Cannot plug in...", e);
        }
        return connection;
    }

    public void cleanUpDB(Connection connection){
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM `student_management`.`schoolclass`");
            statement.execute("ALTER TABLE `student_management`.`schoolclass` AUTO_INCREMENT = 1");
            statement.execute("DELETE FROM `student_management`.`subject`");
            statement.execute("ALTER TABLE `student_management`.`subject` AUTO_INCREMENT = 1");
            statement.execute("DELETE FROM `student_management`.`student`");
            statement.execute("ALTER TABLE `student_management`.`student` AUTO_INCREMENT = 1");
            statement.execute("DELETE FROM `student_management`.`specialclass`");
            statement.execute("ALTER TABLE `student_management`.`specialclass` AUTO_INCREMENT = 1");
            statement.execute("DELETE FROM `student_management`.`group`");
            statement.execute("ALTER TABLE `student_management`.`group` AUTO_INCREMENT = 1");
            statement.execute("DELETE FROM `student_management`.`schoolclass_subjects`");
            statement.execute("DELETE FROM `student_management`.`groups_students`");
            statement.execute("DELETE FROM `student_management`.`students_subjects`");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
