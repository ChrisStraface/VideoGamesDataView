package com.example.videogamesdataview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GamesController {
    public TableView SalesTable;
    public TableColumn<VideogamesSells, String> Title;
    public TableColumn<VideogamesSells, String> Platform;
    public TableColumn<VideogamesSells, String> ReleaseDate;
    public TableColumn<VideogamesSells, String> Developer;
    public TableColumn<VideogamesSells, String> Publisher;
    public TableColumn<VideogamesSells, String> Series;
    public TableColumn<VideogamesSells, Integer> Sales;

    public TextField TitleField;
    public TextField PlatformField;
    public TextField DateField;
    public TextField DeveloperField;
    public TextField PublisherField;
    public TextField SeriesField;
    public TextField SalesField;

    public Button enterButton = new Button();
    public void initialize() throws Exception {
   restoreOrReadData();

    VideogamesSells.readAllData();
        ArrayList<VideoGames> temporaryList = (ArrayList<VideoGames>) VideoGames.getAllVideoGames();

        ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
    SalesTable.setItems(temporaryObservableList);

    Title.setCellValueFactory(new PropertyValueFactory<>("name"));
    Platform.setCellValueFactory(new PropertyValueFactory<>("platform"));
    ReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
    Developer.setCellValueFactory(new PropertyValueFactory<>("developer"));
    Publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
    Series.setCellValueFactory(new PropertyValueFactory<>("series"));
    Sales.setCellValueFactory(new PropertyValueFactory<>("sales"));

    Title.setCellFactory(TextFieldTableCell.forTableColumn());
    Platform.setCellFactory(TextFieldTableCell.forTableColumn());
    ReleaseDate.setCellFactory(TextFieldTableCell.forTableColumn());
    Developer.setCellFactory(TextFieldTableCell.forTableColumn());
    Series.setCellFactory(TextFieldTableCell.forTableColumn());
    Publisher.setCellFactory(TextFieldTableCell.forTableColumn());
    Sales.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        Title.setOnEditCommit(
                (TableColumn.CellEditEvent<VideogamesSells, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    VideogamesSells filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setName(t.getNewValue());
                });
        Platform.setOnEditCommit(
                (TableColumn.CellEditEvent<VideogamesSells, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    VideogamesSells filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setPlatform(t.getNewValue());
                });
        ReleaseDate.setOnEditCommit(
                (TableColumn.CellEditEvent<VideogamesSells, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    VideogamesSells filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setReleaseDate(t.getNewValue());
                });
        Developer.setOnEditCommit(
                (TableColumn.CellEditEvent<VideogamesSells, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    VideogamesSells filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setDeveloper(t.getNewValue());
                });
        Series.setOnEditCommit(
                (TableColumn.CellEditEvent<VideogamesSells, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    VideogamesSells filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setSeries(t.getNewValue());
                });
        Publisher.setOnEditCommit(
                (TableColumn.CellEditEvent<VideogamesSells, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    VideogamesSells filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setDeveloper(t.getNewValue());
                });
        Sales.setOnEditCommit(
                (TableColumn.CellEditEvent<VideogamesSells, Integer> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    VideogamesSells filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setSales(t.getNewValue());
    });
    }
    public void enterButton() {
    String TitleRow = TitleField.getText();
    SalesTable.getItems().add(TitleRow);
    String PlatformRow = PlatformField.getText();
    SalesTable.getItems().add(PlatformRow);
    String DateRow = DateField.getText();
    SalesTable.getItems().add(DateRow);
    String DeveloperRow = DeveloperField.getText();
    SalesTable.getItems().add(DeveloperRow);
    String SeriesRow = SeriesField.getText();
    SalesTable.getItems().add(SeriesRow);
    String PublisherRow = PublisherField.getText();
    SalesTable.getItems().add(PublisherRow);
    String SalesRow = SalesField.getText();
    SalesTable.getItems().add(SalesRow);
    }
    public void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedFilmObjects");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> temporaryList = new ArrayList<>(SalesTable.getItems());
        out.writeObject(temporaryList);

        out.close();
        fileOut.close();
    }
    public void restoreOrReadData() {
        try {
            FileInputStream fileIn = new FileInputStream("SavedFilmObjects");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            VideogamesSells.setAllVideoGames((ArrayList<VideoGames>) in.readObject());
            in.close();
            fileIn.close();
        } catch (Exception exception) {
            VideogamesSells.readAllData();
        }
    }
}