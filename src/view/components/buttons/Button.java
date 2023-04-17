package view.components.buttons;

import java.awt.*;

import javax.swing.*;

public class Button extends JButton {
  public Button() {
    super();
  }

  public Button(Icon icon) {
    super(icon);
  }

  public Button(String text) {
    super(text);
    Font sansSerifSmall  = new Font(Font.MONOSPACED, Font.PLAIN,  24);

    this.setFont(sansSerifSmall);
    this.setMargin(new Insets(10, 10, 10, 10));
  }

}
