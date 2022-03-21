/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.testfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author appuv
 */
public class VisualEffectCircle extends Pane {
    private Circle circEvent;
    private double dx = 2.0;
    private double dy = 3.0;
    
    public VisualEffectCircle() {
        //trying to change the opacity, however fell into some errors
        //circEvent.setOpacity(0.2);
        circEvent = new Circle(80, Color.PINK);
        circEvent.relocate(400, 200);
        getChildren().add(circEvent);
        
        // Using timeline for keyframe object
        Timeline tlCirc = new Timeline();
        // Set up a KeyFrame that fires an event every 10 milliseconds
        // and invokes its own event listener
        KeyFrame kfCirc = new KeyFrame(Duration.millis(6), new CircAnimate());
        tlCirc.getKeyFrames().add(kfCirc);
        tlCirc.setCycleCount(Timeline.INDEFINITE);
        tlCirc.play();
    }
    
    private class CircAnimate implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent t) {
            // get current location
            double cx = circEvent.getLayoutX();
            double cy = circEvent.getLayoutY();
            double radius = circEvent.getRadius();
            
            // Rob's trick of getting boundaries
            Bounds bounds = getBoundsInLocal();
            
            if (cx <= bounds.getMinX() + radius || 
                    cx >= bounds.getMaxX() - radius) {
                dx = -dx;
            }
            if (cy <= bounds.getMinY() + radius|| cy >= bounds.getMaxY() - radius) {
                dy = -dy;
            }
            
            //update position
            circEvent.setLayoutX(cx + dx);
            circEvent.setLayoutY(cy + dy);
        }
        
    }
}