package chess;

public class Rook extends Piece {
	private PieceColour colour;
	private String symbol;

	public Rook(PieceColour pc) {
		if (pc.equals(PieceColour.WHITE)) {
			this.colour = PieceColour.WHITE;
			this.symbol = "♖";
		} else if (pc.equals(PieceColour.BLACK)) {
			this.colour = PieceColour.BLACK;
			this.symbol = "♜";
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public PieceColour getColour() {
		return colour;
	}

	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
//		if  {
//			return false;
//		}

		if (j0 == j1) {
			for (int l = Math.min(i0, i1)+1; l < Math.max(i0, i1); l++) {
				if (Board.hasPiece(l, j1)){
					return false;
				}
			}
		} else if (i0 == i1) {
			for (int k = Math.min(j0, j1)+1; k < Math.max(j0, j1); k++) {
				if (Board.hasPiece(i1, k))
					return false;
			}
		} else if (i0 != i1 && j0 != j1){
			return false;
		}
		return !((Board.hasPiece(i1, j1)) && Board.getPiece(i1, j1).getColour() == (Board.getPiece(i0, j0).getColour()));
	}
}