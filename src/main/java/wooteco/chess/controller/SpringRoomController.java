package wooteco.chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wooteco.chess.dto.RoomDto;
import wooteco.chess.service.SpringRoomService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class SpringRoomController {

    private final SpringRoomService roomService;

    private SpringRoomController(final SpringRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllRooms(Model model) throws SQLException {
        List<RoomDto> rooms = roomService.findAllRoom();
        model.addAttribute("rooms", rooms);

        return "index";
    }

    @GetMapping("/enter")
    public String enterRoom(@RequestParam(value = "roomId") Integer roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "game";
    }

    // TODO: 2020/04/22 valid 에러페이지 이동 문제
    @GetMapping("/create")
    public String createRoom(@Valid RoomDto roomId, Errors errors, Model model) throws SQLException {
        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            return getAllRooms(model);
        }
        roomService.addRoom(roomId);
        return "redirect:/rooms";
    }

    @GetMapping("/remove")
    public String removeRoom(@RequestParam(value = "roomId") RoomDto roomDto) throws SQLException {
        roomService.removeRoom(roomDto);
        return "redirect:/rooms";
    }
}
