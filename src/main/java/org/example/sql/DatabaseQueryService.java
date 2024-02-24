package org.example.sql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient(){
        MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
        List<MaxProjectCountClient> list = new ArrayList<>();
        Connection connection = Database.getINSTANCE().getConnection();
        String sql = null;

        try {
            sql = String.join("\n", Files.readAllLines(Path.of("find_max_projects_client.sql")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
               maxProjectCountClient.setName(rs.getString("NAME"));
               maxProjectCountClient.setProjectCount(rs.getInt("PROJECT_COUNT"));
               list.add(maxProjectCountClient);
            }
            rs.close();
            st.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return list;
    }

    public List<LongestProjectCount> findLongestProject(){
        LongestProjectCount longestProjectCount = new LongestProjectCount();
        List<LongestProjectCount> list = new ArrayList<>();
        Connection connection = Database.getINSTANCE().getConnection();
        String sql = null;

        try {
            sql = String.join("\n", Files.readAllLines(Path.of("find_longest_project.sql")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                longestProjectCount.setProjectID(Integer.parseInt(rs.getString("PROJECT_ID")));
                longestProjectCount.setMonthCount(Integer.parseInt(rs.getString("MONTH_COUNT")));
                list.add(longestProjectCount);
            }
            rs.close();
            st.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return list;
    }

    public List<MaxSalaryCountWorker> findMaxSalaryWorker(){
        MaxSalaryCountWorker maxSalaryCountWorker = new MaxSalaryCountWorker();
        List<MaxSalaryCountWorker> list = new ArrayList<>();
        Connection connection = Database.getINSTANCE().getConnection();
        String sql = null;

        try {
            sql = String.join("\n", Files.readAllLines(Path.of("find_max_salary_worker.sql")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                maxSalaryCountWorker.setName(rs.getString("NAME"));
                maxSalaryCountWorker.setSalary(Integer.parseInt(rs.getString("SALARY")));
                list.add(maxSalaryCountWorker);
            }
            rs.close();
            st.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return list;
    }

    public List<YoungestEldestWorkersFinder> findYoungestEldestWorkers(){
        YoungestEldestWorkersFinder youngestEldestWorkersFinder = new YoungestEldestWorkersFinder();
        List<YoungestEldestWorkersFinder> list = new ArrayList<>();
        Connection connection = Database.getINSTANCE().getConnection();
        String sql = null;

        try {
            sql = String.join("\n", Files.readAllLines(Path.of("find_youngest_eldest_workers.sql")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                youngestEldestWorkersFinder.setType(rs.getString("TYPE"));
                youngestEldestWorkersFinder.setName(rs.getString("NAME"));
                youngestEldestWorkersFinder.setBirthday(LocalDate.parse(rs.getString("BIRTHDAY")));
                list.add(youngestEldestWorkersFinder);
            }
            rs.close();
            st.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return list;
    }

    public List<ProjectPricesPrinter> findProjectPrices(){
        ProjectPricesPrinter projectPricesPrinter = new ProjectPricesPrinter();
        List<ProjectPricesPrinter> list = new ArrayList<>();
        Connection connection = Database.getINSTANCE().getConnection();
        String sql = null;

        try {
            sql = String.join("\n", Files.readAllLines(Path.of("print_project_prices.sql")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                projectPricesPrinter.setProjectId(rs.getInt("PROJECT_ID"));
               projectPricesPrinter.setPrice(rs.getInt("PRICE"));
                list.add(projectPricesPrinter);
            }
            rs.close();
            st.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return list;
    }
}