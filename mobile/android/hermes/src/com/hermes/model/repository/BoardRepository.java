package com.hermes.model.repository;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.hermes.model.Board;
import com.hermes.model.ItemBoard;

public class BoardRepository {
	private Context context;

	public BoardRepository(Context context) {
		this.context = context;
	}

	public Board createMainBoard() {
		Board board = new Board(createItensForMainBoard());
		return board;
	}

	private List<ItemBoard> createItensForMainBoard() {
		List<ItemBoard> itens = new ArrayList<ItemBoard>();
		itens.add(new ItemBoard("1_estou_com_fome.png", "1_estou_com_fome.mp3"));
		itens.add(new ItemBoard("2_quero_ir_ao_banheiro.png",
				"2_quero_ir_ao_banheiro.mp3"));
		itens.add(new ItemBoard("3_quero_brincar.png", "3_quero_brincar.mp3"));
		itens.add(new ItemBoard("4_estou_com_frio.png", "4_estou_com_frio.mp3"));
		itens.add(new ItemBoard("5_estou_com_calor.png",
				"5_estou_com_calor.mp3"));
		itens.add(new ItemBoard("6_quero_dormir.png", "6_quero_dormir.mp3"));
		itens.add(new ItemBoard("7_quero_escovar_os_dentes.png",
				"7_quero_escovar_os_dentes.mp3"));
		itens.add(new ItemBoard("8_estou_feliz.png", "8_estou_feliz.mp3"));
		itens.add(new ItemBoard("9_estou_triste.png", "9_estou_triste.mp3"));
		itens.add(new ItemBoard("10_quero_ver_tv.png", "10_quero_ver_tv.mp3"));
		itens.add(new ItemBoard("11_quero_ler.png", "11_quero_ler.mp3"));
		itens.add(new ItemBoard("12_estou_com_sede.png",
				"12_estou_com_sede.mp3"));
		return itens;
	}

	// private Board createNextBoard() {
	// Board nextBoard = new Board(createItensForNextBoards());
	// return nextBoard;
	// }
	//
	// private List<ItemActionable> createItensForNextBoards() {
	// List<ItemActionable> itens = new ArrayList<ItemActionable>();
	// itens.add(new ItemBoard("teste", "teste"));
	// itens.add(new ItemBoard("teste", "teste"));
	// itens.add(new ItemBoard("teste", "teste"));
	// itens.add(new ItemBoard("teste", "teste"));
	// itens.add(new ItemBoard("teste", "teste"));
	// itens.add(new ItemBoard("teste", "teste"));
	// return itens;
	// }

	public Context getContext() {
		return context;
	}

}
