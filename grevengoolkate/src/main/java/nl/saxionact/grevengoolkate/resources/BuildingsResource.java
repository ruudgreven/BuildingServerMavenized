package nl.saxionact.grevengoolkate.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.saxionact.grevengoolkate.model.Building;
import nl.saxionact.grevengoolkate.model.RoomService;

/**
 * Simple replace MediaType.APPLICATION_XML with MediaType.APPLICATION_JSON to
 * support json in stead of xml
 */

@Path("/buildings")
public class BuildingsResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Building> getBuildings() {
		List<Building> buildings = new ArrayList<Building>();
		buildings.addAll(RoomService.getInstance().getBuildings());
		
		return buildings;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBuilding(Building building) {
		RoomService.getInstance().addBuilding(building);

		return Response.created(URI.create("/building/" + building.getId()))
				.build();

	}

}
