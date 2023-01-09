package com.nfteam.server.auth.utils;

import com.google.gson.Gson;
import com.nfteam.server.dto.response.error.ErrorResponse;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class ErrorResponder {

    public static void sendErrorResponse(HttpServletResponse response, HttpStatus status) throws IOException {
        Gson gson = new Gson();
        ErrorResponse errorResponse = new ErrorResponse(String.valueOf(status.value()), status.getReasonPhrase());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status.value());
        response.getWriter().write(gson.toJson(errorResponse, ErrorResponse.class));
    }
}
