package main.java.servlet;

import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
@WebServlet( name = "sortFinal", urlPatterns = {"/sortFinal"} )



public class SortFinal extends HttpServlet
{

static String Domain  = "";
static String Path    = "";
static String Servlet = "sortFinal";


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
   String listOfString = request.getParameter("listOfStrings");

   String[] StringArray = listOfString.split(" ");

   List<String> newStrings = new Arraylist<String>(Arrays.asList(StringArray));

   if(operation.equals(OperationAscending)){
        //Sorts string in ascending order
        Collections.sort(newStrings);

   }else{
        Collections.sort(newStrings);
        Collections.reverse(newStrings);
   }

   String rslt = "";

   for (String name : newStrings){
       rslt += name + " ";
   }
   
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out, listOfString, rslt);
   PrintTail(out);
}  // End doPost

/** *****************************************************
 *  Overrides HttpServlet's doGet().
 *  Prints an HTML page with a blank form.
********************************************************* */
@Override
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out);
   PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */
private void PrintHead (PrintWriter out)
{
   out.println("<html>");
   out.println("");

   out.println("<head>");
   out.println("<title>Elias Aleman SWE 432 Fall 2020 Final</title>");
   out.println("</head>");
   out.println("");
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, String lhs, String rslt)
{
   out.println("<body>");
   out.println("<p>");
   out.println("A simple example that demonstrates how to operate with");
   out.println("multiple submit buttons.");
   out.println("</p>");
   out.print  ("<form method=\"post\"");
   
   out.println(" action=\"/" + Servlet + "\">");
   out.println("");
   out.println(" <table>");
   out.println("  <tr>");
   out.println("   <td>List of String (Separated by Spaces):");
   out.println("   <td><input type=\"text\" name=\"listOfStrings\" value=\"" + lhs + "\" size=5>");
   out.println("  </tr>");
  
   out.println("  <tr>");
   out.println("   <td>Result:");
   out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + rslt + "\" size=6>");
   out.println("  </tr>");
   out.println(" </table>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <input type=\"submit\" value=\"" + OperationAscending + "\" name=\"Operation\">");
   out.println(" <input type=\"submit\" value=\"" + OperationDescending + "\" name=\"Operation\">");
   
   out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
   out.println("</form>");
   out.println("");
   out.println("</body>");
} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
private void PrintBody (PrintWriter out)
{
   PrintBody(out, "", "");
}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

}  // End twoButtons
