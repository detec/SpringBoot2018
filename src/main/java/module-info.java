module SampleBoot {
    requires javax.transaction.api;
    requires com.fasterxml.jackson.databind;
    requires javax.servlet.api;
    requires hibernate.jpa;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.tx;
    requires spring.web;
    requires spring.webmvc;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires org.slf4j;
}