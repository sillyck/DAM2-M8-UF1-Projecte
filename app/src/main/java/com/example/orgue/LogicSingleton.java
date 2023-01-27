package com.example.orgue;

import android.content.Context;
import android.content.Intent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LogicSingleton
{
    private static String playerName;
    private static int currentQuestion;
    public static int currentScore;
    public static int totalScore;
    private static long timeStart;
    private static long timeFinish;

    public static int durationSeconds;
    public static int durationMinutes;

    private static Map<Integer,QuestionInformation> questionDatabase;

    public static void Initialize()
    {
        timeStart = System.currentTimeMillis();
        playerName = "";
        currentQuestion = 0;
        questionDatabase = new HashMap<>();
        PushInformationToDatabase();
    }

    public static void StopTimer()
    {
        timeFinish = System.currentTimeMillis();
        durationSeconds = (int)((timeFinish-timeStart)/1000);
        durationMinutes = (int)((float)durationSeconds/60);
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

    public static void PushMoreScores(int current, int total)
    {
        currentScore += current;
        totalScore += total;
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
                new String[]{"imatge_lleons_escut_fassana"},
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
                new String[]{"Entre 10 i 20","Entre 21 i 40","Més de 40"},
                new String[]{"2"},
                false
            )
        );
        questionDatabase.put
        (
            3,
            new QuestionInformation
            (
                PantallaBotonsImatge.class,
                "Segons la imatge, on creieu que estava situat l’orgue anterior? \n\nSitueu-lo al plànol",
                new String[]{"orgue_antic_04"},
                new String[]{"Segons la imatge, on creieu que estava situat l’orgue anterior? Situeu-lo al plànol"},
                new String[]{"9"},
                false
            )
        );
        questionDatabase.put
        (
            4,
            new QuestionInformation
            (
                PantallaBotonsImatge.class,
                "Observeu bé la imatge i responeu.",
                new String[]{"granorgue"},
                new String[]{"Observeu bé la imatge i responeu."},
                new String[]{"6"},
                false
            )
        );
        questionDatabase.put
        (
            5,
            new QuestionInformation
            (
                ActivityRadioButtons.class,
                "Quina és la relació entre el disseny de la façana del nou orgue i la ciutat de Valls?",
                new String[]{"simulacio_nou_orgue"},
                new String[]{"Els calçots i els castells","Els castells i el campanar","El campanar i els gegants"},
                new String[]{"1"},
                false
            )
        );
        questionDatabase.put
        (
            6,
            new QuestionInformation
            (
                PantallaRelacionar.class,
                "Llegeiu i relacioneu cada tipus d'orgue amb la definició que creieu que li correspon.",
                new String[]{"simulacio_nou_orgue"},
                new String[]{"els calçots i els castells","els castells i el campanar","el campanar i els gegants"},
                new String[]{"1"},
                true
            )
        );
        questionDatabase.put
        (
            7,
            new QuestionInformation
            (
                ActivityCheckboxes.class,
                "Llegeiu i relacioneu cada tipus d'orgue amb la definició que creieu que li correspon.",
                new String[]{"simulacio_nou_orgue"},
                new String[]{"els calçots i els castells","els castells i el campanar","el campanar i els gegants"},
                new String[]{"1"},
                true
            )
        );
        questionDatabase.put
        (
            8,
            new QuestionInformation
            (
                Escuts.class,
                "Llegeiu i relacioneu cada tipus d'orgue amb la definició que creieu que li correspon.",
                new String[]{"simulacio_nou_orgue"},
                new String[]{"els calçots i els castells","els castells i el campanar","el campanar i els gegants"},
                new String[]{"1"},
                true
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
