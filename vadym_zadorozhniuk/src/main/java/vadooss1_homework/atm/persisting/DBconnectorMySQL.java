package vadooss1_homework.atm.persisting;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static vadooss1_homework.atm.persisting.ConfigLoader.passwordDB;
import static vadooss1_homework.atm.persisting.ConfigLoader.urlDB;
import static vadooss1_homework.atm.persisting.ConfigLoader.userDB;


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

    public void resetDB(Connection connection){
        try {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS `autoteller_machine`");
            statement.execute("CREATE SCHEMA IF NOT EXISTS `autoteller_machine` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin");
            statement.execute("USE `autoteller_machine`");
            statement.execute("CREATE TABLE IF NOT EXISTS `autoteller_machine`.`user` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `surname` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `phone` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin");
            statement.execute("CREATE TABLE IF NOT EXISTS `autoteller_machine`.`card` (\n" +
                    "  `id` BIGINT(16) NOT NULL AUTO_INCREMENT,\n" +
                    "  `pin` SMALLINT(4) NULL DEFAULT NULL,\n" +
                    "  `type` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `hasChip` VARCHAR(45) NULL DEFAULT 'false',\n" +
                    "  `dateTerm` DATE NULL DEFAULT NULL,\n" +
                    "  `lockReason` VARCHAR(100) NULL DEFAULT 'absent',\n" +
                    "  `enterPin` INT(11) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin");
            statement.execute("CREATE TABLE IF NOT EXISTS `autoteller_machine`.`account` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `balance` DOUBLE NULL DEFAULT NULL,\n" +
                    "  `fk_id_user` INT(11) NULL DEFAULT NULL,\n" +
                    "  `fk_id_card` BIGINT(16) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `2_idx` (`fk_id_user` ASC),\n" +
                    "  INDEX `3_idx` (`fk_id_card` ASC),\n" +
                    "  CONSTRAINT `2`\n" +
                    "    FOREIGN KEY (`fk_id_user`)\n" +
                    "    REFERENCES `autoteller_machine`.`user` (`id`)\n" +
                    "    ON DELETE SET NULL\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `3`\n" +
                    "    FOREIGN KEY (`fk_id_card`)\n" +
                    "    REFERENCES `autoteller_machine`.`card` (`id`)\n" +
                    "    ON DELETE SET NULL\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin");
            statement.execute("CREATE TABLE IF NOT EXISTS `autoteller_machine`.`atm` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `cashTotal` INT(11) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin");
            statement.execute("CREATE TABLE IF NOT EXISTS `autoteller_machine`.`money` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `par` INT(11) NOT NULL,\n" +
                    "  `fk_id_atm` INT(11) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `1_idx` (`fk_id_atm` ASC),\n" +
                    "  CONSTRAINT `1`\n" +
                    "    FOREIGN KEY (`fk_id_atm`)\n" +
                    "    REFERENCES `autoteller_machine`.`atm` (`id`)\n" +
                    "    ON DELETE SET NULL\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin");
            statement.execute("CREATE TABLE IF NOT EXISTS `autoteller_machine`.`service` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `serviceKind` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin");
            statement.execute("CREATE TABLE IF NOT EXISTS `autoteller_machine`.`transactions` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `date` TIMESTAMP NULL DEFAULT NULL,\n" +
                    "  `successTrans` VARCHAR(45) NULL DEFAULT 'true',\n" +
                    "  `fk_id_user` INT(11) NULL DEFAULT NULL,\n" +
                    "  `fk_id_service` INT(11) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `4_idx` (`fk_id_user` ASC),\n" +
                    "  INDEX `5_idx` (`fk_id_service` ASC),\n" +
                    "  CONSTRAINT `4`\n" +
                    "    FOREIGN KEY (`fk_id_user`)\n" +
                    "    REFERENCES `autoteller_machine`.`user` (`id`)\n" +
                    "    ON DELETE SET NULL\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `5`\n" +
                    "    FOREIGN KEY (`fk_id_service`)\n" +
                    "    REFERENCES `autoteller_machine`.`service` (`id`)\n" +
                    "    ON DELETE SET NULL\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('check card')");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('check pin')");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('get cash')");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('transfer money')");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('balance on screen')");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('balance in SMS')");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('balance print')");
            statement.execute("INSERT INTO autoteller_machine.service (serviceKind) values ('return card')");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
