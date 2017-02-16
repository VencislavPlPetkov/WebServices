package org.venci.webservices.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.venci.webservices.messenger.model.Message;
import org.venci.webservices.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@QueryParam("year") int year) {

		if (year > 0) {
			messageService.getAllMessagesForYear(year);
		}

		return messageService.getAllMessages();
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {

		Message newMessage = messageService.addMessage(message);

		String newId = String.valueOf(newMessage.getId());

		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();

		return Response.created(uri).entity(newMessage).build();

		// return messageService.addMessage(message);

	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {

		message.setId(messageId);

		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId) {

		messageService.removeMessage(messageId);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {

		Message message = messageService.getMessage(messageId);

		String uri = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(message.getId()))
				.build().toString();

		message.addLink(uri, "self");

		return message;

	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {

		return new CommentResource();
	}

}
