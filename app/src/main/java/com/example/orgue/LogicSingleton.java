package com.example.orgue;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Dictionary;

public class LogicSingleton
{
    private static String playerName;
    private static int currentQuestion;
    private static Dictionary<Integer,QuestionInformation> questionDatabase;


    public static void Initialize()
    {
        playerName = "";
        currentQuestion = 0;
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



    public static Intent NextQuestion(Context currentContext)
    {
        currentQuestion++;
        if(WhatActivityShouldBeLoaded(currentContext,currentQuestion)!=null) return WhatActivityShouldBeLoaded(currentContext,currentQuestion);
        throw new NullPointerException();
    }

    public static Intent WhatActivityShouldBeLoaded(Context currentContext, int num)
    {
        switch(num)
        {
            case 1: return new Intent(currentContext, PantallaBotonsImatge.class);
            case 2: return new Intent(currentContext, PantallaBotonsImatge.class);
            default: return null;
        }
    }

    private static void PushInformationToDatabase()
    {
        questionDatabase.put(1,new QuestionInformation(PantallaBotonsImatge.class,"",new String[]{"",""},new String[]{"",""},new String[]{"",""},false));
        
    }
}
