package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import controller.IController;
import model.photoalbum.snapshot.Snapshot;
import view.components.labels.ImageLabel;
import view.components.labels.Label;
import view.components.panels.ImagePanel;
import view.components.panels.Panel;

public class GraphicalView extends JFrame implements IView {

  /** Misc **/
  private IController controller;

  private ArrayList<Snapshot> snapshots;

  /** Panels **/
  private Panel mainPanel;
  private Panel descriptionPanel;
  private ImagePanel imagePanel;
  private Panel buttonPanel;
  private Panel imageContainerPanel;

  /** Labels **/
  private Label closeLabel;
  private Label leftLabel;
  private Label rightLabel;
  private Label selectLabel;
  private Label descriptionLabel;
  private Label idLabel;
  private Label imageLabel;

  /** Fonts **/
  Font sansSerif;
  Font sansSerifSmall;


  public GraphicalView(int width, int height, IController controller) throws IOException {

    this.controller = controller;
    this.snapshots = new ArrayList<>();

    this.setTitle("Photo Album");
    this.setSize(new Dimension(width, height));

    this.setupInits();
    this.createLayout();
    this.setDefaults();
    this.setupEventHandlers();

    this.setContentPane(mainPanel);

  }

  private void setupInits() {
    this.sansSerif  = new Font(Font.MONOSPACED, Font.BOLD,  32);
    this.sansSerifSmall  = new Font(Font.MONOSPACED, Font.PLAIN,  18);
  }

  private void setupEventHandlers() {

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
          JOptionPane.showMessageDialog(null, "Out of Snaps!", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    rightLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (!controller.handleNext(e)) {
          JOptionPane.showMessageDialog(null, "Out of Snaps!", "Error", JOptionPane.ERROR_MESSAGE);
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

  public void switchToNew(String imageName, String description, String id) {
    this.setImage(imageName, false);
    this.setDescription(description);
    this.setId(id);
  }

  @Override
  public void updatePicture(Snapshot snap, int size) throws IOException {
    snapshots.add(snap);
    this.imagePanel.setShapes(snap);
    this.imagePanel.setSize(size);
    this.imagePanel.saveImage(snapCount);
    snapCount += 1;
  }

  public void close() {
    this.dispose();
  }

  private void setDefaults() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }

  private void createLayout() {
    mainPanel = new Panel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


    descriptionPanel = new Panel(new BorderLayout());
    descriptionLabel = new Label("This is the first Penguin");
    descriptionLabel.setFont(sansSerif);

    descriptionLabel.setBorder(BorderFactory.createEmptyBorder(0, 230, 0, 0));
    descriptionPanel.add(descriptionLabel, BorderLayout.CENTER);

    idLabel = new Label("");
    idLabel.setBorder(BorderFactory.createEmptyBorder(0, 350, 2, 0));
    idLabel.setFont(sansSerifSmall);
    descriptionPanel.add(idLabel, BorderLayout.SOUTH);


    closeLabel = new ImageLabel("close-default", "close-hover");
    closeLabel.setBorder(BorderFactory.createEmptyBorder(3, 10, 5, 10));
    descriptionPanel.add(closeLabel, BorderLayout.WEST);

    imageContainerPanel = new Panel();
    imageContainerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    imagePanel = new ImagePanel();
    imageContainerPanel.add(imagePanel);

    buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 50, 0));
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

    this.setInitials();


  }

  public void setImage(String fileName, boolean first) {
    if (first) {
      //TODO
    }
    else
      imageLabel.setImage(fileName);
  }
  public void setId(String id) {
    idLabel.setText(id);
  }
  public void setDescription(String description) {
    descriptionLabel.setText(description);
  }

  private void setInitials() {
    this.setImage("snap-0", true);
  }


}