package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class UsersView implements View {
    private Controller controller;

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    @Override
    public void refresh(ModelData modelData) {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }
        for (int i = 0; i < modelData.getUsers().size(); i++) {
            System.out.println("\t" + modelData.getUsers().get(i));
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

}
