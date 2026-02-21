package dev.rodrigo.desafiovotacao.repository;

import dev.rodrigo.desafiovotacao.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {}
