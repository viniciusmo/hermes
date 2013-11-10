package com.hermes.sync;

import java.util.ArrayList;
import java.util.List;

public class SyncWebServices implements Synceable {

	@Override
	public void doSync() {
		List<Synceable> syncs = new ArrayList<Synceable>();
		syncs.add(new SyncBoards());
		syncs.add(new SyncWords());
		for (Synceable synceable : syncs) {
			synceable.doSync();
		}
	}
}
