package pl.sda.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/albumServlet")
public class AlbumController extends HttpServlet {

    private final String ALBUMS_SESSION_NAME = "albums";
    private final String ALBUM_PAGE_PATH = "/album.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute(ALBUMS_SESSION_NAME) == null) {
            req.getSession().setAttribute(ALBUMS_SESSION_NAME, new ArrayList<Album>());
        }

        getServletContext().getRequestDispatcher(ALBUM_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String artist = req.getParameter("artist");
        String genre = req.getParameter("genre");
        int year = 0;

        try {
            year = Integer.parseInt(req.getParameter("year"));
        } catch (NumberFormatException e){
            System.out.println("Year was invalid");
        }

        Album album = new Album(title, artist, genre, year);

        if (album.isValid()) {
            List<Album> albums = (List) req.getSession().getAttribute(ALBUMS_SESSION_NAME);
            albums.add(album);
        }

        req.setAttribute("invalid", !album.isValid());

        getServletContext().getRequestDispatcher(ALBUM_PAGE_PATH).forward(req, resp);
    }
}