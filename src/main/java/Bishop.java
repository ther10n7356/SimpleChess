public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        return super.isCheckNullOrOtherPiece(chessBoard.board[toLine][toColumn])
                && !super.isCheckEverCell(chessBoard,line,column, toLine, toColumn)
                && (Math.abs(line - column) == Math.abs(toLine - toColumn)
                || Math.abs(line + column) == Math.abs(toLine + toColumn));
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
