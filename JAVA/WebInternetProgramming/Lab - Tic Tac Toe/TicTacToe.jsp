
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!

	int counter = 0;
	//counts clicks for tie
	int clicks = 0;
	char player = 'X';
	// sets the picture for x and o players
	String openSpace = "http://placehold.it/150/cccccc?text=_";
	String xPlayer = "http://placehold.it/150/E8117F/ffffff?text=X";
	String oPlayer = "http://placehold.it/150/78ddfa/ffffff?text=O";
	String disabler = "onclick ='return false'";
	String sign = "";
	//flags
	boolean winner = false;
	boolean firstRun = true;
	boolean isTie = false;
	//simple board
	char[] board = new char [9];
	
	//checks winner exists
	public boolean isWin(char player, char[] board ){
	
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
	//prints replacement link
	public String playerSign(char player){
		
		String pSign = "";
		
		if(player == 'X'){
			pSign+="<a href='#' class='thumbnail'><img src='"+ xPlayer +"' alt='X'></a>";
		}else{
			pSign+="<a href='#' class='thumbnail'><img src='"+ oPlayer +"' alt='O'></a>";
		}
		
		return pSign;
	}
	//switches player
	public void whoPlayer(){
		if(player == 'X'){
			player = 'O';
		}else{
		    player = 'X';
		}
		
	}
	

%> <%--ends declares --%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Tic Tac Toe</title>
<style> 
	html,body { background: black; }
 </style>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<%whoPlayer(); %>
			<h1><font color="white"	> Player <%= player%> Turn <small>Tic Tac Toe</small></font></h1>
			<%whoPlayer(); %>
		</div>
		
<%


//when new game resets everything
	String reset = request.getParameter("value");
	if (reset != null) {
		if (reset.equals("reset")) {
			for(int i = 0; i < board.length; i++){
				board[i] = 0;
			}
			winner = false;
			player = 'X';
			clicks = 0;
			isTie = false;	
			request.getSession().invalidate();
			response.sendRedirect("TicTacToe.jsp");
		}
	}
//grabs the spot and enters the player into the board, checks status
if(request.getParameter("spot") != null){
	clicks++;
	if(clicks >=9){
		isTie = true;
	}
	board[Integer.parseInt(request.getParameter("spot"))] = player;
	isWin(player, board);
}
	for(int i = 0; i < 3; i++){
%>

		<div class="row">
			<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
<%--if blank displays open spot , also injects disabler when winner is present--%>
				<%if(board[counter] == 0){ %>
					<a href='TicTacToe.jsp?spot=<%= counter %>' class='thumbnail' <%if(winner == true){ %> <%= disabler %><%} %>><img src='<%= openSpace %>' alt='Open'></a>	
				<%} else{
						if(board[counter] != ' '){
// 		prints the correct pic to page					
						sign = playerSign(board[counter]);
						%>
							<%=sign %>
						<%} %>

				<%} %>	
				
				
			</div>
			<% counter++; %><%--this counter is to the spots  --%>
			<div class="col-sm-2 col-xs-4 text-center">
				
				<%if(board[counter] == 0 ){ %>
					<a href='TicTacToe.jsp?spot=<%= counter %>' class='thumbnail' <%if(winner == true){ %> <%= disabler %><%} %>><img src='<%= openSpace %>' alt='Open'></a>	
				<%} else{
						if(board[counter] != ' '){
							
						sign = playerSign(board[counter]);
						%>
							<%=sign %>
						<%} %>

				<%} %>	
				
			</div>
			<% counter++; %>
			<div class="col-sm-2 col-xs-4 text-center">
				
				<%if(board[counter] == 0 ){ %>
					<a href='TicTacToe.jsp?spot=<%= counter %>' class='thumbnail' <%if(winner == true){ %> <%= disabler %><%} %>><img src='<%= openSpace %>' alt='Open'></a>	
				<%} else{
						if(board[counter] != ' '){
							
						sign = playerSign(board[counter]);
						%>
							<%=sign %>
						<%} %>

				<%} %>	
			</div>
		</div> <!--  end row -->
		
<%
		counter++;
	}//end for loop
	counter = 0;
	// reset counter at the end of display
	
	if(winner == true){ %>
	<div class="text-center">
		<h2> <font color="yellow">Player <%=player %> is the Winner!!</font></h2>
	</div>
<%}else if(isTie == true){%>
	<div class="text-center">
		<h2> <font color="yellow">Its a Tie!! AGAIN!!</font></h2>
	</div>
<%}

	if(winner == false && firstRun == false){
		whoPlayer();
	}
	
	firstRun = false;
	
	%>
	
		<p class="text-center">
			<a href="TicTacToe.jsp?value=reset" class="btn btn-lg btn-primary" >New Game</a>
		</p>


	</div>
</body>
</html>
