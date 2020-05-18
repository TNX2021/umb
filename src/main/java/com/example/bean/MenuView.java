package com.example.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ManagedBean
public class MenuView {

    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        //Submenus PATIENTS APPOINTMENTS & COLLEGIES
        DefaultSubMenu patients = new DefaultSubMenu("Пациенты");
        DefaultSubMenu appointments = new DefaultSubMenu("Посещения");
        DefaultSubMenu doctors = new DefaultSubMenu("Коллеги");
        //2 MENU ITEMS
        DefaultMenuItem patientsList = new DefaultMenuItem("Список пациентов");
        DefaultMenuItem findPatById = new DefaultMenuItem("Найти пациента по ID");
        //ADDING PATIENTS MENU ITEMS TO SUBMENU PATIENTS
        patients.getElements().add(patientsList);
        patients.getElements().add(findPatById);
        //SUBMENU APPOINTMNETS
        DefaultMenuItem appointmentsList = new DefaultMenuItem("Список посещений");
        DefaultMenuItem findAppbyId = new DefaultMenuItem("Найти посещение по ID");
        DefaultMenuItem addApp = new DefaultMenuItem("Добавить посещение");
        //ADDING APPOINTMENTS MENU ITEMS TO SUBMENU APPOINTMNETS
        appointments.getElements().add(appointmentsList);
        appointments.getElements().add(findAppbyId);
        appointments.getElements().add(addApp);
        //

    }

    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Success", "Data saved");

    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void showPatientList()
    {
        FacesContext.getCurrentInstance().getApplication().createComponent("dataTable");
    }
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}