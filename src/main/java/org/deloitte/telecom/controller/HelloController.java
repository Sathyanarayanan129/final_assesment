package org.deloitte.telecom.controller;

import org.deloitte.telecom.dto.SessionData;
import org.deloitte.telecom.exceptions.MobileNoAlreadyExistsException;
import org.deloitte.telecom.entities.Account;
import org.deloitte.telecom.service.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {
    private static Logger Log= LoggerFactory.getLogger(HelloController.class);

    private AccountServiceImpl service;

    public AccountServiceImpl getService() {
        return service;
    }

    @Autowired
    public void setService(AccountServiceImpl service) {
        this.service = service;
    }

    private SessionData sessionData;

    @Autowired
    public void setSessionData(SessionData data) {
        this.sessionData = data;

    }

    public SessionData getSessionData() {
        return sessionData;
    }


    @GetMapping("/userinput")
    public ModelAndView userInput() {
        return new ModelAndView("userinput");
    }

    @GetMapping("/logincheck")
    public RedirectView loginCheck(@RequestParam("phone") String phone,
                                   @RequestParam("password") String password) {
        boolean correct = service.checkCredentialsByMobileNo(phone, password);
        System.out.println("correct="+correct);
        if (!correct) {
            return new RedirectView("/userinput");
        }
        Account user = service.findByMobileNo(phone);
        sessionData.setAccount(user);
        return new RedirectView("/home");
    }


    @GetMapping("/home")
    public Object home() {
        if (sessionData.getAccount() == null) {
            return new RedirectView("/userinput");
        }
        Account appUser = sessionData.getAccount();
        ModelAndView mv = new ModelAndView("home", "user", appUser);
        return mv;
    }


    @GetMapping("/processregister")
    public RedirectView processRegister(@RequestParam("name") String name,
                                        @RequestParam("phone")String phone,
                                        @RequestParam("password") String password,
                                        @RequestParam("accountType") String accountType,
                                        @RequestParam("balance") double balance) {
        Account user = new Account(name, password);
        user.setAccountType(accountType);
        user.setBalance(balance);
        user.setMobileNo(phone);
        user.setPassword(password);
        user = service.save(user);
        sessionData.setAccount(user);
        return new RedirectView("/home");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/register");
    }

    @GetMapping("/signout")
    public RedirectView signout() {
        sessionData.setAccount(null);
        return new RedirectView("/userinput");
    }

    @GetMapping("/error")
    public ModelAndView error(){
        return new ModelAndView("error","message","something went wrong");
    }

    @ExceptionHandler(MobileNoAlreadyExistsException.class)
    public ModelAndView handleIfMobileNumberAlreadyExists(MobileNoAlreadyExistsException e){
      return new ModelAndView("error","message","mobile number already exists");
    }

    @ExceptionHandler(value = Throwable.class)
    public ModelAndView catchAll(Throwable e){
        e.printStackTrace();
      return new ModelAndView("error","message","Something went wrong");
    }


}
