
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="game" class="Beans.TicBean" scope="session"></jsp:useBean>
	
	<jsp:setProperty property="reset" name="game" value="${ param.reset }" />
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
		${ game.setSpot( param.spot ) } <!--  sets spot -->
		
	<div class="container">
		<div class="page-header">
			<h1><font color="white"	> Player ${ game.getPlayer() } Turn <small>Tic Tac Toe</small></font></h1>
		</div>
		<div class="row">
			<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=0' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[0]) }' alt='Open'></a>	
			</div>
			
			<div class="col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=1' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[1] ) }' alt='Open'></a>	
			</div>
			<div class="col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=2' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[2] ) }' alt='Open'></a>	
			</div>
		</div> <!--  end row -->
		
		<div class="row">
			<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=3' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[3] ) }' alt='Open'></a>	
			</div>
			<div class="col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=4' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[4] ) }' alt='Open'></a>	
			</div>
			<div class="col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=5' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[5] ) }' alt='Open'></a>	
			</div>
		</div><!--  end row -->
		
		
		<div class="row">
			<div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center"> 
				<a href='TicTacToeBean.jsp?spot=6' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[6] ) }' alt='Open'></a>	
			</div>
			<div class="col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=7' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[7] ) }' alt='Open'></a>	
			</div>
			<div class="col-sm-2 col-xs-4 text-center">
				<a href='TicTacToeBean.jsp?spot=8' class='thumbnail'><img src='${ game.getOpenSpace( game.getBoard()[8] ) }' alt='Open'></a>	
			</div>
		</div><!--  end row -->
	</div><!--  container end row -->
	
	
		<p class="text-center">
			<a href="TicTacToeBean.jsp?reset=reset" class="btn btn-lg btn-primary" >New Game</a>
		</p>
		${ game.setClicks( param.clicks) }
		${ game.setPlayer() } <!-- switcher -->
		<!--  ${ game.setSpot( param.spot ) }--> <!--  sets spot -->
		<!--  ${ game.setBoard() } --> <!--  sets board with value -->

</body>
</html>
