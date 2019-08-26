import java.util.*;

class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        System.out.println("(" + x + ", " + y + ")");
        return "";
    }
}

public class KnightTour {

    public static int i_move[] = {1, 2};
    public static int j_move[] = {2, 1};

    public static ArrayList<ArrayList<Position>> possiblePaths = new ArrayList<>();

    public static ArrayList<Position> getPossibleMoves(int chess[][], int x_pos, int y_pos) {
        ArrayList<Position> position = new ArrayList<Position>();

        for(int i = 0; i < i_move.length; i++) {
            if(checkBoardUtils(i_move[i] + x_pos, j_move[i] + y_pos, chess.length)) {
                Position p = new Position(i_move[i] + x_pos, j_move[i] + y_pos);
                position.add(p);
            }
        }
        return position;
    }

    public static void getPath(int startX, int startY, int endX, int endY, int chessBoard[][], ArrayList<Position> position, ArrayList<Position> path) {
        
        if(startX == endX && startY == endY) {
            System.out.println(path);
            possiblePaths.add(new ArrayList<Position>(path));
            return;
        }

        if(position == null) {
            return;
        }
        
        ArrayList<Position> nextPossibleMove = getPossibleMoves(chessBoard, startX, startY);
        
        for(int i = 0; i < nextPossibleMove.size(); i++) {
            Position coordinate = position.get(i);
            //System.out.println(coordinate);
            path.add(coordinate);
            // System.out.println("----------");
            // for(Position h : path) {
            //     System.out.println(h);
            // }


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

        int startX = 0, startY = 0;
        int endX = n-1, endY = n-1;

        ArrayList<Position> position = getPossibleMoves(chessBoard, 0, 0);

        getPath(startX, startY, endX, endY, chessBoard, position, new ArrayList<Position>());

        for(ArrayList<Position> al : possiblePaths) {
            for(Position y : al) {
                System.out.print(y);
            }
            System.out.println();
        }
     }
}