package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade7 implements Atividade {

    public List<LocalDateTime> getNewListSortedByRegister(List<Aluno> alunos) {
        return alunos.stream()
                .map(Aluno::getDataHoraCadastro)
                .sorted(Comparator.comparing(LocalDateTime::toLocalDate)
                        .reversed().thenComparing(LocalDateTime::getHour).thenComparing(LocalDateTime::getMinute))
                .collect(Collectors.toList());
    }


    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();

        System.out.println("List<LocalDateTime> ordenada pela data de cadastro em ordem decrescente e a hora e minuto do cadastro em ordem crescente: ");
        List<LocalDateTime> alunosSortedByRegister = getNewListSortedByRegister(alunoRepository);
        alunosSortedByRegister.forEach(System.out::println);
    }
}
