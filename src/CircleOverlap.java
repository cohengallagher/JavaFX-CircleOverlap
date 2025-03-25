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

public class CircleOverlap extends Application {
    //--------------------------------------------------------------------
    //  Displays 20 circles, with overlapping circles filled with a
    //  translucent blue.
    //--------------------------------------------------------------------

    public void start(Stage primaryStage) {
        Circle[] circles = new Circle[20]; // Array to store circles
        Random gen = new Random();

        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);

        for (int i = 0; i < 20; i++) {
            // Generate random radius between 6 and 35
            int radius = gen.nextInt(30) + 6;

            // Random position, keeping circle fully inside the scene
            int x = gen.nextInt(500 - (radius * 2)) + radius;
            int y = gen.nextInt(500 - (radius * 2)) + radius;

            circles[i] = new Circle(x, y, radius); // Create a new circle

            // Check if this circle overlaps with any previous circles
            for (int j = 0; j < i; j++) {
                double diffX = circles[i].getCenterX() - circles[j].getCenterX();
                double diffY = circles[i].getCenterY() - circles[j].getCenterY();
                double distance = Math.sqrt(diffX * diffX + diffY * diffY); // Find distance between centers

                // If the circles are touching or overlapping
                if (distance < circles[i].getRadius() + circles[j].getRadius()) {
                    circles[i].setFill(Color.rgb(0, 0, 255, 0.5)); // Make it translucent blue
                    circles[j].setFill(Color.rgb(0, 0, 255, 0.5));
                }
            }

            root.getChildren().add(circles[i]); // Add circle
        }

        primaryStage.setTitle("Circle Overlap");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
