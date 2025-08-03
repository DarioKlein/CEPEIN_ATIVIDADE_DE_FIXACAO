package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.Comparator;
import java.util.List;

public class Atividade5 implements Atividade {

    public Aluno getLastAlunoRegistered(List<Aluno> alunos) {
        alunos.sort(Comparator.comparing(Aluno::getDataHoraCadastro));
        return alunos.get(alunos.size() - 1);
    }


    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();

        // Último aluno cadastrado
        System.out.println("Último aluno cadastrado: ");
        System.out.println(getLastAlunoRegistered(alunoRepository));
    }
}
