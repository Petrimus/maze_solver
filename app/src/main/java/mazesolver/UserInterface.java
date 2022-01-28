/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.Scanner;

/**
 *
 * @author popalmu
 */
public class UserInterface {

    private final Scanner reader;

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        Maze maze = new Maze();

        System.out.print("Anna nimesi: ");
        String name = reader.nextLine();
        System.out.println("");

        OUTER:
        while (true) {
            System.out.println("Anna komento: ");
            System.out.println("1 - tulosta nimi");
            System.out.println("3 - piirrä labyrintti");
            System.out.println("2 - lopeta");
            int command = Integer.parseInt(reader.nextLine());

            switch (command) {
                case 1:
                    System.out.println(name);
                    break;
                case 2:
                    break OUTER;
                case 3:                        
                    maze.drawMaze();
                    System.out.println("");
                    break;                            
                default:
                    System.out.println("Syötä oikea komento");
                    break;
            }
        }
    }
}
