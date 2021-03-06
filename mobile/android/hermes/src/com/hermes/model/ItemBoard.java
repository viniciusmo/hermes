package com.hermes.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hermes.model.dao.BoardDao;
import com.hermes.model.dao.DaoSession;
import com.hermes.model.dao.ItemBoardDao;
import com.hermes.tools.SoundTools;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table ITEM_BOARD.
 */
public class ItemBoard implements ItemActionable, Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private long boardId;
	@Expose
	@SerializedName("path_sound")
	private String pathSound;
	@Expose
	@SerializedName("path_image")
	private String pathImage;

	/** Used to resolve relations */
	private transient DaoSession daoSession;

	/** Used for active entity operations. */
	private transient ItemBoardDao myDao;

	private Board board;
	private Long board__resolvedKey;

	public ItemBoard() {
	}

	public ItemBoard(Long id) {
		this.id = id;
	}

	public ItemBoard(Long id, long boardId, String pathSound, String pathImage) {
		this.id = id;
		this.boardId = boardId;
		this.pathSound = pathSound;
		this.pathImage = pathImage;
	}

	/** called by internal mechanisms, do not call yourself. */
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getItemBoardDao() : null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

	/** Not-null value. */
	public String getPathSound() {
		return pathSound;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setPathSound(String pathSound) {
		this.pathSound = pathSound;
	}

	/** Not-null value. */
	public String getPathImage() {
		return pathImage;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	/** To-one relationship, resolved on first access. */
	public Board getBoard() {
		long __key = this.boardId;
		if (board__resolvedKey == null || !board__resolvedKey.equals(__key)) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			BoardDao targetDao = daoSession.getBoardDao();
			Board boardNew = targetDao.load(__key);
			synchronized (this) {
				board = boardNew;
				board__resolvedKey = __key;
			}
		}
		return board;
	}

	public void setBoard(Board board) {
		if (board == null) {
			throw new DaoException(
					"To-one property 'boardId' has not-null constraint; cannot set to-one to null");
		}
		synchronized (this) {
			this.board = board;
			boardId = board.getId();
			board__resolvedKey = boardId;
		}
	}

	/**
	 * Convenient call for {@link AbstractDao#delete(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void delete() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.delete(this);
	}

	/**
	 * Convenient call for {@link AbstractDao#update(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void update() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.update(this);
	}

	/**
	 * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void refresh() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.refresh(this);
	}

	public void doAction() {
		SoundTools.playFileFromPath(pathSound);
	}

}
