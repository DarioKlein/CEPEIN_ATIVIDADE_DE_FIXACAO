package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.enums.Periodo;
import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Atividade10 implements Atividade {

    public Map<Boolean, Map<String, List<Aluno>>> getAlunosForBenefitAndGroupedByAcronymCourse(List<Aluno> alunos) {
        return alunos.stream()
                .filter(aluno -> aluno.getCurso() != null)
                .collect(Collectors.partitioningBy(Aluno::getPossuiAlgumTipoDeBeneficio, Collectors.groupingBy(aluno -> aluno.getCurso().getSigla())));
    }

    public Map<Boolean, Map<Periodo, Map<String, List<Aluno>>>> getAlunosForBenefitAndPeriodAndAcronymCourse(List<Aluno> alunos) {
        return alunos.stream()
                .filter(aluno -> aluno.getCurso() != null)
                .collect(
                        Collectors.partitioningBy(Aluno::getPossuiAlgumTipoDeBeneficio,
                                Collectors.groupingBy(aluno -> aluno.getCurso().getPeriodo(),
                                        Collectors.groupingBy(aluno -> aluno.getCurso().getSigla()))));
    }

    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();

        // 1. Alunos particionados por beneficiários e não beneficiários e agrupados pela sigla do curso
        System.out.println("Alunos agrupados por beneficiários e não beneficiários e agrupados pela sigla do curso:");
        Map<Boolean, Map<String, List<Aluno>>> alunosForBenefitAndGroupedByAcronymCourse = getAlunosForBenefitAndGroupedByAcronymCourse(alunoRepository);
        alunosForBenefitAndGroupedByAcronymCourse.forEach((possuiBeneficio, mapaCursos) -> {
            System.out.println("\nÉ beneficiário: " + possuiBeneficio);
            mapaCursos.forEach((siglaCurso, listaAlunos) -> {
                System.out.println("  Curso: " + siglaCurso);
                listaAlunos.forEach(aluno -> {
                    System.out.println("    - " + aluno);
                });
            });
        });

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");

        // 2. Alunos particionados por beneficiários e não beneficiários, agrupados por período e pela sigla do curso
        System.out.println("Alunos agrupados por beneficiários e não beneficiários e agrupados por período e pela sigla do curso:");
        Map<Boolean, Map<Periodo, Map<String, List<Aluno>>>> alunosForBenefitAndPeriodAndAcronymCourse = getAlunosForBenefitAndPeriodAndAcronymCourse(alunoRepository);
        alunosForBenefitAndPeriodAndAcronymCourse.forEach((possuiBeneficio, mapaPorPeriodo) -> {
            System.out.println("\nÉ beneficiário: " + possuiBeneficio);
            mapaPorPeriodo.forEach((periodo, mapaPorCurso) -> {
                System.out.println("  Período: " + periodo);
                mapaPorCurso.forEach((siglaCurso, listaAlunos) -> {
                    System.out.println("    Curso: " + siglaCurso);
                    listaAlunos.forEach(aluno -> {
                        System.out.println("      - " + aluno);
                    });
                });
            });
        });
    }
}
