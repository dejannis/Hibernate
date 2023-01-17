package ctrl;

import db.Db;
import ui.Ui;

public class App {

    public static void launch() {

        Ctrl ctrl = new Ctrl();

        ctrl.ui = new Ui();
        ctrl.db = new Db();

        /*mainLoop:
        while (true) {
            int item = ctrl.ui.menu();

            switch (item) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    ctrl.deleteWorker();
                    break;
                case 4:
                    ctrl.showWorkers();
                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                    break; //mainLoop;
            }

        }*/
    }
}