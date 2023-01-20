package com.example.orgue;

public class QuestionInformation
{
    Class questionClass;
    String questionTitle;
    String[] images;
    String[] texts;
    String[] answers;
    boolean aloneInItsType;

    public QuestionInformation()
    {

    }

    public QuestionInformation(Class questionClass, String questionTitle, String[] images, String[] texts, String[] answers, boolean aloneInItsType)
    {
        this.questionClass = questionClass;
        this.questionTitle = questionTitle;
        this.images = images;
        this.texts = texts;
        this.answers = answers;
        this.aloneInItsType = aloneInItsType;
    }

    public Class getQuestionClass()
    {
        return questionClass;
    }

    public void setQuestionClass(Class questionClass)
    {
        this.questionClass = questionClass;
    }

    public String getQuestionTitle()
    {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle)
    {
        this.questionTitle = questionTitle;
    }

    public String[] getImages()
    {
        return images;
    }

    public void setImages(String[] images)
    {
        this.images = images;
    }

    public String[] getTexts()
    {
        return texts;
    }

    public void setTexts(String[] texts)
    {
        this.texts = texts;
    }

    public String[] getAnswers()
    {
        return answers;
    }

    public void setAnswers(String[] answers)
    {
        this.answers = answers;
    }

    public boolean isAloneInItsType()
    {
        return aloneInItsType;
    }

    public void setAloneInItsType(boolean aloneInItsType)
    {
        this.aloneInItsType = aloneInItsType;
    }
}
