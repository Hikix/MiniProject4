/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.testfx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author appuv
 */
public class IntroPane extends Pane {

    private Ellipse elli;
    private Text desc;
    private Rectangle rect;

    public IntroPane() {
        elli = new Ellipse(600, 100, 200, 50);
        elli.setStroke(Color.RED);
        elli.setStrokeWidth(3);
        elli.setFill(null);
        getChildren().add(elli);
        // how do i add font
        desc = new Text(440, 90, "                   Introduction to Sorting,\n choose a Sort method from the drop down menu to continue");
        getChildren().add(desc);


    }
}    
