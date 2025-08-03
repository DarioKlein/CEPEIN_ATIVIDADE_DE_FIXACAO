package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.enums.Periodo;
import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utils.FormatDate;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Atividade4 implements Atividade {

    public List<Aluno> getAlunosBornAfterDate(List<Aluno> alunos) {
        return alunos.stream().filter(aluno -> FormatDate.format(aluno.getDataNascimento())
                .isAfter(LocalDate.of(2001, 2, 15))).toList();
    }

    public Set<Aluno> getAlunosRegisteredAfterHours(List<Aluno> alunos) {
        return alunos.stream().filter(aluno -> aluno.getDataHoraCadastro().getHour() > 18).collect(Collectors.toSet());
    }

    public List<Aluno> getAlunosWithoutCourse(List<Aluno> alunos) {
        return alunos.stream().filter(aluno -> aluno.getCurso() == null).toList();
    }

    public List<Aluno> getAlunosWithCourse(List<Aluno> alunos) {
        return alunos.stream()
                .filter(aluno -> aluno.getCurso() != null)
                .collect(Collectors.toMap(aluno -> aluno.getCurso().getDescricao(), aluno -> aluno, (a1, a2) -> a1)).values().stream().toList();
    }

    public Collection<Aluno> getAlunosStudyMorningAndGreaterThanThirty(List<Aluno> alunos) {
        return alunos.stream()
                .filter(aluno -> aluno.getCurso() != null)
                .filter(aluno -> aluno.getCurso().getPeriodo().equals(Periodo.MATUTINO))
                .filter(aluno -> LocalDate.now().getYear() - FormatDate.format(aluno.getDataNascimento()).getYear() > 30).toList();
    }

    public Aluno getAlunoRegisteredInYear(List<Aluno> alunos) {
        return alunos.stream().filter(aluno -> aluno.getDataHoraCadastro().getYear() == 2021).findFirst().orElse(null);
    }

    public int getAmountAlunosRegisteredInSameDayAndMonth(List<Aluno> alunos) {
        Map<String, List<Aluno>> alunosByDate = alunos.stream().collect(Collectors.groupingBy(aluno -> {
            var data = aluno.getDataHoraCadastro();
            return data.getDayOfMonth() + "/" + data.getMonthValue();
        }));

        return alunosByDate.values().stream().filter(lista -> lista.size() > 1).mapToInt(List::size).sum();
    }

    @Override
    public void result() {

        List<Aluno> alunoRepository = AlunoRepository.findAll();

        // 1. Alunos nascidos após 15/02/2001
        System.out.println("Alunos nascidos após 15/02/2001: ");
        List<Aluno> alunosBornAfterDate = getAlunosBornAfterDate(alunoRepository);
        alunosBornAfterDate.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("\n");

        // 2. Alunos cadastrados após as 18 horas
        System.out.println("Alunos cadastrados após as 18 horas: ");
        Set<Aluno> alunosRegisteredAfterHours = getAlunosRegisteredAfterHours(alunoRepository);
        alunosRegisteredAfterHours.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("\n");

        // 3. Alunos que não possuem curso
        System.out.println("Alunos que não possuem curso: ");
        List<Aluno> alunosWithoutCourse = getAlunosWithoutCourse(alunoRepository);
        alunosWithoutCourse.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("\n");

        // 4. Alunos que possuem curso sem repetir o curso
        System.out.println("Alunos que possuem curso sem repetir o curso: ");
        List<Aluno> alunosWithCourse = getAlunosWithCourse(alunoRepository);
        alunosWithCourse.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("\n");

        // 5. Alunos que estudam de manhã e que tem mais de 30 anos
        System.out.println("Alunos que estudam de manhã e que tem mais de 30 anos: ");
        Collection<Aluno> alunosStudyMorningAndGreaterThanThirty = getAlunosStudyMorningAndGreaterThanThirty(alunoRepository);
        alunosStudyMorningAndGreaterThanThirty.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("\n");

        // 6. O primeiro aluno cadastrado no ano 2021
        System.out.println("O primeiro aluno cadastrado no ano 2021: ");
        Aluno alunoRegisteredInYear = getAlunoRegisteredInYear(alunoRepository);
        System.out.println(alunoRegisteredInYear);

        System.out.println("\n");
        System.out.println("\n");

        // 7. Quantidade de alunos que foram cadastrados no mesmo dia e mês
        System.out.println("Quantidade de alunos que foram cadastrados no mesmo dia e mês: ");
        System.out.println(getAmountAlunosRegisteredInSameDayAndMonth(alunoRepository));
    }
}
