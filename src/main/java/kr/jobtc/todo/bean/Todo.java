package kr.jobtc.todo.bean;

import lombok.Data;

@Data
public class Todo {
    int sno;
    String nal;
    String doc;
    String chk;
    public Todo(){}
    public Todo(String doc, String chk){
        this.doc = doc;
        this.chk = chk;
    }
}
