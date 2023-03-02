package com.example.videogamesdataview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

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

    public void initialize() throws Exception {
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
    }
}