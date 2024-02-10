/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject52;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Mavenproject52 {
    static ArrayList<Integer> playerposition = new ArrayList<Integer>();
     static ArrayList<Integer> cpuposition = new ArrayList<Integer>();
    public static void main(String[] args) {
       char [][] game={{' ' ,'|' ,' ' ,'|' ,' '},
                       {'-' ,'+' ,'-' ,'+' ,'-'},
                       {' ' ,'|' ,' ' ,'|' ,' '},
                       {'-' ,'+' ,'-' ,'+' ,'-'},
                       {' ' ,'|' ,' ' ,'|' ,' '}};
    gameboard(game);
Scanner scan = new Scanner(System.in);
while(true)
{
System.out.println("enter your placement");
int playerpos = scan.nextInt();
    placepiece(playerpos,game,"user");
      Random rand = new Random();
      int cpupos=rand.nextInt(9)+1;
    placepiece(cpupos,game,"cpu");
    gameboard(game);
    String result =checkwin();
    System.out.print(result);
}
    }
public static void gameboard(char [][]game)
{
      
for(char [] row:game)
{for(char c:row)
{
    System.out.print(c);
}
System.out.println();
}}
public static void placepiece(int playerpos,char[][]game,String s)
{
    char symbol=' ';
    if(s.equals("user"))
    {
        symbol='X';
        playerposition.add(playerpos);
    }
    else if(s.equals("cpu"))
    {
           symbol='O';
           cpuposition.add(playerpos);
    }
switch(playerpos)
{
    case 1:
        game[0][0]=symbol;
        break;
    case 2:
        game[0][2]=symbol;
        break;
    case 3:
        game[0][4]=symbol;
        break;
    case 4:
        game[2][0]=symbol;
        break;
    case 5:
        game[2][2]=symbol;
        break;
    case 6:
        game[2][4]=symbol;
        break;
    case 7:
        game[4][0]=symbol;
        break;
    case 8:
        game[4][2]=symbol;
        break;
    case 9:
        game[4][4]=symbol;
        break;
 }
    }
public static String checkwin()
{
 List toprow =  Arrays.asList(1,2,3);
 List midrow = Arrays.asList(4,5,6);
 List lastrow =  Arrays.asList(7,8,9);
 List firstcol = Arrays.asList(1,4,7);
 List midcol =  Arrays.asList(2,5,8);
 List lastcol = Arrays.asList(3,6,9);
 List fdiag =  Arrays.asList(1,5,9);
 List sdiag =  Arrays.asList(3,5,7);
 List <List> winning= new ArrayList<List>();
 winning.add(sdiag);
 winning.add(fdiag);
 winning.add(toprow);
 winning.add(midrow);
 winning.add(lastrow);
 winning.add(firstcol);
 winning.add(midcol);
 winning.add(lastcol);
 for(List l : winning)
 {
     if(playerposition.containsAll(l))
     {
         return"Congratulations!you have won :)";
     }
     else if(cpuposition.containsAll(l))
     {
         return"Cpu wins! sorry :(";
     }
     else if(playerposition.size()+cpuposition.size()== 9)
     {
         return "CAT";
     }
 }
return" ";
}    
}

