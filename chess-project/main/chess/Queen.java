package chess;

public class Queen extends Piece {
	private PieceColour colour;
	private String symbol;

	public Queen(PieceColour pc) {
		if (pc.equals(PieceColour.WHITE)) {
			this.colour = PieceColour.WHITE;
			this.symbol = "♕";
		} else if (pc.equals(PieceColour.BLACK)) {
			this.colour = PieceColour.BLACK;
			this.symbol = "♛";
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
		if ((Board.hasPiece(i1, j1)) && Board.getPiece(i1, j1).getColour() == (Board.getPiece(i0, j0).getColour())) {
			return false;
		}
		if (j0 == j1) {
			for (int l = Math.min(i0, i1) + 1; l < Math.max(i0, i1); l++) {
				if (Board.hasPiece(l, j1)) {
					return false;
				}
			}
		} else if (i0 == i1) {
			for (int k = Math.min(j0, j1) + 1; k < Math.max(j0, j1); k++) {
				if (Board.hasPiece(i1, k)) {
					return false;
				}
			}
		} else if (Math.abs(j1 - j0) != Math.abs(i1 - i0)) {
			return false;
		} else {
			for (int m = 1; m < Math.abs(j1 - j0); m++) {
				if (i0 > 0) {
					int i2 = i0 - m;
					int j2 = j0 + m;
					if (Board.hasPiece(i2, j2)) {
						return false;
					}
				}
			}
			for (int n = 1; n < Math.abs(j1 - j0); n++) {
				if (j0 > 0) {
					int i2 = i0 + n;
					int j2 = j0 - n;
					if (Board.hasPiece(i2, j2)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}


