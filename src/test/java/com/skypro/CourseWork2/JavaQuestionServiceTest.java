package com.skypro.CourseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;

@SpringBootTest
class JavaQuestionServiceTest {

	private final JavaQuestionService out = new JavaQuestionService();


	@Test
	public void shouldAddQuestion_1() {
		Question result = out.add(Constants.question_1, Constants.answer_2);
		Assertions.assertTrue(out.questions.contains(result));
		Assertions.assertEquals(Constants.QUESTION_1, result);
	}
	@Test
	public void shouldRemoveQuestion_1() {
		out.add(Constants.QUESTION_1);
		Question result = out.remove(Constants.QUESTION_1);
		Assertions.assertFalse(out.questions.contains(result));
		Assertions.assertEquals(Constants.QUESTION_1, result);
	}

	@Test
	public void shouldThrowQuestionNotFoundException() {
		Assertions.assertThrows(QuestionNotFoundException.class,
				() -> out.remove(Constants.QUESTION_1)
		);
	}

	@Test
	public void shouldReturnAll() {
		out.add(Constants.QUESTION_1);
		out.add(Constants.QUESTION_2);
		out.add(Constants.QUESTION_3);
		Collection<Question> result = out.getAll();
		Assertions.assertEquals(Constants.getAllConstant(), result);
	}

	@Test
	public void shouldGetRandom() {
		out.add(Constants.QUESTION_1);
		out.add(Constants.QUESTION_2);
		out.add(Constants.QUESTION_3);
		Question result = out.getRandomQuestion();
		Assertions.assertTrue(result.equals(Constants.QUESTION_1) || result.equals(Constants.QUESTION_2) || result.equals(Constants.QUESTION_3));
	}
}
