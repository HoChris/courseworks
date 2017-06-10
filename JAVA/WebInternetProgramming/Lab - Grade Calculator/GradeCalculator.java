package lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/lab2/GradeCalculator")
public class GradeCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GradeCalculator() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
	
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Grade Calculator</title>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>");
		out.println("</head>");
		//subject	possible score	actual score	percent
		//subject attendance /5%, labs/20% , quizes /25%, midterm /25%, final /25%
		out.println("<body>");

		//myscore
		String attend = request.getParameter("attend") == null ? "" : request.getParameter("attend");
		String lab = request.getParameter("lab") == null ? "" : request.getParameter("lab");
		String quiz = request.getParameter("quiz") == null ? "" : request.getParameter("quiz");
		String midterm = request.getParameter("midterm") == null ? "" : request.getParameter("midterm");
		String finalsc = request.getParameter("finalsc") == null ? "" : request.getParameter("finalsc");
		//possible
		String pattend = request.getParameter("p-attend") == null ? "" : request.getParameter("p-attend");
		String plab = request.getParameter("p-lab") == null ? "" : request.getParameter("p-lab");
		String pquiz = request.getParameter("p-quiz") == null ? "" : request.getParameter("p-quiz");
		String pmidterm = request.getParameter("p-midterm") == null ? "" : request.getParameter("p-midterm");
		String pfinalsc = request.getParameter("p-finalsc") == null ? "" : request.getParameter("p-finalsc");
		//attributes
		String atp = (String) session.getAttribute("atp");
		String labp = (String) session.getAttribute("labp");
		String quizp = (String) session.getAttribute("quizp");
		String midtermp = (String) session.getAttribute("midtermp");
		String finalp = (String) session.getAttribute("finalp");
		String sum = (String) session.getAttribute("sum");
		


		out.println("<form action =\"GradeCalculator\" method=\"post\" >");
		out.println("<h3>Grade Calculator</h3>");
		out.println("<h4>----------Possible points------------My Score--------</h4>");

		//attend
		if(atp != null){
			out.println("Attendance | <input type = \"text\" name=\"p-attend\" value=\""+ pattend +"\" />");
			out.println("<input type = \"text\" name=\"attend\" value=\""+ attend +"\"/> -- 5% <br/>");
		}
		else{
			out.println("Attendance | <input type = \"text\" name=\"p-attend\" value=\"100\" />");
			out.println("<input type = \"text\" name=\"attend\" value=\""+ attend +"\"/> <br/>");
		}
		//labs
		if(labp != null){
			out.println("Labs | <input type = \"text\" name=\"p-lab\" value=\""+ plab +"\" />");
			out.println("<input type = \"text\" name=\"lab\"  value=\""+ lab +"\" /> -- 25%<br/>");
		}
		else{
			out.println("Labs | <input type = \"text\" name=\"p-lab\" value=\"210\" />");
			out.println("<input type = \"text\" name=\"lab\"  value=\""+ lab +"\" /> <br/>");
		}
		//quiz		
		if(quizp != null){
			out.println("Quiz | <input type = \"text\" name=\"p-quiz\" value=\""+ pquiz +"\" />");
			out.println("<input type = \"text\" name=\"quiz\"  value=\""+ quiz +"\" /> -- 25%<br/>");
		}
		else{
			out.println("Quiz | <input type = \"text\" name=\"p-quiz\" value=\"100\" />");
			out.println("<input type = \"text\" name=\"quiz\"  value=\""+ quiz +"\" /> <br/>");
		}
		//midterm
		if(midtermp != null){
			out.println("Midterm | <input type = \"text\" name=\"p-midterm\" value=\""+ pmidterm +"\" />");
			out.println("<input type = \"text\" name=\"midterm\"   value=\""+ midterm +"\"/> -- 25%<br/>");
		}
		else{
			out.println("Midterm | <input type = \"text\" name=\"p-midterm\" value=\"200\" />");
			out.println("<input type = \"text\" name=\"midterm\"   value=\""+ midterm +"\"/> <br/>");
		}
		//final
		if(finalp != null){
			out.println("Final | <input type = \"text\" name=\"p-finalsc\" value=\""+ pfinalsc +"\" />");
			out.println("<input type = \"text\" name=\"finalsc\"   value=\""+ finalsc +"\"/> -- 25%<br/>");
		}
		else{
			out.println("Final | <input type = \"text\" name=\"p-finalsc\" value=\"250\" />");
			out.println("<input type = \"text\" name=\"finalsc\"   value=\""+ finalsc +"\"/> <br/>");
			
		}
		out.println("<input type =\"submit\" class=\"btn btn-info\" value=\"Calculate\" />");
		
		out.println("<br /><br />");
		out.println("Final Percentage | <input type= 'text' name='sum' value='"+ sum +"' />");

		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//myscore
		String attend = request.getParameter("attend") == null ? "" : request.getParameter("attend");
		String lab = request.getParameter("lab") == null ? "" : request.getParameter("lab");
		String quiz = request.getParameter("quiz") == null ? "" : request.getParameter("quiz");
		String midterm = request.getParameter("midterm") == null ? "" : request.getParameter("midterm");
		String finalsc = request.getParameter("finalsc") == null ? "" : request.getParameter("finalsc");
		Double sumScore = 0.0;
		// actual/possible * .05
		if(!attend.equals("")){
			Double dattend = request.getParameter("attend") == null ? 0.0 : Double.parseDouble(request.getParameter("attend"));
			Double pAttend = request.getParameter("p-attend") == null ? 0.0 : Double.parseDouble(request.getParameter("p-attend"));
			String tattend = Double.toString(dattend/pAttend * .05);
			sumScore += dattend/pAttend * .05;
			session.setAttribute("atp", tattend);
		}
		if(!lab.equals("")){
			Double dlab = request.getParameter("lab") == null ? 0.0 : Double.parseDouble(request.getParameter("lab"));
			Double pLab = request.getParameter("p-lab") == null ? 0.0 : Double.parseDouble(request.getParameter("p-lab"));
			String tlab = Double.toString(dlab/pLab * .20);
			sumScore += dlab/pLab * .20;
			session.setAttribute("labp", tlab);
		}
		if(!quiz.equals("")){
			Double dquiz = request.getParameter("quiz") == null ? 0.0 : Double.parseDouble(request.getParameter("quiz"));
			Double pQuiz = request.getParameter("p-quiz") == null ? 0.0 : Double.parseDouble(request.getParameter("p-quiz"));
			String tquiz = Double.toString(dquiz/pQuiz * .25);
			sumScore += dquiz/pQuiz * .25;
			session.setAttribute("quizp", tquiz);
		}
		if(!midterm.equals("")){
			Double dmidterm = request.getParameter("midterm") == null ? 0.0 : Double.parseDouble(request.getParameter("midterm"));
			Double pMidterm = request.getParameter("p-midterm") == null ? 0.0 : Double.parseDouble(request.getParameter("p-midterm"));
			String tmidterm = Double.toString(dmidterm/pMidterm * .25);
			sumScore += dmidterm/pMidterm * .25;
			session.setAttribute("midtermp", tmidterm);

		}
		if(!finalsc.equals("")){			
			Double dfinalsc = request.getParameter("finalsc") == null ? 0.0 : Double.parseDouble(request.getParameter("finalsc"));
			Double pFinalsc = request.getParameter("p-finalsc") == null ? 0.0 : Double.parseDouble(request.getParameter("p-finalsc"));
			String tfinal = Double.toString(dfinalsc/pFinalsc * .25);
			sumScore += dfinalsc/pFinalsc * .25;
			session.setAttribute("finalp", tfinal);
		}
			String sScore = Double.toString(sumScore * 100);
			session.setAttribute("sum", sScore);

		doGet(request, response);
		
	}

}
