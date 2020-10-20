package ikbo.prak12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    JMenu menu;
    JMenuItem a1, a2, a3, a4;
    ICreateDocuments documentsFabric;
    IDocument document;
    JTextArea txtaNotepad = new JTextArea();
    JScrollPane scrollBar = new JScrollPane(txtaNotepad);
    App(ICreateDocuments documentsFabric) {
        super("Work with File");
        this.documentsFabric = documentsFabric;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocation(700, 400);

        JMenuBar m1 = new JMenuBar();

        menu = new JMenu("File");
        a1 = new JMenuItem("New");
        a2 = new JMenuItem("Open");
        a3 = new JMenuItem("Save");
        a4 = new JMenuItem("Exit");

        a1.addActionListener(new FileNew());
        a2.addActionListener(new FileOpen());
        a3.addActionListener(new FileSave());
        a4.addActionListener(new FileExit());

        menu.add(a1);
        menu.add(a2);
        menu.add(a3);
        menu.add(a4);

        m1.add(menu);

        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        txtaNotepad.setLineWrap(true);
        txtaNotepad.setEnabled(false);
        add(scrollBar);
        // Размещаем нашу панель в панели содержим0ого
        setJMenuBar(m1);

        setVisible(true);
    }

    class FileNew implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Создает");
            document = documentsFabric.CreateNew();
            txtaNotepad.setText("");
            txtaNotepad.setEnabled(true);
        }
    }

    class FileOpen implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Открывает");
            document = documentsFabric.CreateOpen();
            txtaNotepad.setText((String)document.getContent());
            txtaNotepad.setEnabled(true);
        }
    }

    class FileSave implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (document != null) {
                document.setContent(txtaNotepad.getText());
                document.saveInformation("./untiled.txt");
                System.out.println("Сохраняет");
            }
            else System.out.println("Не сохраняет");
        }
    }

    class FileExit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Выход");
            setVisible(false);
            System.exit(0);
        }
    }
}
