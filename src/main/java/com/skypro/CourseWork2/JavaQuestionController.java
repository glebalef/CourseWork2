package com.skypro.CourseWork2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping ("/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam(value = "question") String question,
                        @RequestParam(value = "answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(value = "question") String question,
                           @RequestParam(value = "answer") String answer) {
        Question newQuestion = new Question(question, answer);
        return javaQuestionService.remove(newQuestion);
    }

    @GetMapping(path = "")
    public Collection getAll () {
        return javaQuestionService.getAll();
    }

//    @GetMapping(path = "random")
//    public Question getRandom () {
//        return javaQuestionService.getRandomQuestion();
//   }


}
