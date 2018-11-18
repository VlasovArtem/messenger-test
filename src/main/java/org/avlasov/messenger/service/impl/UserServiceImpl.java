package org.avlasov.messenger.service.impl;

import org.avlasov.messenger.entity.User;
import org.avlasov.messenger.repository.UserRepository;
import org.avlasov.messenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by artemvlasov on 16/07/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> save(User user) {
        Objects.requireNonNull(user, "User is required for saving.");
        return Optional.ofNullable(repository.save(user));
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean delete(int id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String email) {
        if (repository.existsByEmail(email)) {
            repository.deleteByEmail(email);
            return true;
        }
        return false;
    }
}
