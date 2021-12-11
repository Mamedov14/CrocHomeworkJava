package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        createTable();
        List<String> strings = readFile(args);
        importsIntoDatabase(strings);

    }

    private static void importsIntoDatabase(List<String> strings) throws SQLException {
        String[] splitStrings;
        Connection conn = ConnectionUtils.getMyConnection();
        for (String str : strings) {
            splitStrings = str.split(",");
//          language=SQL
            String sql = """
                    INSERT INTO test
                    (order_number, username, article_article, product_name, price_in_rubles)
                    VALUES
                    (?, ?, ?, ?, ?);
                    """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(splitStrings[0]));
            ps.setString(2, splitStrings[1]);
            ps.setString(3, splitStrings[2]);
            ps.setString(4, splitStrings[3]);
            ps.setInt(5, Integer.parseInt(splitStrings[4]));
            ps.executeUpdate();
        }
        conn.close();
    }

    private static List<String> readFile(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
        List<String> stringArrayList = new ArrayList<>();
        String buffer;
        while ((buffer = br.readLine()) != null) {
            stringArrayList.add(buffer);
        }
        return stringArrayList;
    }


    private static void createTable() {
        try {
            Connection conn = ConnectionUtils.getMyConnection();
            Statement statement = conn.createStatement();
//          language=SQL
            String sql = """
                    CREATE TABLE IF NOT EXISTS test
                    (order_number INTEGER,
                    username VARCHAR(255),
                    article_article VARCHAR(255),
                    product_name VARCHAR(255),
                    price_in_rubles INTEGER);
                    """;
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }
}