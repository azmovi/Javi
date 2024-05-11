package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.StudioDAO;
import br.ufscar.dc.dsw.dao.FilmeDAO;
import br.ufscar.dc.dsw.domain.Studio;
import br.ufscar.dc.dsw.domain.Filme;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/filmes/*")
public class FilmeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private FilmeDAO filme_dao;

    @Override
    public void init() {
        filme_dao = new FilmeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String action = request.getPathInfo();

        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        }

        catch (RuntimeException | IOException | ServletException e)
        {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        doGet(request, response);

    }


    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Filme> listaFilmes = filme_dao.getAll();
        request.setAttribute("listaFilmes", listaFilmes);
        request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/filme/lista.jsp");
        dispatcher.forward(request, response);
    }

    private Map<Long, String> getStudios() {

        Map <Long,String> studios = new HashMap<>();
        for (Studio studio: new StudioDAO().getAll()) {
            studios.put(studio.getId(), studio.getEmpresa());
        }
        return studios;
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("studios", getStudios());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/filme/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Filme filme = filme_dao.get(id);
        request.setAttribute("filme", filme);
        request.setAttribute("studios", getStudios());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/filme/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String diretor = request.getParameter("diretor");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Float preco = Float.parseFloat(request.getParameter("preco"));
        
        Long studio_id = Long.parseLong(request.getParameter("studio"));
        Studio studio = new StudioDAO().get(studio_id);
        
        Filme filme = new Filme(nome, diretor, ano, preco, studio);
        filme_dao.insert(filme);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String diretor = request.getParameter("diretor");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Float preco = Float.parseFloat(request.getParameter("preco"));
        
        Long studio_id = Long.parseLong(request.getParameter("studio"));
        Studio studio = new StudioDAO().get(studio_id);
        
        Filme filme = new Filme (id, nome, diretor, ano, preco, studio);
        filme_dao.update(filme);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Filme filme = new Filme(id);
        filme_dao.delete(filme);
        response.sendRedirect("lista");
    }
}
