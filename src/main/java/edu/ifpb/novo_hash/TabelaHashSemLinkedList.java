package edu.ifpb.novo_hash;

import edu.ifpb.Aluno;

import java.util.Arrays;

public class TabelaHashSemLinkedList {

    private Aluno[] elementos;

    public TabelaHashSemLinkedList(int tamanho) {
        this.elementos = new Aluno[tamanho];
    }

    private int funcaoHash(int matricula) throws Exception {
        if(matricula < 0) {
            throw new Exception("Matricula inválida");
        }
        return matricula%elementos.length;
    }

    public void redimencionar() throws Exception {
        Aluno[] antigo = this.elementos;

        this.elementos = new Aluno[elementos.length * 2];
        
        for(Aluno al : antigo) {
            if(al != null) {
                if(!al.getNome().isEmpty()) {
                    inserirValor(al.getMatricula(), al.getNome());
                }
            }
        }
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
                    if(index == elementos.length) {
                        redimencionar();
                    }
                    corrente = elementos[index];
                }

                elementos[index] = new Aluno(matricula, nome);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String remover(int matricula) throws Exception {
        try {
            int index = funcaoHash(matricula);
            while(elementos[index] != null && elementos[index].getMatricula() != matricula) {
                index++;
            }

            if(elementos[index] == null) {
                throw new Exception("Aluno não encontrado");
            }

            String nome = elementos[index].getNome();
            elementos[index].setNome("");
            return nome;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "NovaTabelaHash{" +
                "elementos=" + Arrays.toString(elementos) +
                '}';
    }
}
