package com.epam.project.command;

import com.epam.project.command.general.AuthorizeCommand;
import com.epam.project.command.general.ChooseLanguageCommand;
import com.epam.project.command.general.LogoutCommand;
import com.epam.project.command.get.*;
import com.epam.project.command.post.ConfirmActOnStatementsRegistrationPageCommand;
import com.epam.project.command.post.CreateStatementCommand;
import com.epam.project.command.post.DeleteStatementCommand;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.service.*;
import com.epam.project.service.transaction.CreateStatementTransactionService;
import com.epam.project.service.transaction.DeleteStatementTransactionService;

public class CommandFactory {

    public static Command create(String command) {
        switch (command) {
            case "authorize":
                return new AuthorizeCommand(new UserService(new DaoHelperFactory()));
            case "register_to_faculty":
                return new GetAllFacultiesCommand(new FacultyService(new DaoHelperFactory()));
            case "get_required_subjects":
                return new GetRequiredSubjectsCommand(
                        new FacultyDtoService(
                                new FacultyService(new DaoHelperFactory()),
                                new RequiredSubjectService(new DaoHelperFactory()),
                                new SubjectService(new DaoHelperFactory())));
            case "create_statement":
                return new CreateStatementCommand(
                        new StatementService(new DaoHelperFactory()),
                        new FacultyDtoService(
                                new FacultyService(new DaoHelperFactory()),
                                new RequiredSubjectService(new DaoHelperFactory()),
                                new SubjectService(new DaoHelperFactory())),
                        new CreateStatementTransactionService(new DaoHelperFactory()));
            case "look_statement":
                return new ShowStatementCommand(
                        new StatementDtoService(
                                new UserService(new DaoHelperFactory()),
                                new StatementService(new DaoHelperFactory()),
                                new FacultyService(new DaoHelperFactory()),
                                new PointsOnSubjectService(new DaoHelperFactory()),
                                new SubjectService(new DaoHelperFactory())));
            case "delete_statement":
                return new DeleteStatementCommand(new DeleteStatementTransactionService(new DaoHelperFactory()));
            case "register_or_deregister_statements":
                return new GetStatementsAccordingToRegistrationToFacultyCommand(
                        new StatementDtoService(
                                new UserService(new DaoHelperFactory()),
                                new StatementService(new DaoHelperFactory()),
                                new FacultyService(new DaoHelperFactory()),
                                new PointsOnSubjectService(new DaoHelperFactory()),
                                new SubjectService(new DaoHelperFactory())));
            case "register_page_confirm_act":
                return new ConfirmActOnStatementsRegistrationPageCommand(new StatementService(new DaoHelperFactory()));
            case "enroll_applicants":
                return new ShowListEnrolledApplicants(
                        new StatementDtoService(
                                new UserService(new DaoHelperFactory()),
                                new StatementService(new DaoHelperFactory()),
                                new FacultyService(new DaoHelperFactory()),
                                new PointsOnSubjectService(new DaoHelperFactory()),
                                new SubjectService(new DaoHelperFactory())),
                        new FacultyService(new DaoHelperFactory()));
            case "choose_language":
                return new ChooseLanguageCommand();
            case "logout":
                return new LogoutCommand();
            default:
                throw new IllegalArgumentException("unknown command");
        }
    }

}
