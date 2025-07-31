package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade3 implements Atividade {

    public List<String> getCompleteName(List<Aluno> alunos) {
        return alunos.stream().map(aluno -> aluno.getNomeCompleto()).collect(Collectors.toList());
    }

    public List<LocalDate> getDateBirth(List<Aluno> alunos) {
        return alunos.stream()
                .map(aluno -> aluno.getDataNascimento())
                .map(data -> LocalDate.parse(formatDate(data)))
                .collect(Collectors.toList());
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
        System.out.println("Nome dos Alunos: ");
        List<String> names = getCompleteName(alunoRepository);
        names.forEach(System.out::println);


        System.out.println("\n");

        // 2. Data de nascimento dos alunos
        System.out.println("Data de nascimento dos alunos: ");
        List<LocalDate> dateBirth = getDateBirth(alunoRepository);
        dateBirth.forEach(System.out::println);

        // 3. Idade dos alunos sem MAP

    }
}
