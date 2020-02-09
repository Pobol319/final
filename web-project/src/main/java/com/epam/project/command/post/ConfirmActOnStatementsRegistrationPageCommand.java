package com.epam.project.command.post;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.StatementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ConfirmActOnStatementsRegistrationPageCommand implements Command {
    private static final Logger LOG = LogManager.getRootLogger();
    private static final String PAGE = "/view/page/admin/register_or_deregister_statements.jsp";
    private static final String PAGE_REGISTRATION = "/command?command=register_or_deregister_statements&registerOrDeregisterCommand=register";
    private static final String PAGE_DEREGISTRATION = "/command?command=register_or_deregister_statements&registerOrDeregisterCommand=deregister";

    private StatementService statementService;

    public ConfirmActOnStatementsRegistrationPageCommand(StatementService statementService) {
        this.statementService = statementService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        LOG.info("ConfirmActOnStatementsRegistrationPageCommand - done ");

        String[] statementsIdStringArray;
        List<Integer> statementsIdIntegerList;
        try {
            statementsIdStringArray = request.getParameterValues("statementId");
            statementsIdIntegerList = convertStringArrayToIntegerList(statementsIdStringArray);
        } catch (NullPointerException e) {
            return CommandResult.forward(PAGE);
        }

        String registerOrDeregisterCommandString = request.getParameter("registerOrUnregisterCommand");
        boolean registerOrDeregisterCommandStringBoolean = !Boolean.parseBoolean(registerOrDeregisterCommandString);

        for (Integer statementId : statementsIdIntegerList) {
            statementService.updateStatementRegistrationByStatementId(statementId, registerOrDeregisterCommandStringBoolean);
        }

        if (registerOrDeregisterCommandStringBoolean) {
            return CommandResult.redirect(PAGE_REGISTRATION);
        } else {
            return CommandResult.redirect(PAGE_DEREGISTRATION);
        }
    }

    private List<Integer> convertStringArrayToIntegerList(String[] strings) {
        List<Integer> integerList = new ArrayList<>();
        for (String string : strings) {
            Integer integer = Integer.parseInt(string);
            integerList.add(integer);
        }
        return integerList;
    }

}
