package org.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private  StudentRepository studentRepository;
    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student input){
        Student saved = studentRepository.save(input);
        return saved;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable Long id){
        Optional<Student> optional= studentRepository.findById(id);
        if(optional.isPresent()){
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>("Student with id: " + id + "is not present", HttpStatus.NOT_FOUND);

        }
    }
    @GetMapping("/all")
    public List<Student> getAllstudents(){
        return studentRepository.findAll();
    }
    @GetMapping("")
    public Set<Student> getCityStudents(@RequestParam String city){
        return studentRepository.findAllByAddress_City(city);
    }
    @PostMapping("/{id}/vehicle")
    public ResponseEntity<String> registerVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle)
    {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isEmpty()){
            return new ResponseEntity<>("Student with id: " + id + "is not present", HttpStatus.NOT_FOUND);
        }
        Student student = optional.get();
        vehicle.setStudent(student);
        Set<Vehicle> vehicles=student.getVehicles();

        vehicles.add(vehicle);
        student.setVehicles(vehicles);
        studentRepository.save(student);
        return  new ResponseEntity<>("Success",HttpStatus.OK);
    }
    @GetMapping("/homepage")
    public String something()
    {
        return "University homepage";
    }
}
