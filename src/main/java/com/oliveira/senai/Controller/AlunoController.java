package com.oliveira.senai.Controller;

import com.oliveira.senai.Model.Aluno;
import com.oliveira.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

@GetMapping
    public List<Aluno> listaDeAlunos(){
        return alunoService.buscarAluno();
}

@PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno){
        return alunoService.salvarAluno(aluno);
}

@GetMapping("/id")
    public Aluno buscarAlunoId(@PathVariable Long id){
        return alunoService.buscarAlunoId(id);
}

@DeleteMapping("/id")
    public void deletarAluno(@PathVariable Long id){
        alunoService.excluirAluno(id);
}

@PutMapping("/id")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno novoAluno){
        Aluno alunoExistente = alunoService.buscarAlunoId(id);
        if (alunoExistente == null) return null;

        alunoExistente.setNomeAluno(novoAluno.getNomeAluno());
        alunoExistente.setEmailAluno(novoAluno.getEmailAluno());
        alunoExistente.setTelefoneAluno(novoAluno.getTelefoneAluno());
        return alunoService.salvarAluno(alunoExistente);
}

}
