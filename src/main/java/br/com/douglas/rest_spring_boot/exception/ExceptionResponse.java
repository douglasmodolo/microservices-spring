package br.com.douglas.rest_spring_boot.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) { }
