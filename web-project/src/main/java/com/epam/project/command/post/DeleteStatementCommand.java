package com.epam.project.command.post;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.transaction.DeleteStatementTransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteStatementCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String PAGE = "/view/page/usual/look_and_delete_statement.jsp";

    private DeleteStatementTransactionService statementTransactionService;

    public DeleteStatementCommand(DeleteStatementTransactionService statementTransactionService) {
        this.statementTransactionService = statementTransactionService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("DeleteStatementCommand - done ");

        String statementIdString = request.getParameter("statementId");
        Integer statementIdInteger = Integer.parseInt(statementIdString);
        statementTransactionService.deleteStatementAndPointsOnSubjects(statementIdInteger);

        return CommandResult.redirect(PAGE);
    }

}
