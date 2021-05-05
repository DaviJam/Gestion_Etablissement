package eu.ensup.gestionetablissement.presentation;

import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.dto.StudentDTO;
import eu.ensup.gestionetablissement.service.ExceptionService;
import eu.ensup.gestionetablissement.service.PersonService;
import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(
        name = "UpdateStudentServlet",
        urlPatterns = "/bloom"
)
public class UpdateStudentController extends HttpServlet {

    private String errorFlag = "error";

    public UpdateStudentController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//
//        System.out.println("student WORKING");
//        RequestDispatcher requestDispatcher;
//        PersonService sc = new PersonService();
//
//        List<PersonDTO> personList = null;
//        try {
//            personList = sc.getAll();
//            List<StudentDTO> students= new ArrayList<>();
//            for(PersonDTO person : personList)
//            {
//                if(person.getRole() == Role.STUDENT)
//                {
//                    students.add((StudentDTO)person);
//                }
//            }
//            req.setAttribute("students", students);
//        } catch (ExceptionService exceptionService) {
//            req.setAttribute(errorFlag, exceptionService.getMessage());
//            requestDispatcher = req.getRequestDispatcher("update_student.jsp");
//            requestDispatcher.forward(req, resp);
//            return;
//        }
//
//        /**
//         * Set the content type
//         */
//        requestDispatcher = req.getRequestDispatcher("update_student.jsp");
//
//        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]};:,<.>/?";
//        String password = RandomStringUtils.random( 15, characters );
//        RequestDispatcher requestDispatcher;
//
//        String	lastname = req.getParameter("Surname");
//        String	mailAddress = req.getParameter("Email");
//        String[] names = {  req.getParameter("num"),
//                            req.getParameter("road"),
//                            req.getParameter("postal"),
//                            req.getParameter("town"),
//                            req.getParameter("dept")};
//        String address = String.join(" ", names);
//        System.out.println(address);
//        String	phoneNumber = req.getParameter("tel");
//        String	firstname = req.getParameter("Name");
//
//        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateOfBirth = new Date();
//        try {
//            dateOfBirth = dtFormat.parse(req.getParameter("BDate"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        PersonDTO dto = new StudentDTO(lastname, mailAddress, address, phoneNumber, firstname, password, dateOfBirth );
//        PersonService sc = new PersonService();
//
//        try {
//            sc.create(dto);
//        } catch (ExceptionService exceptionService) {
//            req.setAttribute(errorFlag, exceptionService.getMessage());
//            requestDispatcher = req.getRequestDispatcher("add_student.jsp");
//            requestDispatcher.forward(req, resp);
//            return;
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/students");
    }



}
