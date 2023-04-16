package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import view.components.Image;
import view.components.buttons.ImageButton;
import view.components.labels.Label;
import view.components.panels.Panel;
import view.components.buttons.Button;

public class PhotoAlbumView extends JFrame implements View {

  /** Panels **/
  private Panel mainPanel;
  private Panel imagePanel;
  private Panel buttonPanel;

  /** Labels **/
  private Label imageLabel;

  /** Buttons **/
  Button leftBtn;
  Button rightBtn;
  Button selectBtn;


  public PhotoAlbumView(int width, int height) throws IOException {
    this.setTitle("Photo Album");
    this.setSize(new Dimension(width, height));

    this.createLayout();
    this.setDefaults();
    this.setupEventHandlers();
    this.setContentPane(mainPanel);

  }

  private void setupEventHandlers() {

    leftBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //TODO: Add Event handler
      }
    });
    rightBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //TODO: Add Event handler
      }
    });
    selectBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //TODO: Add Event handler
      }
    });
  }

  private void setDefaults() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void createLayout() {
    mainPanel = new Panel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    imagePanel = new Panel();
    imagePanel.setLayout(new FlowLayout());

    imageLabel = new Label(new ImageIcon("src/assets/snapshots/img.png"));
    imagePanel.add(imageLabel);

    buttonPanel = new Panel(new FlowLayout());
    leftBtn = new Button("Left");
    rightBtn = new Button("Right");
    selectBtn = new Button("Select");
    buttonPanel.add(leftBtn);
    buttonPanel.add(selectBtn);
    buttonPanel.add(rightBtn);

    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    mainPanel.add(imagePanel);
    mainPanel.add(Box.createVerticalStrut(370));
    mainPanel.add(Box.createVerticalGlue());
    mainPanel.add(buttonPanel);
  }

  public static void main(String[] args) throws IOException {
    PhotoAlbumView view = new PhotoAlbumView(1000, 1000);
    view.setVisible(true);
  }

}
