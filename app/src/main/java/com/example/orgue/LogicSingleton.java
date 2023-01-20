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
        questionDatabase.put
        (
            0,
            new QuestionInformation
            (
                MainActivity.class,
                "",
                new String[]{""},
                new String[]{""},
                new String[]{""},
                true
            )
        );
        questionDatabase.put
        (
            1,
            new QuestionInformation
            (
                PantallaBotonsImatge.class,
                "",
                new String[]{""},
                new String[]{""},
                new String[]{""},
                false
            )
        );
        questionDatabase.put
        (
            2,
            new QuestionInformation
            (
                PantallaBotonsImatge.class,
                "",
                new String[]{""},
                new String[]{""},
                new String[]{""},
                false
            )
        );
    }
}
