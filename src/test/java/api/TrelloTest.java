package api;


import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.api.Response;
import practice.api.TrelloBO;

public class TrelloTest {
    TrelloBO trelloBO=new TrelloBO();

    @Test
    public void createBoardTest(){
        trelloBO.createBoard();
    }

    @Test
    public void deleteBoardByIdTest(){
        //Step_1
        String boardId="hCba3vq7";
        //Step_2
        Response res=trelloBO.deleteBoard(boardId);
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }

    @Test
    public void updateBoardTest(){
        //Step_1
        String boardId=trelloBO.createBoard();
        //Step_2
        Response res=trelloBO.updateBoard(boardId);
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }

    @Test
    public void createCustomListsTest(){
        //Step_1
        String boardId=trelloBO.createBoard();
        //Step_2
        Response res1=trelloBO.customBoard(boardId, "Want");
        Response res2=trelloBO.customBoard(boardId, "Buy");
        Response res3=trelloBO.customBoard(boardId, "Use");
        //Validate
        Assert.assertEquals(res1.getStatusCode().intValue(),200,"invalid code");
        Assert.assertEquals(res2.getStatusCode().intValue(),200,"invalid code");
        Assert.assertEquals(res3.getStatusCode().intValue(),200,"invalid code");
    }

    @Test
    public void createCustomBoardTest(){
        //Step1 createBoard
        String boardId = trelloBO.createBoard();
        //Step2 Get Lists on a Board
        String listId = trelloBO.getListIds(boardId).getJSONObject(0).get("id").toString();
        System.out.println(listId);
        //Step3 Create a new Card
        Response res = trelloBO.createCard(listId, "Car");
        System.out.println(res.getBody());
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }

    @Test
    public void moveCardOnListTest(){
        //Step1 createBoard
        String boardId = trelloBO.createBoard();
        //Step2 Change Name
        trelloBO.updateBoard(boardId);
        //Step3 create two List
        trelloBO.customBoard(boardId, "List1");
        trelloBO.customBoard(boardId, "List2");
        //Step4 Get Lists on a Board
        JSONArray listIds = trelloBO.getListIds(boardId);
        String listId = listIds.getJSONObject(0).get("id").toString();
        //Step5 Create two new Card
        trelloBO.createCard(listId, "Card1");
        trelloBO.createCard(listId, "Card2");
        //Step6 Get first a Card
        String cardId = trelloBO.getCardIdsByList(listId).getJSONObject(0).get("id").toString();
        //Step7 Move Card
        listId = listIds.getJSONObject(1).get("id").toString();
        Response res = trelloBO.moveCard(cardId, listId);
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }
}

//61a51dd34acd696f0df54e56
