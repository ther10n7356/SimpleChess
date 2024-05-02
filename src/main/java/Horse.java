public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        int lineDiff = super.getAbsDifference(line, toLine);
        int columnDiff = super.getAbsDifference(column, toColumn);

        return super.isCheckNullOrOtherPiece(chessBoard.board[toLine][toColumn]) && (lineDiff == 1 && columnDiff == 2
                || lineDiff == 2 && columnDiff == 1);
    }

    public String getSymbol() {
        return "H";
    }
}
