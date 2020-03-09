package com.epam.project.command.general;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.project.entity.User;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;


public class AuthorizeCommand implements Command {
    private static final String PAGE = "/view/page/usual/menu.jsp";
    private static final String AUTHORIZE_ERROR_PAGE = "/view/page/error/error_authorization.jsp";
    private UserService service;

    public AuthorizeCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = service.login(login, password);
        if (user.isPresent()) {
            session.setAttribute("user", user.get());
        } else {
            request.setAttribute("errorMessage", "Wrong login or password");
            return CommandResult.forward(AUTHORIZE_ERROR_PAGE);
        }
        return CommandResult.redirect(PAGE);
    }
}
