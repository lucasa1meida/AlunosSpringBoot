package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
