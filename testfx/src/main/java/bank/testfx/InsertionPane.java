/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.testfx;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author appuv
 */
public class InsertionPane extends Pane {
    private Ellipse elli;
    private Text desc;
    private Rectangle rect;
    private Button randNum;
    private Button resetNum;
    private Button startSort;

    public InsertionPane() {
        elli = new Ellipse(600, 75, 200, 30);
        elli.setStroke(Color.RED);
        elli.setStrokeWidth(3);
        elli.setFill(null);
        getChildren().add(elli);
        // how do i add font
        desc = new Text(440, 90, "                   Insertion Sort: description blah blah blah");
        getChildren().add(desc);
        
        //button
        randNum = new Button("Generate Random Numbers");
        resetNum = new Button("Reset Numbers");
        startSort = new Button("Start sort");
        randNum.setLayoutX(330);
        randNum.setLayoutY(350);
        getChildren().add(randNum);
        resetNum.setLayoutX(500);
        resetNum.setLayoutY(350);
        getChildren().add(resetNum);
        startSort.setLayoutX(600);
        startSort.setLayoutY(350);
        getChildren().add(startSort);
        /*
        Pane button1 = new Pane();
        button1.setLayoutX(50);
        button1.setLayoutY(100);
        button1.
        Pane button2 = new Pane();
        button1.setLayoutX(50);
        button1.setLayoutY(100);
        Pane button3 = new Pane();
        button1.setLayoutX(50);
        button1.setLayoutY(100);
         */
        // had to go through stack overflow to find a way to duplicate the rectanges in a row, then modded it a bit
        int rows = 10, cols = 1, horizontal = 75, vertical = 40;
        rect = null;
        for (int i = 0; i < cols; ++i) {//Iterate through columns
            for (int j = 0; j < rows; ++j) {//Iterate through rows
                rect = new Rectangle((horizontal * j) + 200, (vertical * i) + 300, horizontal, vertical);
                rect.setStroke(Color.RED);
                rect.setFill(null);
                getChildren().add(rect);
            }

        }
    }
}
