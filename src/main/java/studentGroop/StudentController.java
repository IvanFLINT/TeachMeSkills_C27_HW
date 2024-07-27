package studentGroop;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "createStudent";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createStudent";
        }

        boolean isCreated = studentService.createStudent(student.getFirstName(), student.getLastName());

        if (isCreated) {
            return "result";
        } else {
            return "operationError";
        }
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "listStudents";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            model.addAttribute("message", "Student successfully deleted.");
        } else {
            model.addAttribute("message", "Failed to delete student.");
        }
        return "redirect:/students";
    }

}
