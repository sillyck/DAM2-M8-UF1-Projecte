package com.example.orgue;

import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe estatica que guardará el nom del jugador, les puntuacions, les preguntes i tindrá
 * els metodes per canviar de preguntes.
 */
public class LogicSingleton
{
    /**
     * El nom del jugador.
     */
    private static String playerName;

    /**
     * El numero que representa la pregunta actual
     */
    private static int currentQuestion;

    /**
     * Els encerts del jugador.
     */
    public static int currentScore;

    /**
     * El numero de respostes que el jugador ha respós tan com bé o malament.
     */
    public static int totalScore;

    /**
     * System.currentTimeMillis() que s'executa en inicialitzar el singleton.
     */
    private static long timeStart;

    /**
     * System.currentTimeMills() que s'executa en el metode de "pausar el timer".
     */
    private static long timeFinish;

    /**
     * Duració dels temps que ha tardat en el jugar en arribar fins aqui, en segons
     */
    public static int durationSeconds;

    /**
     * Duració dels temps que ha tardat en el jugar en arribar fins aqui, en minuts
     */
    public static int durationMinutes;

    /**
     * La base de dades de les preguntes; aqui dins s'enmagatzema la informació que s'ugtilitzar per
     * canviar de pantalla i per complir camps d'algunes preguntes.
     */
    private static Map<Integer,QuestionInformation> questionDatabase;

    /**
     * "Inicialitza" el singleton. Funciona com un constructor, per tal de posar totes les variables
     * a zero i/o a punt per el seu primer ús.
     */
    public static void Initialize()
    {
        timeStart = System.currentTimeMillis();
        playerName = "";
        currentQuestion = 0;
        questionDatabase = new HashMap<>();
        PushInformationToDatabase();
    }

    /**
     * Pausa el timer. En veritat no hi ha cap timer aqui i no pausa res. pero aquest metode executa
     * mates per tal de calcular quans segons i minuts ha tardat el jugador en arribar fins aqui.
     */
    public static void StopTimer()
    {
        timeFinish = System.currentTimeMillis();
        durationSeconds = (int)((timeFinish-timeStart)/1000);
        durationMinutes = (int)((float)durationSeconds/60);
    }

    /**
     * Setter de playerName
     * @param newPlayerName El nou nom del jugador
     */
    public static void SetNewPlayerName(String newPlayerName)
    {
        playerName = newPlayerName;
    }

    /**
     * El getter de playerName
     * @return El nom del jugador
     */
    public static String getPlayerName()
    {
        return playerName;
    }

    /**
     * Getter de currentQuestion.
     * @return El numero corresponent a la pregunta acutal.
     */
    public static int GetCurrentQuestion()
    {
        return currentQuestion;
    }

    /**
     * Retorna la informació de la pregunta actual.
     * @return La informació de la pregunta actual segons la questionDatabase.
     */
    public static QuestionInformation getCurrentQuestionInformation()
    {
        return questionDatabase.get(currentQuestion);
    }

    /**
     * Metode que retorna l'Intent de la seguent pregunta per tal que la classe de l'activitat
     * hi pugui anar.
     * @param currentContext El Context de l'activitat actual, s'utilitzaraá per inicialitzar
     *                       l'Intent que es retornará.
     * @return L'Intent que la classe utilitzará per canviar d'activity.
     */
    public static Intent NextQuestion(Context currentContext)
    {
        currentQuestion++;
        if(WhatActivityShouldBeLoaded(currentContext,currentQuestion)!=null) return WhatActivityShouldBeLoaded(currentContext,currentQuestion);
        throw new NullPointerException();
    }

    /**
     * Suma mes puntuacions a les actuals.
     * @param current Les respostes correctes de la pantalla actual.
     * @param total Respostes totals.
     */
    public static void PushMoreScores(int current, int total)
    {
        currentScore += current;
        totalScore += total;
    }

    /**
     * Construeix un Intent en base a quina pregunta s'hagi de cargar i d'a on estigui ara mateix.
     * @param currentContext El Context de la pantalla actual.
     * @param num La pregunta que s'ha de cargar.
     * @return L'Intent ja ben format.
     */
    private static Intent WhatActivityShouldBeLoaded(Context currentContext, int num)
    {
        if(questionDatabase.containsKey(num)) return new Intent(currentContext, Objects.requireNonNull(questionDatabase.get(num)).questionClass);
        else return null;
    }

    /**
     * Metode que posa tota la informació a la base de dades de preguntes.
     */
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
}
