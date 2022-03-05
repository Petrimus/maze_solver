/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package mazesolver;

/**
 * Enumerate of direction
 * 
 * @author popalmu
 */
public enum Direction {
    NORTH(1, -1, 0, "north"),
    SOUTH(2, 1, 0, "south"),
    EAST(4, 0, 1, "east"),
    WEST(8, 0, -1, "west");

    private final int bit;
    private final int dy;
    private final int dx;
    private final String dir;
    private Direction opposite;

    // use the static initializer to resolve forward references
    static {
        NORTH.opposite = SOUTH;
        SOUTH.opposite = NORTH;
        EAST.opposite = WEST;
        WEST.opposite = EAST;
    }

    private Direction(int bit, int dy, int dx, String dir) {
        this.bit = bit;
        this.dy = dy;
        this.dx = dx;
        this.dir = dir;
    }

    /**
     * @return the bit
     */
    public int getBit() {
        return bit;
    }

    /**
     * @return the dy
     */
    public int getDy() {
        return dy;
    }

    /**
     * @return the dx
     */
    public int getDx() {
        return dx;
    }
    
    public String getDirString() {
        return this.dir;
    }

    /**
     * @return the opposite
     */
    public Direction getOpposite() {
        return opposite;
    }
    
};
