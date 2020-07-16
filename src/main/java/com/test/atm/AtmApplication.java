package com.test.atm;

import com.test.atm.Model.FrontUser;
import com.test.atm.Util.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class AtmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmApplication.class, args);

        HashMap<FrontUser,Double> database = new HashMap<>();

        FrontUser user1 = new FrontUser("Robert","MasinaVerde");
        FrontUser user2 = new FrontUser("Andrei","MasinaGalbena");

        database.put(user1,1050.40);
        database.put(user2,4020.30);

        Database.database = database;
    }

}
