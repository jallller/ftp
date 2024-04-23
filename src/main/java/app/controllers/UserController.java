package app.controllers;

import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.UserMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {

        app.post("login", ctx -> login(ctx,connectionPool));
    }

    public static void login(Context ctx, ConnectionPool connectionPool) {

        //Hent formaparametre
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        //Check om bruger findes i db

        try {
            User user = UserMapper.login(username,password,connectionPool);
            //Hvis ja - send videre til task
            ctx.render("task.html");
        } catch (DatabaseException e) {
            //Hvis nej - tilbage til loginside med fejbesked
            ctx.attribute("message",e.getMessage());
            ctx.render("index.html");
        }








    }
}
