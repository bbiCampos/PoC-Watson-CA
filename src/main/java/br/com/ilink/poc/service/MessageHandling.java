package br.com.ilink.poc.service;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageHandling {

    //Prepara a Mensagem que será enviada para o bot. Removendo espaços, tabulação e nova linha, trouxe da aurora/trix.

    public static String parseMessage(String texto) {
        ArrayList<String> tempText = new ArrayList<String>(Arrays.asList(new String[]{texto}));

        String vMessageData = String.join(",", tempText);

        if (vMessageData == null) {
            return "";
        }
        if (vMessageData.length() > 2048) {
            throw new RuntimeException("As mensagens não podem ter mais que 2048 caracteres");
        }
        return vMessageData.replaceAll("\\n|\\r|\\t|  ", " ");
    }

}