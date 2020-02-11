package com.epam.project.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

public class CongratulationsTag extends TagSupport {
    private static final Logger LOG = LogManager.getRootLogger();

    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpSession session = request.getSession();
        Enumeration<String> locale = session.getAttributeNames();
        String message = "Поздравляем с зачислением в университет!!!!!";
        while (locale.hasMoreElements()) {
            if (locale.nextElement().equals("locale")) {
                String localeEnum = (String) session.getAttribute("locale");
                if (localeEnum.equals("en_US")) {
                    message = "Congratulations on admission to the university!!!!";
                } else if (localeEnum.equals("be_BY")) {
                    message = "Віншуем з залічэннем ва ўніверсітэт!!!!";
                } else {
                    message = "Поздравляем с зачислением в университет!!!!";
                }
            }
        }
        JspWriter out = pageContext.getOut();
        try {
            out.write(message);
        } catch (IOException e) {
            LOG.error("Some problems with custom tag");
        }
        return SKIP_BODY;
    }
}
