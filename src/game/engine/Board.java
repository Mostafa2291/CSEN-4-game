package game.engine;

import java.util.ArrayList;

import game.engine.cells.Cell;
import game.engine.monsters.Monster;
import game.engine.cards.*;


public class Board {
    //Read only
   private final Cell[][] boardCells;
   private final ArrayList<Card> originalCards;

   //Read & Write
   private ArrayList<Monster> stationedMonsters;
   private ArrayList<Card> cards;

   
   public Board(Cell[][] boardCells, ArrayList<Card> originalCards, ArrayList<Monster> stationedMonsters,
        ArrayList<Card> cards) {
    this.boardCells = new Cell[Constants.BOARD_ROWS][Constants.BOARD_COLS];
    this.originalCards = originalCards;
    this.stationedMonsters = new ArrayList<Monster>();
    this.cards = new ArrayList<Card>();
   }
   public Cell[][] getBoardCells() {
    return boardCells;
   }
   public ArrayList<Card> getOriginalCards() {
    return originalCards;
   }
   public ArrayList<Monster> getStationedMonsters() {
    return stationedMonsters;
   }
   public void setStationedMonsters(ArrayList<Monster> stationedMonsters) {
    this.stationedMonsters = stationedMonsters;
   }
   public ArrayList<Card> getCards() {
    return cards;
   }
   public void setCards(ArrayList<Card> cards) {
    this.cards = cards;
   }
   

   



}
