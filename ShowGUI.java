package com.javafxbook;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class ShowGUI extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<Student> students = initStudents();
        Scene scene = new Scene(initTable(students), 600, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Students");
        primaryStage.show();
    }

    private TableView initTable(List<Student> students) {
        TableView tableView = new TableView();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        initTableColumns(tableView);
        tableView.getItems().addAll(students);

        return tableView;
    }

    private void initTableColumns(TableView tableView) {
        TableColumn<String, Student> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<String, Student> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<String, Student> gpaColumn = new TableColumn<>("GPA");
        gpaColumn.setCellValueFactory(new PropertyValueFactory<>("GPA"));

        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(gpaColumn);
    }

    private List<Student> initStudents() {
        return Arrays.asList(new Student("First", "1", "GPA_1"),
                new Student("Second", "2", "GPA_2"),
                new Student("Third", "3", "GPA_3"));
    }

    public class Student {
        private String name;
        private String ID;
        private String GPA;

        public Student(String name, String ID, String GPA) {
            this.name = name;
            this.ID = ID;
            this.GPA = GPA;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getGPA() {
            return GPA;
        }

        public void setGPA(String GPA) {
            this.GPA = GPA;
        }
    }

}