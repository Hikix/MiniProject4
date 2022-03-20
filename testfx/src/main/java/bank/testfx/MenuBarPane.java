/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.testfx;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author appuv
 */
public class MenuBarPane extends BorderPane {

    private MenuBar menuBar;
    private Menu paneMenu;
    private MenuItem exitItem;
    private RadioMenuItem mItem, insItem, selItem, intItem, bubItem;
    private MergePane mPane;
    private InsertionPane insPane;
    private SelectionPane selPane;
    private IntroPane intPane;
    private BubblePane bubPane;

    public MenuBarPane() {
        mPane = new MergePane();
        insPane = new InsertionPane();
        selPane = new SelectionPane();
        intPane = new IntroPane();
        bubPane = new BubblePane();

        // StackPane is a layout manager that puts each node that it contains
        // on top of each other...in a stack
        StackPane sp = new StackPane();
        sp.getChildren().addAll(mPane, insPane, selPane, intPane, bubPane);
        setCenter(sp);

        mPane.setVisible(false);
        insPane.setVisible(false);
        selPane.setVisible(false);
        bubPane.setVisible(false);

        menuBar = new MenuBar();
        paneMenu = new Menu("Pane Select");
        menuBar.getMenus().add(paneMenu);

        exitItem = new MenuItem("Exit");
        intItem = new RadioMenuItem("Intro");
        mItem = new RadioMenuItem("Merge Sort");
        selItem = new RadioMenuItem("Selection Sort");
        insItem = new RadioMenuItem("Insertion Sort");
        bubItem = new RadioMenuItem("Bubble Sort");
        intItem.setSelected(true);
        paneMenu.getItems().addAll(intItem, mItem, selItem, insItem, bubItem, exitItem);

        // Use a ToggleGroup to tell the program that only one of the pane
        // menus should be selected
        ToggleGroup paneItemToggle = new ToggleGroup();
        intItem.setToggleGroup(paneItemToggle);
        mItem.setToggleGroup(paneItemToggle);
        selItem.setToggleGroup(paneItemToggle);
        insItem.setToggleGroup(paneItemToggle);
        bubItem.setToggleGroup(paneItemToggle);

        exitItem.setOnAction(this::processMenu);
        intItem.setOnAction(this::processMenu);
        mItem.setOnAction(this::processMenu);
        selItem.setOnAction(this::processMenu);
        insItem.setOnAction(this::processMenu);
        bubItem.setOnAction(this::processMenu);

        setTop(menuBar);
    }

    public void processMenu(ActionEvent evt) {
        // Get the specific menu item that generated the event
        MenuItem item = (MenuItem) evt.getSource();

        // Set all the pane visibilities to false, then choose the one to 
        // make visible based on evt
        intPane.setVisible(false);
        mPane.setVisible(false);
        selPane.setVisible(false);
        insPane.setVisible(false);
        bubPane.setVisible(false);

        if (item == exitItem) {
            System.exit(0);
        } else if (item == intItem) {
            intPane.setVisible(true);
        } else if (item == mItem) {
            mPane.setVisible(true);
        } else if (item == selItem) {
            selPane.setVisible(true);
        } else if (item == insItem) {
            insPane.setVisible(true);
        } else if (item == bubItem) {
            bubPane.setVisible(true);
        }
    }
}