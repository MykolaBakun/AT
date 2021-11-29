package practice.api;

import practice.api.Request;


public class RequestRepo {

    public static Request getPostman() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("postman-echo.com");
        request.setPath("get");
        request.setMethod("GET");
        return request;
    }

    private static Request baseTrelloRequest() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("api.trello.com");
        return request;
    }

    private final static String KEY=Credentials.MyKey;
    private final static String TOKEN=Credentials.MyToken;

    public static Request createTrelloBoard(String boardName) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/?name="+ boardName+ "&defaultLists=false&key="+ KEY + "&token=" + TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request deleteTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?key=" + KEY + "&token=" + TOKEN);
        request.setMethod("DELETE");
        return request;
    }

    public static Request updateInfoTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?name=AT&desc=Test&prefs/background=red&key=" + KEY + "&token=" + TOKEN);
        request.setMethod("PUT");
        return request;
    }

    public static Request customTrelloBoard(String boardId, String nameList) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/" + boardId + "/lists?name=" + nameList + "&pos=bottom&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request listIdsTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/" + boardId + "/lists?key="+KEY + "&token="+TOKEN);
        request.setMethod("GET");
        return request;
    }

    public static Request createCardTrello(String idList, String nameCart) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards?idList=" + idList + "&name=" + nameCart + "&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request getCardIdsByListTrello(String idList) {
        Request request=baseTrelloRequest();
        request.setPath("1/lists/" + idList + "/cards?key="+ KEY + "&token="+ TOKEN);
        request.setMethod("GET");
        return request;
    }

    public static Request moveCardTrello(String idCart, String newIdList) {
        Request request=baseTrelloRequest();
        request.setPath("1/cards/" + idCart + "?idList=" + newIdList + "&key="+ KEY + "&token="+ TOKEN);
        request.setMethod("PUT");
        return request;
    }
}
