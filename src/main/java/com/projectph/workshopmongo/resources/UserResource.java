package com.projectph.workshopmongo.resources;

import com.projectph.workshopmongo.domain.User;
import com.projectph.workshopmongo.dto.UserDTO;
import com.projectph.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll()
    {
        List<User>  list = service.findAll();
        List<UserDTO> listDTO = list.stream().map( x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value= "/{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id)
    {
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

}
