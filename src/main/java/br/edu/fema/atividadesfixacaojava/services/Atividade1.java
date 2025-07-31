package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Atividade1 implements Atividade {

    private Set<Aluno> alunosRepositorySet;

    public void getAlunosRepositorySet() {
        this.alunosRepositorySet.forEach(System.out::println);
    }

    public void addAlunosRepositoryToSet(List<Aluno> alunosRepository) {
        alunosRepositorySet = new HashSet<>();
        alunosRepository.forEach(aluno -> alunosRepositorySet.add(aluno));
    }

    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();
        addAlunosRepositoryToSet(alunoRepository);
        getAlunosRepositorySet();
    }
}
