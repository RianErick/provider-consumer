package org.example.service;

import io.vavr.control.Try;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import org.example.handler.GenericExceptionMapper;
import org.example.model.Produtor;
import org.example.repository.ProdutorRepository;

import java.util.Optional;

@ApplicationScoped
public class ProdutorService {

    @Inject
    ProdutorRepository produtorRepository;

    public Produtor insertAt(Produtor produtor) {
        Try.run(() -> produtorRepository.persist(produtor))
                .onFailure(e -> System.out.println("Erro ao salvar: " + e.getMessage()));
        return produtor;
    }

    public Produtor findById(Long id) {
        Optional<Produtor> produtor = Optional.of(produtorRepository.findById(id));

        if (produtor.isEmpty()) {
            throw new EntityNotFoundException("Opss! Recurso não encontrado... :(");
        }

        return produtor.get();
    }

}
