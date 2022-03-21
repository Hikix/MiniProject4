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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * The way we have structured our code is the following:
 * 
 * We used ArrayLists in order to hold content from different tabs, with each
 * ArrayList entry being a separate tab's entry
 * 
 * We used VBoxes that had HBoxes that were stacked on top of each other
 * inside of them, with each HBox containing some graphical elements such
 * as the text fields or buttons
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Declare and initialise variables to use for graphics
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
        ArrayList<ScrollPane> visualisationScrollPanes = new ArrayList<>();
        ArrayList<HBox> visualisationHBoxes = new ArrayList<>();
        String defaultTabStr, bStr, sStr, iStr, qStr;
        Random rnd = new Random();
        
        // Add tabs to the tab ArrayList
        Collections.addAll(tabs, tabSortingIntro, tabBubbleSort, tabSelectionSort, tabInsertionSort, tabQuickSort);
        
        // Make sure none of the tabs can be closed
        tabs.forEach(tab -> {
            tab.setClosable(false);
        });
        
        // Text to display on the default tab
        defaultTabStr = "Sorting Algorithms\n"
                + "\n"
                + "This program will show some of the most common"
                + " sorting algorithms, including:\n"
                + "\n"
                + "\t1 - Bubble Sort\n"
                + "\t2 - Selection Sort\n"
                + "\t3 - Insertion Sort\n"
                + "\t4 - Quick Sort\n";
        
        // Set default label text to the above string
        defaultLabel.setText(defaultTabStr);
        // Adds default label to the default HBox
        defaultHBox.getChildren().add(defaultLabel);
        // Centres the label text
        defaultHBox.setAlignment(Pos.CENTER);
        
        // Creates V Boxes and adds them to the mainVBoxes ArrayList
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.setSpacing(Constants.SPACING);
            mainVBoxes.add(vBox);
        }
        
        //Sets the description for bubble sort
        bStr = "\tBubble Sort Description:\n"
                + "\n"
                + "Bubble Sort is the simplest sorting algorithm that works by "
                + "repeatedly swapping the adjacent elements if they are in the"
                + " wrong order.\n"
                + "\n";
        
        // Sets the description for selection sort
        sStr = "\tSelection Sort Description:\n"
                + "\n"
                + "Selection sort sorts an array by repeatedly finding the "
                + "minimum element from the unsorted part, and placing it at "
                + "the beginning.\n"
                + "\n";
        
        // Sets the description for insertion sort
        iStr = "\tInsertion Sort Description:\n"
                + "Insertion sort is a simple sorting algorithm that works "
                + "by splitting an array into a \"sorted\" and \"unsorted\" "
                + "part. \nValues from the unsorted part are picked and placed "
                + "into the correct position in the sorted part.\n"
                + "\n";
        
        // Sets the description for quick sort
        qStr = "\tQuick Sort Description:\n"
                + "Quick sort is also a divide-and-conquer algorithm. It "
                + "selects an element as a pivot and partitions the array "
                + "around the pivot.\n"
                + "\n";
        
        // Adds the description strings to the descriptionStrings ArrayList
        descriptionStrings.add(bStr);
        descriptionStrings.add(sStr);
        descriptionStrings.add(iStr);
        descriptionStrings.add(qStr);
        
        // Creates labels for each description and adds them to the 
        // descriptionLabels ArrayList
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            descriptionLabels.add(new Label(descriptionStrings.get(i)));
        }
        
        // Creates the TextFields for each algo and the HBox 
        // associated with them
        for(int i = 0; i < Constants.NUM_ALGOS; i++){
            HBox hBox = new HBox();
            textFields.add(new TextField[Constants.NUM_TEXT_FIELDS]);
            for(int j = 0; j < Constants.NUM_TEXT_FIELDS; j++){
                TextField textField = new TextField();
                textFields.get(i)[j] = textField;
                // Clips the range of each text field to between 0 and 99
                // and sets any non-number entry to 0
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
        
        // Creates and adds the start algorithm buttons to the startButtons
        // ArrayList
        startButtons.add(new Button("Start Bubble Sort"));
        startButtons.add(new Button("Start Selection Sort"));
        startButtons.add(new Button("Start Insertion Sort"));
        startButtons.add(new Button("Start Quick Sort"));
        
        // Sets the start buttons to run their specified algorithm when
        // they are pressed, or say "Invalid numbers!" when the numbers
        // are invalid
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
        
        // Creates and adds the generate random numbers and reset buttons to 
        // the randonNumsButtons ArrayList
        for (int i = 0; i < Constants.NUM_ALGOS; i++) {
            // Creates generate random numbers buttons and adds behaviours for
            // when they're clicked
            randomNumsButtons.add(new Button("Generate Random Numbers"));
            randomNumsButtons.get(i).setOnAction(a -> {
                for (int j = 0; j < textFields.size(); j++) {
                    for (TextField field : textFields.get(j)) {
                        field.setText("" + rnd.nextInt(100));
                    }
                }
            });
            
            // Creates reset buttons and adds behaviours for when they're
            // clicked
            resetButtons.add(new Button("Reset Numbers"));
            resetButtons.get(i).setOnAction(a -> {
                 for (int j = 0; j < textFields.size(); j++) {
                    for (TextField field : textFields.get(j)) {
                        field.setText("");                
                    }
                }
            });
        }
        
        // Adds buttons to the button HBoxes
        for (int i = 0; i < Constants.NUM_ALGOS; i++){
            HBox hBox = new HBox();
            hBox.getChildren().addAll(randomNumsButtons.get(i), startButtons.get(i), 
                    resetButtons.get(i));
            hBox.setAlignment(Pos.CENTER);
            buttonHBoxes.add(hBox);
        }
        
        // Creates labels and scroll panes for visualisation and adds them to
        // the visualisationLabels and visualisationScrollPanes ArrayLists
        for (int i = 0; i < Constants.NUM_ALGOS; i++) {
            Label label = new Label("");
            ScrollPane sp = new ScrollPane();
            sp.setPrefSize(1200, 400);
            sp.setContent(label);
            
            visualisationLabels.add(label);
            visualisationScrollPanes.add(sp);
        }
        
        // Adds the scroll panes to the Hboxes and adds the HBoxes to the
        // visualisationHBoxes ArrayList
        for (int i = 0; i < Constants.NUM_ALGOS; i++) {
            HBox hBox = new HBox();
            hBox.getChildren().add(visualisationScrollPanes.get(i));
            hBox.setAlignment(Pos.BOTTOM_CENTER);
            visualisationHBoxes.add(hBox);
        }
        
        // Adds all of the HBoxes to VBoxes and adds those VBoxes to the
        // mainVBoxes ArrayList
        for (int i = 0; i < Constants.NUM_ALGOS; i++){
            mainVBoxes.get(i).getChildren().addAll(
                    descriptionLabels.get(i),
                    textFieldHBoxes.get(i),
                    buttonHBoxes.get(i),
                    visualisationHBoxes.get(i)
            );
        }
        
        // Sets the content of each of the tabs to the mainVBox
        tabSortingIntro.setContent(defaultHBox);
        tabBubbleSort.setContent(mainVBoxes.get(0));
        tabSelectionSort.setContent(mainVBoxes.get(1));
        tabInsertionSort.setContent(mainVBoxes.get(2));
        tabQuickSort.setContent(mainVBoxes.get(3));
        
        // Adds all of the tabs to the tab pane
        tabPane.getTabs().add(tabSortingIntro);
        tabPane.getTabs().add(tabBubbleSort);
        tabPane.getTabs().add(tabSelectionSort);
        tabPane.getTabs().add(tabInsertionSort);
        tabPane.getTabs().add(tabQuickSort);
        
        // Creates and sets the scene to the stage
        Scene scene = new Scene(tabPane, 1200, 800);
        stage.setScene(scene);
        stage.setTitle("Sorting Algorithms");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    /**
     * Converts array of text fields to array of integers
     * @param fields array of text fields
     * @return array of integers
     */
    private int[] fieldsToArray(TextField[] fields) {
        int[] returnArr = new int[fields.length];
        for (int i = 0; i < fields.length; i++) {
            returnArr[i] = Integer.valueOf(fields[i].getText());
        }
        return returnArr;
    }
}