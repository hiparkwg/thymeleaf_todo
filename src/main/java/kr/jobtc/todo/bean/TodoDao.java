package kr.jobtc.todo.bean;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.jobtc.todo.mybatis.MyFactory;

@Component
public class TodoDao {
    SqlSession session;

    public TodoDao(){
        session = MyFactory.getSession();
    }

    public List<Todo> list(Todo vo){
        String findStr="";
        findStr = vo.getDoc();
        List<Todo> list = session.selectList("todo.list", findStr);
        return list;
    }
    public boolean register(Todo vo){
        boolean b=true;
        int cnt = session.insert("todo.insert", vo);
        if(cnt>0){
            session.commit();
        }else{
            b=false;
            session.rollback();
        }
        return b;
    }
    public boolean update(Todo vo){
        boolean b=true;
        int cnt = session.update("todo.update", vo);
        if(cnt>0){
            session.commit();
        }else{
            b=false;
            session.rollback();
        }
        return b;
    }

    public boolean delete(int sno){
        boolean b=true;
        int cnt = session.delete("todo.delete", sno);
        if(cnt>0){
            session.commit();
        }else{
            b=false;
            session.rollback();
        }
        return b;
    }
}
