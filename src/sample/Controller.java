package sample;

import abstraction.BlackCounter;
import abstraction.Counter;

import abstraction.WhiteCounter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Controller {
    @FXML
    private GridPane gridMap;
    @FXML
    private TextArea commentator;
    @FXML
    private Button loading;
    @FXML
    private Button saving;

    private Game game;
    private int clicked;
    private Counter currentCounter;
    private MapTile currentTile;
    private int shout;

    @FXML
    public void initialize() throws FileNotFoundException {
        shout = -1;
        currentTile = null;
        currentCounter = null;
        clicked = 0;
        game = new Game();
        game.fillTheBoard();
        refreshGUI();
        gridMap.setCursor(Cursor.HAND);
        commentator.setFont(Font.font("Verdana", 20));
        commentator.setText("White counters start the game!" + "\n");
    }

    @FXML
    public void onButtonClicked(ActionEvent actionEvent) throws FileNotFoundException {
        Object source = actionEvent.getSource();
        if (source == loading) {
            FileChooser fileChooser = new FileChooser();

            // show open file dialog
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                game.clearTheBoard();
                Scanner scanner = new Scanner(selectedFile);
                String starter = null;
                while (scanner.hasNext()){
                    String row = scanner.nextLine();
                    if (row.equals("BLACK") || row.equals("WHITE"))
                        starter = row;
                    else {
                        char[] rowRepresentation = row.toCharArray();
                        int index;
                        for (index = 0; index < row.length(); index++){
                            if (rowRepresentation[index] == '(')
                                break;
                        }
                        String counterName = row.substring(0, index);
                        int counterX = rowRepresentation[index + 1] - '0';
                        int counterY = rowRepresentation[index + 4] - '0';
                        game.createCounter(counterName, counterX, counterY);
                    }
                }
                refreshGUI();
                commentator.appendText(starter + " counters continue the game!");
                if (starter != null) {
                    if (starter.equals("WHITE"))
                        shout = 0;
                    else
                        shout = 1;
                }
            }
        }
        if (source == saving) {
            FileChooser fileChooser = new FileChooser();

            // set extension filter for text files
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extensionFilter);

            // show save file dialog
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                StringBuilder state = new StringBuilder();
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 8; j++){
                        Counter counter = game.getCounter(i, j);
                        if (counter != null){
                            String row = counter.toString() + "\n";
                            state.append(row);
                        }
                    }
                }
                if (shout % 2 == 0)
                    state.append("WHITE" + "\n");
                else
                    state.append("BLACK" + "\n");
                PrintWriter writer = new PrintWriter(file);
                writer.println(state);
                writer.close();
            }
        }
    }

    private void refreshGUI() throws FileNotFoundException {
        commentator.setText(null);
        game.deleteNotLivingCounter();
        if (!game.isEndGame()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    createTile(i, j);
                }
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    createFinalTile(i, j);
                }
            }
            gridMap.setCursor(Cursor.DEFAULT);
            commentator.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
            commentator.appendText(game.getWinner() + " WINNERS" + "\n");
            commentator.appendText("Thank you for the game!" + "\n");
            loading.setDisable(true);
            saving.setDisable(true);
        }
        shout += 1;
    }

    private void createTile(int i, int j) throws FileNotFoundException {
        MapTile mapTile;
        if (i % 2 == 0) {
            if (j % 2 == 0)
                mapTile = new MapTile(Color.WHITE, game, i, j);
            else
                mapTile = new MapTile(Color.LIGHTBLUE, game, i, j);
        } else {
            if (j % 2 == 0)
                mapTile = new MapTile(Color.LIGHTBLUE, game, i, j);
            else
                mapTile = new MapTile(Color.WHITE, game, i, j);
        }
        mapTile.addImage(i, j);
        mapTile.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    click(i, j, mapTile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        gridMap.add(mapTile, i, j);
    }

    private void createFinalTile(int i, int j) throws FileNotFoundException {
        MapTile mapTile;
        if (i % 2 == 0) {
            if (j % 2 == 0)
                mapTile = new MapTile(Color.WHITE, game, i, j);
            else
                mapTile = new MapTile(Color.LIGHTBLUE, game, i, j);
        } else {
            if (j % 2 == 0)
                mapTile = new MapTile(Color.LIGHTBLUE, game, i, j);
            else
                mapTile = new MapTile(Color.WHITE, game, i, j);
        }
        mapTile.addImage(i, j);
        gridMap.add(mapTile, i, j);
    }

    private void click(int x, int y, MapTile mapTile) throws FileNotFoundException {
        if (clicked == 0) {
            currentCounter = game.getCounter(x, y);
            if (currentCounter != null) {
                currentTile = mapTile;
                currentTile.highlight();
                clicked += 1;
            }
        }
        else { // clicked == 1
            Counter attackedTile = game.getCounter(x, y);
            if (attackedTile == null) {
                if (currentCounter.isAllowedMove(new Point(x, y), null)) {
                    if (!game.isLeapedOverOthers(currentCounter, new Point(x, y))) {
                        currentCounter.move(new Point(x, y));
                        clicked -= 1;
                        refreshGUI();
                    }
                    else
                        commentator.appendText("You can not leap over other counters!" + "\n");
                }
                else
                    commentator.appendText("The movement is not allowed for this counter!" + "\n");
            }
            else { // attackedTile != null
                if ((currentCounter instanceof WhiteCounter && attackedTile instanceof WhiteCounter) || (currentCounter
                        instanceof BlackCounter && attackedTile instanceof BlackCounter)) { // currentCounter and attackedTile are the same color
                    currentTile.restoreColor();
                    currentTile = mapTile;
                    currentCounter = attackedTile;
                    currentTile.highlight();
                }
                else {
                    if (currentCounter.isAllowedMove(new Point(x, y), attackedTile)) {
                        if (!game.isLeapedOverOthers(currentCounter, new Point(x, y))) {
                            currentCounter.move(new Point(x, y));
                            currentCounter.battle(attackedTile);
                            clicked -= 1;
                            refreshGUI();
                        }
                        else
                            commentator.appendText("You can not leap over other counters!" + "\n");
                    }
                    else
                        commentator.appendText("The movement is not allowed for this counter!" + "\n");
                }
            }
        }
    }
}
