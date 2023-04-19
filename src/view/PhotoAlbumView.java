package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import controller.PhotoAlbumController;
import model.photoalbum.snapshot.Snapshot;
import view.components.labels.ImageLabel;
import view.components.labels.Label;
import view.components.panels.ImagePanel;
import view.components.panels.Panel;

public class PhotoAlbumView extends JFrame implements IView, KeyListener {

  /** Misc **/
  private PhotoAlbumController controller;
  private int snapCount = 0;
  private int currentSnap = 0;

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


  public PhotoAlbumView(int width, int height, PhotoAlbumController controller) throws IOException {

    this.controller = controller;
    this.snapshots = new ArrayList<>();

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
    this.sansSerifSmall  = new Font(Font.MONOSPACED, Font.PLAIN,  18);
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
        if (currentSnap - 1 < 0) {
          JOptionPane.showMessageDialog(null, "Out of Snaps!", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }
        currentSnap -= 1;
        view.changeImage("snap-" + currentSnap);
        view.setDescription(snapshots.get(currentSnap).getDescription());
        view.setId(snapshots.get(currentSnap).getId());
      }
    });
    rightLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (currentSnap + 1 >= snapCount) {
          JOptionPane.showMessageDialog(null, "Out of Snaps!", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }
        currentSnap += 1;
        view.changeImage("snap-" + currentSnap);
        view.setDescription(snapshots.get(currentSnap).getDescription());
        view.setId(snapshots.get(currentSnap).getId());
      }
    });
    selectLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        view.showSelectOptions(e);
      }
    });

  }

  public void changeImage(String filename) {
    this.setImage(filename, false);
  }

  @Override
  public void updatePicture(Snapshot snap, int size) throws IOException {
    snapshots.add(snap);
    this.imagePanel.setShapes(snap);
    this.imagePanel.setSize(size);
    this.imagePanel.saveImage(snapCount);
    snapCount += 1;
  }

  public void showSelectOptions(MouseEvent e) {
    JPopupMenu menu = new JPopupMenu();
    IView IView = this;
    for (Snapshot snapshot: snapshots) {
      JMenuItem item = new JMenuItem();
      item.setText(snapshot.getId());
      menu.add(item);
      item.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Snapshot snap = getSnapshotFromID(item.getText());
          IView.changeImage("snap-" + snapshots.indexOf(snap));
          IView.setDescription(snap.getDescription());
          IView.setId(snap.getId());
          currentSnap = snapshots.indexOf(snap);
        }
      });
    }
    menu.show(e.getComponent(), 0, e.getY());
  }

  private Snapshot getSnapshotFromID(String id) {
    for (Snapshot snapshot: snapshots) {
      if (Objects.equals(snapshot.getId(), id)) {
        return snapshot;
      }
    }
    return snapshots.get(0);
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

  }

  public void setImage(String fileName, boolean first) {
    if (first) {
      imageContainerPanel.remove(imagePanel);
      imageLabel = new ImageLabel(fileName);
      imageContainerPanel.add(imageLabel);
      this.setDescription(snapshots.get(0).getDescription());
      this.setId(snapshots.get(0).getId());
      currentSnap = 0;
    }
    else
      imageLabel.setImage(fileName);
  }

  public void setId(String id) {
    idLabel.setText(id);
  }

  public void setInitials() {
    this.setImage("snap-0", true);
  }
  public void setDescription(String description) {
    descriptionLabel.setText(description);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
//    switch (keyCode) {
//      case KeyEvent.VK_LEFT:
//        this.setImage("pengu");
//        this.setDescription("This is the first Penguin");
//        break;
//      case KeyEvent.VK_RIGHT:
//        this.setImage("pengu2");
//        this.setDescription("This is the second Penguin");
//        break;
//      default:
//        break;
//    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
