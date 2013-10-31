package com.hermes.model.repository;

import com.google.gson.Gson;
import com.hermes.R;
import com.hermes.model.Board;
import com.hermes.model.ItemBoard;
import com.hermes.tools.ApplicationContext;
import com.hermes.tools.OnFinishSaveFile;
import com.hermes.tools.Storage;
import com.hermes.tools.WebClient;

public class SyncBoards {

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
		String url = ApplicationContext.res().getString(
				R.string.url_service_boards);
		String result = WebClient.getContent(url);
		BoardContainer boardContainer = new Gson().fromJson(result,
				BoardContainer.class);
		for (Board board : boardContainer.getBoards()) {
			for (final ItemBoard item : board.getItemBoardList()) {
				saveImageOfItem(item);
				saveSoundOfItem(item);
			}
		}
		BoardRepository.setBoardContainer(boardContainer);
	}

}
