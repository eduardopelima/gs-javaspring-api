package br.com.fiap.greenenergy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.greenenergy.repository.OnibusRepository;
import br.com.fiap.greenenergy.model.Onibus;

@Service
public class OnibusService {
    
    @Autowired
    OnibusRepository onibusRepository;

    public List<Onibus> list() {
        return onibusRepository.findAll();
    }

    public Optional<Onibus> findById(long id) {
        return onibusRepository.findById(id);
    }

    public Onibus save(Onibus onibus) {
        return onibusRepository.save(onibus);
    }

    public boolean existsById(long id) {
        return onibusRepository.existsById(id);
    }

    public void delete(Long id) {
        onibusRepository.deleteById(id);
    }

}
