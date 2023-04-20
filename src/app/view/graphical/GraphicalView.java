package app.view.graphical;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

import app.controller.IController;
import app.model.shape.IShape;
import app.view.components.labels.ImageLabel;
import app.view.components.labels.Label;
import app.view.components.panels.ImagePanel;
import app.view.components.panels.Panel;

public class GraphicalView extends JFrame implements IView {

  /** Misc **/
  private final IController controller;
  private int size;
  private final int width;
  private final int height;

  /** Panels **/
  private Panel mainPanel;
  private ImagePanel imagePanel;

  /** Labels **/
  private Label closeLabel;
  private Label leftLabel;
  private Label rightLabel;
  private Label selectLabel;
  private Label descriptionLabel;
  private Label idLabel;

  /** Fonts **/
  Font sansSerif;
  Font sansSerifSmall;


  public GraphicalView(int width, int height, IController controller) throws IOException {

    this.controller = controller;
    this.width = width;
    this.height = height;

  }

  @Override
  public void loadSnapshot(List<IShape> shapes, int size){
    this.imagePanel.setShapes(shapes);
    this.imagePanel.setSize(size);
    this.imagePanel.repaint();
  }

  @Override
  public void displaySnapshotList(List<String> snapshotIDs, MouseEvent e) {
    JPopupMenu menu = new JPopupMenu();
    for (String id: snapshotIDs) {
      JMenuItem item = new JMenuItem();
      item.setText(id);
      IView view = this;

      item.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (!controller.handleSnapshotSelection(((JMenuItem) e.getSource()).getText())) {
            view.error();
          }
        }
      });

      menu.add(item);
    }

    menu.show(e.getComponent(), 0, e.getComponent().getY());
  }

  @Override
  public void switchToNew(List<IShape> shapes, String description, String id) {
    this.loadSnapshot(shapes, this.size);
    this.setDescription(description);
    this.setId(id);
  }

  @Override
  public void initialize(List<IShape> shapes, String desc, String id, int size) {
    this.size = size;
    this.setTitle("Photo Album");
    this.setSize(new Dimension(width, height));

    this.setupInits();
    this.createLayout();
    this.setDefaults();
    this.setupEventHandlers();

    this.setContentPane(mainPanel);
    this.validate();
    this.loadSnapshot(shapes, size);
    this.setDescription(desc);
    this.setId(id);
    this.setVisible(true);
  }

  @Override
  public void error() {
    JOptionPane.showMessageDialog(null, "Out of Snaps!", "Error", JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void close() {
    this.dispose();
  }

  private void setupInits() {
    this.sansSerif  = new Font(Font.MONOSPACED, Font.BOLD,  32);
    this.sansSerifSmall  = new Font(Font.MONOSPACED, Font.PLAIN,  18);
  }

  private void setupEventHandlers() {
    IView view = this;

    closeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        controller.handleClose(e);
      }
    });
    leftLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (!controller.handlePrevious(e)) {
          view.error();
        }
      }
    });

    rightLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (!controller.handleNext(e)) {
          view.error();
        }
      }
    });

    selectLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        controller.handleSelect(e);
      }
    });

  }

  private void setDefaults() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }

  private void createLayout() {
    mainPanel = new Panel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


    Panel descriptionPanel = new Panel(new BorderLayout());
    Panel textPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 0));

    descriptionLabel = new Label("");
    descriptionLabel.setFont(sansSerif);
    descriptionLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 40));
    textPanel.add(descriptionLabel);
    descriptionPanel.add(textPanel, BorderLayout.CENTER);

    idLabel = new Label("");
    idLabel.setBorder(BorderFactory.createEmptyBorder(0, 350, 2, 0));
    idLabel.setFont(sansSerifSmall);
    descriptionPanel.add(idLabel, BorderLayout.SOUTH);


    closeLabel = new ImageLabel("close-default", "close-hover");
    closeLabel.setBorder(BorderFactory.createEmptyBorder(3, 10, 5, 10));
    descriptionPanel.add(closeLabel, BorderLayout.WEST);

    Panel imageContainerPanel = new Panel();
    imageContainerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    imagePanel = new ImagePanel();
    imageContainerPanel.add(imagePanel);


    Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 50, 0));
    leftLabel = new ImageLabel("left-arrow", "left-arrow-hover");
    rightLabel = new ImageLabel("right-arrow", "right-arrow-hover");
    selectLabel = new ImageLabel("select", "select-hover");
    buttonPanel.add(leftLabel);
    buttonPanel.add(selectLabel);
    buttonPanel.add(rightLabel);

    buttonPanel.setOpaque(false);
    mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    mainPanel.add(descriptionPanel);
    mainPanel.add(imageContainerPanel);
    mainPanel.add(buttonPanel);

  }

  private void setId(String id) {
    idLabel.setText(id);
  }

  private void setDescription(String description) {
    descriptionLabel.setText(description);
  }
}
