/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.testfx;

/**
 *
 * @author Keval
 */
public class ArrayMethods {
    /**
     * Converts array to String
     * @param input array to convert
     * @return String containing converted array
     */
    public static String arrayToString(int [] input){
        String s = "";
        for (int i = 0; i < input.length; i++){
            s += (input[i] + " ");
        }
        return s;
    }
    
}
