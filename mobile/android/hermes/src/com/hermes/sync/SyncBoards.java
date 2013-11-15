package com.hermes.sync;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hermes.R;
import com.hermes.model.Board;
import com.hermes.model.BoardContainer;
import com.hermes.model.ItemBoard;
import com.hermes.model.dao.BoardDao;
import com.hermes.model.dao.ItemBoardDao;
import com.hermes.tools.ApplicationContext;
import com.hermes.tools.Log;
import com.hermes.tools.OnFinishSaveFile;
import com.hermes.tools.Storage;
import com.hermes.tools.WebClient;

public class SyncBoards implements Synceable {

	private void saveSoundOfItem(final ItemBoard item) {
		Storage.downlaodAndSaveFile(item.getPathSound(),
				String.format("sound%d", item.getId()), new OnFinishSaveFile() {
					@Override
					public void onFinishSaveFile(String file) {
						item.setPathSound(file);
					}
				});
	}

	private void saveImageOfItem(final ItemBoard item) {
		Storage.downlaodAndSaveFile(item.getPathImage(),
				String.format("image%d", item.getId()), new OnFinishSaveFile() {
					public void onFinishSaveFile(String file) {
						item.setPathImage(file);
					}
				});
	}

	public void doSync() {
		BoardDao boardDao = BoardDao.create();
		if (boardDao.loadAll().isEmpty()) {
			Log.i("Carregando boards");
			String url = ApplicationContext.res().getString(
					R.string.url_service_boards);
			String result = WebClient.getContent(url);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			BoardContainer boardContainer = gson.fromJson(result,
					BoardContainer.class);
			for (Board board : boardContainer.getBoards()) {
				boardDao.insert(board);
				Log.i("Total de itens na board " + board.getItemBoardList());
				Log.i("ID board " + board.getId());
				ItemBoardDao itemBoardDao = ItemBoardDao.create();
				for (ItemBoard itemBoard : board.getItemBoardList()) {
					itemBoard.setBoard(board);
					itemBoardDao.insert(itemBoard);
					saveImageOfItem(itemBoard);
					saveSoundOfItem(itemBoard);
					itemBoardDao.update(itemBoard);
					Log.i("Path image " + itemBoard.getPathImage());
				}
			}
		}
		boardDao.getDatabase().close();

	}
}
