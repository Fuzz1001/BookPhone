package com.example.demo.service;

import com.example.demo.connect.Connect;
import com.example.demo.entity.Kniga;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class KnigaService extends Connect implements IService {

    Connection connection = getConnection();


    @Override
    public Integer add(Kniga kniga) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO KNIGA (name, email, phone) VALUES(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setLong(1, kniga.getId());
            preparedStatement.setString(1, kniga.getName());
            preparedStatement.setString(2, kniga.getEmail());
            preparedStatement.setLong(3, kniga.getPhone());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Kniga> getAll() throws SQLException {
        List<Kniga> knigaList = new ArrayList<>();

        String sql = "SELECT ID, NAME, EMAIL, PHONE FROM kniga";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Kniga kniga = new Kniga();
                kniga.setId(resultSet.getLong("ID"));
                kniga.setName(resultSet.getString("NAME"));
                kniga.setEmail(resultSet.getString("EMAIL"));
                kniga.setPhone(resultSet.getLong("PHONE"));

                knigaList.add(kniga);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return knigaList;
    }

    @Override
    public Kniga getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, NAME, EMAIL, PHONE FROM KNIGA WHERE ID=?";

        Kniga kniga = new Kniga();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                kniga.setId(resultSet.getLong("ID"));
                kniga.setName(resultSet.getString("NAME"));
                kniga.setEmail(resultSet.getString("EMAIL"));
                kniga.setPhone(resultSet.getLong("PHONE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kniga;
    }

    @Override
    public Integer update(Kniga kniga) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE KNIGA SET  NAME=?, EMAIL=?, PHONE=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, kniga.getName());
            preparedStatement.setString(2, kniga.getEmail());
            preparedStatement.setLong(3, kniga.getPhone());
            preparedStatement.setLong(4, kniga.getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Long remove(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM KNIGA WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    public Long readFile(byte[] fileBytes) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(fileBytes)));
        XmlMapper xmlMapper = new XmlMapper();
        List<Kniga> list = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Kniga value = xmlMapper.readValue(line, Kniga.class);
                list.add(value);
                System.out.println(value);
            }

            list.forEach(kniga -> {
                try {
                    add(kniga);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] fileForBD() throws IOException, SQLException {
        KnigaService get = new KnigaService();
        List<Kniga> users = get.getAll();
        XmlMapper xmlMapper = new XmlMapper();

        try (FileWriter nFile = new FileWriter("src/main/resources/file2.xml", false)) {
            for (Kniga user : users) {
                String de = xmlMapper.writeValueAsString(user);
                System.out.println(de);
                nFile.append(de);
                nFile.append('\n');
            }
            nFile.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Files.readAllBytes(Paths.get("src/main/resources/file2.xml"));
    }
}



