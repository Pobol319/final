package com.epam.project.command.get;


import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.entity.*;
import com.epam.project.entity.dto.StatementDto;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowStatementCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String PAGE = "/view/page/usual/look_and_delete_statement.jsp";

    private StatementDtoService statementDtoService;

    public ShowStatementCommand(StatementDtoService statementDtoService) {
        this.statementDtoService = statementDtoService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("ShowStatementCommand - done ");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        StatementDto statementDto = statementDtoService.getStatementDtoInfo(userId);

        if (statementDto.getStatement() != null) {
            request.setAttribute("isUserHaveStatement", true);
        } else {
            request.setAttribute("isUserHaveStatement", false);
            return CommandResult.forward(PAGE);
        }

        request.setAttribute("statementDto", statementDto);
        request.setAttribute("subjects", statementDto.getSubjects());
        request.setAttribute("points", statementDto.getPointsOnSubjects());

        return CommandResult.forward(PAGE);
    }

}
