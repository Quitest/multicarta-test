package ru.pel.tests.multicartatest.filter;

import org.xml.sax.SAXException;
import ru.pel.tests.multicartatest.validator.XmlValidatorAgainstXsd;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public class PaymentFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        XmlValidatorAgainstXsd validator = new XmlValidatorAgainstXsd();
        if ("POST".equals(request.getMethod())) {
            try {
                validator.validate(request.getReader(), new File("payment.xsd"));
            } catch (SAXException | XMLStreamException e) {
                throw new IOException(e.getMessage(), e);
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
