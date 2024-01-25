package solution;

import java.io.*;
import java.util.Scanner;

import generic_module.*;

class CustomCalculator implements Serializable{
    // you can not use any additional attribute in this class 
    int a,b,c,d; // class attributes to use here

    // resulting attributes 
    int addition_result; // keep the value of the addition here 
    int subtraction_result; // keep the value of subtraction here 
    int big1, big2, big3, big4; // the highest valye

    public CustomCalculator(int a, int b){ 
    /* ---TASK Started--- */
    // For two number saving a custom constructor that you need to implement
    // store the values to a and b attribute, first value in a and second value in b 
    // attribute value of c and d should be set to -1
    this.a = a;
    this.b = b;
    this.c = -1;
    this.d = -1;
    /* ---TASK Ended---- */

        
    }
    public CustomCalculator(int a, int b, int c, int d){   
        /* ---TASK Started--- */
        // For four number saving you need to call this constructor 
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        /* ---TASK Ended---- */
         
    }

    public void addition(StoreObject STOBJ){
        /* ---TASK Started--- */
        //conduct the addition here, keep the stored value in addition_result attribute, all the other resulting_attributes should have value of -1
        //call print function
        this.addition_result = this.a + this.b;
        this.subtraction_result = -1;
        this.big1 = -1;
        this.big2 = -1;
        this.big3 = -1;
        this.big4 = -1;

        this.print();
        /* ---TASK Ended---- */

        /*  ----  OOP STORING PORTION ----  (DO NOT CHANGE THIS LINE AND BELOW THIS) */
        STOBJ.store(this, "1");
    }

    public void subtraction(StoreObject STOBJ){
        /* ---TASK Started--- */
        // conduct the subtraction here, store the result in subtraction_result attribute, all the other resulting_attributes should have value of -1
        // Between a and b, if b is bigger comparatively, swap the attribute values 
        // conduct the subtraction (a-b), store the result in subtraction_result attribute
        // call print function
        this.addition_result = -1;
        if(this.b>this.a){
            int temp = this.a;
            this.a = this.b;
            this.b = this.a;
        }
        this.subtraction_result = this.a - this.b;
        this.big1 = -1;
        this.big2 = -1;
        this.big3 = -1;
        this.big4 = -1;

        this.print();
        /* ---TASK Ended --- */

        /*  ----  OOP STORING PORTION ----  (DO NOT CHANGE THIS LINE AND BELOW THIS) */
        STOBJ.store(this, "2");

    }

    public void sortNumbers(StoreObject STOBJ){
        /* ---TASK Started--- */
        // only big1, big2, big3, big4 values should be populated. Other resultant_attributes should have -1 value 
        // the highest value will be stored in big1
        // the second highest one will be stored in big2
        // the third highest one in big3 and so on 
        // call print function
        this.addition_result = -1;
        this.subtraction_result = -1;

        int[] arr = new int[]{this.a, this.b, this.c, this.d};
        Arrays.sort(arr);
        this.big1 = arr[3];
        this.big2 = arr[2];
        this.big3 = arr[1];
        this.big4 = arr[0];
        
        this.print();
        /* ---TASK Ended --- */

        /*  ----  OOP STORING PORTION ----  (DO NOT CHANGE THIS LINE AND BELOW THIS) */
        STOBJ.store(this, "3");

    }

    public void print(){
        System.out.println(this.addition_result + " " + this.subtraction_result + " " + this.big1 + " " + this.big2 + " " + this.big3 + " " + this.big4); 
        return; 
    }

}

public class Problem{
    public static void main(String [] args){
        /* ---- (TEST CASE NUMBER) DO NOT MODIFY THIS PORTION STARTED ---- */
        int testCase = 1; // default testcase 
        try{
            testCase = Integer.parseInt(args[0]); // input of testCase number
        }
        catch(Exception e){}
        StoreObject STOBJ = new StoreObject("teacher" , testCase); 

        /* ---- (TEST CASE NUMBER) DO NOT MODIFY THIS PORTION ENDED  ----*/

        /* ---TASK Started--- */

        /* Take input a number as choice, use CustomCalculator class to do the calculation and store the results
         *  if choice is 0: Take input two numbers, Do addition (STOBJ), to calculate (a + b) and to keep the proper snapshot 
         *  if choice is 1: Take input two numbers, call subtraction (STOBJ) to calculate (a-b), and keep the proper snapshot
         *  if choice is 2: Take input four numbers, call sortNumbers (STOBJ) to sort the numbers in ascending order and store in appropriate attributes; 
         */ 
        CustomCalculator calc;
        Scanner sc = new Scanner(System.in); 
        int choice = sc.nextint();
        if(choice == 0)
        {
            int one = sc.nextint();
            int two = sc.nextint();
            
            addition(STOBJ);
        }
        else if(choice == 1)
        {
            int one = sc.nextint();
            int two = sc.nextint();
            
            subtraction(STOBJ);
        }
        else if(choice == 2)
        {
            int one = sc.nextint();
            int two = sc.nextint();
            int three = sc.nextint();
            int four = sc.nextint();

            sortNumbers(STOBJ);
            
        }
        /* ---TASK Ended --- */
        
        /*  ----  OOP STORING PORTION ----  (DO NOT CHANGE THIS LINE AND BELOW THIS) */
        STOBJ.store(calc, "4");
    }
}