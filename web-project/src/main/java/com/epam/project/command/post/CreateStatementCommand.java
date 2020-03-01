package com.epam.project.command.post;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.entity.*;
import com.epam.project.entity.dto.FacultyDto;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class CreateStatementCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String PAGE = "/view/page/usual/apply_to_faculty.jsp";
    private static final String PAGE_WHEN_USER_HAVE_STATEMENT = "/command?command=apply_to_faculty";

    private StatementService statementService;
    private FacultyDtoService facultyDtoService;

    public CreateStatementCommand(StatementService statementService, FacultyDtoService facultyDtoService) {
        this.statementService = statementService;
        this.facultyDtoService = facultyDtoService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("CreateStatementCommand - done ");

        HttpSession session = request.getSession();
        String[] pointsStringArray = request.getParameterValues("points");
        List<Integer> pointsIntegerList = convertArrayFromStringToInt(pointsStringArray);
        String facultyIdString = request.getParameter("selectedFacultyId");
        Integer facultyIdInt = Integer.parseInt(facultyIdString);

        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        if (statementService.doesUserHaveStatement(userId)) {
            request.setAttribute("userHaveStatement", true);
            return CommandResult.forward(PAGE_WHEN_USER_HAVE_STATEMENT);
        }

        FacultyDto facultyDto = facultyDtoService.getFacultyDtoInfo(facultyIdInt);
        statementService.createStatementAndPointsOnSubjects(user,facultyDto,pointsIntegerList);

        return CommandResult.redirect(PAGE);
    }

    private List<Integer> convertArrayFromStringToInt(String[] stringArray) {
        List<Integer> integerList = new ArrayList<>();
        for (String stringNumber : stringArray) {
            Integer integer = Integer.parseInt(stringNumber);
            integerList.add(integer);
        }
        return integerList;
    }


}
