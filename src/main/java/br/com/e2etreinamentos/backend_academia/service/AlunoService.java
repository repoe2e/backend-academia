package br.com.e2etreinamentos.backend_academia.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import br.com.e2etreinamentos.backend_academia.dto.AlunoRequest;
import br.com.e2etreinamentos.backend_academia.exception.BusinessException;
import br.com.e2etreinamentos.backend_academia.model.Aluno;
import br.com.e2etreinamentos.backend_academia.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository = new AlunoRepository();

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public Aluno cadastrar(AlunoRequest request) {

        validar(request);

        repository.buscarPorEmail(request.getEmail())
                .ifPresent(a -> {
                    throw new BusinessException("E-mail já cadastrado");
                });

        Aluno aluno = new Aluno(
                null,
                request.getNome(),
                request.getEmail(),
                request.getIdade(),
                request.getWhatsapp());

        return repository.salvar(aluno);
    }

    public List<Aluno> listar() {
        return repository.listarTodos();
    }

    public Aluno buscar(Long id) {

        return repository.buscarPorId(id)
                .orElseThrow(() ->
                        new BusinessException("Aluno não encontrado"));
    }

    public Aluno atualizar(Long id, AlunoRequest request) {

        validar(request);

        Aluno aluno = buscar(id);

        repository.buscarPorEmail(request.getEmail())
                .ifPresent(existente -> {

                    if (!existente.getId().equals(id)) {
                        throw new BusinessException("E-mail já cadastrado");
                    }
                });

        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setIdade(request.getIdade());
        aluno.setWhatsapp(request.getWhatsapp());

        return aluno;
    }

    public void excluir(Long id) {

        Aluno aluno = buscar(id);

        repository.remover(aluno);
    }

    private void validar(AlunoRequest request) {

        if (request.getNome() == null ||
                request.getNome().isBlank()) {

            throw new BusinessException("Nome é obrigatório");
        }

        if (request.getEmail() == null ||
                request.getEmail().isBlank()) {

            throw new BusinessException("E-mail é obrigatório");
        }

        if (!Pattern.matches(EMAIL_REGEX, request.getEmail())) {
            throw new BusinessException("E-mail inválido");
        }

        if (request.getIdade() == null ||
                request.getIdade() <= 0) {

            throw new BusinessException("Idade é obrigatória");
        }

        if (request.getWhatsapp() == null ||
                request.getWhatsapp().isBlank()) {

            throw new BusinessException("WhatsApp é obrigatório");
        }
    }
}