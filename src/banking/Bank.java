package banking;

import org.sqlite.SQLiteDataSource;

import java.util.ArrayList;
import java.util.List;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bank {
    private static List<Card> cardList = new ArrayList<>();
    public static void addCard(Card card) {
        cardList.add(card);
    }

    public static boolean checkIfCardExists(String cardNumber) {
        for (Card card : cardList){
            if (card.getCardNumber().equals(cardNumber)) {
                return true;
            }
        }
        return false;
    }

    public static Card getCard(String cardNumber) {
        for (Card card: cardList) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    public static boolean login(String cardNumber, String pin) {
        for (Card card : cardList) {
            if (card.getCardNumber().equals(cardNumber) && card.getPin().equals(pin)) {
                return true;
            }
        }
        return false;
    }
}

//    String url = "jdbc:sqlite:C:/sqlite/test.db";
//    SQLiteDataSource dataSource = new SQLiteDataSource();
//        dataSource.setUrl(url);
//                try (Connection con = dataSource.getConnection()) {
//                if (con.isValid(5)){
//                System.out.println("Connection is valid");
//                }
//                try(Statement statement = con.createStatement()) {
//                statement.executeUpdate("CREATE TABLE IF NOT EXISTS HOUSES(" +
//                "id INTEGER PRIMARY KEY," +
//                "name TEXT NOT NULL," +
//                "words TEXT NOT NULL)");
////                int i = statement.executeUpdate("INSERT INTO HOUSES VALUES " +
////                        "(1, 'Targaryen of king''s Landing', 'Fire and Blood')," +
////                        "(2, 'Stark of Winterfell', 'Summer is Coming')," +
////                        "(3, 'Lannister of Casterly Rock', 'Hear Me Roar!')");
//                int u = statement.executeUpdate("UPDATE HOUSES " +
//                "SET words = 'Winter is coming' " +
//                "Where id = 2");
////                System.out.println(i + u);
//                try (ResultSet greatHouses = statement.executeQuery("SELECT * FROM HOUSES")) {
//                while (greatHouses.next()) {
//                int id = greatHouses.getInt("id");
//                String name = greatHouses.getString("name");
//                String words = greatHouses.getString("words");
//                System.out.printf("House %d%n", id);
//                System.out.printf("\tName: %s%n", name);
//                System.out.printf("\tWords: %s%n", words);
//                }
//                }
//                }
//                } catch (SQLException e) {
//                e.printStackTrace();
//                }