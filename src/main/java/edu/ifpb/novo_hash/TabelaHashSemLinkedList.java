package edu.ifpb.novo_hash;

import edu.ifpb.Aluno;

import java.util.Arrays;

public class TabelaHashSemLinkedList {

    private Aluno[] elementos;

    private Aluno[] elementosRedimencionado;

    public TabelaHashSemLinkedList(int tamanho) {
        this.elementos = new Aluno[tamanho];
    }

    private int funcaoHash(int matricula) throws Exception {
        if(matricula < 0) {
            throw new Exception("Matricula inválida");
        }
        return matricula%elementos.length;
    }

    public void redimencionar() {

    }


    public void inserirValor(int matricula, String nome) {
        try {
            int index = funcaoHash(matricula);
            Aluno aluno = new Aluno(matricula, nome);

            if(elementos[index] == null) {
                elementos[index] = aluno;
            } else {
                Aluno corrente = elementos[index];
                while(corrente != null && !corrente.getNome().isEmpty()) {
                    index++;
                    corrente = elementos[index];
                }

                if(index == elementos.length) {
                    redimencionar();
                }

                elementos[index] = new Aluno(matricula, nome);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "NovaTabelaHash{" +
                "elementos=" + Arrays.toString(elementos) +
                '}';
    }
}
