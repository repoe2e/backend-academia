package br.com.e2etreinamentos.backend_academia.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import br.com.e2etreinamentos.backend_academia.model.Aluno;

@Repository
public class AlunoRepository {

    private final List<Aluno> alunos = new ArrayList<>();

    private final AtomicLong sequence = new AtomicLong(1);

    public Aluno salvar(Aluno aluno) {

        aluno.setId(sequence.getAndIncrement());

        alunos.add(aluno);

        return aluno;
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public Optional<Aluno> buscarPorId(Long id) {

        return alunos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public Optional<Aluno> buscarPorEmail(String email) {

        return alunos.stream()
                .filter(a -> a.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public void remover(Aluno aluno) {
        alunos.remove(aluno);
    }
}