package Beans;

public class TicBean {
	
	char[] board;
	char player;
	String spot;
	String reset;
	int clicks; 
	boolean winner;
	boolean tie;
	
	String openSpace = "http://placehold.it/150/cccccc?text=_";
	String xPlayer = "http://placehold.it/150/E8117F/ffffff?text=X";
	String oPlayer = "http://placehold.it/150/78ddfa/ffffff?text=O";
	
	
	public TicBean(){
		this.board = new char[9];
		//init board
		for (int i = 0; i < board.length; i++) {
			board[i] = 0;
		}
		this.player = 'X';
		this.reset = "";
		this.clicks = 0;
		this.winner = false;
		this.tie = false;
		this.spot = "";
	}


	public String getSpot() {
		return spot;
	}


	public void setSpot(String spot) {
		if(!spot.equals("") || spot != null){
			this.spot = spot;
		}

	}


	public char[] getBoard() {
		return board;
	}


	public char getPlayer() {
		return player;
	}


	public String getReset() {
		return reset;
	}


	public int getClicks() {
		if(clicks == 0 ){
			clicks = 0;
		}
		return clicks;
	}


	public boolean isWinner( ) {
		
		for(int i = 0; i < board.length; i++){
			//tr, mr, br
			if( board[0] == player && board[1] == player && board[2] == player || 
					board[3] == player && board[4] == player && board[5] == player ||
					board[6] == player && board[7] == player && board[8] == player){
				 winner = true;
				break;
			//lc, mc, rc
			}else if(board[0] == player && board[3] == player && board[6] == player || 
					board[1] == player && board[4] == player && board[7] == player ||
					board[2] == player && board[5] == player && board[8] == player){
				 winner = true;
				 break;
			//ld,rd
			}else if(board[0] == player && board[4] == player && board[8] == player || 
					board[2] == player && board[4] == player && board[6] == player){
				 winner = true;
				 break;
			}
		}
		return winner;
	}


	public boolean isTie() {
		return tie;
	}


	public String getOpenSpace(char player) {
		String link = openSpace;
//		if(!spot.equals("") && board[Integer.parseInt(spot)]!=0){
//			if(board[Integer.parseInt(spot)] == 'X'){
//				link = xPlayer;
//			}if(board[Integer.parseInt(spot)] == 'O'){
//				link = oPlayer;
//			}
		
		if(player == 'X'){
			link = xPlayer;
		}
		if(player == 'O'){
			link = oPlayer;
		}
		return link;
	}


	public String getxPlayer() {
		return xPlayer;
	}


	public String getoPlayer() {
		return oPlayer;
	}


	public void setBoard() {
		if(spot != null && !spot.equals("") && winner != true){
			board[Integer.parseInt(spot)] = player;
			for(int i = 0; i < board.length; i++){
				System.out.println(board[i] + " ");
				System.out.println("---");
			}
		}
		
	}


	public void setPlayer( ) {
		this.player = player == 'X' ? 'O' : 'X';
	}


	public void setReset(String reset) {
		if(!reset.equals("") && reset != null){
			for(int i = 0; i < board.length; i++){
				board[i] = 0;
			}
			winner = false;
			player = 'X';
			clicks = 0;
			tie = false;	
			spot = "";
			System.out.println(reset);
			System.out.println("we reset");
		}else{
			this.reset = null;
		}

	}


	public void setClicks(int clicks) {
		if(clicks >=9){
			tie = true;
			return;
		}
		if(tie != true){
			this.clicks++;
		}
		else{
			this.clicks = clicks;
		}
		
	}

}
