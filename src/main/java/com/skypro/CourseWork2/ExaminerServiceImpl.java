package com.skypro.CourseWork2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new TooManyQuestionsException();
        }
        Set<Question> questionsList = new HashSet<Question>();
        for (int i = 0; ; i++) {
            questionsList.add(javaQuestionService.getRandomQuestion());
            if (questionsList.size() == amount) {
                break;
            }
        }
        return questionsList;
    }
}
