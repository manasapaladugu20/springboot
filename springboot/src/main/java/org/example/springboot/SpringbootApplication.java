package org.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SpringbootApplication
		//implements CommandLineRunner
 {

//	@Autowired
//	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//		Helloworld hw=context.getBean(Helloworld.class);
//		hw.sayMessage();
//		car c = context.getBean(car.class);
//		c.start();
//		c.stop();
		//Student s = new Student();
		//Set<Student> ds = studentRepository.findAllByAddress_City("Dallas");
//		Student s = new Student();
//		s.setFirstname("pat");
//		s.setLastname("p");
//		s.setEmail("pp@gmail.com");
//		Vehicle v = new Vehicle();
//		v.setVin("tyhhhhj");
//		v.setColor("blue");
//		v.setMake("toyota");
//		v.setStudent(s);
//		Vehicle v1 = new Vehicle();
//		v1.setVin("uujhhnn");
//		v1.setColor("black");
//		v1.setMake("toyota");
//		v1.setStudent(s);
//
//		Set<Vehicle> vehicles =new HashSet<>();
//		vehicles.add(v);
//		vehicles.add(v1);
//		s.setVehicles(vehicles);
//		studentRepository.save(s);


//		s.setPassword("17290745");
//		Student saved = studentRepository.save(s);
//		System.out.println(saved);

//		Optional<Student> retrievedoptional = studentRepository.findById(1L);
//		Student retrieved = retrievedoptional.get();
//		retrieved.setPhonenumber("1224444");
//		studentRepository.save(retrieved);
//		Address a = new Address();
//		a.setLineone("mac arthur");
//		a.setCity("Dallas");
//		a.setState("TX");
//		s.setAddress(a);
//		studentRepository.save(s);
//		Student es = studentRepository.findByEmail("jj@gmail.com");
//
//
//		System.out.println(es);
//		Optional<Student> retrieved = studentRepository.findById(5L);
//		Student s = retrieved.get();
//		System.out.println("******");
//		Set<Vehicle> vehicles = s.getVehicles();
//		System.out.println(vehicles);
//		Set<Student> retrieved = studentRepository.getCityStudents("Dallas");
//		System.out.println(retrieved);
	//}

}
