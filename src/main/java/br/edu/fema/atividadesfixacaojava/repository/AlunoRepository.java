package br.edu.fema.atividadesfixacaojava.repository;

import br.edu.fema.atividadesfixacaojava.model.Aluno;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AlunoRepository {
    public static List<Aluno> findAll(){
        return Arrays.asList(
                new Aluno(1L, "Sheila suvako", "01/09/2000", LocalDateTime.of(2024,10, 10, 12, 10), false, null),
                new Aluno(2L, "Jonas Ladeira", "16/07/1980", LocalDateTime.of(1998,4, 8, 10, 55), false, null),
                new Aluno(3L, "Paulo Argentino", "30/01/1987", LocalDateTime.of(2005,12, 4, 9, 50), true, CursoRepository.findById(1L)),
                new Aluno(4L, "Ana Banana", "29/03/2002", LocalDateTime.of(2020,5, 5, 14, 32), false, CursoRepository.findById(1L)),
                new Aluno(5L, "Fernando Pinto", "07/01/2001", LocalDateTime.of(2019,8, 28, 23, 12), false, CursoRepository.findById(2L)),
                new Aluno(6L, "Pedro Pedros", "13/01/1987", LocalDateTime.of(1999,9, 22, 7, 38), true, CursoRepository.findById(2L)),
                new Aluno(7L, "Carlos Drummon", "17/01/2000", LocalDateTime.of(2021,12, 15, 22, 11), false, CursoRepository.findById(3L)),
                new Aluno(8L, "Shaw Shi Chon", "10/04/2005", LocalDateTime.of(2023,5, 7, 19, 43), true, CursoRepository.findById(4L)),
                new Aluno(9L, "Rafael Jacinto", "29/06/2003", LocalDateTime.of(2021,10, 9, 0, 21), true, CursoRepository.findById(4L)),
                new Aluno(10L,"Paulo Romano", "01/01/2000", LocalDateTime.of(2018,4, 12, 1, 43), true, null),
                new Aluno(11L,"Paulo Grego", "10/11/1967", LocalDateTime.of(1980,6, 1, 9, 56 ), false, CursoRepository.findById(3L)),
                new Aluno(12L,"Paulo Persa", "21/06/1996", LocalDateTime.of(2012,2, 28, 14, 18), true, CursoRepository.findById(5L)),
                new Aluno(13L,"Paulo Chines", "01/12/1992", LocalDateTime.of(2010,3, 16, 8, 9), false, CursoRepository.findById(5L)),
                new Aluno(14L,"Paulo Otomano", "06/08/2004", LocalDateTime.of(2020,1, 19, 6, 32), false, null),
                new Aluno(15L,"Paulo Arabico", "19/05/2001", LocalDateTime.of(2019,11, 6, 13, 5), false, CursoRepository.findById(3L)),
                new Aluno(16L,"João Silva", "06/04/2004", LocalDateTime.of(2020,1, 19, 10, 25), true, null),
                new Aluno(17L,"Giovana Silva", "19/09/2001", LocalDateTime.of(2020,1, 19, 13, 5), false, CursoRepository.findById(3L))
        );
    }

}
