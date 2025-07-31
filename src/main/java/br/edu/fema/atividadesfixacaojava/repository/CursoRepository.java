package br.edu.fema.atividadesfixacaojava.repository;

import br.edu.fema.atividadesfixacaojava.enums.Periodo;
import br.edu.fema.atividadesfixacaojava.model.Curso;

import java.util.Arrays;
import java.util.List;

class CursoRepository {

    public static List<Curso> findAll(){
        return Arrays.asList(
                new Curso(1L, "Ciência da Computação","BCC", "2", 1 , Periodo.VESPERTINO),
                new Curso(2L, "Ciência da Computação","BCC", "1", 1 , Periodo.NOTURNO),
                new Curso(3L, "Ciência da Computação","BCC", "1", 2 , Periodo.MATUTINO),
                new Curso(4L, "Análise e Desenvolvimento de Sistemas","ADS", "1", 1 , Periodo.MATUTINO),
                new Curso(5L, "Análise e Desenvolvimento de Sistemas","ADS", "2", 1 , Periodo.VESPERTINO)
        );
    }

     static Curso findById(Long id){
        List<Curso> cursos = findAll();
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        return null;
    }
}
