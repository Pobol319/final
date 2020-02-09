package com.epam.project.command.post;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.entity.*;
import com.epam.project.entity.dto.FacultyDto;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.*;
import com.epam.project.service.transaction.CreateStatementTransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreateStatementCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String PAGE = "/command?command=register_to_faculty";

    private StatementService statementService;
    private FacultyDtoService facultyDtoService;
    private CreateStatementTransactionService statementTransactionService;

    public CreateStatementCommand(StatementService statementService, FacultyDtoService facultyDtoService,
                                  CreateStatementTransactionService statementTransactionService) {
        this.statementService = statementService;
        this.facultyDtoService = facultyDtoService;
        this.statementTransactionService = statementTransactionService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("CreateStatementCommand - done ");

        HttpSession session = request.getSession();
        String[] pointsString = request.getParameterValues("points");
        String facultyIdString = request.getParameter("selectedFacultyId");
        Integer facultyIdInt = Integer.parseInt(facultyIdString);

        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        if (statementService.doesUserHaveStatement(userId)) {
            request.setAttribute("answerForCreateStatement", "0");
            return CommandResult.forward(PAGE);
        }

        FacultyDto facultyDto = facultyDtoService.getFacultyDtoInfo(facultyIdInt);
        statementTransactionService.createStatementAndPointsOnSubjects(user,facultyDto,pointsString);

        request.setAttribute("answerForCreateStatement", "1");
        return CommandResult.redirect(PAGE);
    }


}
