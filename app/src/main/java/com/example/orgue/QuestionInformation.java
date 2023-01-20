package com.example.orgue;

public class QuestionInformation
{
    public Class questionClass;
    public String questionTitle;
    public String[] images;
    public String[] texts;
    public String[] answers;
    public boolean aloneInItsType;

    public QuestionInformation() { }

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
