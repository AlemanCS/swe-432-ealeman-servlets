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



/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the operation
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
@Override
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   String operation = request.getParameter("Operation");
   String listOfString = request.getParameter("listOfStrings").toLowerCase();
   String[] StringArray = listOfString.split(" ");
   List<String> newStrings = new ArrayList<String>(Arrays.asList(StringArray));

   if(operation.equals(OperationAscending)){
        //Sorts string in ascending order
        Collections.sort(newStrings);

   }else{
       //Sorts string in descinding order
        Collections.sort(newStrings);
        Collections.reverse(newStrings);
   }

   //Adds string to Set to remove duplicates
   Set<String> s = new LinkedHashSet<>(newStrings);
   
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out, listOfString);
   makeList(out, s);
   PrintTail(out);
}  // End doPost

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */
private void PrintHead (PrintWriter out)
{
   out.println("<html>");
   out.println("");

   out.println("<head>");
   out.println("<title>Sort Final</title>");
   out.println("</head>");
   out.println("");
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, String lhs)
{
   out.println("<body>");
   out.println("<p>");
   out.println("Enter a list of Strings, separated by spaces");
   out.println("List will be return in ascending or descending order, with no duplicates");
   out.println("</p>");
   out.print  ("<form method=\"post\"");
   
   out.println(" action=\"/" + Servlet + "\">");
   out.println("");
   out.println(" <table>");
   out.println("  <tr>");
   out.println("   <td>List of String (Separated by Spaces):");
   out.println("   <td><input type=\"text\" name=\"listOfStrings\" value=\"" + lhs + "\" size=30>");
   out.println("  </tr>");
  
   out.println(" </table>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <input type=\"submit\" value=\"" + OperationAscending + "\" name=\"Operation\">");
   out.println(" <input type=\"submit\" value=\"" + OperationDescending + "\" name=\"Operation\">");
   
   //out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
   out.println("</form>");
   out.println("");
   out.println("</body>");
} // End PrintBody

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("<p> Elias Aleman SWE 432 Fall 2020 Final ");
   out.println("</html>");
} // End PrintTail

private void makeList(PrintWriter out, Set<String> s){
    String result = "[ ";
    for (String name : s){
        result += name + ", ";
    }
    result += "]";
    out.println("<h3> RESULT </h3>");
    out.println(result);
}
}
