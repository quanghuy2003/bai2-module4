package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }


    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @PostMapping("/validate")
    String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            return "index";
        }

        model.addAttribute("email", email);
        return "success";
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }


    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }



//    @GetMapping ("/tong")
//    public String tong (Model model, @RequestParam int a, int b) {
//        model.addAttribute("tong", a + b);
//        return "index";
//    }
//
//    @GetMapping ("/hieu")
//    public String hieu (Model model, @RequestParam int a, int b) {
//        model.addAttribute("hieu", a - b);
//        return "index";
//    }
//
//    @GetMapping ("/tich")
//    public String tich (Model model, @RequestParam int a, int b) {
//        model.addAttribute("tich", a * b);
//        return "index";
//    }
//
//    @GetMapping ("/thuong")
//    public String thuong (Model model, @RequestParam int a, int b) {
//        model.addAttribute("hieu", a / b);
//        return "index";
//    }

    @GetMapping
    public String showIndex() {
        return "index";
    }

    @GetMapping("/cal")
    public String showResult(Model model, @RequestParam String cal, int a1, int b2) {
        int result=0;
        switch (cal) {
            case "tong":
                result = a1 + b2;
                break;
            case "hieu":
                result = a1 - b2;
                break;
            case "thuong":
                result = a1 / b2;
                break;
            case "tich":
                result = a1 * b2;
                break;

        }
        model.addAttribute("result",result);
        return "result";
    }

}
