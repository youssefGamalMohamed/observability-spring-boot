package com.yousse.gamal.observability_demo.filters;

import org.springframework.stereotype.Component;

import io.micrometer.tracing.Tracer;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Component
@RequiredArgsConstructor
// @Order(Integer.MIN_VALUE)
@Slf4j
public class TraceIdInjectorFilter implements Filter {

    private static final String TRACE_ID_HEADER = "X-Trace-ID";
    private final Tracer tracer;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletResponse response = (HttpServletResponse) resp;

        // Get the current span's trace ID
        String traceId = tracer.currentTraceContext().context().traceId();
        
        // Add the trace ID to the response header
        response.setHeader(TRACE_ID_HEADER, traceId);

        log.info("Injecting trace id into response headers");
        log.info("Trace ID: {}", traceId);
    
        // Continue the request chain (proceed with request)
        chain.doFilter(req, resp);
    }

}
