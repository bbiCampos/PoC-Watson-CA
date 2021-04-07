package br.com.ilink.poc.service;

import com.ibm.watson.assistant.v1.model.Context;

public class ControlContext {


    public static Boolean firstCall = Boolean.TRUE;
    public static Context botContext;

    public static Context getNLUContext() {
        if (firstCall) {
            firstCall = Boolean.FALSE;
            return new Context();
        } else {
            return botContext;
        }
    }

}

