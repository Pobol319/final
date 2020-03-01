package com.epam.project.command.get;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.entity.Faculty;
import com.epam.project.entity.PointsOnSubject;
import com.epam.project.entity.Statement;
import com.epam.project.entity.User;
import com.epam.project.entity.dto.FacultyDto;
import com.epam.project.entity.dto.StatementDto;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class GetStatementsAccordingToRegistrationToFacultyCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String PAGE = "/view/page/usual/register_or_deregister_statements.jsp";

   private StatementDtoService statementDtoService;

    public GetStatementsAccordingToRegistrationToFacultyCommand(StatementDtoService statementDtoService) {
        this.statementDtoService = statementDtoService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("GetStatementsAccordingToRegistrationToFacultyCommand - done ");

        String typeOfCommand = request.getParameter("registerOrDeregisterCommand");
        boolean isRegisteredToFaculty = !typeOfCommand.equals("register");
        List<StatementDto> statementDtoList = statementDtoService.getStatementDtoAccordingToRegistration(isRegisteredToFaculty);

        request.setAttribute("isRegisteredToFaculty", isRegisteredToFaculty);
        request.setAttribute("statementDtoList", statementDtoList);
        return CommandResult.forward(PAGE);
    }
}
