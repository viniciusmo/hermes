package com.hermes.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.hermes.model.Board;
import com.hermes.model.ItemBoard;
import com.hermes.model.ItemBoardCall;

public class BoardRepository {

	public BoardRepository() {

	}

	public Board createMainBoard() {
		Board board = new Board(createItensForMainBoard());
		return board;
	}

	private List<ItemBoard> createItensForMainBoard() {
		List<ItemBoard> itens = new ArrayList<ItemBoard>();
		itens.add(new ItemBoardCall("1_estou_com_fome.jpg",
				"1_estou_com_fome.mp3", createNextBoard()));
		itens.add(new ItemBoard("2_quero_ir_ao_banheiro.jpg",
				"2_quero_ir_ao_banheiro.mp3"));
		itens.add(new ItemBoard("3_quero_brincar.jpg", "3_quero_brincar.mp3"));
		itens.add(new ItemBoard("4_estou_com_frio.jpg", "4_estou_com_frio.mp3"));
		itens.add(new ItemBoard("5_estou_com_calor.jpg",
				"5_estou_com_calor.mp3"));
		itens.add(new ItemBoard("6_quero_dormir.jpg", "6_quero_dormir.mp3"));
		itens.add(new ItemBoard("7_quero_escovar_os_dentes.jpg",
				"7_quero_escovar_os_dentes.mp3"));
		itens.add(new ItemBoard("8_estou_feliz.jpg", "8_estou_feliz.mp3"));
		itens.add(new ItemBoard("9_estou_triste.jpg", "9_estou_triste.mp3"));
		itens.add(new ItemBoard("10_quero_ver_tv.jpg", "10_quero_ver_tv.mp3"));
		itens.add(new ItemBoard("11_quero_ler.jpg", "11_quero_ler.mp3"));
		itens.add(new ItemBoard("12_estou_com_sede.jpg",
				"12_estou_com_sede.mp3"));
		return itens;
	}

	private Board createNextBoard() {
		Board nextBoard = new Board(createItensForNextBoards());
		return nextBoard;
	}

	private List<ItemBoard> createItensForNextBoards() {
		List<ItemBoard> itens = new ArrayList<ItemBoard>();
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("1_estou_com_fome.jpg", "1_estou_com_fome.mp3"));
		return itens;
	}

}
