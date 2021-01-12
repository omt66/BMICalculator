package omt.bmidemo20210111;

import java.util.Scanner;

/**
 * This program will help us to find the BMI for our users :)
 * 
 * @author omt
 */
public class BMIDemo {
    /**
     * This will calculate the BMI value based on the weight and height
     * information provided in the parameters.
     * Also, based on the boolean flag (isImperial) it will either do 
     * calculations for Imperial system or SI (Standard International).
     * 
     * @param weight
     * @param height
     * @param isImperial
     * @return 
     */
    static float calculateBmi(float weight, float height, boolean isImperial) {
        float multiplier = isImperial ? 703: 1;
        float bmi = multiplier*weight/(height*height);
        
        return bmi;
    }
    
    /**
     * We need to provide some useful information for the user.
     * This information is from Department of Health and Human Services/National 
     * Institutes of Health
     * 
     * BMI VALUES
     *  Underweight: less than 18.5
     *  Normal: between 18.5 and 24.9
     *  Overweight: between 25 and 29.9
     *  Obese: 30 or greater
     * @param bmi 
     */
    static void printBmiInfo(float bmi) {
        println("BMI VALUES");
        println(" * Underweight: less than 18.5");
        println(" * Normal: between 18.5 and 24.9");
        println(" * Overweight: between 25 and 29.9");
        println(" * Obese: 30 or greater");
        println("Your BMI value is " + bmi);
        
        if (bmi < 18.5) {
            println("You are underweight");
        }
        else if (bmi >= 18.5 && bmi < 25) {
            println("You are normal :)");
        }
        else if (bmi >= 25 && bmi < 29.9) {
            println("Be careful, you are overweight now!");
        }
        else {
            println("Opps, you are obese!!!");
        }
    }
    
    /**
     * This is our little helper method to print out info.
     * @param msg 
     */
    static void println(String msg) {
        System.out.println(msg);
    }
    
    /**
     * This is our main demo...
     */
    static void bmidemo() {
        println("--- BMI Calculator ---");
        
        float weight, height, bmi;
        String answer;
        boolean useImperial;
        Scanner input = new Scanner(System.in);

        // Let's find out what system user wants to use
        println("Welcome BMI Calculator, which system would you like to use (lbs+inch / kg+m)?");
        println("  1. lbs+inch");
        println("  2. kg+m");
        
        answer = input.nextLine();
        if (answer.equals("1")) {
            useImperial = true;
        }
        else {
            useImperial = false;
        }
        // I need to get the user's input
        println("Please enter your weight: " + (useImperial == true ? "(lbs)" : "(kg)"));
        weight = input.nextFloat();
        println("Weight is " + weight);
        
        // Let's get the height info
        println("Please enter your height: " + (useImperial == true ? "(inch)" : "(m)"));
        height = input.nextFloat();
        println("Height is " + height);
        bmi = calculateBmi(weight, height, useImperial);
        printBmiInfo(bmi);
    }
    
    
    /**
     * This is the main entry point for the application!
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("--- BMI Demo (11 Jan 2021/Mon) ---");
        bmidemo();
    }
}
