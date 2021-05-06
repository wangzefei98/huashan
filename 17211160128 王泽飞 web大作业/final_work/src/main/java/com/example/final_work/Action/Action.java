package com.example.final_work.Action;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class Action {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world...";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/403")
    public String lanjie(){
        return "403";
    }


//    Integer page_Size;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AdminService adminService;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @RequestMapping(value = "/{page}" ,method = RequestMethod.GET)
//    public String showPage(@PathVariable String page)
//    {
//        return page;
//    }
//
//
//    @PostMapping("/user")
//    public String addUser(User user){
//        System.out.println(user);
//        userService.addUser(user);
//        System.out.println(11);
//        return "ok";
//    }
//
//    @PostMapping("/admin")
//    public String login(Admin admin, HttpSession session){
//        System.out.println(admin);
//
//        if (adminService.login(admin)!=null)
//        {
//            session.setAttribute("userinfo",adminService.login(admin));
//            return "showUsers";
//        }
//        else
//            return "wrong";
//    }
//
//
//    @GetMapping("/users")
//    public String findAllUser(Model model,
//                              @RequestParam(required=true,defaultValue="1") Integer pageNow,
//                              @RequestParam(required=false,defaultValue="5") Integer pageSize){
//        System.out.println(pageNow);
//        page_Size = pageSize;
//        PageHelper.startPage(pageNow,pageSize);
//        List<Employee> list=employeeService.getUserList();
//        PageInfo  pageInfo=new PageInfo<Employee>(list);
//        System.out.println(list);
//        model.addAttribute("pageInfo",pageInfo);
//        model.addAttribute("list",list);
//        return "showUsers";
//    }
//
//
//    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
//    public String addEmp(@Valid Employee employee) {
//        //System.out.println(employee);
//        if (employeeService.addEmp(employee)==1) {
//
//            List<Employee> employees =employeeService.getUserList();
//            PageInfo<Employee> pageInfo = new PageInfo<>(employees);
//            int lastpage = (int) Math.floor(pageInfo.getSize() / page_Size) + 1;
//            return "redirect:/users/users?pageNow=" + lastpage;
//        }
//        return "users/users";
//    }
//
//
//    @RequestMapping(value = "/upemp1/{id}")
//    public String editEmp1(@PathVariable Integer id, Model model){
//        Employee employee = employeeService.findEmpbyId(id);
//        model.addAttribute("emp", employee);
//        return "empmodify";
//    }
//    @RequestMapping(value = "/upemp2")
//    public String editEmp2(Employee employee){
//        if(employeeService.updateEmp(employee)==1){
//            return "redirect:/users/users";
//        }
//        return "admin";
//    }
//
//
//    @RequestMapping(value = "/DelEmp/{id}")
//    public String deleteEmp(@PathVariable Integer id){
//        if(employeeService.deleteEmp(id)==1){
//            return "redirect:/users/users";
//        }
//        return "admin";
//    }
//    //17211160128 王泽飞
//    @ResponseBody
//    @RequestMapping(value="/users/{ids}",method=RequestMethod.DELETE)
//    public String deleteEmp2(@PathVariable("ids")String ids){
//        System.out.println(ids);
//        if(ids.contains("-")){
//            String[] str_ids = ids.split("-");
//            for (String id : str_ids) {
//                employeeService.deleteEmp(Integer.valueOf(id));
//            }
//        }else{
//            Integer id = Integer.parseInt(ids);
//            employeeService.deleteEmp(id);
//        }
//        return "success";
//    }

}
