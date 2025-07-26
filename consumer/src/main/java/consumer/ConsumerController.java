package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/students")
    public List<?> getStudentsFromServiceA() {
        return restTemplate.getForObject("http://A/students", List.class);
    }
@PostMapping("/students/add")
public Object addStudent(@RequestBody Object student) {
    return restTemplate.postForObject("http://A/students/add", student, Object.class);
}
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        restTemplate.delete("http://A/students/" + id);
    }
    @GetMapping("/students/{id}")
    public Object getStudentById(@PathVariable Long id) {
        return restTemplate.getForObject("http://A/students/" + id, Object.class);
    }
}
