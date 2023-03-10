package com.example.atividadeservletboasvindas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;

@WebServlet(name = "greetingsServlet", value = "/saudacao")
public class GreetingsServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");

        int currentTime = LocalTime.now().getHour();

        String msg;
        if (currentTime > 6 && currentTime <= 12) {
            msg = "Bom dia";
        } else if (currentTime > 12 && currentTime <= 18) {
            msg = "Boa tarde";
        } else msg = "Boa noite";

        req.setAttribute("msg", String.format(msg));
        res.setHeader("msg", String.format(msg));
        req.setAttribute("name", String.format(name));
        res.setHeader("name", String.format(name));
        req.getRequestDispatcher("/greetings.jsp").forward(req, res);
    }
}