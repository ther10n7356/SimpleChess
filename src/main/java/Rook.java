public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        return super.isCheckNullOrOtherPiece(chessBoard.board[toLine][toColumn])
                && !super.isCheckEverCell(chessBoard,line,column, toLine, toColumn)
                && (line == toLine || column == toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
