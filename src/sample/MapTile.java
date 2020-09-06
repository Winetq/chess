package sample;

import abstraction.Counter;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapTile extends StackPane {
    private Rectangle rectangle;
    private Game game;
    private Point coordinates;
    private Color baseColor;

    public MapTile(Color color, Game game, int x, int y){
        rectangle = new Rectangle(80, 80);
        rectangle.setFill(color);
        this.getChildren().add(rectangle);
        this.game = game;
        coordinates = new Point(x, y);
        baseColor = color;
    }

    public void addImage(int x, int y) throws FileNotFoundException {
        Counter counter = game.getCounter(x, y);
        if (counter != null) {
            Image image = new Image(new FileInputStream("C:\\Users\\gabuc\\IdeaProjects\\chess\\src\\images\\" + counter.getPath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(80);
            imageView.setFitWidth(80);
            this.getChildren().add(imageView);
        }
    }

    public void highlight(){
        rectangle.setFill(Color.YELLOW);
    }

    public void restoreColor(){
        rectangle.setFill(baseColor);
    }
}
