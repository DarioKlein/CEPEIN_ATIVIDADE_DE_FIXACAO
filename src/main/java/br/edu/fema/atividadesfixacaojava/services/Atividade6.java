package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utils.FormatDate;

import java.util.*;
import java.util.stream.Collectors;

public class Atividade6 implements Atividade {

    public Set<String> getNewSetSortedByBirth(List<Aluno> alunos) {
        return alunos.stream()
                .sorted(Comparator.comparing(aluno -> FormatDate.format(aluno.getDataNascimento())))
                .map(Aluno::toString).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();

        System.out.println("List<Aluno> ordenada pela data de nascimento em ordem crescente:");
        Set<String> alunosSortedByBirth = getNewSetSortedByBirth(alunoRepository);
        alunosSortedByBirth.forEach(System.out::println);
    }
}
