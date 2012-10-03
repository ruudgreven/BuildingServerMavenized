package nl.saxionact.grevengoolkate.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.saxionact.grevengoolkate.model.Building;
import nl.saxionact.grevengoolkate.model.RoomService;

import com.sun.jersey.api.NotFoundException;

/**
 * Simple replace MediaType.APPLICATION_XML with MediaType.APPLICATION_JSON to
 * support json in stead of xml
 */

@Path("/building")
public class BuildingResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Building getBuilding(@PathParam("id") int id) {
		Building building = RoomService.getInstance().getBuilding(id);
		if (building == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return building;
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBuilding(@PathParam("id") int id, Building update) {
		Building current = RoomService.getInstance().getBuilding(id);
		if (current == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);

		current.setOfficialName(update.getOfficialName());
		current.setNickName(update.getNickName());
		current.setStreet(update.getStreet());
		current.setZip(update.getZip());
		current.setCountry(update.getCountry());
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public void removeBuilding(@PathParam("id") int id) {
		Building b = RoomService.getInstance().removeBuilding(id);
		if (b == null)
			throw new NotFoundException("No such Building.");

	}

}
