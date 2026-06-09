package br.com.e2etreinamentos.backend_academia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.e2etreinamentos.backend_academia.dto.AlunoRequest;
import br.com.e2etreinamentos.backend_academia.model.Aluno;
import br.com.e2etreinamentos.backend_academia.service.AlunoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService service = new AlunoService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastrar(
            @RequestBody AlunoRequest request) {

        return service.cadastrar(request);
    }

    @GetMapping
    public List<Aluno> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public Aluno buscar(
            @PathVariable Long id) {

        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(
            @PathVariable Long id,
            @RequestBody AlunoRequest request) {

        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id) {

        service.excluir(id);
    }
}