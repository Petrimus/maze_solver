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
    private final Maze maze = new Maze();

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        
        RecursiveSolve recSolve = new RecursiveSolve();
        System.out.print("Anna nimesi: ");
        String name = reader.nextLine();
        System.out.println("");

        OUTER:
        while (true) {
            System.out.println("Anna komento: ");
            System.out.println("1 - tulosta nimi");
            System.out.println("2 - piirrä labyrintti");
            System.out.println("3 - ratkaise labyrintti rekursiivisesti");
            System.out.println("4 - lopeta");

            int command = Integer.parseInt(reader.nextLine());

            switch (command) {
                case 1:
                    System.out.println(name);
                    break;

                case 2:
                    maze.drawMaze();
                    System.out.println("");
                    break;
                case 3:

                    recSolve.solve(this.maze);
                    break;
                case 4:
                    break OUTER;
                default:
                    System.out.println("Syötä oikea komento");
                    break;
            }
        }
    }
}
