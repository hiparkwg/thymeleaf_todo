package kr.jobtc.todo.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TodoController {
    @Autowired
    TodoDao dao;
    
    @RequestMapping(path="/todo_list")
    public ModelAndView list(Todo vo){
        ModelAndView mv = new ModelAndView();
        List<Todo> list = dao.list(vo);
        mv.addObject("list", list);
        mv.addObject("doc", vo.getDoc());
        mv.setViewName("todo/list");
        return mv;
    }

    @RequestMapping(path="/todo_register")
    public ModelAndView register(Todo vo){
        ModelAndView mv = null;
        String msg = "저장중 오류 발생";

        boolean b = dao.register(vo);
        if(b) msg = "";

        mv = list(new Todo());
        mv.addObject("msg", msg);
        return mv;
    }
    
    @RequestMapping(path="/todo_update")
    public ModelAndView update(Todo vo){
        ModelAndView mv = null;
        String msg = "수정중 오류 발생";

        boolean b = dao.update(vo);
        if(b) msg="aaa";
        mv = list(new Todo());
        mv.addObject("msg", msg);
        return mv;
    }
    @RequestMapping(path="/todo_delete")
    public ModelAndView delete(Todo vo){
        ModelAndView mv = null;
        String msg = "삭제중 오류 발생";
        boolean b = dao.delete(vo.getSno());
        if(b) msg="aaa";
        mv = list(new Todo());
        mv.addObject("msg", msg);

        return mv;
    }



}
