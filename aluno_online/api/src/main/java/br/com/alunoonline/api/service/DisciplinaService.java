package br.com.alunoonline.api.service;

import java.util.List;
import java.util.Optional;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void criarDisciplina (Disciplina disciplina){
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinasDoProf(Long professorId) {
        return disciplinaRepository.findByProfessorId(professorId);
    }

    public List<Disciplina> listarTodosDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public void deletarDisciplinaPorId(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public void atualizarDisciplinaPorID(Long id, Disciplina disciplina) {

        Optional<Disciplina> disciplinaDoBancoDeDados = buscarDisciplinaPorId(id);

        if (disciplinaDoBancoDeDados.isEmpty()) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada no banco de dados");
        }

        Disciplina disciplinaEditado = disciplinaDoBancoDeDados.get();

        disciplinaEditado.setNome(disciplina.getNome());
        disciplinaEditado.setProfessor(disciplina.getProfessor());

        disciplinaRepository.save(disciplinaEditado);
    }
}