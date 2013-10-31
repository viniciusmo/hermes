package com.hermes.model;

import java.io.Serializable;
import java.util.List;

import com.hermes.model.dao.BoardDao;
import com.hermes.model.dao.DaoSession;
import com.hermes.model.dao.ItemBoardDao;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table BOARD.
 */
public class Board implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
    /** Not-null value. */
    private String name;
    /** Not-null value. */
    private String categorie;
    private int lines;
    private int cols;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BoardDao myDao;

    private List<ItemBoard> itemBoardList;

    public Board() {
    }

    public Board(Long id) {
        this.id = id;
    }

    public Board(Long id, String name, String categorie, int lines, int cols) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.lines = lines;
        this.cols = cols;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBoardDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    /** Not-null value. */
    public String getCategorie() {
        return categorie;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ItemBoard> getItemBoardList() {
        if (itemBoardList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ItemBoardDao targetDao = daoSession.getItemBoardDao();
            List<ItemBoard> itemBoardListNew = targetDao._queryBoard_ItemBoardList(id);
            synchronized (this) {
                if(itemBoardList == null) {
                    itemBoardList = itemBoardListNew;
                }
            }
        }
        return itemBoardList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetItemBoardList() {
        itemBoardList = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
