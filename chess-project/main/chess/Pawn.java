package chess;

public class Pawn extends Piece {
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc) {
		if (pc.equals(PieceColour.WHITE)) {
			this.colour = PieceColour.WHITE;
			this.symbol = "♙";
		} else if (pc.equals(PieceColour.BLACK)) {
			this.colour = PieceColour.BLACK;
			this.symbol = "♟";
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public PieceColour getColour() {
		return colour;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		int direction;
		if (Board.getPiece(i0, j0).getColour() == PieceColour.BLACK) {
			direction = 1;
		} else {
			direction = -1;
		}
		if (Board.hasPiece(i1, j1) && Board.getPiece(i0, j0).getColour() == Board.getPiece(i1, j1).getColour()) {
			return false;
		}
		if ((Math.abs(i1 - i0) > 2) || (Math.abs(j1 - j0) > 1)) {
			return false;
		}
		if (i0 == 1 || i0 == 6) {
			if (j0 == j1) {
				return !(Board.hasPiece(i0 + direction, j0) || Board.hasPiece(i1, j1));
			} else
				return (Board.hasPiece(i1, j1));
		} else {
			if (i0 + direction != i1) {
				return false;
			}
			if (Math.abs(j1 - j0) == 0) {

				return !(Board.hasPiece(i1, j1));
			} else {
				return (Board.hasPiece(i1, j1));
			}
		}
	}
}
