package com.javarush.task.task32.task3209.listeners;

/**
 * Created by Sukora Stas.
 */

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * он должен реализовывать интерфейс MenuListener и иметь
 * конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem
 * redoMenuItem).
 */
public class UndoMenuListener implements MenuListener {

    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(MenuEvent e) {
//        Спрашивать у представления можем ли мы отменить действие
//        Делать доступным или не доступным пункт меню undoMenuItem в зависимости от того, что нам вернуло представление
        if (view.canUndo()) {
            undoMenuItem.setEnabled(true);
        }
        else if (!view.canUndo()) {
            undoMenuItem.setEnabled(false);
        }
        //Аналогично поступи и для пункта меню redoMenuItem
        if (view.canRedo()) {
            redoMenuItem.setEnabled(true);
        }
        else if (!view.canRedo()) {
            redoMenuItem.setEnabled(false);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

}
