import java.util.*;

import javafx.geometry.Pos;

class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Backtracking {

    public static int i_move[] = {-2, -1, 1, 2, 1, 2, -1, -2};
    public static int j_move[] = {1, 2, 2, 1, -2, -1, -2, -1};

    public static ArrayList<ArrayList<Position>> possiblePaths = new ArrayList<>();

    public static ArrayList<Position> getPossibleMoves(int chess[][], int x_pos, int y_pos) {
        ArrayList<Position> position = new ArrayList<Position>();

        for(int i = 0; i < i_move.length; i++) {
            if(checkBoardUtils(i_move[i] + x_pos, j_move[i] + y_pos, chess.length)) {
                //System.out.println("(" + (i_move[i] + x_pos) + ", " +  (j_move[i] + y_pos) + ")");
                Position p = new Position(i_move[i] + x_pos, j_move[i] + y_pos);
                position.add(p);
            }
        }
        return position;
    }

    public static void getPath(int startX, int startY, int endX, int endY, int chessBoard[][], ArrayList<Position> position, ArrayList<Position> path) {
        
        if(startX == endX && startY == endY) {
            possiblePaths.add(path);
            return;
        }
        
        for(int i = 0; i < position.size(); i++) {
            Position coordinate = position.get(i);
            path.add(coordinate);
            boolean flag = false;
            int index = 0;

            ArrayList<Position> nextPossibleMove = getPossibleMoves(chessBoard, coordinate.x, coordinate.y);
            Iterator iterator = nextPossibleMove.iterator();
            while(iterator.hasNext()) {
                Position p = (Position) iterator.next();
                if((p.x < coordinate.x) && (p.y < coordinate.y)) {
                    nextPossibleMove.remove(index);
                }
                index++;
            }

            getPath(coordinate.x, coordinate.y, endX, endY, chessBoard, nextPossibleMove, path);
            path.remove(path.size()-1);

        }

    }

    public static boolean checkBoardUtils(int i, int j, int boardLength) {
        if((i >= 0) && (j >= 0) && (i < boardLength) && (j < boardLength))
            return true;
        return false;
    }

    public static void main(String[] args) {

        int n = 5;
        int chessBoard[][] = new int[n][n];

        int knightX = 3;
        int knightY = 3;

        // first check whether the move is valid or not
        boolean status = checkBoardUtils(knightX, knightY, n);
        // if(status)
        //     getPossibleMoves(chessBoard, knightX, knightY);
        // else {
        //     System.out.println("Invalid Move");
        // }

        int startX = 0, startY = 0;
        int endX = n-1, endY = n-1;

        ArrayList<Position> position = getPossibleMoves(chessBoard, 0, 0);

        getPath(startX, startY, endX, endY, chessBoard, position, new ArrayList<Position>());
    }
}