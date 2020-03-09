package com.epam.project.command.general;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.entity.UserRoleEnum;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountCreationCommand implements Command {
    private static final String PAGE = "/view/page/general/registration.jsp";
    private UserService userService;

    public AccountCreationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter("login");
        if (!userService.isLoginUnique(login)) {
            request.setAttribute("answerForRegistration", false);
            return CommandResult.forward(PAGE);
        }

        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String password = request.getParameter("password");
        userService.save(firstName, secondName, login, password, UserRoleEnum.USER);

        request.setAttribute("answerForRegistration", true);
        return CommandResult.redirect(PAGE);
    }
}
