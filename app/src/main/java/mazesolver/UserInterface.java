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
    private Maze maze;
    private final MazeGenerator generator = new MazeGenerator();

    public UserInterface(Scanner reader) {
        this.maze = generator.generateMaze(5, 5);
        this.reader = reader;
    }

    public void start() {
        RecursiveSolve recSolve = new RecursiveSolve();
        DeadendFillingSolver deadendSolver = new DeadendFillingSolver();

        int command = 0;
        System.out.print("Anna nimesi: ");
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

            System.out.println("6 - lopeta");

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

                        System.out.println("Time it took to solve was " + recSolveMaze.getSolveTime() / 1e9 * 1000 + "milliseconds");
                    } else {
                        System.out.println("Tämä labyrintti oli aivan liian vaikea tai mahdoton minulle");
                    }

                    break;

                case 5:
                    Maze maze = deadendSolver.solve(this.maze);
                    maze.drawMaze();
                    System.out.println("");
                   System.out.println("Time it took to solve was " + maze.getSolveTime() / 1e9 * 1000 + "milliseconds");
                    System.out.println("");
                    break;

                case 6:
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
                break;
            } else {
                System.out.println("Pitää olla numer välillä 10-100");
            }
        }
        // System.out.println("");
        while (true) {
            System.out.print("Anna korkeus (10-100): ");
            if (reader.hasNextInt()) {
                height = reader.nextInt();
                break;
            } else {
                System.out.println("Pitää olla numer välillä 10-100");
            }
        }
        return this.generator.generateMaze(height, width);
    }

    private void printMazeArray(int[][] arr) {
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%5d ", arr1[j]);
            }
            System.out.println();
        }
    }
}
