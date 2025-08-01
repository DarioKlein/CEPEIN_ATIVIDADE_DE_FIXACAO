package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Atividade3 implements Atividade {

    public List<String> getCompleteName(List<Aluno> alunos) {
        return alunos.stream().map(aluno -> aluno.getNomeCompleto()).toList();
    }

    public List<LocalDate> getDateBirth(List<Aluno> alunos) {
        return alunos.stream().map(aluno -> aluno.getDataNascimento()).map(data -> LocalDate.parse(formatDate(data))).toList();
    }

    public List<Integer> getAge(List<Aluno> alunos) {
        List<Integer> ages = new ArrayList<>();
        alunos.forEach(aluno -> ages.add(LocalDate.now().getYear() - Integer.parseInt(aluno.getDataNascimento().split("/")[2])));
        return ages;
    }

    public String formatDate(String date) {
        if (!date.contains("/")) {
            throw new RuntimeException("A data passada não possui o formato adequado");
        }

        return arrayDateToStringDate(changeArrayOrder(date));
    }

    public String arrayDateToStringDate(List<String> dates) {
        return String.join("-", dates);
    }

    public List<String> changeArrayOrder(String date) {
        String[] parts = date.split("/");
        return List.of(parts[2], parts[1], parts[0]);
    }

    @Override
    public void result() {
        List<Aluno> alunoRepository = AlunoRepository.findAll();

        // 1. Nome completo dos alunos
        System.out.println("Nome completo dos Alunos: ");
        List<String> names = getCompleteName(alunoRepository);
        names.forEach(System.out::println);

        System.out.println("\n");

        // 2. Data de nascimento dos alunos
        System.out.println("Data de nascimento dos alunos: ");
        List<LocalDate> dateBirth = getDateBirth(alunoRepository);
        dateBirth.forEach(System.out::println);

        System.out.println("\n");

        // 3. Idade dos alunos sem MAP
        System.out.println("Idade dos alunos: ");
        List<Integer> ages = getAge(alunoRepository);
        ages.forEach(System.out::println);

    }
}
