package org.example.model;


import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "produtor")
public class Produtor extends BaseEntityContext {

    @Column(name = "descricao", unique = true, length = 255, nullable = false)
    private String descricao;

    @JsonbDateFormat("dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataMensagem = LocalDateTime.now();

    public Produtor() {
        super();
    }

    @Override
    public void persist() {
        super.persist();
    }

    @Override
    public void persistAndFlush() {
        super.persistAndFlush();
    }

    @Override
    public void delete() {
        super.delete();
    }

    @Override
    public boolean isPersistent() {
        return super.isPersistent();
    }
}
