package com.john.sc.easymock.service;

import com.john.sc.easymock.ifc.Collaborator;
import lombok.Data;

@Data
public class ClassUnderTest {
    private Collaborator collaborator;

    public void setListener(Collaborator listener) {
        this.collaborator = listener;
    }

    public String removeDocument(String msg) {
       return collaborator.documentRemoved(msg);
    }
}
