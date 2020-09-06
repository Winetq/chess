package sample;

import abstraction.Counter;
import counters.black.*;
import counters.white.*;

import java.awt.Point;
import java.util.ArrayList;

public class Game {
    private boolean isEnd;
    private ArrayList<Counter> counters;
    private String winner;

    private boolean isLeapedOverOthersDiagonally(Counter counter, Point newPoint){
        for (int i = 0; i < (int)counters.size(); i++){
            if ((counters.get(i).getX() > counter.getX() && counters.get(i).getX() < newPoint.x) && (counters.get(i).getY() >
                    counter.getY() && counters.get(i).getY() < newPoint.y)) { // right diagonally down looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
            if ((counters.get(i).getX() < counter.getX() && counters.get(i).getX() > newPoint.x) && (counters.get(i).getY() <
                    counter.getY() && counters.get(i).getY() > newPoint.y)) { // left diagonally up looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
            if ((counters.get(i).getX() > counter.getX() && counters.get(i).getX() < newPoint.x) && (counters.get(i).getY() <
                    counter.getY() && counters.get(i).getY() > newPoint.y)) { // right diagonally up looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
            if ((counters.get(i).getX() < counter.getX() && counters.get(i).getX() > newPoint.x) && (counters.get(i).getY() >
                    counter.getY() && counters.get(i).getY() < newPoint.y)) { // left diagonally down looking at white counters
                if ((Math.abs(counters.get(i).getX() - newPoint.x) == Math.abs(counters.get(i).getY() - newPoint.y)) &&
                        (Math.abs(counters.get(i).getX() - counter.getX()) == Math.abs(counters.get(i).getY() - counter.getY()))) // checking if the counter is located on the proper diagonal
                    return true;
            }
        }

        return false;
    }

    private boolean isLeapedOverOthersVertically(Counter counter, Point newPoint){
        for (int i = 0; i < (int)counters.size(); i++){
            if ((counters.get(i).getX() == counter.getX() && counters.get(i).getX() == newPoint.x) && (counters.get(i).getY() <
                    counter.getY() && counters.get(i).getY() > newPoint.y)) // up
                return true;
            if ((counters.get(i).getX() == counter.getX() && counters.get(i).getX() == newPoint.x) && (counters.get(i).getY() >
                    counter.getY() && counters.get(i).getY() < newPoint.y)) // down
                return true;
        }

        return false;
    }

    private boolean isLeapedOverOthersHorizontally(Counter counter, Point newPoint){
        for (int i = 0; i < (int)counters.size(); i++){
            if ((counters.get(i).getY() == counter.getY() && counters.get(i).getY() == newPoint.y) && (counters.get(i).getX() >
                    counter.getX() && counters.get(i).getX() < newPoint.x)) // right
                return true;
            if ((counters.get(i).getY() == counter.getY() && counters.get(i).getY() == newPoint.y) && (counters.get(i).getX() <
                    counter.getX() && counters.get(i).getX() > newPoint.x)) // left
                return true;
        }

        return false;
    }

    private void setEnd(boolean end) {
        isEnd = end;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Game() {
        this.isEnd = false;
        this.counters = new ArrayList<>();
        this.winner = null;
    }

    public void fillTheBoard(){
        // white counters
        for (int i = 0; i <= 7; i++){
            WhitePawn whitePawn = new WhitePawn(new Point(i, 6));
            counters.add(whitePawn);
        }

        WhiteRook whiteRook1 = new WhiteRook(new Point(0, 7));
        counters.add(whiteRook1);
        WhiteRook whiteRook2 = new WhiteRook(new Point(7, 7));
        counters.add(whiteRook2);

        WhiteKnight whiteKnight1 = new WhiteKnight(new Point(1, 7));
        counters.add(whiteKnight1);
        WhiteKnight whiteKnight2 = new WhiteKnight(new Point(6, 7));
        counters.add(whiteKnight2);

        WhiteBishop whiteBishop1 = new WhiteBishop(new Point(2, 7));
        counters.add(whiteBishop1);
        WhiteBishop whiteBishop2 = new WhiteBishop(new Point(5, 7));
        counters.add(whiteBishop2);

        WhiteQueen whiteQueen = new WhiteQueen(new Point(3, 7));
        counters.add(whiteQueen);

        WhiteKing whiteKing = new WhiteKing(new Point(4, 7));
        counters.add(whiteKing);

        // black counters
        for (int i = 0; i <= 7; i++){
            BlackPawn blackPawn = new BlackPawn(new Point(i, 1));
            counters.add(blackPawn);
        }

        BlackRook blackRook1 = new BlackRook(new Point(0, 0));
        counters.add(blackRook1);
        BlackRook blackRook2 = new BlackRook(new Point(7, 0));
        counters.add(blackRook2);

        BlackKnight blackKnight1 = new BlackKnight(new Point(1, 0));
        counters.add(blackKnight1);
        BlackKnight blackKnight2 = new BlackKnight(new Point(6, 0));
        counters.add(blackKnight2);

        BlackBishop blackBishop1 = new BlackBishop(new Point(2, 0));
        counters.add(blackBishop1);
        BlackBishop blackBishop2 = new BlackBishop(new Point(5, 0));
        counters.add(blackBishop2);

        BlackQueen blackQueen = new BlackQueen(new Point(3, 0));
        counters.add(blackQueen);

        BlackKing blackKing = new BlackKing(new Point(4, 0));
        counters.add(blackKing);
    }

    public Counter getCounter(int x, int y){
        for (int i = 0; i < (int)counters.size(); i++){
            if (counters.get(i).getX() == x && counters.get(i).getY() == y)
                return counters.get(i);
        }
        return null;
    }

    public void deleteNotLivingCounter(){
        for (int i = 0; i < (int)counters.size(); i++){
            if (!counters.get(i).isAlive()) {
                counters.remove(i);
                i -= 1;
            }
        }
    }

    public boolean isLeapedOverOthers(Counter counter, Point newPoint){
        if (counter instanceof WhiteKnight || counter instanceof BlackKnight)
            return false;
        return isLeapedOverOthersDiagonally(counter, newPoint) || isLeapedOverOthersVertically(counter, newPoint) ||
                isLeapedOverOthersHorizontally(counter, newPoint);
    }

    public boolean isEndGame() {
        int kings = 0;
        boolean whiteKing = false;
        boolean blackKing = false;
        for (int i = 0; i < (int)counters.size(); i++){
            if (counters.get(i) instanceof WhiteKing) {
                whiteKing = true;
                kings += 1;
            }
            if (counters.get(i) instanceof BlackKing) {
                blackKing = true;
                kings += 1;
            }
        }

        if (kings == 1) {
            this.setEnd(true);
            if (!whiteKing)
                setWinner("BLACK");
            else
                setWinner("WHITE");
        }

        return isEnd;
    }

    public void clearTheBoard(){
        counters.clear();
    }

    public void createCounter(String name, int x, int y){
        switch (name){
            // black counters
            case "BlackBishop":
                BlackBishop blackBishop = new BlackBishop(new Point(x, y));
                counters.add(blackBishop);
                break;
            case "BlackKing":
                BlackKing blackKing = new BlackKing(new Point(x, y));
                counters.add(blackKing);
                break;
            case "BlackKnight":
                BlackKnight blackKnight = new BlackKnight(new Point(x, y));
                counters.add(blackKnight);
                break;
            case "BlackPawn":
                BlackPawn blackPawn = new BlackPawn(new Point(x, y));
                counters.add(blackPawn);
                break;
            case "BlackQueen":
                BlackQueen blackQueen = new BlackQueen(new Point(x, y));
                counters.add(blackQueen);
                break;
            case "BlackRook":
                BlackRook blackRook = new BlackRook(new Point(x, y));
                counters.add(blackRook);
                break;
            // white counters
            case "WhiteBishop":
                WhiteBishop whiteBishop = new WhiteBishop(new Point(x, y));
                counters. add(whiteBishop);
                break;
            case "WhiteKing":
                WhiteKing whiteKing = new WhiteKing(new Point(x, y));
                counters.add(whiteKing);
                break;
            case "WhiteKnight":
                WhiteKnight whiteKnight = new WhiteKnight(new Point(x, y));
                counters.add(whiteKnight);
                break;
            case "WhitePawn":
                WhitePawn whitePawn = new WhitePawn(new Point(x, y));
                counters.add(whitePawn);
                break;
            case "WhiteQueen":
                WhiteQueen whiteQueen = new WhiteQueen(new Point(x, y));
                counters.add(whiteQueen);
                break;
            case "WhiteRook":
                WhiteRook whiteRook = new WhiteRook(new Point(x, y));
                counters.add(whiteRook);
                break;
        }
    }

    public String getWinner() {
        return winner;
    }
}
