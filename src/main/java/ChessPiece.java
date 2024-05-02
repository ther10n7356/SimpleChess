public abstract class ChessPiece {
    private String color;
    boolean check;

    public ChessPiece(String color) {
        this.color = color;
        this.check = true;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) {
            return false;
        }

        return chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn);
    }

    public abstract String getSymbol();

    public int getDifference(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    protected boolean isCheckNullOrOtherPiece(ChessPiece chessPiece) {
        return chessPiece == null || !chessPiece.getColor().equals(this.getColor());
    }

    protected boolean isCheckEverCell (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int lineDiff = getDifference(line, toLine);
        int columnDiff = getDifference(column, toColumn);
        int count = (columnDiff == 0) ? lineDiff: columnDiff;
        int lineIndex = 0;
        int columnIndex = 0;
        for (int i = 1; i < Math.abs(count); i++) {

            if (columnDiff != 0) {
                if (columnDiff < 0)
                    columnIndex = columnDiff + i;
                else
                    columnIndex = columnDiff - i;
            }
            if (lineDiff != 0) {
                if (lineDiff < 0)
                    lineIndex = lineDiff + i;
                else
                    lineIndex = lineDiff - i;
            }

            if (chessBoard.board[line - lineIndex][column - columnIndex] != null)
                return true;
        }

        return false;
    }

    public int getAbsDifference(int firstValue, int secondValue) {
        return Math.abs(getDifference(firstValue, secondValue));
    }
}
