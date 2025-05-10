package com.oliveira.senai.Service;

import com.oliveira.senai.Interface.AlunoRepository;
import com.oliveira.senai.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> buscarAluno(){
        return alunoRepository.findAll();
    }

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void excluirAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno buscarAlunoId(Long id){
        return alunoRepository.findById(id).orElse(null);
    }


}
