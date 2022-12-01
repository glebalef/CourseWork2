package com.skypro.CourseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionService questionServiceMock;

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void shouldReturnSetOfRandomQuestions() {
        when(questionServiceMock.getAll()).thenReturn(Constants.getAllConstant());
        when(questionServiceMock.getRandomQuestion()).thenReturn(Constants.getRandomQuestionTest(),Constants.getRandomQuestionTest(),Constants.getRandomQuestionTest(),Constants.getRandomQuestionTest(),Constants.getRandomQuestionTest());

        Collection<Question> resultFromThree = out.getQuestions(Constants.goodAmount_2);

        Assertions.assertEquals(resultFromThree.size(), Constants.goodAmount_2);
        Assertions.assertTrue(resultFromThree.contains(Constants.QUESTION_1));
        Assertions.assertTrue(resultFromThree.contains(Constants.QUESTION_2));
        Assertions.assertTrue(resultFromThree.contains(Constants.QUESTION_3));

    }

    @Test
    public void shouldThrowTooManyQuestionsException() {
        when(questionServiceMock.getAll()).thenReturn(Constants.getAllConstant());
        Assertions.assertThrows(TooManyQuestionsException.class,
                () -> out.getQuestions(Constants.badAmount)
        );
    }
}
