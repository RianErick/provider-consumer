package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.model.Produtor;

@ApplicationScoped
public class ProdutorRepository implements PanacheRepository<Produtor> {

}
