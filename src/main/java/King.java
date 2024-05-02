public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!super.canMoveToPosition(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }

        int lineDiff = super.getAbsDifference(line, toLine);
        int columnDiff = super.getAbsDifference(column, toColumn);

        return super.isCheckNullOrOtherPiece(chessBoard.board[toLine][toColumn]) && (lineDiff == 1  && columnDiff == 1
                || lineDiff == 1  && columnDiff == 0
                || lineDiff == 0  && Math.abs(column - toColumn) == 1);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = board.board.length -1; i >= 0 ; i--) {
            for (int j = board.board[i].length -1; j >= 0 ; j--) {
                if (board.board[i][j] == null) continue;

                if (!board.board[i][j].getColor().equals(getColor())
                        && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
