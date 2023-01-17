package ui;

import ctrl.Ctrl;
import db.Db;
import db.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui {

    public void menu() {

        JFrame f = new JFrame("Company");
        f.setSize(380, 280);
        f.setLocation(770, 480);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel("Choose option");
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        f.add(label, c);

        JRadioButton addWorker = new JRadioButton("addWorker");
        addWorker.setActionCommand("addWorker");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        f.add(addWorker, c);

        JRadioButton updateWorker = new JRadioButton("updateWorker");
        updateWorker.setActionCommand("updateWorker");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 2;
        f.add(updateWorker, c);

        JRadioButton deleteWorker = new JRadioButton("deleteWorker");
        deleteWorker.setActionCommand("deleteWorker");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 3;
        f.add(deleteWorker, c);

        JRadioButton showWorkers = new JRadioButton("showWorkers");
        showWorkers.setActionCommand("showWorkers");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 4;
        f.add(showWorkers, c);

        JRadioButton getWorkerByName = new JRadioButton("getWorkerByName");
        getWorkerByName.setActionCommand("getWorkerByName");
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 5;
        f.add(getWorkerByName,c);

        ButtonGroup choices = new ButtonGroup();
        choices.add(deleteWorker);
        choices.add(showWorkers);
        choices.add(addWorker);
        choices.add(updateWorker);
        choices.add(getWorkerByName);

        JButton button = new JButton("get");
        button.setPreferredSize(new Dimension(100, 30));
        c = new GridBagConstraints();
        c.insets = new Insets(0,10,0,10);
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 1;
        f.add(button, c);


        JButton closeButton = new JButton("close");
        closeButton.setPreferredSize(new Dimension(100, 30));
        c = new GridBagConstraints();
        c.insets = new Insets(0,10,0,10);
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 4;
        f.add(closeButton, c);

        Ctrl ctrl = new Ctrl();
        ctrl.ui = new Ui();
        ctrl.db = new Db();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = choices.getSelection().getActionCommand();

                switch (option) {
                    case "addWorker" -> ctrl.addWorker();
                    case "updateWorker" -> ctrl.updateWorker();
                    case "deleteWorker" -> ctrl.deleteWorker();
                    case "showWorkers" -> ctrl.showWorkers();
                    case "getWorkerByName" -> ctrl.getWorkerByName();
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    public int getId() {
        int selectedId = 0;
        while (true) {
            try {
                selectedId = Integer.parseInt(JOptionPane.showInputDialog("Enter Id"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter valid ID");
            }
        }
        return selectedId;
    }

    public Worker getWorker() {

        Worker worker = new Worker();
        while (worker.name == null) {
            String name =  JOptionPane.showInputDialog("Insert worker's name");
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty");
                continue;
            }
            worker.name = name;
        }

        String age;
        while (true) {
            try{
                age = JOptionPane.showInputDialog("Insert worker's age");
                if (age.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Age cannot be empty");
                    continue;
                }
                worker.age = Integer.parseInt(age);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter a number");
            }
        }

        while (worker.address == null) {
            String address =  JOptionPane.showInputDialog("Insert worker's address");
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address cannot be empty");
                continue;
            }
            worker.address = address;
        }

        String salary;
        while (true) {
            try{
                salary = JOptionPane.showInputDialog("Insert worker's salary");
                if (salary.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "salary cannot be empty");
                    continue;
                }
                worker.salary = Integer.parseInt(salary);
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter a number");
            }
        }
        return worker;
    }

    public void updateWorker (Worker w) {

        String name = JOptionPane.showInputDialog("Insert worker's name");
        if(!name.isEmpty()) {
            w.name = name;
        }

        String age = JOptionPane.showInputDialog("Insert worker's age");
        if(!age.isEmpty()) {
            w.age = Integer.parseInt(age);
        }

        String address = JOptionPane.showInputDialog("Insert worker's address");
        if(!address.isEmpty()) {
            w.address = address;
        }

        String salary = JOptionPane.showInputDialog("Insert worker's salary");
        if(!salary.isEmpty()) {
            w.salary = Integer.parseInt(salary);
        }
    }

    public String showWorkerByName() {
        String selectedWorker;
        while (true) {
            selectedWorker = JOptionPane.showInputDialog("Insert worker's name");
            if(selectedWorker.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty");
                continue;
            }
            break;
        }
        return selectedWorker;
    }
}
