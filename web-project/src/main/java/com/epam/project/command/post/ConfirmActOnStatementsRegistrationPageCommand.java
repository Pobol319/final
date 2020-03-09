package com.epam.project.command.post;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.StatementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ConfirmActOnStatementsRegistrationPageCommand implements Command {
    private static final String PAGE_REGISTRATION = "/command?command=register_or_deregister_statements&registerOrDeregisterCommand=register";
    private static final String PAGE_DEREGISTRATION = "/command?command=register_or_deregister_statements&registerOrDeregisterCommand=deregister";

    private StatementService statementService;

    public ConfirmActOnStatementsRegistrationPageCommand(StatementService statementService) {
        this.statementService = statementService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String registerOrDeregisterCommandString = request.getParameter("registerOrUnregisterCommand");
        boolean registerOrDeregisterCommandStringBoolean = !Boolean.parseBoolean(registerOrDeregisterCommandString);

        String[] statementsIdStringArray;
        List<Integer> statementsIdIntegerList;

        if (request.getParameter("statementId") == null) {
            if (registerOrDeregisterCommandStringBoolean) {
                return CommandResult.redirect(PAGE_REGISTRATION);
            } else {
                return CommandResult.redirect(PAGE_DEREGISTRATION);
            }
        } else {
            statementsIdStringArray = request.getParameterValues("statementId");
            statementsIdIntegerList = convertStringArrayToIntegerList(statementsIdStringArray);
        }

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
