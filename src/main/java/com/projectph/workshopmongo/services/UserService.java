package com.projectph.workshopmongo.services;


import com.projectph.workshopmongo.domain.User;
import com.projectph.workshopmongo.dto.UserDTO;
import com.projectph.workshopmongo.repository.UserRepository;
import com.projectph.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj)
    {
        return repo.insert(obj);
    }

    public void delete(String id)
    {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        User newobj = findById(obj.getId());
        updateData(newobj, obj);
        return repo.save(newobj);
    }

    private void updateData(User newobj, User obj) {
        newobj.setName(obj.getName());
        newobj.setEmail(obj.getEmail());
    }


    public User fromDTO(UserDTO objDto)
    {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
