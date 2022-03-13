/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author popalmu
 */
public class UserInterface {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private final Scanner reader;
    private Maze maze;
    private final MazeGenerator generator = new MazeGenerator();

    /**
     * Construct and initialize user interface
     *
     * @param reader
     */
    public UserInterface(Scanner reader) {
        this.maze = generator.generateMaze(10, 10);
        this.reader = reader;
    }

    /**
     * UI start method. Executes in loop.
     */
    public void start() {
        RecursiveSolve recSolve = new RecursiveSolve();
        DeadendFillingSolver deadendSolver = new DeadendFillingSolver();

        int command = 0;
        System.out.println("Anna nimesi: ");
        String name = reader.nextLine();
        System.out.println("");

        OUTER:
        while (true) {
            System.out.println("");
            System.out.println("Anna komento: ");
            System.out.println("1 - tulosta nimi");
            System.out.println("2 - Generoi uusi labyrintti");
            System.out.println("3 - piirrä labyrintti");
            System.out.println("4 - ratkaise labyrintti rekursiivisesti");
            System.out.println("5 - ratkaise labyrintti deadend-filling algoritmilla");
            System.out.println("6 - ratkaise molemmilla algoritmeilla ja näytä ajat, tulostusta");
            System.out.println("7 - lopeta");

            if (reader.hasNextInt()) {
                command = reader.nextInt();
            }
            // int command = Integer.parseInt(reader.nextLine());

            switch (command) {
                case 1:
                    System.out.println(name);
                    break;

                case 2:
                    this.maze = optionGeneratteMaze();

                    break;

                case 3:
                    this.maze.drawMaze();
                    // this.maze.printMazeArray();
                    System.out.println("");
                    break;

                case 4:
                    Maze recSolveMaze = recSolve.solve(this.maze);
                    if (recSolveMaze.isSolved()) {
                        System.out.println("");
                        System.out.println("solved");
                        recSolveMaze.drawMaze();
                        System.out.println("");
                        System.out.println("Time it took to solve was "
                                + df.format(recSolveMaze.getSolveTime() / 1e9 * 1000) + " milliseconds");
                    } else {
                        System.out.println("Tämä labyrintti oli aivan liian vaikea tai mahdoton minulle");
                    }

                    break;

                case 5:
                    Maze solvedMaze = deadendSolver.solve(this.maze);
                    solvedMaze.drawMaze();
                    System.out.println("");
                    System.out.println("Time it took to solve was "
                            + df.format(solvedMaze.getSolveTime() / 1e9 * 1000) + " milliseconds");
                    System.out.println("");
                    break;
                
                case 6:
                    Maze deadMaze = deadendSolver.solve(this.maze);
                    Maze recMaze = recSolve.solve(this.maze);
                    System.out.println("");
                    System.out.println("Time it took to solve maze recursively was "
                            + df.format(recMaze.getSolveTime() / 1e9 * 1000) + " milliseconds");
                    System.out.println("Time it took to solve maze with deadend-filling was "
                            + df.format(deadMaze.getSolveTime() / 1e9 * 1000) + " milliseconds");
                    System.out.println("");
                    break;

                case 7:
                    break OUTER;

                default:
                    System.out.println("Syötä oikea komento");
                    break;
            }
        }
    }

    private Maze optionGeneratteMaze() {
        int height = 0;
        int width = 0;
        while (true) {
            System.out.print("Anna leveys (10-100): ");
            if (reader.hasNextInt()) {
                width = reader.nextInt();
                if (width < 10 | width > 100) {
                    System.out.println("Pitää olla numero välillä 100");
                    continue;
                }
                break;
            } else {
                System.out.println("Pitää olla numero välillä 100");
            }
        }
        // System.out.println("");
        while (true) {
            System.out.print("Anna korkeus (10-100): ");
            if (reader.hasNextInt()) {
                height = reader.nextInt();
                if (height < 10 | height > 100) {
                    System.out.println("Pitää olla numero välillä 10-100");
                    continue;
                }
                break;
            } else {
                System.out.println("Pitää olla numer välillä 10-100");
            }
        }
        return this.generator.generateMaze(height, width);
    }
}
