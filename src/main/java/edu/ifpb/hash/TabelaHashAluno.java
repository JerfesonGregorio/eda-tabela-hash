package edu.ifpb.hash;

import java.util.Arrays;
import java.util.LinkedList;

public class TabelaHashAluno {

    private LinkedList<Aluno>[] elementos;

    public TabelaHashAluno(int tamanho) {
        this.elementos = new LinkedList[tamanho];
    }

    private int funcaoHash(int matricula) throws Exception {
        if(matricula < 0) {
            throw new Exception("Matricula inválida");
        }
        return matricula%elementos.length;
    }

    public String pegarValor(int matricula) throws Exception {
        try {
            int index = funcaoHash(matricula);
            LinkedList<Aluno> lista = elementos[index];

            return lista.stream()
                    .filter(al -> al.getMatricula() == matricula).findFirst()
                    .orElseThrow(() -> new Exception("Aluno não encontrado"))
                    .getNome();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void inserirValor(int matricula, String nome) {
        try {
            int index = funcaoHash(matricula);
            Aluno aluno = new Aluno(matricula, nome);
            if(elementos[index] == null) {
                LinkedList<Aluno> lista = new LinkedList<>();
                elementos[index] = lista;
            }
            elementos[index].add(aluno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno removerValor(int matricula) {
        try {
            int hash = funcaoHash(matricula);
            LinkedList<Aluno> lista = elementos[hash];
            for(Aluno al : lista) {
                if(al.getMatricula() == matricula) {
                    lista.remove(al);
                    return al;
                }
            }
            throw new Exception("Aluno não encontrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "TabelaHashAluno{" +
                "elementos=" + Arrays.toString(elementos) +
                '}';
    }
}
