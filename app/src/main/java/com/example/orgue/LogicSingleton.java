package com.example.orgue;

import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LogicSingleton
{
    private static String playerName;
    private static int currentQuestion;
    private static Map<Integer,QuestionInformation> questionDatabase;

    public static void Initialize()
    {
        playerName = "";
        currentQuestion = 0;
        questionDatabase = new HashMap<>();
        PushInformationToDatabase();
    }

    public static void SetNewPlayerName(String newPlayerName)
    {
        playerName = newPlayerName;
    }

    public static String getPlayerName()
    {
        return playerName;
    }

    public static int GetCurrentQuestion()
    {
        return currentQuestion;
    }

    public static QuestionInformation getCurrentQuestionInformation()
    {
        return questionDatabase.get(currentQuestion);
    }

    public static Intent NextQuestion(Context currentContext)
    {
        currentQuestion++;
        if(WhatActivityShouldBeLoaded(currentContext,currentQuestion)!=null) return WhatActivityShouldBeLoaded(currentContext,currentQuestion);
        throw new NullPointerException();
    }

    private static Intent WhatActivityShouldBeLoaded(Context currentContext, int num)
    {
        if(questionDatabase.containsKey(num)) return new Intent(currentContext, Objects.requireNonNull(questionDatabase.get(num)).questionClass);
        else return null;
    }

    private static void PushInformationToDatabase()
    {
//        questionDatabase.put
//        (
//            0,
//            new QuestionInformation
//            (
//                MainActivity.class,
//                "",
//                new String[]{""},
//                new String[]{""},
//                new String[]{""},
//                true
//            )
//        );
        questionDatabase.put
        (
            1,
            new QuestionInformation
            (
                PantallaBotonsImatge.class,
                "Busqueu aquest carrer i situeu-lo al plànol.",
                new String[]{"@drawable/imatge_lleons_escut_fassana","imatge_lleons_escut_fassana"},
                new String[]{"Busqueu aquest carrer i situeu-lo al plànol."},
                new String[]{"10"},
                false
            )
        );
        questionDatabase.put
        (
            2,
            new QuestionInformation
            (
                ActivityRadioButtons.class,
                "Quants escuts de la ciutat has pogut comptabilitzar al llarg de la visita?",
                new String[]{"escut"},
                new String[]{"entre 10 i 20","entre 21 i 40","més de 40"},
                new String[]{"2"},
                false
            )
        );
    }

    public int calculateCurrentQuestion(String input)
    {
        switch(input)
        {
            case "1.2": return 1;
            case "1.4": return 1;
            case "2.2": return 2;
            case "3.2": return 3;
            case "3.3": return Integer.parseInt(null);
            case "3.6": return 4;
            case "4.1": return Integer.parseInt(null);
            case "4.4": return 5;
            case "5.2": return 6;
            case "5.4": return 7;
            case "6.2": return 8;
            case "6.5": return 9;
            case "7.2": return Integer.parseInt(null);
            case "7.4": return 10;
            case "8": return 11;
            case "0": return 0;
            default: return 0;
        }
    }
}
