package edu.ifpb;

import edu.ifpb.hash.TabelaHashAluno;
import edu.ifpb.novo_hash.TabelaHashSemLinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        TabelaHashSemLinkedList nt = new TabelaHashSemLinkedList(5);


        try {


            nt.inserirValor(1, "vvvv");
            nt.inserirValor(6, "3eq");

            System.out.println(nt);

            System.out.println(nt.remover(1));
            System.out.println(nt.remover(6));

            System.out.println(nt);
            nt.inserirValor(6, "ssss");
            nt.inserirValor(1, "lllll");
            System.out.println(nt.buscar(1));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



//    public static void main(String[] args) throws Exception {
//
//        TabelaHashAluno t = new TabelaHashAluno(20);
//
//        t.inserirValor(2, "João");
//        t.inserirValor(1, "Maria");
//        t.inserirValor(3, "Pedro");
//        t.inserirValor(4, "Ana");
//        t.inserirValor(7, "Bruno");
//        t.inserirValor(6, "Carla");
//        t.inserirValor(19, "Lucas");
//        t.inserirValor(20, "Lívia");
//        t.inserirValor(24, "Rafael");
//        t.inserirValor(12, "Fernanda");
//        t.inserirValor(15, "Thiago");
//        t.inserirValor(21, "Beatriz");
//        t.inserirValor(31, "Eduardo");
//
//
//        System.out.println(t.pegarValor(2));
//
//        System.out.println(t);
//
//        System.out.println("\n");
//
//        t.inserirValor(100, "SanToro");
//        System.out.println(t);
//        System.out.println(t.removerValor(100).getNome());
//        System.out.println(t);
//
//    }
}