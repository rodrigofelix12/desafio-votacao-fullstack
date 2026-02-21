package dev.rodrigo.desafiovotacao.repository;

import dev.rodrigo.desafiovotacao.entity.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {}
