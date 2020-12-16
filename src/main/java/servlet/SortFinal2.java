package main.java.servlet;

import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.annotation.WebServlet;
@WebServlet( name = "sortFinal2", urlPatterns = {"/sortFinal2"} )



public class SortFinal2 extends HttpServlet
{
static String Domain  = "";
static String Path    = "";
static String Servlet = "sortFinal2";


static String OperationAscending = "Ascend";
static String OperationDescending = "Descend";


@Override
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   String operation = request.getParameter("Operation");
   String listOfString = request.getParameter("listOfStrings").toLowerCase();
   String[] StringArray = listOfString.split(" ");
   List<String> newStrings = new ArrayList<String>(Arrays.asList(StringArray));
   String option = "";

   if(operation.equals(OperationAscending)){
        //Sorts string in ascending order
        Collections.sort(newStrings);
        option = "Ascending Order";

   }else{
       //Sorts string in descinding order
        Collections.sort(newStrings);
        Collections.reverse(newStrings);
        option = "Descending Order";

   }

   //Adds string to Set to remove duplicates
   Set<String> s = new LinkedHashSet<>(newStrings);
   
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out, listOfString);
   makeList(out, s, option);
   PrintTail(out);
}


private void PrintHead (PrintWriter out)
{
   out.println("<html>");
   out.println("");

   out.println("<head>");
   out.println("<title>Sort Final</title>");
   out.println("</head>");
   out.println("");
}


private void PrintBody (PrintWriter out, String list)
{
   out.println("<body>");
   out.println("<p>");
   out.println("This web app will take a list of Strings, separated by spaces and ");
   out.println("return it in ascending or descending order, with no duplicates");
   out.println("</p>");
   out.print  ("<form method=\"post\"");
   
   out.println(" action=\"/" + Servlet + "\">");
   out.println("");
   out.println(" <table>");
   out.println("  <tr>");
   out.println("   <td>Enter Strings here (Separated by Spaces):");
   out.println("   <td><input type=\"text\" name=\"listOfStrings\" value=\"" + list + "\" size=30>");
   out.println("  </tr>");
  
   out.println(" </table>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <input type=\"submit\" value=\"" + OperationAscending + "\" name=\"Operation\">");
   out.println(" <input type=\"submit\" value=\"" + OperationDescending + "\" name=\"Operation\">");
   
   out.println("</form>");
   out.println("");
   out.println("</body>");
}


private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("<h4>  SWE 432 Fall 2020 Final </h4>");
   out.println("<h4> Elias Aleman </h4>");
   out.println("</html>");
}

private void makeList(PrintWriter out, Set<String> s, String option){
    String result = "[ ";
    for (String name : s){
        result += name + ", ";
    }
    result += "]";
    out.print("<h3> Resulting list in  ");
    out.print(option);
    out.print("</h3>");
    out.println(result);
}
}
