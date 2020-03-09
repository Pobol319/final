package com.epam.project.command.get;

import com.epam.project.command.Command;
import com.epam.project.command.CommandResult;
import com.epam.project.entity.RequiredSubject;
import com.epam.project.entity.Subject;
import com.epam.project.entity.dto.FacultyDto;
import com.epam.project.exceptions.ServiceException;
import com.epam.project.service.FacultyDtoService;
import com.epam.project.service.RequiredSubjectService;
import com.epam.project.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetRequiredSubjectsCommand implements Command {
    private static final String PAGE = "/command?command=apply_to_faculty";

    private FacultyDtoService facultyDtoService;

    public GetRequiredSubjectsCommand(FacultyDtoService facultyDtoService) {
        this.facultyDtoService = facultyDtoService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String facultyIdString = request.getParameter("facultyId");
        Integer facultyIdInt = Integer.parseInt(facultyIdString);

        FacultyDto facultyDto = facultyDtoService.getFacultyDtoInfo(facultyIdInt);

        request.setAttribute("requiredSubjects", facultyDto.getSubjects());
        request.setAttribute("selectedFacultyId", facultyIdInt);
        return CommandResult.forward(PAGE);
    }
}
