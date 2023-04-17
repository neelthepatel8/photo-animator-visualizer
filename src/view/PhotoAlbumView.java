package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

import view.components.Image;
import view.components.buttons.ImageButton;
import view.components.labels.ImageLabel;
import view.components.labels.Label;
import view.components.labels.SnapshotLabel;
import view.components.panels.Panel;
import view.components.buttons.Button;

public class PhotoAlbumView extends JFrame implements View, KeyListener {

  /** Panels **/
  private Panel mainPanel;
  private Panel descriptionPanel;
  private Panel imagePanel;
  private Panel buttonPanel;

  /** Labels **/
  private Label closeLabel;
  private Label leftLabel;
  private Label rightLabel;
  private Label selectLabel;
  private Label descriptionLabel;
  private Label imageLabel;

  /** Buttons **/
  Button leftBtn;
  Button rightBtn;
  Button selectBtn;

  /** Fonts **/
  Font sansSerif;
  Font sansSerifSmall;


  public PhotoAlbumView(int width, int height) throws IOException {
    this.setTitle("Photo Album");
    this.setSize(new Dimension(width, height));

    this.addKeyListener(this);
    this.setupInits();
    this.createLayout();
    this.setDefaults();
    this.setupEventHandlers();
    this.setContentPane(mainPanel);

  }

  private void setupInits() {
    this.sansSerif  = new Font(Font.MONOSPACED, Font.BOLD,  32);
    this.sansSerifSmall  = new Font(Font.MONOSPACED, Font.BOLD,  24);
  }

  private void setupEventHandlers() {

    PhotoAlbumView view = this;
    closeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        view.dispose();
      }
    });
    leftLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        view.setImage("pengu");
        view.setDescription("This is the first Penguin");
      }
    });
    rightLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        view.setImage("pengu2");
        view.setDescription("This is the second Penguin");
      }
    });
    selectLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.out.println("Pressed: " + e.getSource().getClass());
      }
    });

  }

  public void changeImage(String filename) {
    this.setImage(filename);
  }

  private void setDefaults() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }

  private void createLayout() throws IOException {
    mainPanel = new Panel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


    descriptionPanel = new Panel(new BorderLayout());
    descriptionLabel = new Label("This is the first Penguin");
    descriptionLabel.setFont(sansSerif);

    descriptionLabel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
    descriptionPanel.add(descriptionLabel, BorderLayout.CENTER);

    closeLabel = new ImageLabel("close-default", "close-hover");
    descriptionPanel.add(closeLabel, BorderLayout.WEST);

    imagePanel = new Panel();
    imagePanel.setLayout(new FlowLayout());

    imageLabel = new SnapshotLabel("pengu");
    imagePanel.add(imageLabel);

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
    mainPanel.add(imagePanel);
    mainPanel.add(buttonPanel);

  }

  private void setImage(String fileName) {
    imageLabel.setIcon(new ImageIcon("src/assets/snapshots/" + fileName + ".jpg"));
  }

  private void setDescription(String description) {
    descriptionLabel.setText(description);
  }

  public static void main(String[] args) throws IOException {
    PhotoAlbumView view = new PhotoAlbumView(700, 1000);
    view.setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    switch (keyCode) {
      case KeyEvent.VK_LEFT:
        this.setImage("pengu");
        this.setDescription("This is the first Penguin");
        break;
      case KeyEvent.VK_RIGHT:
        this.setImage("pengu2");
        this.setDescription("This is the second Penguin");
        break;
      default:
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
