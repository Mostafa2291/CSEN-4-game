package game.engine.monsters;

import game.engine.Role;

public class MultiTasker extends Monster {

    private int normalSpeedTurns; //no. of turns MT moves at normals speed,,, R/W

    public MultiTasker(String name, String description, Role originalRole, int energy) {
        super(name, description, originalRole, energy);
        this.normalSpeedTurns = 0;
    }

    public int getNormalSpeedTurns() {
        return normalSpeedTurns;
    }

    public void setNormalSpeedTurns(int normalSpeedTurns) { //added constraint to prevent setting NST to 0
        if(normalSpeedTurns >= 0)
            this.normalSpeedTurns = normalSpeedTurns;
        else
            this.normalSpeedTurns = 0;
    }

    
    
    



}
