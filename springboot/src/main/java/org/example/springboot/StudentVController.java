package org.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/view/student")
public class StudentVController {
    @Autowired
    private StudentRepository studentRepository;



    @GetMapping("/all")
    public List<Student> retrievall(Model model){
         List<Student> students = studentRepository.findAll();
         model.addAttribute("data", students);
         return students;


    }
}
