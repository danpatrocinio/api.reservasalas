package com.banana.reservasalas.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.TimeZone;

@WebFilter(filterName = "TimeZoneFilter", urlPatterns = { "/reservasalas/*" })
public class TimeZoneFilter implements Filter {

    /**
     // Filtro para configurar o TimeZone da api.
     // Todas as requisicoes que passarem por "/reservasalas" vao passar por doFilter()
     */

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // configura o timezone na JVM do Java para todas as URLs a partir de /reservasalas
        TimeZone.setDefault(TimeZone.getTimeZone("UTC-3"));

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) {
    }

}