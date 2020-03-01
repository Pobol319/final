package com.epam.project.command.get;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.entity.Faculty;
import com.epam.project.entity.dto.StatementDto;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.FacultyService;
import com.epam.project.service.StatementDtoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ShowListEnrolledApplicants implements Command {
    private static final String PAGE = "/view/page/usual/enroll_applicants.jsp";

    private StatementDtoService statementDtoService;
    private FacultyService facultyService;

    public ShowListEnrolledApplicants(StatementDtoService statementDtoService, FacultyService facultyService) {
        this.statementDtoService = statementDtoService;
        this.facultyService = facultyService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        List<StatementDto> statementDtoList = statementDtoService.getStatementDtoAccordingToRegistration(true);
        List<Faculty> faculties = facultyService.getAllFaculties();
        Map<Faculty, List<StatementDto>> enrolledApplicants = statementDtoService.getEnrolledStatementDtoListAccordingToFaculty(faculties,
                statementDtoList);

        request.setAttribute("mapFaculty", enrolledApplicants);

        return CommandResult.forward(PAGE);
    }


}
