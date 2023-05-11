package valls.orgue;

/**
 *  Classe que guardará informació de les preguntes dins la questionDatabase dins de LogicSingleton.
 */
public class QuestionInformation
{
    /**
     * La classe de la pantalla de la pregunta
     */
    @SuppressWarnings("rawtypes")
    public Class questionClass;

    /**
     * El text que hi haurá en el titul de la pantalla; normalment aixo será l'enunciat de la pregunta
     */
    public String questionTitle;

    /**
     * Array d'strings amb els identificadors de recursos d'imatges que surtiran a la pantalla
     * (si es que n'hi han).
     */
    public String[] images;

    /**
     * Array d'strings amb els texts secundaris que surtiran a la pantalla
     * (si es que n'hi han).
     * <p>
     * Aquests texts poden ser labels de chechboxes/radiobuttons, items de dropdowns, etc...
     */
    public String[] texts;

    /**
     * Array d'strings amb les respostes de la pregunta.
     */
    public String[] answers;

    /**
     * Si es true, senyala que sols hi ha una sola pregunta en aquesta activity.
     * Per simplificar el codi, moltes de les pantalles d'una vegada no apareixen en la
     * questionDatabase o tenen informació sobrant.
     * <p>
     * L'informació de les pantalles amb informació sobrant estan en el codi/XML de la propia pantalla.
     */
    public boolean aloneInItsType;

    /**
     * Constructor buït. Perque existeix? Gran pregunta...
     */
    @SuppressWarnings("unused")
    public QuestionInformation() { }

    /**
     * Constructor per defecte amb tota la informació del objecte.
     * @param questionClass La classe de Java de la pregunta
     * @param questionTitle El titul de la pregunta
     * @param images Les imatges de la pregunta
     * @param texts Els textos de la pregunta
     * @param answers Les respostes correctes de la pregunta
     * @param aloneInItsType True si la pregunnta sols es fa una vegada (i por lo tant te informació limitada).
     */
    @SuppressWarnings("rawtypes")
    public QuestionInformation(Class questionClass, String questionTitle, String[] images, String[] texts, String[] answers, boolean aloneInItsType)
    {
        this.questionClass = questionClass;
        this.questionTitle = questionTitle;
        this.images = images;
        this.texts = texts;
        this.answers = answers;
        this.aloneInItsType = aloneInItsType;
    }
}
