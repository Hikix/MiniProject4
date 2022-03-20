package bank.testfx;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();
        Tab tabSortingIntro = new Tab("Sorting Intro");
        Tab tabBubbleSort = new Tab("Bubble Sort");
        Tab tabSelectionSort = new Tab("Selection Sort");
        Tab tabInsertionSort = new Tab("Insertion Sort");
        Tab tabQuickSort = new Tab("Quick Sort");
        Label defaultLabel = new Label();
        HBox defaultHBox = new HBox();
        ArrayList<Tab> tabs = new ArrayList<>();
        ArrayList<VBox> mainVBoxes = new ArrayList<>();
        ArrayList<String> descriptionStrings = new ArrayList<>();
        ArrayList<Label> descriptionLabels = new ArrayList<>();
        ArrayList<HBox> textFieldHBoxes = new ArrayList<>();
        ArrayList<Button> randomNumsButtons = new ArrayList<>();
        ArrayList<Button> resetButtons = new ArrayList<>();
        ArrayList<Button> startButtons = new ArrayList<>();
        ArrayList<HBox> buttonHBoxes = new ArrayList<>();
        String defaultTabStr, bStr, sStr, iStr, mStr, qStr;
        
        Collections.addAll(tabs, tabSortingIntro, tabBubbleSort, tabSelectionSort, tabInsertionSort, tabQuickSort);
        
        tabs.forEach(tab -> {
            tab.setClosable(false);
        });
        
        defaultTabStr = "Sorting Algorithms\n"
                + "\n"
                + "This program will show some of the most common"
                + " sorting algorithms, including:\n"
                + "\n"
                + "\t1 - Bubble Sort\n"
                + "\t2 - Selection Sort\n"
                + "\t3 - Insertion Sort\n"
                + "\t4 - Quick Sort\n";
        
        defaultLabel.setText(defaultTabStr);
        defaultHBox.getChildren().add(defaultLabel);
        defaultHBox.setAlignment(Pos.CENTER);
        
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.setSpacing(Constants.SPACING);
            mainVBoxes.add(vBox);
        }
        
        /**
         * Sets the description for bubble sort
         */
        bStr = "\tBubble Sort Description:\n"
                + "\n"
                + "Bubble Sort is the simplest sorting algorithm that works by "
                + "repeatedly swapping the adjacent elements if they are in the"
                + " wrong order.\n"
                + "\n";
        
        /**
         * Sets the description for selection sort
         */
        sStr = "\tSelection Sort Description:\n"
                + "\n"
                + "Selection sort sorts an array by repeatedly finding the "
                + "minimum element from the unsorted part, and placing it at "
                + "the beginning.\n"
                + "\n";
        
        /**
         * Sets the description for insertion sort
         */
        iStr = "\tInsertion Sort Description:\n"
                + "Insertion sort is a simple sorting algorithm that works "
                + "by splitting an array into a \"sorted\" and \"unsorted\" "
                + "part. \nValues from the unsorted part are picked and placed "
                + "into the correct position in the sorted part.\n"
                + "\n";
        
        /**
         * Sets the description for quick sort
         */
        qStr = "\tQuick Sort Description:\n"
                + "Quick sort is also a divide-and-conquer algorithm. It "
                + "selects an element as a pivot and partitions the array "
                + "around the pivot.\n"
                + "\n";
        
        descriptionStrings.add(bStr);
        descriptionStrings.add(sStr);
        descriptionStrings.add(iStr);
        descriptionStrings.add(qStr);
        
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            descriptionLabels.add(new Label(descriptionStrings.get(i)));
        }
        
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            HBox hBox = new HBox();
            for(int j = 0; j < Constants.NUM_TEXT_FIELDS; j++){
                hBox.getChildren().add(new TextField());
            }
            textFieldHBoxes.add(hBox);
        }
        
        startButtons.add(new Button("Start Bubble Sort"));
        startButtons.add(new Button("Start Selection Sort"));
        startButtons.add(new Button("Start Insertion Sort"));
        startButtons.add(new Button("Start Quick Sort"));
        
        startButtons.get(0).setOnAction(a -> {
            
        });
        startButtons.get(1).setOnAction(a -> {
            
        });
        startButtons.get(2).setOnAction(a -> {
            
        });
        startButtons.get(3).setOnAction(a -> {
            
        });
        
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            HBox hBox = new HBox();
            hBox.getChildren().addAll(randomNumsButtons.get(i), startButtons.get(i), 
                    resetButtons.get(i));
            hBox.setAlignment(Pos.CENTER);
            buttonHBoxes.add(hBox);
        }
        
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            mainVBoxes.get(i).getChildren().addAll(descriptionLabels.get(i),
                    textFieldHBoxes.get(i),
                    buttonHBoxes.get(i));
        }
        
        tabSortingIntro.setContent(defaultHBox);
        tabBubbleSort.setContent(mainVBoxes.get(0));
        tabSelectionSort.setContent(mainVBoxes.get(1));
        tabInsertionSort.setContent(mainVBoxes.get(2));
        tabQuickSort.setContent(mainVBoxes.get(3));
        
        tabPane.getTabs().add(tabSortingIntro);
        tabPane.getTabs().add(tabBubbleSort);
        tabPane.getTabs().add(tabSelectionSort);
        tabPane.getTabs().add(tabInsertionSort);
        tabPane.getTabs().add(tabQuickSort);
        
        Scene scene = new Scene(tabPane, 1200, 800);
        stage.setScene(scene);
        stage.setTitle("Sorting Algorithms");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}