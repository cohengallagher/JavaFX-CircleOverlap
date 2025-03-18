import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.Random;

//************************************************************************
//  CircleOverlap.java       Author: Cohen Gallagher
//
//  Programming Project 8.16
//************************************************************************

public class CircleOverlap extends Application
{
    //--------------------------------------------------------------------
    //  Displays 20 circles, with overlapping circles filled with a
    //  translucent blue.
    //--------------------------------------------------------------------

    public void start(Stage primaryStage)
    {
        Circle[] circles = new Circle[20];
        Random gen = new Random();

        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);

        for (int i = 0; i < 20; i++)
        {
            int radius = gen.nextInt(30) + 6;
            int x = gen.nextInt(500 - (radius * 2)) + radius;
            int y = gen.nextInt(500 - (radius * 2)) + radius;

            circles[i] = new Circle(x, y, radius);
            root.getChildren().add(circles[i]);

            // check for overlap with previous circles
            // Hint, use another for loop (nested)
            // Within the second for loop, get the difference for x and y
            // double distance = Math.sqrt(diffX * diffX + diffY * diffY)
            // if the distance is less than radius plus previous circle radius fill
            // use the getCenterX() and getCenterY() methods
        }

        primaryStage.setTitle("Circle Overlap");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

