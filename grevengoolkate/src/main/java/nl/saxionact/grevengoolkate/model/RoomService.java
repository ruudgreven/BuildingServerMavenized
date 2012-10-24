package nl.saxionact.grevengoolkate.model;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RoomService {

	private Map<Integer, Building> buildingDB;
	private AtomicInteger idCounter;

	private volatile static RoomService instance;

	public static RoomService getInstance() {
		if (instance == null) {
			instance = new RoomService();
		}
		return instance;
	}

	private RoomService() {
		buildingDB = new ConcurrentHashMap<Integer, Building>();
		idCounter = new AtomicInteger(2);

		Building a = new Building();
		a.setId(1);
		a.setOfficialName("Epy Drostgebouw");
		buildingDB.put(1, a);

		Building b = new Building();
		b.setId(2);
		b.setOfficialName("De admiraal");
		buildingDB.put(2, b);
	}

	public void addBuilding(Building building) {
		building.setId(idCounter.incrementAndGet());
		this.buildingDB.put(building.getId(), building);
	}

	public Collection<Building> getBuildings() {
		return buildingDB.values();
	}

	public Building getBuilding(int id) {
		return buildingDB.get(id);
	}

	public Building removeBuilding(int id) {
		return buildingDB.remove(id);
	}

}
