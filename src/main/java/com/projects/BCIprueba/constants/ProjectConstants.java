package com.projects.BCIprueba.constants;

import java.util.regex.Pattern;

public class ProjectConstants {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEXP =
            Pattern.compile("^[A-Za-z0-9\\._-]*@[A-Za-z0-9\\.]*\\.[A-Za-z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern  VALID_PASSWORD_REGEXP =
            Pattern.compile("^(?=.*[A-Z]{1})(?=.*[a-z]{1,})(?=.*[0-9]{2})$");

    public static final String VALID_NUMERIC = "\\d+";
}
