/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Cell represents one block of labyrinth. Coordinates are immutable, but walls
 * can be changed.
 *
 * @author popalmu
 */
public class Cell {

    private final int y;
    private final int x;
    private boolean north = true;
    private boolean south = true;
    private boolean west = true;
    private boolean east = true;
    private boolean onThePath = false;

    /**
     * Construct and initialize Cell in (y, x) coordinates of the maze
     *
     * @param y y coordinate
     * @param x x coordinate
     */
    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    /**
     * Construct and initializes Cell with coordinates and each possible
     * direction to move
     *
     * @param y y coordinate
     * @param x x coordinate
     * @param north true or false if direction north is available for movement
     * @param south true or false if direction south is available for movement
     * @param west true or false if direction west is available for movement
     * @param east true or false if direction east is available for movement
     */
    public Cell(int y, int x, boolean north, boolean south, boolean west, boolean east) {
        this.y = y;
        this.x = x;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }

    /**
     * Get list of possible directions to move
     *
     * @return A List of directions in which movement is possible
     */
    public List<Direction> getPossibleDirections() {
        List<Direction> dirs = new ArrayList<>();
        if (this.north) {
            dirs.add(Direction.NORTH);
        }
        if (this.south) {
            dirs.add(Direction.SOUTH);
        }
        if (this.east) {
            dirs.add(Direction.EAST);
        }
        if (this.west) {
            dirs.add(Direction.WEST);
        }
        return dirs;
    }

    /**
     * @param onThePath the onThePath to set
     */
    public void setOnThePath(boolean onThePath) {
        this.onThePath = onThePath;
    }

    /**
     * @param north the north to set
     */
    public void setNorth(boolean north) {
        this.north = north;
    }

    /**
     * @param west the west to set
     */
    public void setWest(boolean west) {
        this.west = west;
    }

    /**
     * @param east the east to set
     */
    public void setEast(boolean east) {
        this.east = east;
    }

    /**
     * @param south the south to set
     */
    public void setSouth(boolean south) {
        this.south = south;
    }

    /**
     * @return the north
     */
    public boolean isNorth() {
        return north;
    }

    /**
     * @return the south
     */
    public boolean isSouth() {
        return south;
    }

    /**
     * @return the west
     */
    public boolean isWest() {
        return west;
    }

    /**
     * @return the east
     */
    public boolean isEast() {
        return east;
    }

    /**
     *
     * @return Boolean if this Cell is on the path from start to finnish
     */
    public boolean isOnThePath() {
        return onThePath;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @return
     */
    @Override
    public Object clone() {
        Cell cell;
        try {
            cell = (Cell) super.clone();
        } catch (CloneNotSupportedException e) {
            cell = new Cell(
                    this.getY(), this.getX(), isNorth(), isSouth(), isWest(), isEast());
        }

        return cell;
    }

}
