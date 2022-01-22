package com.example;
import java.awt.Container;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.Buffer;
import java.util.*;
import java.util.Scanner;
import javax.swing.JFrame;


public class App{
    
   
    
    static int score=0;
    
    public static void playagain(){
        System.out.println("Would You Like to play again? Y/N");
        Scanner yes_or_no_obj= new Scanner(System.in);
        String yes_or_no_input= yes_or_no_obj.nextLine();
        String yes_or_no=yes_or_no_input.toLowerCase();
        if(yes_or_no.matches("y")){
            Game();
        
        }else{

        }

    }
    public static void checkscore(int highscore){
        if ( score > highscore){
            System.out.println("New Highscore");
            System.out.print("The Previous Highscore was:"+" "+highscore);
            try {
                
                String a1=Integer.toString(score);
                FileWriter fw = new FileWriter("write.txt");
                fw.write(a1);
                fw.flush();
                fw.close();
            } catch (IOException e) {
               
                e.printStackTrace();
            }
            playagain();
        }else{
            playagain();
        }
            
    }
    public static void add_score(){
        score++;
        System.out.println("Your Current Score is:"+" "+score);
    }  

    
    public static void Game(){

        Random rand = new Random();
        int upperbound = 100;
        
        int d=rand.nextInt(upperbound);
        int c= rand.nextInt(upperbound);
        int f=c+d;
        String c1 = Integer.toString (c);
        String d1 = Integer.toString (d);
        System.out.printf(c1 +" "+"+" +" "+ d1+"\n"); 
        
        
        Input(f,score);

        



    }
    public static void Input(int f,int score){
        Scanner scanner = new Scanner(System.in);
        int input;
        try {
            input = scanner.nextInt();
            System.out.println("You said: " + input);
        } catch (InputMismatchException e) {
            System.out.println("That was not a number.  Please try again.");
            Input(f,score);
            input=scanner.nextInt();
        }
        
        
       
        if (input == f){
            System.out.println("Correct");
            add_score();
            Game();
        }else{
            System.out.println("Game Over");
            System.out.println("The Correct Answer was:"+" "+f);
            System.out.println("Your Final Score was:"+" "+score);
            
            checkscore(input);
           
            }
    }          
        
     

        public static void main(String arg[]) throws IOException{

            
            FileReader fr = new FileReader("write.txt");
            int i;
            while ((i=fr.read())!=-1){
            
            int highscore = i - '0';
            
          
            System.out.println(highscore);

            }

        Game();
    }

}


