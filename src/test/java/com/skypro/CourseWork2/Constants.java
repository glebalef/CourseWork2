package com.skypro.CourseWork2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Constants {

    static Random random = new Random();

    public static String question_1 = "QUESTION_1";
    public static String question_2 = "QUESTION_2";
    public static String question_3 = "QUESTION_3";
    public static String answer_1 = "ANSWER_1";
    public static String answer_2 = "ANSWER_2";
    public static String answer_3 = "ANSWER_3";

    public static int goodAmount_1 = 2;
    public static int goodAmount_2 = 3;
    public static int badAmount = 4;



    public static final Question QUESTION_1 = new Question(question_1, answer_1);
    public static final Question QUESTION_2 = new Question(question_2, answer_2);
    public static final Question QUESTION_3 = new Question(question_3, answer_3);

    public static final HashSet <Question> getAllConstant() {
        HashSet<Question> test = new HashSet<>();
        test.add(QUESTION_1);
        test.add(QUESTION_2);
        test.add(QUESTION_3);
        return test;
    }

    public static Question getRandomQuestionTest() {
        Question [] questArr = getAllConstant().toArray(new Question[getAllConstant().size()]);
        return questArr[random.nextInt(questArr.length)];
    }
}
