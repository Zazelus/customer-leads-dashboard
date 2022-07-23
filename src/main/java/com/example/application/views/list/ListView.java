package com.example.application.views.list;

import com.example.application.data.entity.Contact;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Contacts | CL Dashboard")
@Route(value = "")
public class ListView extends VerticalLayout {

    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField filterText = new TextField();

    public ListView() {
        addClassName("list-view");
        setSizeFull();

        configureGrid();
    }

    /**
     * Sets some attributes for our contact-containing grid.
     */
    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName", "email");
        grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void closeEditor() {
        // TO-DO
    }

    public void editContact(Contact contact) {
        // TO-DO
    }

    void addContact() {
        grid.asSingleSelect().clear();
        editContact(new Contact());
    }

    private void updateList() {
        // TO-DO
    }

    private void saveContact() {
        // TO-DO
    }

    private void deleteContact() {
        // TO-DO
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact");
        addContactButton.addClickListener(click -> addContact());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

}
