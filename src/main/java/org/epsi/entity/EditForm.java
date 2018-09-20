package org.epsi.entity;

import java.util.List;

import javax.validation.Valid;

public class EditForm {

    @Valid
    private List<EditFromClient> client;
    @Valid
    private Client client1;

    public void setEditListClient(final List<EditFromClient> listeClient) {
    	client = listeClient;
    }

    public List<EditFromClient> getEditListClient() {
        return client;
    }

	public void setEditClient(final Client myClient) {
		client1 = myClient;
	}
    
    public Client getEditClient() {
    	return client1;
    }
}