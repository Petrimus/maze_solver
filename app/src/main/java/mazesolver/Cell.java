/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author popalmu
 */
public class Cell {
    private boolean north = false;
    private boolean south = false;
    private boolean west = false;
    private boolean east =false;
    
    public Cell() {
        
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
    
    @Override
    public String toString() {
        char northx = this.north ? 't' : 'f';
        char southx = this.south ? 't' : 'f';
        char westx = this.north ? 't' : 'f';
        char eastx = this.north ? 't' : 'f';
        
        return "" + northx + southx + westx + eastx;
    }
}
