/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.testfx;

/**
 *
 * @author appuv
 */
public class ArrayMethods {
    public static String printArray(int [] input){
        String s = "";
        for (int i = 0; i < input.length; i++){
            s += (input[i] + " ");
        }
        return s;
    }
    
}
