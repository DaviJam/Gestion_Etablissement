package eu.ensup.gestionetablissement.presentation;

import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.dto.StudentDTO;
import eu.ensup.gestionetablissement.service.ExceptionService;
import eu.ensup.gestionetablissement.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Student controller.
 */
@WebServlet(
        name = "StudentController",
        urlPatterns = {
            "/students_menu",
            "/students_add",
            "/students_list",
            "/students_update",
            "/students_change",
            "/students_remove",
        }
)
public class StudentController extends HttpServlet {

    private String errorFlag = "error";

    /**
     * Instantiates a new Student controller.
     */
    public StudentController() {
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

        switch(req.getRequestURI())
        {
            case "/etablissement/students_menu": {
                requestDispatcher = req.getRequestDispatcher("/student_menu.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
            case "/etablissement/students_update": {
                PersonService sc = new PersonService();

                List<PersonDTO> personList;
                try {
                    personList = sc.getAll();

                    List<StudentDTO> students = new ArrayList<>();
                    for (PersonDTO person : personList) {
                        if (person.getRole() == Role.STUDENT) {
                            students.add((StudentDTO) person);
                        }
                    }

                    req.setAttribute("students", students);
                } catch (ExceptionService exceptionService) {
                    req.setAttribute(errorFlag, exceptionService.getMessage());
                    requestDispatcher = req.getRequestDispatcher("update_student.jsp");
                    requestDispatcher.forward(req, resp);
                    return;
                }

                /**
                 * Set the content type
                 */
                requestDispatcher = req.getRequestDispatcher("update_student.jsp");

                requestDispatcher.forward(req, resp);
               return;
            }
            case "/etablissement/students_add": {
                requestDispatcher = req.getRequestDispatcher("/add_student.jsp");
                requestDispatcher.forward(req, resp);
                break;
            }
            case "/etablissement/students_change": {
                System.out.println("##################");
                break;
            }
        }
    }


    /**
     * Check user boolean.
     *
     * @param req  the req
     * @param resp the resp
     * @return the boolean true if has session flase otherwise
     * @throws IOException the io exception
     */
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
