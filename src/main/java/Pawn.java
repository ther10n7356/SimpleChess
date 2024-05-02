public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        if (getColor().equals("White")) {
            return moveCheck(getDifference(toLine, line), 1, chessBoard, line, column, toLine, toColumn);
        } else {
            return moveCheck(getDifference(line, toLine), 6, chessBoard, line, column, toLine, toColumn);
        }
    }

    private boolean moveCheck(int difference, int firstLine, ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == firstLine && difference == 2) {
            return true;
        } else if (
                chessBoard.board[toLine][toColumn] != null
                        && !chessBoard.board[toLine][toColumn].getColor().equals(getColor())
                        && difference == 1 && getAbsDifference(column, toColumn) == 1
        ) {
            return true;
        } else return super.isCheckNullOrOtherPiece(chessBoard.board[toLine][toColumn])
                    && difference == 1
                    && column == toColumn;
    }

    public String getSymbol() {
        return "P";
    }
}
