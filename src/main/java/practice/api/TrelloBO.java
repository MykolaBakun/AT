package practice.api;

import org.testng.Assert;


import java.util.UUID;

public class TrelloBO {

    public String create() {
        Request createRequest = RequestRepo.createTrelloBoard("Board"+ UUID.randomUUID().toString().substring(0,5));
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }

    public Response delete(String boardId) {
        Request deleteRequest = RequestRepo.deleteTrelloBoard(boardId);
        Response deleteResponse=new Client().send(deleteRequest);
        Assert.assertEquals(deleteResponse.getStatusCode().intValue(),200,"invalid code");
        return deleteResponse;
    }
}
