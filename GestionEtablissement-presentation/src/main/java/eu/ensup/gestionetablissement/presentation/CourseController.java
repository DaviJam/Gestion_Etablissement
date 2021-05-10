package eu.ensup.gestionetablissement.presentation;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
    name = "CourseController",
    urlPatterns = {
        "/course_handler"
    }
)
public class CourseController extends HttpServlet {
    private String successFlag = "success";
    private String errorFlag = "error";
    /**
     * Instantiates a new Student controller.
     */
    public CourseController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleMethods(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleMethods(req, resp);
    }

    private void handleMethods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!checkUser(req,resp)) {
            return;
        }
        RequestDispatcher requestDispatcher;

        switch(req.getRequestURI()) {
            case "/etablissement/course_handler":  {
                if(req.getMethod().equals("GET"))
                {
                    requestDispatcher = req.getRequestDispatcher("course.jsp");
                    requestDispatcher.forward(req, resp);
                }
                else if(req.getMethod().equals("POST"))
                {

                }
            }
        }
    }

    boolean checkUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean res = true;
        HttpSession checkUserSession = req.getSession(false);
        if (checkUserSession != null && checkUserSession.getAttribute("user-id") == null) {
            System.out.println(req.getMethod() + " Redirected to home no user logged in");
            resp.sendRedirect("/etablissement/accueil");
            res = false;
        }
        return res;
    }
}
