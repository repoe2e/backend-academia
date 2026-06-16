package br.com.e2etreinamentos.backend_academia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.e2etreinamentos.backend_academia.dto.AlunoRequest;
import br.com.e2etreinamentos.backend_academia.model.Aluno;
import br.com.e2etreinamentos.backend_academia.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
@Tag(name = "Alunos", description = "Operações relacionadas aos alunos")
public class AlunoController {

    private final AlunoService service = new AlunoService();

    
    @Operation(summary = "Cadastrar novo aluno")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastrar(
            @RequestBody AlunoRequest request) {

        return service.cadastrar(request);
    }

    @Operation(summary = "Listar todos os alunos")
    @GetMapping
    public List<Aluno> listar() {

        return service.listar();
    }

    @Operation(summary = "Buscar aluno por ID")
    @GetMapping("/{id}")
    public Aluno buscar(
            @PathVariable Long id) {

        return service.buscar(id);
    }

    @Operation(summary = "Atualizar aluno")
    @PutMapping("/{id}")
    public Aluno atualizar(
            @PathVariable Long id,
            @RequestBody AlunoRequest request) {

        return service.atualizar(id, request);
    }

    @Operation(summary = "Excluir aluno")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id) {

        service.excluir(id);
    }
}