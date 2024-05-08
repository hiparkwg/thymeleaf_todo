package kr.jobtc.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ThymeleafTestController {

    @RequestMapping(value="/")
    public String index(){
        return "hi thymeleaf";
    }

    @RequestMapping(value="/message")
    public ModelAndView message(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("message");
        return mv;
    }

    @RequestMapping(value="/list")
    public List list(){
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(new String[]{"a","b","c","d"}));
        return list;
    }

    @RequestMapping(value="/map")
    public Map map(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "hong");
        map.put("address", "대구");
        map.put("email", "hong@korea.com");
        return map;
    }

    @RequestMapping(value="/calc")
    public String calc(){
        String str = String.format("%s * %s = %s", 10, 20, (10*20));
        return str;
    }

    @RequestMapping(value="/gugudan")
    public String gugudan(){
        StringBuffer sb = new StringBuffer();
        int dan = 5;

        for(int i=1 ; i<10 ; i++){
            sb.append(String.format("%s * %s = %s<br/>", i, dan, (i*dan)));
        }
        return sb.toString();
    }

    @RequestMapping(value="/json")
    public String json(){
        JSONObject obj = new JSONObject();
        obj.put("name", "hong");

        return obj.toString();
    }

    @RequestMapping(value="/json_array")
    public String jsonArray(){
        JSONArray array = new JSONArray();

        array.add("kim");
        array.add("lee");
        array.add("park");
        array.add("choi");

        return array.toJSONString();
    }

    @RequestMapping(value="/view")
    public ModelAndView view(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "hong gil dong!!!");
        mv.setViewName("view");
        return mv;
    }

    @RequestMapping(value="/status")
    public ModelAndView status(){
        ModelAndView mv = new ModelAndView();
        String[] data = new String[]{"kim","hong","park","choi","nam", "lee"};
        List<String> list = new ArrayList<>(Arrays.asList(data));     
        mv.addObject("list",list);
        mv.setViewName("status");
        return mv;
    }

    @RequestMapping(value="/choice")
    public ModelAndView choice(){
        ModelAndView mv = new ModelAndView();
        Map<String, String> map = new HashMap<>();
        map.put("name", "hong");
        map.put("address", "대구");
        map.put("email", "hong@korea.com");
        mv.addObject("map", map);
        mv.setViewName("choice");
        return mv;
    }

    @RequestMapping(value="flag")
    public ModelAndView flag(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("flag_main");
        return mv;
    }

 }
