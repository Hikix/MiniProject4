package bank.testfx;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
        final ArrayList<TextField[]> textFields = new ArrayList<>();
        ArrayList<HBox> textFieldHBoxes = new ArrayList<>();
        ArrayList<Button> randomNumsButtons = new ArrayList<>();
        ArrayList<Button> resetButtons = new ArrayList<>();
        ArrayList<Button> startButtons = new ArrayList<>();
        ArrayList<HBox> buttonHBoxes = new ArrayList<>();
        ArrayList<Label> visualisationLabels = new ArrayList<>();
        ArrayList<HBox> visualisationHBoxes = new ArrayList<>();
        String defaultTabStr, bStr, sStr, iStr, qStr;
        Random rnd = new Random();
        
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
            textFields.add(new TextField[Constants.NUM_TEXT_FIELDS]);
            for(int j = 0; j < Constants.NUM_TEXT_FIELDS; j++){
                TextField textField = new TextField();
                textFields.get(i)[j] = textField;
                textField.setOnAction(a -> {
                    try {
                        if (Integer.valueOf(textField.getText()) > 99) {
                            textField.setText("" + 99);
                        } else if (Integer.valueOf(textField.getText()) < 0) {
                            textField.setText("" + 0);
                        }
                    } catch (NumberFormatException e) {
                        textField.setText("" + 0);
                    }      
                });
                hBox.getChildren().add(textField);
            }
            textFieldHBoxes.add(hBox);
        }
        
        startButtons.add(new Button("Start Bubble Sort"));
        startButtons.add(new Button("Start Selection Sort"));
        startButtons.add(new Button("Start Insertion Sort"));
        startButtons.add(new Button("Start Quick Sort"));
        
        startButtons.get(0).setOnAction(a -> {
            try {
                visualisationLabels.get(0).setText(SortAlgorithms.bubbleSort(fieldsToArray(textFields.get(0))));
            } catch (NumberFormatException e) {
                visualisationLabels.get(0).setText("Invalid numbers!");
            }
        });
        startButtons.get(1).setOnAction(a -> {
            try {
                visualisationLabels.get(1).setText(SortAlgorithms.selectionSort(fieldsToArray(textFields.get(1))));
            } catch (NumberFormatException e) {
                visualisationLabels.get(1).setText("Invalid numbers!");
            }
        });
        startButtons.get(2).setOnAction(a -> {
            try {
                visualisationLabels.get(2).setText(SortAlgorithms.insertionSort(fieldsToArray(textFields.get(2))));
            } catch (NumberFormatException e) {
                visualisationLabels.get(2).setText("Invalid numbers!");
            }
        });
        startButtons.get(3).setOnAction(a -> {
            try {
                visualisationLabels.get(3).setText(SortAlgorithms.quickSort(fieldsToArray(textFields.get(3)), 0, Constants.NUM_TEXT_FIELDS - 1));
            } catch (NumberFormatException e) {
                visualisationLabels.get(3).setText("Invalid numbers!");
            }
        });
        
        for (int i = 0; i < Constants.NUM_ALGOS; i++) {
            randomNumsButtons.add(new Button("Generate Random Numbers"));
            resetButtons.add(new Button("Reset Numbers"));
            resetButtons.get(i).setOnAction(a -> {
                 for (int j = 0; j < textFields.size(); j++) {
                    for (TextField field : textFields.get(j)) {
                        field.setText("");                
                    }
                }
            });
        }
        
        for (int i = 0; i < Constants.NUM_ALGOS; i++) {
            randomNumsButtons.get(i).setOnAction(a -> {
                for (int j = 0; j < textFields.size(); j++) {
                    for (TextField field : textFields.get(j)) {
                        field.setText("" + rnd.nextInt(100));                
                    }
                }
            });
        }
        
        for (int i = 0; i < Constants.NUM_ALGOS; i++){
            HBox hBox = new HBox();
            hBox.getChildren().addAll(randomNumsButtons.get(i), startButtons.get(i), 
                    resetButtons.get(i));
            hBox.setAlignment(Pos.CENTER);
            buttonHBoxes.add(hBox);
        }
        
        for (int i = 0; i < Constants.NUM_ALGOS; i++) {
            visualisationLabels.add(new Label(""));
        }
        
        for (int i = 0; i < Constants.NUM_ALGOS; i++) {
            HBox hBox = new HBox();
            hBox.getChildren().add(visualisationLabels.get(i));
            hBox.setAlignment(Pos.CENTER);
            visualisationHBoxes.add(hBox);
        }
        
        for (int i = 0; i < Constants.NUM_ALGOS; i++){
            mainVBoxes.get(i).getChildren().addAll(
                    descriptionLabels.get(i),
                    textFieldHBoxes.get(i),
                    buttonHBoxes.get(i),
                    visualisationHBoxes.get(i)
            );
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
    
    private int[] fieldsToArray(TextField[] fields) {
        int[] returnArr = new int[fields.length];
        for (int i = 0; i < fields.length; i++) {
            returnArr[i] = Integer.valueOf(fields[i].getText());
        }
        return returnArr;
    }
}