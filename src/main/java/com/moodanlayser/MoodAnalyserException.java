package com.moodanlayser;

public class MoodAnalyserException extends Exception {

    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,No_ACCESS,METHOD_INVOCATION_ISSUE,
    }

    ExceptionType type;
    public MoodAnalyserException( ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
