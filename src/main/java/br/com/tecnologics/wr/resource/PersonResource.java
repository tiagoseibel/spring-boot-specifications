package br.com.tecnologics.wr.resource;

import br.com.tecnologics.wr.model.Person;
import br.com.tecnologics.wr.repository.PersonRepository;
import br.com.tecnologics.wr.specification.WrSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity findAll(@RequestParam("_page") Integer page, @RequestParam("_sort") String sort, @RequestParam(value = "_filter", required = false) String filter) {

        PageRequest pr = PageRequest.of(page, 10, Sort.by(sort));

        WrSpecificationBuilder<Person> sb = new WrSpecificationBuilder<>();
        Page<Person> p = personRepository.findAll(sb.build(filter), pr);

        System.out.println("size: " + p.getTotalElements());
        
        return ResponseEntity.ok(p);
    }

}
