package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Atividade1 implements Atividade {

    private Set<Aluno> alunosRepositorySet;

    public void getAlunosRepositorySet() {
        System.out.println("Lista de alunos: \n");
        this.alunosRepositorySet.forEach(System.out::println);
    }

    public void addAlunosRepositoryToSet(List<Aluno> alunosRepository) {
        alunosRepositorySet = alunosRepository.stream().collect(Collectors.toSet());
    }

    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();
        addAlunosRepositoryToSet(alunoRepository);
        getAlunosRepositorySet();
    }
}
