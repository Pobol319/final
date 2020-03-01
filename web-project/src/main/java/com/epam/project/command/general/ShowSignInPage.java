package com.epam.project.command.general;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSignInPage implements Command {
    private static final String PAGE = "/view/page/general/authorization.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.redirect(PAGE);
    }
}
