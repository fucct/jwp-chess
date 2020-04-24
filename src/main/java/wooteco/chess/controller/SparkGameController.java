package wooteco.chess.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;
import wooteco.chess.domain.Color;
import wooteco.chess.service.GameService;

import java.sql.SQLException;

public class SparkGameController {
//    public static final String BASIC_URL = "/game";
//    public static final String MOVE_URL = BASIC_URL + "/move";
//    public static final String STATUS_URL = BASIC_URL + "/status";
//    public static final String INIT_URL = BASIC_URL + "/init";
//    public static final String LOAD_URL = BASIC_URL + "/load";
//    public static final String GET_URL = BASIC_URL + "/get";
//
//    public static String initGame(Request request, Response response) throws SQLException {
//        GameService gameService = GameService.getInstance();
//        int roomId = Integer.parseInt(request.queryParams("roomId"));
//        gameService.initialize(roomId);
//
//        Gson gson = new Gson();
//        JsonObject object = new JsonObject();
//        String pieces = gson.toJson(gameService.getPiecesResponseDTO(roomId).getPieces());
//        String currentColor = gameService.getCurrentColor(roomId);
//
//        object.addProperty("pieces", pieces);
//        object.addProperty("currentColor", currentColor);
//
//        return gson.toJson(object);
//    }
//
//    public static String movePiece(Request request, Response response) throws SQLException {
//        GameService gameService = GameService.getInstance();
//
//        int roomId = Integer.parseInt(request.queryParams("roomId"));
//        String sourcePosition = request.queryParams("sourcePosition");
//        String targetPosition = request.queryParams("targetPosition");
//        gameService.movePiece(roomId, sourcePosition, targetPosition);
//        boolean kingDead = gameService.isKingDead(roomId);
//        String currentColor = gameService.getCurrentColor(roomId);
//
//        Gson gson = new Gson();
//        JsonObject object = new JsonObject();
//        String pieces = gson.toJson(gameService.getPiecesResponseDTO(roomId).getPieces());
//
//        object.addProperty("pieces", pieces);
//        object.addProperty("kingDead", kingDead);
//        object.addProperty("currentColor", currentColor);
//
//        return gson.toJson(object);
//    }
//
//    public static String showStatus(Request request, Response response) throws SQLException {
//        GameService gameService = GameService.getInstance();
//        int roomId = Integer.parseInt(request.queryParams("roomId"));
//
//        double whiteScore = gameService.getScore(roomId, Color.WHITE);
//        double blackScore = gameService.getScore(roomId, Color.BLACK);
//
//        Gson gson = new Gson();
//        JsonObject object = new JsonObject();
//
//        object.addProperty("whiteScore", whiteScore);
//        object.addProperty("blackScore", blackScore);
//
//        return gson.toJson(object);
//    }
//
//    public static String loadGame(Request request, Response response) throws SQLException {
//        GameService gameService = GameService.getInstance();
//        int roomId = Integer.parseInt(request.queryParams("roomId"));
//
//        Gson gson = new Gson();
//        JsonObject object = new JsonObject();
//        String pieces = gson.toJson(gameService.getPiecesResponseDTO(roomId).getPieces());
//        String currentColor = gameService.getCurrentColor(roomId);
//
//        object.addProperty("pieces", pieces);
//        object.addProperty("currentColor", currentColor);
//
//        return gson.toJson(object);
//    }
//
//    public static String getMovablePositions(final Request request, final Response response) throws SQLException {
//        GameService gameService = GameService.getInstance();
//        int roomId = Integer.parseInt(request.queryParams("roomId"));
//        String sourcePosition = request.queryParams("sourcePosition");
//
//        Gson gson = new Gson();
//
//        return gson.toJson(gameService.getMovablePositions(roomId, sourcePosition));
//    }
}
