package com.nhnacademy.jdbc.board.index.web;

import com.nhnacademy.jdbc.board.board.domain.Board;
import com.nhnacademy.jdbc.board.board.domain.CreateRequestBoard;
import com.nhnacademy.jdbc.board.board.exception.BoardNotExistException;
import com.nhnacademy.jdbc.board.board.exception.BoardNotFoundException;
import com.nhnacademy.jdbc.board.board.mapper.BoardMapper;
import com.nhnacademy.jdbc.board.board.service.BoardService;
import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.exception.UserNotFoundException;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@Controller
public class BoardListController {

    private final UserMapper userMapper;
    private final UserService userService;
    private final BoardMapper boardMapper;
    private final BoardService boardService;

    public BoardListController(UserMapper userMapper, UserService userService, BoardMapper boardMapper, BoardService boardService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.boardMapper = boardMapper;
        this.boardService = boardService;
    }



    @ModelAttribute("boardList")
    public List<Board> getBoardList(){
        return boardService.getAllBoardList();
    }


    @GetMapping("/board")
    public String boardListViewController(Model model){
        List<Board> boards = boardService.getAllBoardList();

        model.addAttribute("boardList", boards);

        return "boardList";
    }


    @GetMapping("/create")
    public String boardCreateViewController(){
        return "boardCreateForm";
    }

    @PostMapping("/create")
    public String boardCreatePostController(@ModelAttribute CreateRequestBoard board,
                                            Model model, HttpServletRequest request){

        String id = (String) request.getSession().getAttribute("userName");
        Optional<User> user = userService.getUserName(id);


        if(user.isPresent()){
            boardService.addBoard(board.getTitle(), board.getContent(), id, user.get().getId());
            return "redirect:/board";
        }
        throw new UserNotFoundException();
    }

    @GetMapping("/board/{boardId}")
    public String boardDetailViewController(@PathVariable(value ="boardId" ,required = false)Long boardId,
                                            Model model){
        Optional<Board> op = boardService.getBoard(boardId);

        if(op.isPresent()){
            Board board = op.get();
            model.addAttribute("board", board);
            return "boardDetail";
        }

        throw new BoardNotExistException();
    }


    @ExceptionHandler(UserNotFoundException.class)
    public String UserNotFound(Model model){
        model.addAttribute("userNotFoundException", UserNotFoundException.class);

        return "redirect/create";
    }


}
