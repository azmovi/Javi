package ufscar.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tabela")
public class ConversorServelet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String valor_minimo = req.getParameter("valor_minimo");
        String valor_maximo = req.getParameter("valor_maximo");
        String valor_incremento = req.getParameter("valor_incremento");

        if ((valor_minimo == null) || valor_minimo.isEmpty())
        {
            valor_minimo = "-100";
        }
        int min = Integer.parseInt(valor_minimo);

        if ((valor_maximo == null) || valor_maximo.isEmpty())
        {
            valor_maximo = "100";
        }
        int max = Integer.parseInt(valor_maximo);

        if ((valor_incremento == null) || valor_incremento.isEmpty())
        {
            valor_incremento = "5";
        }
        int incremento = Integer.parseInt(valor_incremento);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Servlet PrintParamsServlet</title>");
        resp.getWriter().println("<style>");
        resp.getWriter().println("table, th, td{ border: 1px solid;}");
        resp.getWriter().println("td{ text-align: center;}");
        resp.getWriter().println("</style>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<table>");
        resp.getWriter().println("<tr>");
        resp.getWriter().println("<th>Celcius</th>");
        resp.getWriter().println("<th>Fahrenheit</th>");
        resp.getWriter().println("<th>Kelvin</th>");
        resp.getWriter().println("</tr>");
        for (int celsius = min; celsius <= max; celsius += incremento)
        {
            double fahr = 1.8 * celsius + 32;
            double kelvin = celsius + 273.15;
            resp.getWriter().println("<tr>");
            resp.getWriter().println("<td>" + celsius + "</td>");
            resp.getWriter().println("<td>" +  fahr + "</td>");
            resp.getWriter().println("<td>" + String.format("%.2f", kelvin) + "</td>");
            resp.getWriter().println("</tr>");
        }
        resp.getWriter().println("</table>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}
