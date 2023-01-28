package com.example.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CRUDdemoController {

    @Autowired
    CRUDdemoRepository cruDdemoRepository;

    @GetMapping("/allbasic")
    public ResponseEntity<List<CRUDmodel>> getAllBasic() {
        try {
            List<CRUDmodel> response = new ArrayList<>();
            cruDdemoRepository.findAll().forEach(response::add);
            if(response.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/basic")
    public ResponseEntity<CRUDmodel> createBasic(@RequestBody CRUDmodel cruDmodel) {
        try{
            log.info(cruDmodel.toString());
            CRUDmodel response = cruDdemoRepository.save(cruDmodel);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
