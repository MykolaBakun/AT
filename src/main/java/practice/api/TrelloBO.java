package practice.api;

import antlr.collections.List;
import org.json.JSONArray;
import org.testng.Assert;


import java.util.UUID;

public class TrelloBO {

    public String createBoard() {
        Request createRequest = RequestRepo.createTrelloBoard("Board"+ UUID.randomUUID().toString().substring(0,5));
        Response createResponse=new Client().send(createRequest);
        Assert.assertEquals(createResponse.getStatusCode().intValue(),200,"invalid code");
        return createResponse.getBodyAsJson().getString("id");
    }

    public Response deleteBoard(String boardId) {
        Request deleteRequest = RequestRepo.deleteTrelloBoard(boardId);
        Response deleteResponse=new Client().send(deleteRequest);
        Assert.assertEquals(deleteResponse.getStatusCode().intValue(),200,"invalid code");
        return deleteResponse;
    }

    public Response updateBoard(String boardId) {
        Request req = RequestRepo.updateInfoTrelloBoard(boardId);
        Response res=new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return res;
    }

    public Response customBoard(String boardId, String nameList) {
        Request req = RequestRepo.customTrelloBoard(boardId, nameList);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return res;
    }

    public JSONArray getListIds(String boardId) {
        Request req = RequestRepo.listIdsTrelloBoard(boardId);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return new JSONArray(res.getBody());
    }

    public Response createCard(String idList, String nameCart) {
        Request req = RequestRepo.createCardTrello(idList, nameCart);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return res;
    }

    public JSONArray getCardIdsByList(String IdList) {
        Request req = RequestRepo.getCardIdsByListTrello(IdList);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return new JSONArray(res.getBody());
    }

    public Response moveCard(String idCart, String newIdList) {
        Request req = RequestRepo.moveCardTrello(idCart, newIdList);
        Response res = new Client().send(req);
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
        return res;
    }

}
