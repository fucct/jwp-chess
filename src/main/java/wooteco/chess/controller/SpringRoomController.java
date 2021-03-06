package wooteco.chess.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import wooteco.chess.dto.AuthorizeDto;
import wooteco.chess.dto.RoomRequestDto;
import wooteco.chess.dto.RoomResponseDto;
import wooteco.chess.service.SpringRoomService;

@Controller
@RequestMapping("/rooms")
public class SpringRoomController {

    private final SpringRoomService roomService;

    private SpringRoomController(final SpringRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllRooms(Model model) throws SQLException {
        List<RoomResponseDto> rooms = roomService.findAllRoom();
        model.addAttribute("rooms", rooms);

        return "index";
    }

    @PostMapping("/enter/{id}")
    public String enterRoom(@PathVariable Long id, @RequestParam Boolean loginSuccess,
        Model model, RedirectAttributes redirectAttributes) throws SQLException {
        if (loginSuccess) {
            model.addAttribute("roomId", id);
            return "game";
        }
        redirectAttributes.addFlashAttribute("authorizeError", "wrongPassword");
        return "redirect:/rooms";
    }

    @PostMapping("/create")
    public String createRoom(@Valid RoomRequestDto roomRequestDto, BindingResult bindingResult,
        Model model) throws SQLException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("nameError", bindingResult.getFieldError("name"));
            model.addAttribute("passwordError", bindingResult.getFieldError("password"));
            return getAllRooms(model);
        }
        roomService.addRoom(roomRequestDto);
        return "redirect:/rooms";
    }

    @PostMapping("/remove/{id}")
    public String removeRoom(@PathVariable Long id, @RequestParam Boolean loginSuccess,
        RedirectAttributes redirectAttributes) throws SQLException {
        if (loginSuccess) {
            roomService.removeRoom(id);
            return "redirect:/rooms";
        }
        redirectAttributes.addFlashAttribute("authorizeError", "wrongPassword");
        return "redirect:/rooms";
    }

    @PostMapping("/authorize")
    @ResponseBody
    public boolean authorize(@Valid @RequestBody AuthorizeDto authorizeDto) {
        if (Objects.nonNull(authorizeDto.getPassword())) {
            return roomService.authorize(authorizeDto.getId(), authorizeDto.getPassword());
        }
        return false;
    }
}
