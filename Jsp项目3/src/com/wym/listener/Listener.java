package com.wym.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    public static int count=0;
    // Public constructor is required by servlet spec
    public Listener() {
    }


    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
      ++count;
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
      --count;
    }


}
