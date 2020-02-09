package com.epam.project.____;

import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;


import java.util.*;

public class Main {

    public static void main(String[] args) throws ConnectionFactoryException, DaoException, ConnectionPoolException {
       /* Connection connection = ConnectionFactory.create();

        PreparedStatement prState = connection.prepareStatement("SELECT * FROM USERS WHERE user_id = 1 ");
        ResultSet resultset = prState.executeQuery();

        while (resultset.next()){
            System.out.println(resultset.getString("name"));
        }

        System.out.println(resultset.toString());


        ConnectionPool pool = ConnectionPool.getInstance();
       SubjectDaoImpl subjectDao = new SubjectDaoImpl(pool.getConnection());
        List<Subject> subjects = subjectDao.getAll();
        System.out.println(subjects.size());
        for (Subject subject : subjects) {
            System.out.println(subject.toString());
        }

        UserDaoImpl userDao = new UserDaoImpl(pool.getConnection());
        Optional<User> user = userDao.findUserByLoginAndPassword("ppobol", "qwe123");

        FacultyDaoImpl facultyDao = new FacultyDaoImpl(pool.getConnection());
        List<Faculty> faculties = facultyDao.getAll();

        RequiredSubjectDaoImpl requiredSubjectDao = new RequiredSubjectDaoImpl(pool.getConnection());
        *//*List<RequiredSubject> requiredSubjects = requiredSubjectDao.findSubjectIdByFacultyId("3");*//*

        SubjectDaoImpl subjectDao = new SubjectDaoImpl(pool.getConnection());

       for (RequiredSubject requiredSubject1 : requiredSubjects){
            System.out.println(requiredSubject1.toString());
        }

        List<Subject> subjects = new ArrayList<>();
        for (RequiredSubject requiredSubject: requiredSubjects){
            Integer id =  requiredSubject.getSubjectId();
            Optional<Subject> optionalSubject = subjectDao.getById(id);
            optionalSubject.ifPresent(subjects::add);
        }

        for(Subject subject : subjects){
            System.out.println(subject.toString());
        }



        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(date);
*/

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int a = random.nextInt(1000);
            System.out.print(a + " ");
            list.add(a);
        }
        System.out.println();




    }


}
