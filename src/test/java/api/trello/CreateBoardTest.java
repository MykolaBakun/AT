package api.trello;


import org.testng.Assert;
import org.testng.annotations.Test;

import practice.api.Response;
import practice.api.TrelloBO;

public class CreateBoardTest {
    TrelloBO trelloBO=new TrelloBO();

    @Test
    public void createBoardTest(){
        trelloBO.create();
    }

    @Test
    public void createAndDeleteBoardTest(){
        //Step_1
        String boardId=trelloBO.create();
        //Step_2
        Response deleteResponse=trelloBO.delete(boardId);
        //Validate
        Assert.assertEquals(deleteResponse.getStatusCode().intValue(),200,"invalid code");
    }


}
