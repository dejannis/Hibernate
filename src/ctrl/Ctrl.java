package ctrl;

import db.Db;
import db.Worker;
import ui.Ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ctrl {

    public Ui ui;
    public Db db;

    public void showWorkers() {
        List<Worker> allWorkers = db.getAllWorkers();

        JFrame f = new JFrame();
        f.setSize(500, 250);
        f.setLocation(720, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        JTextArea ta = new JTextArea(10, 40);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta);
        f.add(ta);
        f.add(sp);
        JButton button = new JButton("close");
        f.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        ta.append("All workers:" + "\n");
        for (int i = 0; i < allWorkers.size(); i++) {
            ta.append(String.valueOf(allWorkers.get(i) + "\n"));
        }
        f.setVisible(true);
    }

    public void deleteWorker(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insert worker's id to delete"));
        Worker worker = db.getWorker(id);
        if(worker == null) {
            JOptionPane.showMessageDialog(null, "There is no worker with this id");
            return;
        }
        db.deleteWorker(id);
    }

    public void addWorker() {
        Worker worker = ui.getWorker();
        db.insertWorker(worker);
    }

    public void updateWorker() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insert worker's id to update"));
        Worker worker = db.getWorker(id);
        if(worker == null) {
            JOptionPane.showMessageDialog(null, "There is no worker with this id");
            return;
        }
        ui.updateWorker(worker);
        db.updateWorker(worker);
    }

    public void getWorkerByName() {
        String name = ui.showWorkerByName();
        Worker worker = db.getWorkerByName(name);
        if(worker == null) {
            JOptionPane.showMessageDialog(null, "There is no worker with this name");
        } else {
            JFrame f = new JFrame();
            f.setSize(500, 250);
            f.setLocation(720, 200);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(new FlowLayout());

            JTextArea ta = new JTextArea(10, 40);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            JScrollPane sp = new JScrollPane(ta);
            f.add(ta);
            f.add(sp);
            JButton button = new JButton("close");
            f.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                }
            });
            ta.append("Worker's name:" + "\n");
            ta.append(String.valueOf(worker));
            f.setVisible(true);
        }
    }
}
