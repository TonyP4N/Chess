package chess;

public class Bishop extends Piece {
	private PieceColour colour;
	private String symbol;

	public Bishop(PieceColour pc) {
		if (pc.equals(PieceColour.WHITE)) {
			this.colour = PieceColour.WHITE;
			this.symbol = "♗";
		} else if (pc.equals(PieceColour.BLACK)) {
			this.colour = PieceColour.BLACK;
			this.symbol = "♝";
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
		} else if (Math.abs(j1 - j0) != Math.abs(i1 - i0)) {
			return false;
		} else {
			if (j1 - j0 == -(i1 - i0)) {
				for (int m = 1; m < Math.abs(j1 - j0) + 1; m++) {
					int i2 = i0 - m;
					int j2 = j0 + m;
					if (i2 > 0 && j2 < 7) {
						if (Board.hasPiece(i2, j2)) {
							return false;
						}
					}
				}
			} else if (i1 - i0 == -(j1 - j0)) {
				for (int n = 1; n < Math.abs(j1 - j0) + 1; n++) {
					int i3 = i0 + n;
					int j3 = j0 - n;
					if (j0 > 0 && i0 < 7) {
						if (Board.hasPiece(i3, j3)) {
							return false;
						}
					}
				}
			} else if ((i1 - i0 == j1 - j0) && (i1 - i0) > 0 ) {
				for (int p = 1; p < Math.abs(j1 - j0); p++) {
					int i4 = i0 + p;
					int j4 = j0 + p;
					if (j0 > 0 && i0 < 7) {
						if (Board.hasPiece(i4, j4)) {
							return false;
						}
					}
				}
			}
			else if (((i1 - i0) == (j1 - j0)) && (i1 - i0) < 0) {
				for (int q = 1; q < Math.abs(j1 - j0); q++) {
					int i5 = i0 - q;
					int j5 = j0 - q;
					if (j0 > 0 && i0 < 7) {
						if (Board.hasPiece(i5, j5)) {
							return false;
						}
					}
				}
			}
			return true;
		}
	}
}