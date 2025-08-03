package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utils.FormatDate;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Atividade9 implements Atividade {

    public Map<Boolean, List<Aluno>> getAlunosForBenefit(List<Aluno> alunos) {
        return alunos.stream().collect(Collectors.groupingBy(Aluno::getPossuiAlgumTipoDeBeneficio));
    }

    public Map<Month, List<Aluno>> getAlunosForMonthBirth(List<Aluno> alunos) {
        return alunos.stream().collect(Collectors.groupingBy(aluno -> FormatDate.format(aluno.getDataNascimento()).getMonth()));
    }

    public Map<Year, List<Aluno>> getAlunosForYearBirth(List<Aluno> alunos) {
        return alunos.stream().collect(Collectors.groupingBy(aluno -> Year.of(FormatDate.format(aluno.getDataNascimento()).getYear())));
    }

    public Map<YearMonth, List<Aluno>> getAlunosForYearBirthAndMonthBirth(List<Aluno> alunos) {
        return alunos.stream().collect(Collectors.groupingBy(aluno -> YearMonth.from(FormatDate.format(aluno.getDataNascimento())), TreeMap::new, Collectors.toList()));
    }

    public Map<Boolean, List<Aluno>> getAlunosForCourse(List<Aluno> alunos) {
        return alunos.stream().collect(Collectors.groupingBy(aluno -> aluno.getCurso() != null));
    }


    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();

        // 1. Alunos agrupados por beneficiários e não beneficiários
        System.out.println("Alunos agrupados por beneficiários e não beneficiários: ");
        Map<Boolean, List<Aluno>> alunosForBenefit = getAlunosForBenefit(alunoRepository);
        alunosForBenefit.forEach((key, value) -> System.out.println("\nÉ beneficiário: " + key + "\nLista:\n" + value));

        // 2. Alunos agrupados por mês de nascimento
        System.out.println("Alunos agrupados por mês de nascimento:");
        Map<Month, List<Aluno>> alunosForMonthBirth = getAlunosForMonthBirth(alunoRepository);
        alunosForMonthBirth.forEach((key, value) -> System.out.println("\nMês: " + key + "\nLista:\n" + value));

        // 3. Alunos agrupados por ano de nascimento
        System.out.println("Alunos agrupados por ano de nascimento:");
        Map<Year, List<Aluno>> alunosForYearBirth = getAlunosForYearBirth(alunoRepository);
        alunosForYearBirth.forEach((key, value) -> System.out.println("\nAno: " + key + "\nLista:\n" + value));

        // 4. Alunos agrupados por ano de nascimento e mês de nascimento
        System.out.println("Alunos agrupados por ano de nascimento e mês de nascimento:");
        Map<YearMonth, List<Aluno>> alunosForYearBirthAndMonthBirth = getAlunosForYearBirthAndMonthBirth(alunoRepository);
        alunosForYearBirthAndMonthBirth.forEach((key, value) -> System.out.println("\nAno e Mês: " + key + "\nLista:\n" + value));

        // 5. Alunos agrupados por possuírem curso ou não
        System.out.println("Alunos agrupados por possuírem curso ou não: ");
        Map<Boolean, List<Aluno>> alunosForCourse = getAlunosForCourse(alunoRepository);
        alunosForCourse.forEach((key, value) -> System.out.println("\nPossui curso: " + key + "\nLista:\n" + value));
    }
}
