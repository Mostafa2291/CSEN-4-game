package game.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import game.engine.cards.Card;
import game.engine.cells.Cell;
import game.engine.dataloader.DataLoader;
import game.engine.monsters.Monster;

public class Game {
//read only
     private final Board board;
     private final ArrayList<Monster> allMonsters;
     private final Monster player;
     private final Monster opponent;


//read and write
    private Monster current;


//work in progress waiting 4 dataloader to be done
     //Game(Role playerRole) throws IOException{

    // }
//constructor 
public Game(Role playerRole) throws IOException{
    //load data from csv files
    ArrayList<Cell> cells = DataLoader.readCells();
    Cell[][] boardCells = new Cell[Constants.BOARD_ROWS][Constants.BOARD_COLS];
    for(int i = 0; i < Constants.BOARD_SIZE; i++){
        boardCells[i / Constants.BOARD_COLS][i % Constants.BOARD_COLS] = cells.get(i);
    }
    ArrayList<Card> originalCards = DataLoader.readCards();
    allMonsters = DataLoader.readMonsters();
    board = new Board(originalCards);
    
    //select player and opponent monsters based on player role
    player = selectRandomMonsterByRole(playerRole);
    Role opponentRole = (playerRole == Role.LAUGHER) ? Role.SCARER : Role.LAUGHER;
    opponent = selectRandomMonsterByRole(opponentRole);
    
    //set current monster to player by default
    current = player;
}


     public Board getBoard() {
         return board;
     }

     public ArrayList<Monster> getAllMonsters() {
         return allMonsters;
     }

     public Monster getPlayer() {
         return player;
     }

     public Monster getOpponent() {
         return opponent;
     }

     public Monster getCurrent() {
         return current;
     }

     public void setCurrent(Monster current) {
         this.current = current;
     }

     
    private Monster selectRandomMonsterByRole(Role role){
        ArrayList<Monster> candidates = new ArrayList<>();
        for(Monster m : allMonsters){
            if(m.getRole() == role) candidates.add(m);
        }
        if(candidates.isEmpty()) return null;
        return candidates.get(new Random().nextInt(candidates.size()));
    }


}
